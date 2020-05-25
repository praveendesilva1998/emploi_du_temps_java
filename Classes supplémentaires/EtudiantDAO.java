package Main.Classe.DAO;

import java.sql.*; 
import Main.Classe.Implements.EtudiantImp;

public class EtudiantDAO implements DAO<EtudiantImp> {
    
    //Attributs
    private String url;
    private String user;
    private String password;
    
    //Constructeur
    public EtudiantDAO()
    {
        this.url = "jdbc:mysql://localhost:3306/hyperplanning";
        this.user = "root";
        this.password = "";
    }
    
    public void displayEtudiant(int id, String email, String password, String nom, String prenom, int id_groupe)
    {
        System.out.println("UTILISATEUR N°"+ id + " :");
        System.out.println("     Nom : " + nom);
        System.out.println("     Prénom : " + prenom);
        System.out.println("     Email : " + email);
        System.out.println("     Mot de Passe : " + password);
        

        
        System.out.println("");
    }
    
    
    public void addEtudiant(EtudiantImp etudiant)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);
            
            String sql = "INSERT INTO etudiant (id, numero, id_groupe) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, etudiant.getIdUtilisateur());
            statement.setInt(2, etudiant.getNumero());
            statement.setInt(3, etudiant.getIdGroupe());
            statement.execute();
            
            System.out.println("L'étudiant est enregistré dans la base de données");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible d'ajouter cet étudiant");
        }
    }
    
    @Override
    public void delete(EtudiantImp etudiant, String table, int id)
    {
        try
        {
            Connection connection = DriverManager.getConnection(url,user,password);

            etudiant.setIdUtilisateur(id);
            String sql = "DELETE FROM " + table + " WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();

            System.out.println("L'étudiant n°" + id + " est supprimé de la base de données avec succès");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Impossible de supprimer l'étudiant");
        }
    }
}
