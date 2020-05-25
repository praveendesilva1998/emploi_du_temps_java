
package Main.Classe.DAO;

import Main.Classe.TypeCours;
import java.sql.*;


public class TypeCoursDAO 
{
    private String url;
    private String user;
    private String password;
        
    public TypeCoursDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayTypeCours(int id, String nom)
    {
        System.out.println("TYPE DE COURS N°"+ id + " :");
        System.out.println("     Nom dy type: " + nom);
    }
    
    public void addType(TypeCours typeCours, String type)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO type_cours (nom) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            statement.execute();
  
            System.out.println("Le type de cours : " + type + " est enregistré dans la base de données");

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    public void updateTypeCours(TypeCours typeCours, int id, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            if(typeCours.getId()==0)
            {
                addType(typeCours, value);
         
            }
            else
            {
                typeCours.setId(id);
                String sql = "UPDATE cours SET nom = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
            }
            
           System.out.println("Le cours " + typeCours.getNom() + " est modifié avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    

    public void delete(TypeCours typeCours, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            typeCours.setId(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("Le type de cours n°" + id + " est supprimé de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
    
    public TypeCours getTypeCoursByInt(TypeCours typeCours, int value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM type_cours WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, value);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                typeCours.setId(resultSet.getInt("id"));
                typeCours.setNom(resultSet.getString("nom"));
                
                int id_type = typeCours.getId();
                String nom = typeCours.getNom();
                
                displayTypeCours(id_type, nom);
            }
            return typeCours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public TypeCours getTypeCoursByName(TypeCours typeCours, String type)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM type_cours WHERE nom = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, type);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                typeCours.setId(resultSet.getInt("id"));
                typeCours.setNom(resultSet.getString("nom"));
                
                int id_type = typeCours.getId();
                String nom = typeCours.getNom();
                
                displayTypeCours(id_type, nom);
            }
            return typeCours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
