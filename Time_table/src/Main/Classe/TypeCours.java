
package Main.Classe;


public class TypeCours 
{
    private int id;
    private String nom;
    
    public TypeCours(){}
    
    public TypeCours(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    
    //getters
    public int getId()
    {
        return id;
    }
    
    public String getNom()
    {
        return nom;
    }
   
    //setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
}
