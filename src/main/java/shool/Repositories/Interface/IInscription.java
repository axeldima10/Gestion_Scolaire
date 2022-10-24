package shool.Repositories.Interface;

import java.util.List;

import shool.Entities.Inscription;

public interface IInscription {
    //void DoInscription(Etudiant etu,Classe classe,String annee);
    Inscription insert(Inscription inscription);
    List<String> findAllAcademicYear();
    
}
