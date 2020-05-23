
package Main;

import Main.Classe.Implements.UtilisateurImp;
import Main.Classe.DAO.UtilisateurDAO;
import Main.Classe.DAO.CoursDAO;
import Main.Classe.Implements.CoursImp;

public class Main 
{

    public static void main(String[] args)
    {
        
        
        String typeString = "nom";
        String valueString = "De Silva";
        
        String typeInt = "droit";
        int valueInt = 1;
        
        CoursImp coursImp = new CoursImp();
        CoursDAO cours = new CoursDAO();

        cours.getCoursByName(coursImp, "Physique");

        
        UtilisateurDAO utilisateur = new UtilisateurDAO();
        UtilisateurImp utilisateurImp = new UtilisateurImp();
        
        //utilisateurImp.setId(1);

        //System.out.println(utilisateurImp.getId());
        //utilisateur.updateUtilisateurInt(utilisateurImp, utilisateurImp.getId(), typeInt, valueInt);
        //utilisateur.updateUtilisateurString(utilisateurImp, utilisateurImp.getId(), typeString, valueString);

        utilisateur.getUtilisateurByInt(utilisateurImp, typeInt, valueInt);
        utilisateur.getUtilisateurByString(utilisateurImp, typeString, valueString);
        //utilisateur.deleteUtilisateur(utilisateurImp, utilisateurImp.getId());
        
    }
    
    
}



