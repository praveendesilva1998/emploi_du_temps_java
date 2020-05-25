
package Main;

import Main.Classe.DAO.EtudiantDAO;
import Main.Classe.Implements.UtilisateurImp;
import Main.Classe.DAO.UtilisateurDAO;
import Main.Classe.DAO.GroupeDAO;
import Main.Classe.Implements.GroupeImp;
import Main.Classe.Implements.EtudiantImp;



public class Main 
{

    public static void main(String[] args)
    {
               
        String typeString = "nom";
        String valueString = "De Silva";
        
        String typeInt = "droit";
        int valueInt = 1;
        
        UtilisateurDAO utilisateur = new UtilisateurDAO();
        UtilisateurImp utilisateurImp = new UtilisateurImp();
        
        GroupeDAO groupe = new GroupeDAO();
        GroupeImp g = new GroupeImp();
        g.setIdGroupe(1);
        g.setNom("Groupe 5");
        g.setIdPromo(3);
        groupe.addGroupe(g);
        
        EtudiantDAO etu = new EtudiantDAO();
        EtudiantImp e = new EtudiantImp();
        e.setIdUtilisateur(1);
        e.setIdGroupe(5);
        e.setNumero(145236520);
        //etu.addEtudiant(e);
        
        etu.delete(e, "etudiant",1);
        //utilisateurImp.setId(1);

        //System.out.println(utilisateurImp.getId());
        //utilisateur.updateUtilisateurInt(utilisateurImp, utilisateurImp.getId(), typeInt, valueInt);
        //utilisateur.updateUtilisateurString(utilisateurImp, utilisateurImp.getId(), typeString, valueString);

        //utilisateur.getUtilisateurByInt(utilisateurImp, typeInt, valueInt);
        //utilisateur.getUtilisateurByString(utilisateurImp, typeString, valueString);
        //utilisateur.deleteUtilisateur(utilisateurImp, utilisateurImp.getId());
        
    }
    
    
}