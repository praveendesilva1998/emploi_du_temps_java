package Main.Classe.Implements;

import Main.Classe.Site;


public class SiteImp implements Site{
    //Attribut
    private int id;
    private String nom;
    
    //Constructeur
    public SiteImp(){
        
    }
    
    public SiteImp(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    //Getters
    public int getIdSite(){
        return id;
    }
    
    public String getNom(){
        return nom;
    }
    
    //Setters
    public void setIdSite(int id){
        this.id = id;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
}

