package shool.Services;

import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Etudiant;
import shool.Entities.Inscription;
import shool.Entities.Professeur;
import shool.Entities.User;

public interface IService {
    public Classe AjouterClasse (Classe classe);
    public List<Classe> ListerClasse();
    public void ModifierClasse(Classe classe);
    public Classe SearchClasseByLibelle(String libelle);
    public void DeleteClasse(Classe classe);
    public List<String> ListeLibelleClass();

    List<Etudiant> listerEtudiants();
    Etudiant searchEtudiantByMat(String matricule);
    List<Etudiant> ListerInscritClasse(String libelle);
    List<Etudiant> ListerInscritClasseAndYear(Classe classe, String annee);
    List<Etudiant> listerInscritsAnnee(String annee);
    Etudiant modifierEtudiant(Etudiant etudiant);
    Etudiant ajouterEtudiant(Etudiant etudiant);

    void inscription(Etudiant etu,Classe classe,String annee);
    Inscription addInscription(Inscription inscription);
    List<String> ListYear();
    

    Professeur ajouterProfesseur(Professeur professeur);
    List<Professeur> listerProfesseur();
    Professeur modifierProfesseur(Professeur professeur);
    int deleteProfesseur(Professeur professeur);
    Professeur searchProfesseurByNci(String nci);
    Professeur searchProfesseurByNom(String nom);
    List<Classe> ListerClasseProfesseurs(String nci);
    int AffecterClasse(Classe classe, Professeur professeur);


    public User searchUserByLoginAndPassword(String login, String password);
    
}
