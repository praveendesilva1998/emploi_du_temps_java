
package Main.Classe.Implements;

import Main.Classe.Cours;

public class CoursImp implements Cours
{
    private String nom;   
    private int id_cours;
    
    public CoursImp(){}
        
    //getters
    @Override
    public int getIdCours()
    {
        return id_cours;
    }
    
    public String getNom()
    {
        return nom;
    }
   
    //setters
    @Override
    public void setIdCours(int id)
    {
        this.id_cours = id;
    }
 
    public void setNom(String nom)
    {
        this.nom = nom;
    }
}
