package Main.Classe.DAO;


public class PromotionDAO {
    
    //Attributs
    private String url;
    private String user;
    private String password;
    
    public PromotionDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayPromotion(int id, String nom)
    {
        System.out.println("Promotion N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        
        System.out.println("");
    }
    
}