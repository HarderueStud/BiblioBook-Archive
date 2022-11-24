package blibliobook;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class User {
    // Liste des groupes disponibles pour les utilisateurs
    public static final String[] groupList = {"client", "bliblio"};
    
    public final int ID; 
    public final String nom; 
    public final String prenom;
    public final String email;
    public final String password;
    public final String groupe;
    public final Date dateInscription;

    // Constructeur
    public User(int p_ID, String p_nom, String p_prenom, String p_email, String p_password,
            String p_groupe, Date p_dateInscription) 
    {
        this.ID = p_ID;
        this.nom = p_nom;
        this.prenom = p_prenom;
        this.email = p_email;
        this.password = p_password;
        this.groupe = p_groupe;
        this.dateInscription = p_dateInscription;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password=" + password +
                ", groupe=" + groupe + ", dateInscription=" + dateInscription + '}';
    }

    // On verifie que les infos donnés sont valide
    public static boolean IsUserValid(String p_nom, String p_prenom, String p_email, String p_groupe){    
    
        if(p_nom.length() < 1 || p_nom.length() > 20)
        {
            System.out.println("Erreur : 1 < Nom < 20 (caracteres)");
            return false;
        }
        
        if(p_prenom.length() < 3 || p_prenom.length() > 20)
        {
            System.out.println("Erreur : 3 < Prenom < 20 (caracteres)");
            return false;
        }
        
        if(!IsEmailValid(p_email)){
            System.out.println("Erreur : Adresse email invalide." + p_email);
            return false;
        }

        // Verification groupe dans liste groupe existant ?
        // ...
        
        return true;
    }  
    
    // L'adress email est-elle valide ?
    public static boolean IsEmailValid(String p_email) {
        String pattern = "[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}";
        //pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        final Pattern EMAIL_REGEX = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE);
        //System.out.println("email : " + EMAIL_REGEX.matcher(p_email).matches());
        return EMAIL_REGEX.matcher(p_email).matches();
    }
    
    // Le numéro de telephone est-il valide ?
    public static boolean IsPhoneNumberValid(String p_tel){
        final Pattern PHONE_REGEX = Pattern.compile("^\\w{10}$"); // 10 chiffres
        return PHONE_REGEX.matcher(p_tel).matches();
    }
    
    // Hash un mot de passe en Sha256 pour stocker dans BDD
    public static String Hashpassword(String p_pass) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(p_pass.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(UnsupportedEncodingException | NoSuchAlgorithmException ex){
            System.out.println("Erreur Hash du mot de passe : " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        // Catch -> returne rien on arrête, on peut pas continuer si hash non fonctionnel
    }
    
// Le mot de passe est-il valide ?
    public static boolean IsPasswordValid(String p_pass){
        final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        return PASSWORD_REGEX.matcher(p_pass).matches();
        
        /*
            ^                 # start-of-string
            (?=.*[0-9])       # a digit must occur at least once
            (?=.*[a-z])       # a lower case letter must occur at least once
            (?=.*[A-Z])       # an upper case letter must occur at least once
            (?=.*[@#$%^&+=])  # a special character must occur at least once
            (?=\S+$)          # no whitespace allowed in the entire string
            .{8,}             # anything, at least eight places though
            $                 # end-of-string
        */
    }
}
