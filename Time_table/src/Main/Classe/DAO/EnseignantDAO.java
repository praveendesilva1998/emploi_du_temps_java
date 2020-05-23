
package Main.Classe.DAO;

import Main.Classe.Enseignant;
import java.sql.*;


public class EnseignantDAO implements DAO<Enseignant>
{
    private String url;
    private String user;
    private String password;
    
    public EnseignantDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayEnseignant(int id, String email, String password, String nom, String prenom)
    {
        System.out.println("UTILISATEUR N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("     Prénom : " + prenom);
        System.out.println("     Email : " + email);
        System.out.println("     Mot de Passe : " + password);
        System.out.println("     Rôle : Enseignant");

        System.out.println("");
    }
      
   
    public Enseignant getUtilisateurByIdUtilisateur(Enseignant enseignant, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM enseignant WHERE id_utilisateur = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                enseignant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                enseignant.setIdCours(resultSet.getInt("id_cours"));

                
                int id_utilisateur = enseignant.getIdUtilisateur();
                int id_cours = enseignant.getIdCours();
                String email = enseignant.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                int droit = 3;
                
                displayEnseignant(id_utilisateur, email, password, nom, prenom, droit);
            }
            return utilisateur;

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public UtilisateurImp getUtilisateurByString(UtilisateurImp utilisateur, String type, String value)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM utilisateur WHERE "+type+" = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                utilisateur.setIdUtilisateur(resultSet.getInt("id"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));
                utilisateur.setDroit(resultSet.getInt("droit"));
                
                int id_utilisateur = utilisateur.getIdUtilisateur();
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
