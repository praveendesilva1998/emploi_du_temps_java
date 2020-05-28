package Main.Classe.DAO;

import Main.Classe.Implements.SalleImp;
import java.sql.*;

public class SalleDAO implements DAO<SalleImp>{
    
    private String url;
    private String user;
    private String password;
    
    public SalleDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displaySalle(int id, String nom, int capacite, int id_site)
    {
        System.out.println("Salle N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("Capacite : " + capacite);
        System.out.println(" ID Site : " + id_site);
        System.out.println("");
    }
    
    public void addSalle(SalleImp salle)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO salle (id, nom, capacite, id_site) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, salle.getIdSalle());
            statement.setString(2, salle.getNom());
            statement.setInt(3, salle.getCapacite());
            statement.setInt(4, salle.getIdSite());
            statement.execute();
            
            System.out.println("La salle est enregistrée dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter la salle");
        }
    }
    
    public void delete(SalleImp salle, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            salle.setIdSalle(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("La salle n°" + id + " est supprimée de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer la salle");
        }
    }
}
