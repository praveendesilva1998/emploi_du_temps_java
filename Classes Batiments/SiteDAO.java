package Main.Classe.DAO;

import Main.Classe.Implements.SiteImp;
import java.sql.*;

public class SiteDAO implements DAO<SiteImp>{
    
    private String url;
    private String user;
    private String password;
    
    public SiteDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displaySite(int id, String nom)
    {
        System.out.println("Site N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        
        System.out.println("");
    }
    
    public void addSite(SiteImp site)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO site (id, nom) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, site.getIdSite());
            statement.setString(2, site.getNom());
            statement.execute();
            
            System.out.println("Le site est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter ce site");
        }
    }
    
    public void delete(SiteImp site, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            site.setIdSite(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("Le site n°" + id + " est supprimé de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer le site");
        }
    }

}
