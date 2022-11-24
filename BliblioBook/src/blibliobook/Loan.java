package blibliobook;
import java.sql.Date;

public class Loan {
    
    public final int ID;
    public final Date dateEmprunt;
    public final Date dateRenduPrevue;
    public Date dateRendu = null;
    public final int ID_Utilisateur;
    public final int ID_Livre;
    
    // Constructeur avec date de rendu
    public Loan(int p_ID, Date p_dateEmprunt, Date p_dateRenduPrevue, Date p_dateRendu,
            int p_ID_Utilisateur, int p_ID_Livre) 
    {
        this.ID = p_ID;        
        this.dateEmprunt = p_dateEmprunt;
        this.dateRenduPrevue = p_dateRenduPrevue;
        this.dateRendu = p_dateRendu;
        this.ID_Utilisateur = p_ID_Utilisateur;
        this.ID_Livre = p_ID_Livre;
    }
    
    // Constructeur sans date de rendu
    public Loan(int p_ID, Date p_dateEmprunt, Date p_dateRenduPrevue,
            int p_ID_Utilisateur, int p_ID_Livre) 
    {
        this.ID = p_ID;        
        this.dateEmprunt = p_dateEmprunt;
        this.dateRenduPrevue = p_dateRenduPrevue;
        this.ID_Utilisateur = p_ID_Utilisateur;
        this.ID_Livre = p_ID_Livre;
    }
    
    @Override
    public String toString() {
        return "Loan{" + "ID=" + ID + ", dateEmprunt=" + dateEmprunt + ", dateRenduPrevue=" + dateRenduPrevue +
                ", dateRendu=" + dateRendu + ", ID_Utilisateur=" + ID_Utilisateur + ", ID_Livre=" + ID_Livre + '}';
    }
    
    
    
}
