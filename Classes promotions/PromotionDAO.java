package Main.Classe.DAO;

import java.sql.*;
import Main.Classe.Implements.PromotionImp;


public class PromotionDAO implements DAO<PromotionImp>{
    
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
    
    public void addPromotion(PromotionImp promo)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO promotion (id, nom) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, promo.getIdPromo());
            statement.setString(2, promo.getNom());
            statement.execute();
            
            System.out.println("La promotion est enregistrée dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cette promotion");
        }
    }
    
    @Override
    public void delete(PromotionImp promo, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            promo.setIdPromo(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("La promotion n°" + id + " est supprimée de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer la promotion");
        }
    }
}