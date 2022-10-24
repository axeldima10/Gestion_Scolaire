package shool.Services;

import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Etudiant;
import shool.Entities.Inscription;
import shool.Entities.Professeur;
import shool.Entities.User;
import shool.Repositories.Interface.IClasse;
import shool.Repositories.Interface.IEtudiant;
import shool.Repositories.Interface.IInscription;
import shool.Repositories.Interface.IProfesseur;
import shool.Repositories.Interface.IUser;




public class Service implements IService {
    IClasse classeDAO;
    IEtudiant etudiantDAO;
    IInscription inscriptionDAO;
    IProfesseur professeurDAO;
    IUser userDAO;

    
    
    

    public Service(IClasse classeDAO, IEtudiant etudiantDAO, IInscription inscriptionDAO, IProfesseur professeurDAO,
            IUser userDAO) {
        this.classeDAO = classeDAO;
        this.etudiantDAO = etudiantDAO;
        this.inscriptionDAO = inscriptionDAO;
        this.professeurDAO = professeurDAO;
        this.userDAO = userDAO;
    }

    @Override
    public Classe AjouterClasse(Classe classe) {
        return classeDAO.insert(classe) ;
        
        
    }

    @Override
    public List<Classe> ListerClasse() {
        return classeDAO.findAll();
        
        
    }

    @Override
    public void ModifierClasse(Classe classe) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Classe SearchClasseByLibelle(String libelle) {
        return classeDAO.findByLibelle(libelle);
        
    }

    @Override
    public void DeleteClasse(Classe classe) {
        // TODO Auto-generated method stub
        
    }

    public List<String> ListeLibelleClass(){
        return classeDAO.findAllLibelle();
    }

    //Students


    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return etudiantDAO.insert(etudiant);
    }

    @Override
    public List<Etudiant> listerEtudiants() {
        
        return etudiantDAO.findAll();
    }

    @Override
    public Etudiant searchEtudiantByMat(String matricule) {
        return etudiantDAO.findByMat(matricule);
    }

    @Override
    public List<Etudiant> ListerInscritClasse(String libelle) {
        return etudiantDAO.findInscritsByClasse(libelle);
    }

    @Override
    public List<Etudiant> ListerInscritClasseAndYear(Classe classe, String annee) {
        return etudiantDAO.findInscritsByClasseAndYear(classe, annee);
    }
    
   

    @Override
    public List<Etudiant> listerInscritsAnnee(String annee) {
        return etudiantDAO.findInscritsByAnnee(annee);
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant etudiant) {
        // TODO Auto-generated method stub
        return null;
    }


    //Inscription
    @Override
    public void inscription(Etudiant etu, Classe classe, String annee) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Inscription addInscription(Inscription inscription) {
        return inscriptionDAO.insert(inscription);
    }

    @Override
    public List<String> ListYear() {
        return inscriptionDAO.findAllAcademicYear();
    }
    

    //Teachers
    @Override
    public  Professeur ajouterProfesseur(Professeur professeur) {
        return professeurDAO.insert(professeur);
        
        
    }

    @Override
    public List<Professeur> listerProfesseur() {
        return professeurDAO.findAll();
    }

    @Override
    public Professeur modifierProfesseur(Professeur professeur) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int deleteProfesseur(Professeur professeur) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Professeur searchProfesseurByNci(String nci) {
        return professeurDAO.findByNci(nci);
    }

    @Override
    public Professeur searchProfesseurByNom(String nom) {
        return professeurDAO.findByNom(nom);
    }


    @Override
    public int AffecterClasse(Classe classe, Professeur professeur) {
        return classeDAO.affectClass(classe, professeur);
    }


    //Users

    @Override
    public User searchUserByLoginAndPassword(String login, String password) {
        return userDAO.findUserByLoginAndPassword(login, password);
    }

    @Override
    public List<Classe> ListerClasseProfesseurs(String nci) {
        return classeDAO.findClassProfesseur(nci);
        
    }

    



    

    
    
}
