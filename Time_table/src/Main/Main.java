
package Main;

import Main.Classe.Utilisateur;
import Main.Classe.DAO.UtilisateurDAO;

public class Main 
{

    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/hyperplanning";
        String user = "root";
        String password = "";
        
        String typeString = "nom";
        String valueString = "DE SILVA";
        
        String typeInt = "droit";
        int valueInt = 1;
        
        Utilisateur utilisateur = new Utilisateur();
        
        utilisateur.setId(1);
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(url, user, password);

        //System.out.println(utilisateur.getId());
        //utilisateurDAO.updateUtilisateurInt(utilisateur, utilisateur.getId(), typeInt, valueInt);
        utilisateurDAO.updateUtilisateurString(utilisateur, utilisateur.getId(), typeString, valueString);

        //utilisateurDAO.getUtilisateurByInt(typeInt, valueInt);
        //utilisateurDAO.getUtilisateurByString(typeString, valueString);

        
    }
    
    
}



