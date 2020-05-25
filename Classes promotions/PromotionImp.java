package Main.Classe.Implements;

import Main.Classe.Promotion;


public class PromotionImp implements Promotion{
    
    //Attributs
    private int id;
    private String nom;
    
    //Constructeur
    public PromotionImp(){}
    
    public PromotionImp(int id, String nom){
        
        this.id = id;
        this.nom = nom;
    }
    
    //Getters
    public int getIdPromo(){
        
        return id;
    }
    
    public String getNom(){
        
        return nom;
    }
    
    //Setters
    public void setIdPromo(int i){
        
        this.id = i;
    }
    
    public void setNom(String n){
        
        this.nom = n;
    }
}
