package Main.Classe.Implements;

import Main.Classe.Etudiant;



public class EtudiantImp implements Etudiant{
    //Attributs
    private int id_utilisateur;
    private int numero;
    private int id_groupe;
    
    
    //Constructeur
    public EtudiantImp(){}
    
    public EtudiantImp(int id_utilisateur, int numero, int id_groupe){
        this.id_utilisateur = id_utilisateur;
        this.numero = numero;
        this.id_groupe = id_groupe;
    }
    
    //getters
    public int getIdUtilisateur(){
        
        return id_utilisateur;
    }
    
    public int getNumero(){
        
        return numero;
    }
    
    public int getIdGroupe(){
        
        return id_groupe;
    }
    
    //setters
    public void setIdUtilisateur(int u){
        
        this.id_utilisateur = u;
    }
    
    public void setNumero(int n){
        
        this.numero = n;
    }
    
    public void setIdGroupe(int j){
        
        this.id_groupe = j;
    }
}
