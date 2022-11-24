package blibliobook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AuthentificationFrame extends javax.swing.JFrame {
    private final DataBase db;
    
    // Constructor
    public AuthentificationFrame() {
        initComponents();
        db = new DataBase();
        
        DataBase.InitTable(); // On cree les tables dans la BDD si elles ne le sont pas encore.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NoAccountButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();
        infoMessage = new javax.swing.JLabel();
        createRandomData = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        title.setFont(new java.awt.Font("Calisto MT", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(160, 80, 126));
        title.setText("BliblioBooks ");

        emailTextField.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        emailTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailTextField.setToolTipText("Enter your email");

        passwordTextField.setFont(new java.awt.Font("Calisto MT", 0, 14)); // NOI18N
        passwordTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordTextField.setToolTipText("Enter your password");
        passwordTextField.setEchoChar('*');

        jLabel2.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel2.setText("MDP :");

        jLabel3.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        jLabel3.setText("Email :");

        NoAccountButton.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        NoAccountButton.setText("Pas encore de compte ?");
        NoAccountButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                NoAccountButtonMousePressed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Calisto MT", 0, 18)); // NOI18N
        LoginButton.setText("Se connecter");
        LoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LoginButtonMousePressed(evt);
            }
        });

        infoMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        infoMessage.setForeground(new java.awt.Color(156, 42, 42));
        infoMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        createRandomData.setText("?");
        createRandomData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                createRandomDataMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addComponent(infoMessage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoAccountButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(createRandomData)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createRandomData))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NoAccountButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoAccountButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NoAccountButtonMousePressed
        NoAccount();
    }//GEN-LAST:event_NoAccountButtonMousePressed

    private void LoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginButtonMousePressed
        String pass = new String(passwordTextField.getPassword()); // On recup le mot de passe sous forme de String
        String email = emailTextField.getText().toLowerCase(); // On recupere l'email
        
        UserConnection(email, pass); // On essaye de connecter l'utilisateur
    }//GEN-LAST:event_LoginButtonMousePressed

    // Creation de donnée aleatoire, livres, utilisateurs, emprunts
    private void createRandomDataMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createRandomDataMousePressed
        CreateRandomData(50, 50, 200);
        infoMessage.setText("Création des data de maniere aleatoire");
    }//GEN-LAST:event_createRandomDataMousePressed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AuthentificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuthentificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuthentificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuthentificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuthentificationFrame().setVisible(true);
            }
        });
    }
    
    // On va sur la page pour cree un compte (register)
    private void NoAccount(){
        this.dispose();
        new CreateAccountFrame().setVisible(true);
    }
    
    // La connexion, verification mdp et email
    private void UserConnection(String email, String password){
        try{
            
            DataBase.stmt = DataBase.conn.createStatement(); 
            
            // On essaye de trouver un utilisateur dans la base de donné ayant la même empreinte de mot de passe & le même email.
            String query = "SELECT * FROM " + DataBase.userTable + " WHERE Email = '" + email +
                    "' AND Password = '" + User.Hashpassword(password) + "'";  // SQL injection compliqué avec HashPassword directement dans la requete, mais reste possible de tricher
            
            //System.out.println(query);
            
            ResultSet result = DataBase.stmt.executeQuery(query);
            
            // Si nous n'avons aucun resultat -> mauvais mdp / email
            if(!result.next()){
                System.out.println("Mauvais pass / email.");
                infoMessage.setText("Erreur : Email / Mot de passe invalide !");
            }
            else{ // On a trouver un resultat (l'utilisateur)
                // Utilisateur reconnu, on ouvre l'application qui lui correspond
                LoginSuccess(result.getInt("ID"), result.getString("Groupe"));
            }
            
            DataBase.stmt.close();
        }
        catch (SQLException sqlExcept)
        {
            System.out.println("Erreur connexion : " + sqlExcept.getMessage());
        }
    }
    
    // On s'est bien connecté, on est rediriger en fonction de notre groupe utilisateur (client / blibliothecaire)
    private void LoginSuccess(int userID, String group){
        this.dispose();
        
        // Redirection
        if(User.groupList[1] == null ? group == null : User.groupList[1].equals(group)) // Bliblio app, tous les droits, utilisateur admin
            new Bliblio_App(userID).setVisible(true);
        else if (group == null ? User.groupList[0] == null : group.equals(User.groupList[0])) // Client app, juste quelques droits, utilisateur lambda
            new Client_App(userID).setVisible(true);
    }
    
    
    // Création de données de maniere aleatoire, pour des tests.
    private void CreateRandomData(int nbrUser, int nbrBook, int nbrEmprunt){
        // Deux comptes blibliothecaire, avec tous les droits
        DataBase.CreateUser("Bob", "Bob", "bob@gmail.com", "Aa1234@?", User.groupList[1]);
        DataBase.CreateUser("Jul", "Jul", "jul@gmail.com", "Aa1234@?", User.groupList[1]);
        // Création utilisateurs
        for(int x = 0; x < nbrUser; x++){
            String nom = "Nom " + (x+1);
            String prenom = "Prenom " + (x+1);
            String email = nom.replace(" ", "").toLowerCase() + "@gmail.com"; // email -> nom  + @gmail.com
            String pass = "Aa1234@?"; // Tous les utilisateurs ont le même mdp pour des raisons de test, un generateur de mot de passe est par ailleur present si besoin (la class RandomStringGenerator).
            String groupe = User.groupList[0]; // CLient normal
            
            DataBase.CreateUser(nom, prenom, email, pass, groupe);
        }
        
        Random rand = new Random();
        RandomStringGenerator rendS = new RandomStringGenerator(12, ThreadLocalRandom.current());
        
        // Creation des livres
        for(int x = 0; x < nbrBook; x++){
            
            String titre = "Titre " + (x+1);
            String categorie = Book.CategoryList[rand.nextInt(Book.CategoryList.length)];
            String ref = rendS.nextString();
            String auteur = "Viktor Hugo";
            String description = "Je suis une longue description du livre que je represente...";
            int etat = (int)(Math.random() * ((5 - 1) + 1)) + 1; // L'etat du livre est entre 1 et 5
            int stock = (int)(Math.random() * ((7 - 0) + 1)) + 0; // il y aura entre 0 et 7 exemplaire pour chaquun des livres. -> petit tock pour bonne proba d'avoir des livres non dispos
            
            DataBase.CreateBook(titre, categorie, ref, auteur, description, etat, stock);
        }
        
        // Creation emprunt, possible collision donc possible erreurs durant les emprunts -> pas grave, emprunt juste pour faire des tests
        int empruntReussi = 0;
        for(int x = 0; x < nbrEmprunt; x++){
            int randUser = (int)(Math.random() * ((nbrUser - 1) + 1)) + 1;            
            int randBook = (int)(Math.random() * ((nbrBook - 1) + 1)) + 1;
            int randNbrJour = (int)(Math.random() * ((20 - 1) + 1)) + 1;
            
            if(DataBase.CreateLoan(randUser, randBook, randNbrJour))
                empruntReussi += 1;
        }
        
        for(int x = 1; x < (int)empruntReussi/2; x++) // on termine la moitier des emprunts commencer
            DataBase.FinishLoan(x);
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton NoAccountButton;
    private javax.swing.JButton createRandomData;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel infoMessage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}