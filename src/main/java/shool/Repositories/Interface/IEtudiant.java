package shool.Repositories.Interface;

import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Etudiant;

public interface IEtudiant {
    Etudiant insert(Etudiant etudiant);
    List<Etudiant> findAll();
    Etudiant findByMat(String matricule);
    List<Etudiant> findInscritsByClasse(String libelle);
    List<Etudiant> findInscritsByClasseAndYear(Classe classe, String annee);
    List<Etudiant> findInscritsByAnnee(String annee);
    Etudiant update(Etudiant etudiant);
    

    
}
