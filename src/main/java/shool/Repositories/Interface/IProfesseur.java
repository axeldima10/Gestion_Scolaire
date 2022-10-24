package shool.Repositories.Interface;

import java.util.List;
import shool.Entities.Professeur;

public interface IProfesseur {
    Professeur insert (Professeur professeur);
    List<Professeur> findAll();
    Professeur update(Professeur professeur);
    int delete(Professeur professeur);
    Professeur findByNci(String nci);
    Professeur findByNom(String nom);
   
    
    
}
