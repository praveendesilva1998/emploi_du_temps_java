
package Main.Classe.Implements;

import Main.Classe.Cours;

public class CoursImp implements Cours
{
    private String nom;   
    public int id_cours;
    
    public CoursImp(){}
        
    //getters
    public int getIdCours()
    {
        return id_cours;
    }
    
    public String getNom()
    {
        return nom;
    }
   
    //setters
    public void setIdCours(int id)
    {
        this.id_cours = id;
    }
 
    public void setNom(String nom)
    {
        this.nom = nom;
    }
}
