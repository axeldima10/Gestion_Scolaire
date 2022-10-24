package shool.Entities;

import java.util.ArrayList;
import java.util.List;

public class Classe {
    

    private int id;
    private String libelle;


    // Constructor
    public Classe(int id) {
        this.id = id;
    }

    public Classe(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }


    public Classe(String libelle) {
        this.libelle=libelle;
    }


// Attributs navigationnelles
List<Inscription> inscriptions= new ArrayList<>();
List<Etudiant> etudiants = new ArrayList<>(); 
List<Classe> classes = new ArrayList<>();







//fonctions navigationnelles



public List<Classe> getClasses() {
    return classes;
}

public List<Etudiant> getEtudiants() {
    return etudiants;
}

public List<Inscription> getInscriptions() {
    return inscriptions;
}


//Fonctions navigationnelles

public void addEtudiant(Etudiant etudiant){
    etudiants.add(etudiant);

}
public void setInscriptions(List<Inscription> inscriptions) {
    this.inscriptions = inscriptions;
}

public void setEtudiants(List<Etudiant> etudiants) {
    this.etudiants = etudiants;
}

public void setClasses(List<Classe> classes) {
    this.classes = classes;
}

    //Getters
    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }
  
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    @Override
    public String toString() {
        return this.libelle;
    } 

   
    
}
