package blibliobook;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    
    private static final String dbURL = "jdbc:derby://localhost:1527/TheLibrary;create=true"; // create=true -> base de donné cree si inexistante
    public static final String userTable = "Users"; // Table ou l'on va mettre les données des utilisateurs
    public static final String loanTable = "Loan"; // Table ou l'on va mettre les données des emprunts
    public static final String bookTable = "Book"; // Table ou l'on va mettre les données des livres
    
    // jdbc Connection
    public static Connection conn = null;
    public static Statement stmt = null;
    
    // Constructeur
    public DataBase(){
        CreateConnection();
    }
    
    // On fait une connexion de la base de donnée
    private static void CreateConnection()
    {
        try
        {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(dbURL, "root", "root"); 
            System.out.println("Connexion BDD : OK");
        }
        catch (SQLException except)
        {
            System.out.println(except.getMessage());
            System.out.println("Erreur : connexion BDD, réessayer..");
        }
    }
    
    // On ferme une connexion existante
    public static void Shutdown()
    {
        try
        {
            if (stmt != null)
                stmt.close();
            
            if (conn != null)
            {
                DriverManager.getConnection(dbURL + ";shutdown=true");
                conn.close();
            }           
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur ShutDown fonction : " + sqlExcept.getMessage());
        }
    }
    
    // On initialise les tables de la BDD
    public static void InitTable(){
        System.out.println("INIT TABLE");
        
        try{
            stmt = conn.createStatement();
            String query = "CREATE TABLE " + userTable + " ( "
            + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Nom VARCHAR(255) NOT NULL, "
            + "Prenom VARCHAR(255) NOT NULL, "
            + "Email VARCHAR (255) NOT NULL, "
            + "Password VARCHAR (255) NOT NULL, "
            + "Groupe VARCHAR (255) NOT NULL DEFAULT 'Client', "
            + "DateInscription DATE NOT NULL, "
            + "CONSTRAINT PK_ID_Users PRIMARY KEY (ID))";
      
            stmt.execute(query);
            System.out.println("Table Users created");
        }
        catch(SQLException except){
            // Code erreur 30000 -> Table deja existente
            if(except.getErrorCode() != 30000){
                System.out.println("Erreur creation table User : " + except.getMessage());
            }
        }
                
        try{
            stmt = conn.createStatement();
            //(Titre, Categorie, Ref, Auteur, Description, DateAjout, Etat, Stock, Disponible)
            String query = "CREATE TABLE " + bookTable + " ( "
            + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "Titre VARCHAR(100) NOT NULL, "
            + "Categorie VARCHAR(100) NOT NULL, "
            + "Ref VARCHAR (100) NOT NULL, "
            + "Auteur VARCHAR (100) NOT NULL, "
            + "Description VARCHAR (1000), "
            + "DateAjout DATE NOT NULL, "
            + "Etat INTEGER NOT NULL DEFAULT 1, " // Etat du livre compris entre 1 et 5
            + "Stock INTEGER NOT NULL DEFAULT 1, "
            + "Disponible BOOLEAN NOT NULL, "
            + "CONSTRAINT PK_ID_Book PRIMARY KEY (ID))";
            //+ "CHECK (Etat > 0 AND Etat < 5)";
      
            stmt.execute(query);
            System.out.println("Table Book created");
        }
        catch(SQLException except){
            // Code erreur 30000 -> Table deja existente
            if(except.getErrorCode() != 30000){
                System.out.println("Erreur creation table Book : " + except.getMessage());
            }
        }
        
        try{
            stmt = conn.createStatement();
            
            String query = "CREATE TABLE " + loanTable + " ( "
            + "ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
            + "DateEmprunt DATE NOT NULL, "
            + "DateRenduPrevue DATE NOT NULL, "
            + "DateRendu DATE, "
            + "ID_Utilisateur INTEGER NOT NULL REFERENCES Users(ID), "
            + "ID_Livre INTEGER NOT NULL REFERENCES Book(ID), "
            + "CONSTRAINT PK_ID_Loan PRIMARY KEY (ID))";
      
            stmt.execute(query);
            System.out.println("Table Loan created");
        }
        catch(SQLException except){
            // Code erreur 30000 -> Table deja existente
            if(except.getErrorCode() != 30000){
                System.out.println("Erreur creation table Loan : " + except.getMessage());
            }
        }
    }

    // On verifie que l'on a pas deja un utilisateur avec cette adress email et ce numero de telephone
    public static boolean IsEmailAvailable(String email){
        try{
            stmt = conn.createStatement(); 

            String query = "SELECT ID FROM " + userTable + " WHERE Email = '" + email + "'"; // "' OR Tel = '" + tel + 
            ResultSet result = stmt.executeQuery(query);
            if(result.next()){
                return false;
            }
            stmt.close();
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur Verif utilisateur valide : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    // On regarde si l'utilisateur donné existe dans la BDD
    public static boolean IsDataExist(int dataID, String dataTable){
        boolean exist = false;
        try{
            stmt = conn.createStatement(); 
            
            String query = "SELECT ID FROM " + dataTable + " WHERE ID = " + Integer.toString(dataID);
            ResultSet result = stmt.executeQuery(query);
            
            if(result.next())
                exist = true;
            
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur verif Data existe : " + sqlExcept.getMessage());
        }
        
        return exist;   
    }

    // Suppression d'une data dans une table donnée - Generique pour eviter d'avoir 3 fonctions faisant la même chose mais dans de stables differentes
    public static boolean DeleteData(int dataID, String dataTable){
        try
        {
            if(!IsDataExist(dataID, dataTable)) // La data existe bien, pour la supprimer
                return false;
            
            // suppression Emprunt possible, aucune dependnaces..
            // Suppression Utilisateur / Livre -> il faut d'abord supprimer les emprunts dependants !
            if(dataTable.equals(userTable) || dataTable.equals(bookTable)){
                try{
                    String target = dataTable.equals(userTable) ? "ID_Utilisateur" : "ID_Livre"; // On supprime un livre ou un utilisateur ?
                    stmt = conn.createStatement(); 
                    
                    String query = "SELECT ID FROM " + loanTable + " WHERE " + target + " = " + Integer.toString(dataID);
                    
                    ResultSet result = stmt.executeQuery(query);
                    System.out.println(query);
                    
                    while(result.next()){
                        int targetID = result.getInt("ID");
                        DeleteData(targetID, loanTable); // Plusieurs choix, on peut supprimer comme ici, ou modifier l'ID et mettre l'id d'un compte blibiothecaire dedié aux comptes / livre ssupprimés a la place.
                    }

                    stmt.close();

                } catch (SQLException sqlExcept){
                    System.out.println("Erreur suppression des dependances (emprunts): " + sqlExcept.getMessage());
                    return false;
                }
            }
            
            stmt = conn.createStatement();
            String query = "DELETE FROM " + dataTable + " WHERE ID = " + Integer.toString(dataID);
            
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Suppression reussie : " + dataTable+ " : " + Integer.toString(dataID));
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur suppression : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    // Création d'un utilisateur
    public static boolean CreateUser(String nom, String prenom, String email, String password, String groupe)
    {
        try
        {
            if(!User.IsUserValid(nom, prenom, email, groupe))
            {
                System.out.println("Erreur : Un ou plusieurs champs sont invalides..");
                return false;
            }
            
            // On test le mdp separement car nous aurons besoin e tester la validiter de l'utilisateur dans UpdateUser,
            // On ne veut cependant pas modifier le mot de passe.
            if(!User.IsPasswordValid(password)){
                System.out.println("Erreur : Le mot de passe est invalide. (un chiffre, une lettre minuscule, une majuscule,"
                        + " un caractere special, aucun espaces ni retour a la ligne, au moins 8 caracteres.)");
            
                //System.out.println(password);
            
                return false;
            }
            
            if(!DataBase.IsEmailAvailable(email))
            {
                System.out.println("Erreur : Utilisateur non valide. l'email est deja utiliser pour un autre utilisateur.");
                return false;
            }
            
            DataBase.stmt = DataBase.conn.createStatement(); 
           
            String query = "INSERT INTO " + DataBase.userTable + "(Nom, Prenom, Email, Password, Groupe, DateInscription) "
                    + "VALUES ('" + nom +
                    "','" + prenom +
                    "','" + email +
                    "','"+ User.Hashpassword(password) +
                    "','"+ groupe +
                    "','" + DataBase.GetActualDate() +
                    "')";
            
            DataBase.stmt.execute(query);
            DataBase.stmt.close();
            
            System.out.println("Utilisateur " + email + " créé.");
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur creation utilisateur : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    // MAJ d'un utilisateur donné
    public static boolean UpdateUser(int userID, String nom, String prenom, String email, String groupe){
        try
        {
            if(!IsDataExist(userID, userTable)) // L'utilisateur a modifier existe bien
                return false;
            
            if(!User.IsUserValid(nom, prenom, email, groupe)) // Les nouvelles infos sont toujours valident ?
                return false;
            
            // Recuperer email actuel de l'utilisteur, la comparer a celle la et verifier que la nouvelle n'est pas utiliser
            // dans un autre compte que celui-ci.
            String actuEmail = "";
            try{
                stmt = conn.createStatement(); 
                String query = "SELECT Email FROM " + userTable + " WHERE ID = " + Integer.toString(userID);
                ResultSet result = stmt.executeQuery(query);
                if(result.next()){
                    actuEmail = result.getString("Email");
                }
                stmt.close();
            }
            catch (SQLException sqlExcept)
            {
                System.out.println("Erreur get User email : " + sqlExcept.getMessage());
                return false;
            }
            
            if(!actuEmail.equals(email) && !DataBase.IsEmailAvailable(email)){ // on a renseigné un nouvelle email, on regarde si il est disponible
                System.out.println("Erreur : Utilisateur non valide. l'email est deja utiliser pour un autre utilisateur.");
                return false;
            }
            
            stmt = conn.createStatement(); 
            
            // Pour une question de simpliciter je mets toutes les informations à jour au lieu de mettre a jour
            // seulement les infos changées.
            String query = "UPDATE " + userTable + " "
                    + "SET Nom = '" + nom +
                    "', Prenom = '" + prenom +
                    "', Email = '" + email +
                    //"', Password = '" + User.Hashpassword(password) +
                    "', Groupe = '" + groupe +
                    "' WHERE ID = " + Integer.toString(userID);
            
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Mise a jour utilisateur reussie : " + prenom + " " + nom);
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur mise a jour utilisateur : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    public static boolean IsReferenceAvailable(String ref){
        try{
            stmt = conn.createStatement(); 

            String query = "SELECT ID FROM " + bookTable + " WHERE Ref = '" + ref + "'";
            ResultSet result = stmt.executeQuery(query);
            
            if(result.next()){
                stmt.close();
                return false;
            }
            stmt.close();
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur Verif reference livre valide : " + sqlExcept.getMessage());
            return false;
        }
    }
    
    // Enregistrement d'un nouveau livre dans la BDD
    public static boolean CreateBook(String titre, String cat, String ref, String auteur, String description, int etat, int stock){
        try
        {
            if(!Book.IsBookValid(titre, cat, ref, auteur, description, etat, stock)){
                return false;
            }
            
            if(!IsReferenceAvailable(ref)){
                System.out.println("Erreur : Livre non valide. la reference est deja utiliser pour un autre livre !");
                return false;
            }
                
            
            stmt = conn.createStatement(); 
           
            String query = "INSERT INTO " + bookTable + "(Titre, Categorie, Ref, Auteur, Description, DateAjout, Etat, Stock, Disponible) "
                    + "VALUES ('" + titre +
                    "','" + cat +
                    "','" + ref +                    
                    "','" + auteur +
                    "','" + description +
                    "','"+ GetActualDate() +
                    "',"+ etat +
                    ","+ stock +
                    ","+ (stock > 0) +
                    ")";
            
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Creation Livre reussie : " + titre + " " + cat);
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur creation livre : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    // Mise a jour d'un livre
    public static boolean UpdateBook(int bookID, String titre, String cat, String ref, String auteur, String description, int etat, int stock){
        try
        {
            if(!IsDataExist(bookID, bookTable)) // Le livre a modifier existe bien
                return false;
            
            if(!Book.IsBookValid(titre, cat, ref, auteur, description, etat, stock))
                return false;
            
            // compare ref actuel et ref donner, si pas pareil verif pas deja utiluiser autre part. 
            // Même principe que pour la mise a jour de l'utilisateur
            String actuRef = "";
            try{
                stmt = conn.createStatement(); 
                String query = "SELECT Ref FROM " + bookTable + " WHERE ID = " + Integer.toString(bookID);
                ResultSet result = stmt.executeQuery(query);
                if(result.next()){
                    actuRef = result.getString("Ref");
                }
                stmt.close();
            }
            catch (SQLException sqlExcept)
            {
                System.out.println("Erreur get book ref : " + sqlExcept.getMessage());
                return false;
            }
            
            if(!actuRef.equals(ref) && !DataBase.IsReferenceAvailable(ref)){ // on a renseigné une nouvelle reference, on regarde si il est disponible
                System.out.println("Erreur : Livre non valide. la reference est deja utiliser pour un autre livre !");
                return false;
            }
            
            stmt = conn.createStatement(); 
            boolean dispo = stock > 0;
            
            // Pour une question de simpliciter je mets toutes les informtions à jour au lieu de mettre a jour
            // seulement les infos changer.
            String query = "UPDATE " + bookTable +
                    " SET Titre = '" + titre +
                    "', Categorie = '" + cat +
                    "', Ref = '" + ref +
                    "', Auteur = '" + auteur +                    
                    "', Description = '" + description +
                    "', Etat = " + etat +     
                    ", Stock = " + stock +
                    ", Disponible = " + dispo +
                    " WHERE ID = " + Integer.toString(bookID);
            
            stmt.execute(query);
            stmt.close();
            
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur mise a jour livre : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    public static boolean CreateLoan(int userID, int bookID, int nbrJourEmprunt){
        try {
            
            if(!IsDataExist(userID, userTable)) // On verifie que l'utilisateur qui emprunte le livre existe
                return false;
        
            if(!IsDataExist(bookID, bookTable)) // On verifie que le livre emprunter existe
                return false;
        
            if(IsUserALreadyLoanThisBook(userID, bookID)) // On verfie que l'utilisateur n'a pas deja emprunter un exemplair ede ce livre (non rendu).
                return false;
                 
            UpdateBookStock(bookID, -1);
            
            // On recupere la date actuel & date de rendu fixé
            Date dateEmprunt = GetActualDate();
            Date dateRenduAttendu = Date.valueOf(dateEmprunt.toLocalDate().plusDays(nbrJourEmprunt));
            
            stmt = conn.createStatement(); 

            // On cree l'emprunt
            String query = "INSERT INTO " + loanTable + "(DateEmprunt, DateRenduPrevue, ID_Utilisateur, ID_Livre) "
                    + "VALUES ('" + dateEmprunt +
                    "','" + dateRenduAttendu +
                    "'," + userID +                    
                    "," + bookID +
                    ")";
            
            
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Création de l'emprunt !");
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur creation emprunt : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    //  On met a jour le stock du livre dans la BDD
    private static void UpdateBookStock(int bookID, int quantite){
            
        try {
            // On met a jour le livre emprunté, il est de nouvau en stock
            stmt = conn.createStatement();
            
            // Le livre est-il disponible ?
            String query = "SELECT * FROM " + bookTable +  " WHERE ID = " + Integer.toString(bookID);
            ResultSet result = stmt.executeQuery(query);
            
            if(result.next()){
                
                // On vient de cree un emprunt -> livre plus dispo si stock <= 0
                UpdateBook(
                            bookID,
                            result.getString("Titre"),
                            result.getString("Categorie"),
                            result.getString("Ref"),
                            result.getString("Auteur"),                                
                            result.getString("Description"),
                            result.getInt("Etat"),
                            result.getInt("Stock") + (quantite)
                           );
            }
            
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erreur maj book stock " + ex.getMessage());
        }     
    }
    
    // Cet utilisateur a t-il deja emprunter un exemplaire d ece livre ET ne l'a pas encore rendu?
    public static boolean IsUserALreadyLoanThisBook(int userID, int bookID){
        boolean userAlreadyLoanThisBook = false;
        try{
            stmt = conn.createStatement(); 
            
            String query = "SELECT * FROM " + loanTable + " WHERE ID_Utilisateur = " + Integer.toString(userID) +
                    " AND ID_Livre = " + Integer.toString(bookID) + " AND DateRendu IS NULL"; // DateRendu != null -> utilisateur a deja emprunter ce livre mais l'a aussi rendu
            
            ResultSet result = stmt.executeQuery(query);
            
            if(result.next()){
                userAlreadyLoanThisBook = true;
                System.out.println("L'utilisateur a deja emprunter un autre exemplaire de ce livre.");
            }
            
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur verif Data existe : " + sqlExcept.getMessage());
        }
        
        return userAlreadyLoanThisBook;   
    }
    
    // Mettre a jour un emprunt
    public static boolean UpdateLoan(int loanID, int userID, int bookID, Date datePrevue){
        try
        {
            if(!IsDataExist(userID, userTable) || !IsDataExist(bookID, bookTable) || !IsDataExist(loanID, loanTable)) // On verifie que l'utilisateur qui emprunte le livre existe// On verifie que le livre emprunter existe
                return false;                                                                                         // On verifie que l'emprunt que nous modifions existe bien
            
            
            int actuIDUser = -1;
            int actuIDBook = -1;
            
            try{ // On verifie les nouveau ID si c'est differents (en cas de changement de proprio / de livre)
                stmt = conn.createStatement(); 
                String query = "SELECT ID_Utilisateur, ID_Livre FROM " + loanTable + " WHERE ID = " + Integer.toString(loanID);
                ResultSet result = stmt.executeQuery(query);
                if(result.next()){
                    actuIDUser = result.getInt("ID_Utilisateur");
                    actuIDBook = result.getInt("ID_Livre");
                }
                else{
                    System.out.println("Erreur, on ne trouve aucun IDS correspondant a l'id (dans updateloan) ");
                    return false;
                }
                stmt.close();
            }
            catch (SQLException sqlExcept)
            {
                System.out.println("Erreur get loan IDS : " + sqlExcept.getMessage());
                return false;
            }
            
            // Changement de l'emprunt, plus le même livre
            if(actuIDBook != bookID){
                UpdateBookStock(bookID, -1); // On prend le nouveau
                UpdateBookStock(actuIDBook, 1); // On repose l'ancien
            }
            
            if(actuIDUser != userID){
                System.out.println("Emprunt : Changement de proprietaire. " + actuIDUser + " -> " + userID);
            }
            
            stmt = conn.createStatement(); 
            
            // Pour une question de simpliciter je mets toutes les informtions à jour au lieu de mettre a jour
            // seulement les infos changer.
            String query = "UPDATE " + loanTable + " "
                    + "SET ID_Utilisateur = " + userID +
                    ", ID_Livre = " + bookID +
                    ", DateRenduPrevue = '" + datePrevue +
                    "' WHERE ID = " + Integer.toString(loanID);
            
            stmt.execute(query);
            stmt.close();
            
            System.out.println("Mise a jour emprunt reussie.");
            return true;
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur mise a jour emprunt : " + sqlExcept.getMessage());
        }
        return false;
    }
    
    // Termine un emprunt
    public static int FinishLoan(int loanID){
        try{
            
            if(!IsDataExist(loanID, loanTable)) // On verifie que l'emprunt que nous terminons existe bien
                return 0;
            
            stmt = conn.createStatement(); 
            
            // On recupere le livre qui a etait emprunté
            String query = "SELECT * FROM " + loanTable +  " WHERE ID = " + Integer.toString(loanID);
            ResultSet result = stmt.executeQuery(query);
            
            int bookID;
            Date datePrevu;
            Date dateRendu = GetActualDate();
            
            if(result.next()){
                bookID = result.getInt("ID_Livre");
                datePrevu = result.getDate("DateRenduPrevue");
                
                if(dateRendu.after(datePrevu))
                    return 2; // La date est passé, l'utilisateur a un retard.
            }
            else{
                System.out.println("Erreur rendu emprunt ");
                return 0;
            }
            
            UpdateBookStock(bookID, 1);
            
           stmt = conn.createStatement();
            query = "UPDATE " + loanTable + " "
                    + "SET DateRendu = '" + GetActualDate() +
                    "' WHERE ID = " + loanID;
            
            stmt.execute(query);
            stmt.close();
            return 1;
         
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur rendu emprunt : " + sqlExcept.getMessage());
        }
        return 0;
    }
    
    
    
    
    // retourne une liste d'emprunt, soit tous les emprunts si on ne specifie pas d'utilisateur, soit les emprunt de l'utilisateur specifié.
    public static List<Loan> GetUserLoan(boolean finished, int p_userID){
        List<Loan> loanList = new ArrayList<>();
        
        try{
            stmt = conn.createStatement(); 
            
            // On essaye de trouver tous les emprunts de l'utilisateurs
            String query = "SELECT * FROM " + loanTable + " WHERE DateRendu";
            query += finished ? " IS NOT NULL" : " IS NULL"; // On demande les emprunts terminer / non terminer ?
                       
            if(p_userID != 0)
                query += " AND ID_Utilisateur = " + p_userID;
            
            query += " ORDER BY DateEmprunt";  // On les tri dans l'ordre de l'emprunt
            
            //query += " ORDER BY ID";
            //System.out.println(query);
            
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                
                Loan newLoan = new Loan(result.getInt("ID"), result.getDate("DateEmprunt"), 
                        result.getDate("DateRenduPrevue"), result.getInt("ID_Utilisateur"),
                        result.getInt("ID_Livre"));
                if(result.getDate("DateRendu") != null)
                    newLoan.dateRendu = result.getDate("DateRendu");
                
                loanList.add(newLoan);
            }
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur get loan : " + sqlExcept.getMessage());
        }
        return loanList;
    }

    // retorune la liste des livres de la BDD
    public static List<Book> GetBook(boolean filter, boolean disponible, String categorie){
        List<Book>bookList = new ArrayList<>();
        
        try{
             
            stmt = conn.createStatement(); 
            
            // On recupere tout les livres de la BDD
            String query = "SELECT * FROM " + bookTable;
            if(filter){ // Si on filtre pas, on affiche tous les livres
                query += " WHERE Disponible = " + Boolean.toString(disponible); // On peut choisir d'afficher la liste des livres disponible / non disponible
                if(!categorie.isEmpty()) // On peut rechercher une categorie en particulier si on le souhaite
                    query += " AND Categorie = " + categorie;
            }
            
            query += " ORDER BY DateAjout"; // Les nouveaux livre en premier 
            
            //query += " ORDER BY ID";
            //System.out.println(query);
            
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                
                Book newBook = new Book(result.getInt("ID"), result.getString("Titre"), 
                        result.getString("Categorie"), result.getString("Ref"),result.getString("Auteur"), 
                        result.getString("Description"), result.getDate("DateAjout"), result.getInt("Etat"),
                        result.getInt("Stock"));
                
                bookList.add(newBook);
            }
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur get book : " + sqlExcept.getMessage());
        }
        
        return bookList;
    }
    
    // retorune la liste des livres de la BDD
    public static List<User> GetUser(boolean filter, boolean isClient){
        List<User>userList = new ArrayList<>();
        
        try{
             
            stmt = conn.createStatement(); 
            
            // On recupere tout les livres de la BDD
            String query = "SELECT * FROM " + userTable;
            
            if(filter){ // Si on filtre pas, on affiche tous les livres
                query += " WHERE Groupe = ";
                query += isClient ? ("'"+User.groupList[0]+"'") : ("'"+User.groupList[1]+"'");
            }
            
            query += " ORDER BY DateInscription"; // Les nouveaux user en premier
            
            //query += " ORDER BY ID";
            //System.out.println(query);
            
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                
                User newUser = new User(result.getInt("ID"), result.getString("Nom"), 
                        result.getString("Prenom"), result.getString("Email"),result.getString("Password"), 
                        result.getString("Groupe"), result.getDate("DateInscription"));
                
                userList.add(newUser);
            }
            stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur get Users : " + sqlExcept.getMessage());
        }
        
        return userList;
    }
        
    // Retourne la date actuelle sous forme jj/mm/aaaa
    public static Date GetActualDate(){
        long millis=System.currentTimeMillis();  
        return new Date(millis);
    }
}
