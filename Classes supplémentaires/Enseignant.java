
package Main.Classe;

import Main.Classe.Implements.CoursImp;
import Main.Classe.Implements.UtilisateurImp;

public class Enseignant implements Cours, Utilisateur
{
    CoursImp cours = new CoursImp();
    UtilisateurImp utilisateur = new UtilisateurImp();
    
    private int id_utilisateur;
    private int id_cours;
    
    public Enseignant(){}
    //getters

    public int getIdUtilisateur()
    {
        return utilisateur.id_utilisateur;      
    }
    

    public int getIdCours()
    {
        return cours.id_cours;
    }
    
    //setters
    public void setIdUtilisateur(int id)
    {
        this.utilisateur.id_utilisateur = id;
    }
    
    public void setIdCours(int id)
    {
        id_cours = cours.getIdCours();
        this.cours.id_cours = id;
    }
    
}
