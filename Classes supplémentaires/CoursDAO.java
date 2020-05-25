
package Main.Classe.DAO;

import java.sql.*;
import Main.Classe.Implements.CoursImp;

public class CoursDAO implements DAO<CoursImp> 
{
    private String url;
    private String user;
    private String password;
    
    public CoursDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayCours(int id, String nom)
    {
        System.out.println("COURS N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("");
    }
    

    public void addCours(CoursImp cours)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO cours(nom) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cours.getNom());
            statement.execute();
            
            System.out.println("Le cours " + cours.getNom() + " est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    public void addCoursEnseignant(CoursImp cours, int id_cours, int id_utilisateur)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "UPDATE enseignant SET id_cours = " + id_cours + " WHERE id_utilisateur = " + id_utilisateur + "";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            
            String sql1 = "SELECT * FROM cours WHERE id = " + id_cours + "";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            ResultSet resultSet = statement1.executeQuery();

            while(resultSet.next())
            {
                cours.setIdCours(resultSet.getInt("id"));
                cours.setNom(resultSet.getString("nom"));
            }
            
            System.out.println("Le professeur n°" + cours.getIdCours() + " enseigne " + cours.getNom());
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    public void updateCours(CoursImp cours, int id, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            if(cours.getIdCours()==0)
            {
                addCours(cours);
         
            }
            else
            {
                cours.setIdCours(id);
                String sql = "UPDATE cours SET nom = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
            }
            
           System.out.println("Le cours " + cours.getNom() + " est modifié avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
   
    
    public void delete(CoursImp cours, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            cours.setIdCours(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("Le cours n°" + id + " est supprimé de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'utilisateur");
        }
    }
    
    public CoursImp getCoursById(CoursImp cours, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM cours WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                cours.setIdCours(resultSet.getInt("id"));
                cours.setNom(resultSet.getString("nom"));
                
                int id_cours = cours.getIdCours();
                String nom_cours = cours.getNom();                
                displayCours(id_cours, nom_cours);
            }
            return cours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public CoursImp getCoursByName(CoursImp cours, String nom)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM cours WHERE nom = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nom);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                cours.setIdCours(resultSet.getInt("id"));
                cours.setNom(resultSet.getString("nom"));
                
                int id_cours = cours.getIdCours();
                String nom_cours = cours.getNom();
                
                displayCours(id_cours, nom_cours);
            }
            return cours;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
}
