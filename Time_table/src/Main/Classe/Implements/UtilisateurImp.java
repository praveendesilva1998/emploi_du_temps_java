
package Main.Classe.Implements;

import Main.Classe.Utilisateur;

public class UtilisateurImp implements Utilisateur
{
    private int id_utilisateur;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int droit;
    
    
    public UtilisateurImp(){}
    
    public UtilisateurImp(int id, String email, String password, String nom, String prenom, int droit)
    {
        this.id_utilisateur = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    
    //getters
    public int getIdUtilisateur()
    {
        return id_utilisateur;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public String getPrenom()
    {
        return prenom;
    }
    
    public int getDroit()
    {
        return droit;
    }
   
    //setters
    public void setIdUtilisateur(int id)
    {
        this.id_utilisateur = id;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
 
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    
    public void setDroit(int droit)
    {
        this.droit = droit;
    }

}

   
