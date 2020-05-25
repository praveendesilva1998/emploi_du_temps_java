package Main.Classe.DAO;

import java.sql.*; 
import Main.Classe.Implements.GroupeImp;

public class GroupeDAO implements DAO<GroupeImp>{
    
    private String url;
    private String user;
    private String password;
    
    public GroupeDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayGroupe(int id, String nom, int id_promo)
    {
        System.out.println("Groupe N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("     Promo N° : " + id_promo);
        
        System.out.println("");
    }
    
    public void addGroupe(GroupeImp groupe)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO groupe (id, nom, id_promo) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, groupe.getIdGroupe());
            statement.setString(2, groupe.getNom());
            statement.setInt(3, groupe.getIdPromo());;
            statement.execute();
            
            System.out.println("Le groupe est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter ce groupe");
        }
    }
    
    @Override
    public void delete(GroupeImp groupe, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            groupe.setIdGroupe(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("Le groupe n°" + id + " est supprimé de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
}