package shool.Repositories.Core;

import shool.Repositories.DB.ClasseDAO;
import shool.Repositories.DB.EtudiantDAO;
import shool.Repositories.DB.InscriptionDAO;
import shool.Repositories.DB.ProfesseurDAO;
import shool.Repositories.DB.UserDAO;
import shool.Repositories.Interface.IClasse;
import shool.Repositories.Interface.IEtudiant;
import shool.Repositories.Interface.IInscription;
import shool.Repositories.Interface.IProfesseur;
import shool.Repositories.Interface.IUser;
import shool.Services.IService;
import shool.Services.Service;

public class Factory {
    public static IService getService(){

        IClasse classeDAO=new ClasseDAO();
        IEtudiant etudiantDAO= new EtudiantDAO();
        IInscription inscriptionDAO = new InscriptionDAO();
        IProfesseur professeurDAO= new ProfesseurDAO();
        IUser userDAO = new UserDAO();

        IService service = new Service(classeDAO, etudiantDAO, inscriptionDAO, professeurDAO, userDAO);
        return service;

    }
    
}
