
package Main.Classe;

public class Utilisateur 
{
    private int id;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private int droit;
    
    public Utilisateur(){}
    
    public Utilisateur(int id, String email, String password, String nom, String prenom, int droit)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.droit = droit;
    }
    
    //getters
    public int getId()
    {
        return id;
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
    public void setId(int id)
    {
        this.id = id;
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
