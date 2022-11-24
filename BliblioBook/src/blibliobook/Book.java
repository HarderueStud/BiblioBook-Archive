package blibliobook;
import java.sql.Date;

public class Book {
    
    // Liste des groupes disponibles pour les utilisateurs
    public static final String[] CategoryList = {"Art", "Cuisine", "Histoire","Jeunesse", "Policier", "Humour",
        "Bande dessinées", "Droit & Economie"};
    
    public int ID;
    public String titre;
    public String categorie;
    public String ref;
    public String Auteur;
    public String Description;
    public Date dateAjout;
    public int etat;
    public int stock;

    // Constructeur d'objet
    public Book(int ID, String titre, String categorie, String ref, String Auteur, String Description, Date dateAjout, int etat, int stock) {
        this.ID = ID;
        this.titre = titre;
        this.categorie = categorie;
        this.ref = ref;
        this.Auteur = Auteur;
        this.Description = Description;
        this.dateAjout = dateAjout;
        this.etat = etat;
        this.stock = stock;
    }
    
    // Verification des infos d'un livre
    public static boolean IsBookValid(String p_titre, String p_cat, String p_ref, String p_auteur, String p_description, int p_etat, int p_stock){
        
        if(p_titre.length() < 1 || p_titre.length() > 40)
        {
            System.out.println("Erreur : 1 < Titre < 40 (caracteres)");
            return false;
        }
        
        // Verification si la categorie est bien dans la liste ?
        //...
        
        if(p_ref.length() < 6 || p_ref.length() > 12) // 
        {
            System.out.println("Erreur : 6 < Reference < 12 (caracteres)");
            return false;
        }
        
        if(p_auteur.length() < 1 || p_auteur.length() > 20)
        {
            System.out.println("Erreur : 1 < Auteur < 20 (caracteres)");
            return false;
        }
        
        if(p_description.length() > 1000)
        {
            System.out.println("Erreur : 0 < Description < 1000 (caracteres)");
            return false;
        }
        
        if(p_etat < 1 || p_etat > 5)
        {
            System.out.println("Erreur : 1 < Etat < 5 (nombre)");
            return false;
        }
        
        return p_stock >= 0;
    }
}
