
package Main.Classe.DAO;

import java.sql.*; 
import Main.Classe.Utilisateur;

public class UtilisateurDAO extends Utilisateur
{

    private String url;
    private String user;
    private String password;
    
    public UtilisateurDAO(String url, String user, String password)
    {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    public void displayUtilisateur(int id, String email, String password, String nom, String prenom, int droit)
    {
        System.out.println("UTILISATEUR N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("     Prénom : " + prenom);
        System.out.println("     Email : " + email);
        System.out.println("     Mot de Passe : " + password);
        
        if(droit==1)
        {
            System.out.println("     Rôle : Administrateur");
        }
        else if(droit==2)
        {
            System.out.println("     Rôle : Référent pédagogique");
        }
        else if(droit==3)
        {
            System.out.println("     Rôle : Enseignant");
        }
        else if(droit==4)
        {
            System.out.println("     Rôle : Etudiant");
        }
        
        System.out.println("");
    }
    
    public void addUtilisateur(Utilisateur utilisateur)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO utilisateur (email, password, nom, prenom, droit) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, utilisateur.getEmail());
            statement.setString(2, utilisateur.getPassword());
            statement.setString(3, utilisateur.getNom());
            statement.setString(4, utilisateur.getPrenom());
            statement.setInt(5, utilisateur.getDroit());
            statement.execute();
            
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom()+ " est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
    
    public void updateUtilisateurString(Utilisateur utilisateur, int id, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            if(utilisateur.getId()==0)
            {
                addUtilisateur(utilisateur);
         
            }
            else
            {
                utilisateur.setId(id);
                String sql = "UPDATE utilisateur SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, value);
                statement.setInt(2, id);
                statement.execute();
            }
            
           System.out.println("Le " + type + " de l'utilisateur n°" + id + " est modifié avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    public void updateUtilisateurInt(Utilisateur utilisateur, int id, String type, int value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            if(utilisateur.getId()==0)
            {
                addUtilisateur(utilisateur);
         
            }
            else
            {
                utilisateur.setId(id);
                String sql = "UPDATE utilisateur SET " + type + " = ? WHERE id = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setInt(1, value);
                statement.setInt(2, id);
                statement.execute();
            }
            
            System.out.println("Le " + type + " de l'utilisateur n°" + id + " est modifié avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de mettre à jour les informations");
        }
    }
    
    public Utilisateur getUtilisateurByInt(String type, int value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM utilisateur WHERE " + type +" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, value);
            ResultSet resultSet = statement.executeQuery();
            
            Utilisateur utilisateur = new Utilisateur();
            
            while(resultSet.next())
            {
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setDroit(resultSet.getInt("droit"));
                
                int id_utilisateur = utilisateur.getId();
                String email = utilisateur.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                int droit = utilisateur.getDroit();
                
                displayUtilisateur(id_utilisateur, email, password, nom, prenom, droit);
            }
            return utilisateur;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public Utilisateur getUtilisateurByString(String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM utilisateur WHERE "+type+" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            
            Utilisateur utilisateur = new Utilisateur();
            
            while(resultSet.next())
            {
                utilisateur.setId(resultSet.getInt("id"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setDroit(resultSet.getInt("droit"));
                
                int id_utilisateur = utilisateur.getId();
                String email = utilisateur.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                int droit = utilisateur.getDroit();
                
                displayUtilisateur(id_utilisateur, email, password, nom, prenom, droit);
            }
            return utilisateur;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
        
    
   
}
