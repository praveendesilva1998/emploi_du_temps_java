
package Main.Classe.DAO;

import Main.Classe.Enseignant;
import Main.Classe.Implements.CoursImp;
import Main.Classe.Implements.UtilisateurImp;
import java.sql.*;


public class EnseignantDAO implements DAO<Enseignant>
{
    private String url;
    private String user;
    private String password;
    
    UtilisateurImp utilisateur = new UtilisateurImp();
    CoursImp cours = new CoursImp();
    
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
    
    public void addEnseignant(Enseignant enseignant, Connection connection, int id_utilisateur)
    {
        try
        {    
            String sql1 = "INSERT INTO enseignant (id_utilisateur, id_cours) VALUES (?, ?)";
            PreparedStatement statement1 = connection.prepareStatement(sql1);
            statement1.setInt(1, id_utilisateur);
            statement1.setInt(2, 0);
            statement1.execute();

            System.out.println("L'enseignant n°" + id_utilisateur + " est enregistré dans la base de données Enseignant");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet utilisateur");
        }
    }
   
    public Enseignant getEnseignantByIdUtilisateur(Enseignant enseignant, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM enseignant, utilisateur WHERE id = id_utilisateur AND id_utilisateur = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next())
            {
                enseignant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                enseignant.setIdCours(resultSet.getInt("id_cours"));
                utilisateur.setEmail(resultSet.getString("email"));
                utilisateur.setPassword(resultSet.getString("password"));
                utilisateur.setNom(resultSet.getString("nom"));
                utilisateur.setPrenom(resultSet.getString("prenom"));

                
                int id_utilisateur = enseignant.getIdUtilisateur();
                int id_cours = enseignant.getIdCours();
                String email = utilisateur.getEmail();
                String password = utilisateur.getPassword();
                String nom = utilisateur.getNom();
                String prenom = utilisateur.getPrenom();
                
                displayEnseignant(id_utilisateur, email, password, nom, prenom);
            }
            
            return enseignant;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public UtilisateurImp getEnseignantByIdCours(Enseignant enseignant, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "SELECT * FROM enseignant, cours WHERE id = id_cours AND id_cours = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next())
            {
                enseignant.setIdUtilisateur(resultSet.getInt("id_utilisateur"));
                enseignant.setIdCours(resultSet.getInt("id_cours"));
                cours.setNom(resultSet.getString("nom"));

                int id_cours = enseignant.getIdCours();
                int id_utilisateur = enseignant.getIdUtilisateur();
                String nom = cours.getNom();
                
                System.out.println("COURS N°"+ id_cours + " :");
                System.out.println("     Nom : " + nom);
                System.out.println("     ID Professeur : " + id_utilisateur);
                System.out.println("");
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
