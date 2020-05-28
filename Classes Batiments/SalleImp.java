package Main.Classe.Implements;

import Main.Classe.Salle;


public class SalleImp implements Salle{
    
    //Attributs
    private int id;
    private String nom;
    private int capacite;
    private int id_site;
    
    //Constructeurs
    public SalleImp(){
        
    }
    
    public SalleImp(int id, String nom, int capacite, int id_site){
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.id_site = id_site;
    }
    
    
    //Getters
    public int getIdSalle(){
        
        return id;
    }
    
    public String getNom(){
        
        return nom;
    }
    
    public int getCapacite(){
        
        return capacite;
    }
    
    public int getIdSite(){
        
        return id_site;
    }
    
    //Setters
    public void setIdSalle(int id){
        
        this.id = id;
    }
    
    public void setNom(String n){
        
        this.nom = n;
    }
    
    public void setCapacite(int c){
        
        this.capacite = c;
    }
    
    public void setIdSite(int s){
        
        this.id_site = s;
    }
}
