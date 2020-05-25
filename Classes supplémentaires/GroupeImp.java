package Main.Classe.Implements;

import Main.Classe.Groupe;

public class GroupeImp implements Groupe{
    
    //Attributs
    private int id_groupe;
    private String nom;
    private int id_promo;
    
    //Constructeurs
    public GroupeImp(){}
    
    public GroupeImp(int id, String nom, int id_promo)
    {
        this.id_groupe = id;
        this.nom = nom;
        this.id_promo = id_promo;
    }
    
    //getters
    public int getIdGroupe()
    {
        return id_groupe;
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public int getIdPromo()
    {
        return id_promo;
    }
   
    //setters
    public void setIdGroupe(int id)
    {
        this.id_groupe = id;
    }
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    public void setIdPromo(int idp)
    {
        this.id_promo = idp;
    }
 
}