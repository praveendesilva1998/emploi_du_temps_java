package Main;

import Main.Classe.DAO.EtudiantDAO;
import Main.Classe.Implements.UtilisateurImp;
import Main.Classe.DAO.UtilisateurDAO;
import Main.Classe.DAO.GroupeDAO;
import Main.Classe.DAO.PromotionDAO;
import Main.Classe.DAO.SalleDAO;
import Main.Classe.DAO.SiteDAO;
import Main.Classe.Implements.GroupeImp;
import Main.Classe.Implements.EtudiantImp;
import Main.Classe.Implements.PromotionImp;
import Main.Classe.Implements.SalleImp;
import Main.Classe.Implements.SiteImp;


public class Main 
{

    public static void main(String[] args)
    {
        //TEST UTILISATEUR     
        String typeString = "nom";
        String valueString = "De Silva";
        String typeInt = "droit";
        int valueInt = 1; 
        UtilisateurDAO utilisateur = new UtilisateurDAO();
        UtilisateurImp utilisateurImp = new UtilisateurImp();
        //utilisateurImp.setId(1);
        //System.out.println(utilisateurImp.getId());
        //utilisateur.updateUtilisateurInt(utilisateurImp, utilisateurImp.getId(), typeInt, valueInt);
        //utilisateur.updateUtilisateurString(utilisateurImp, utilisateurImp.getId(), typeString, valueString);
        //utilisateur.getUtilisateurByInt(utilisateurImp, typeInt, valueInt);
        //utilisateur.getUtilisateurByString(utilisateurImp, typeString, valueString);
        //utilisateur.deleteUtilisateur(utilisateurImp, utilisateurImp.getId());
        
        //TEST GROUPE
        GroupeDAO groupe = new GroupeDAO();
        GroupeImp g = new GroupeImp();
        g.setIdGroupe(1);
        g.setNom("Groupe 5");
        //groupe.addGroupe(g);
        //groupe.delete(g, "groupe",1);        
        
        //TEST ETUDIANT
        EtudiantDAO etu = new EtudiantDAO();
        EtudiantImp e = new EtudiantImp();
        e.setIdUtilisateur(1);
        e.setIdGroupe(5);
        e.setNumero(145236520);
        //etu.addEtudiant(e);
        //etu.delete(e, "etudiant",1);
        
        //TEST PROMOTIOn
        PromotionDAO p = new PromotionDAO();
        PromotionImp pr = new PromotionImp();
        pr.setIdPromo(1);
        pr.setNom("ING 3");
        //p.addPromotion(pr);
        //p.delete(pr,"promotion",1);
        
        //TEST SITE
        SiteDAO s = new SiteDAO();
        SiteImp site = new SiteImp();
        site.setIdSite(1);
        site.setNom("INSEEC");
        //s.addSite(site);
        //s.delete(site, "site", 1);
        
        //TEST SALLE
        SalleDAO sa = new SalleDAO();
        SalleImp sal = new SalleImp();
        sal.setIdSalle(1);
        sal.setNom("P304");
        sal.setCapacite(40);
        sal.setIdSite(1);
        //sa.addSalle(sal);
        sa.delete(sal, "salle", 1);
    }
    
    
}