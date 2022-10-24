package shool.Repositories.Interface;

import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Professeur;

public interface IClasse {
    public Classe  insert (Classe classe);
    public List<Classe> findAll();
    public void update(Classe classe);
    public Classe findByLibelle(String libelle);
    public void Delete(Classe classe);
    int affectClass(Classe classe, Professeur professeur);
    List<Classe> findClassProfesseur(String nci);
    public List<String> findAllLibelle();
    


    
}
