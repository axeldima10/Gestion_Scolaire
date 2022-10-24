package shool.Entities;

import java.util.ArrayList;
import java.util.List;

public class Etudiant extends User{
    

    private String matricule;
    private String tuteur;

    //Constructors

    public Etudiant(){
        role= Role.Etudiant;
        nbre++;
        id=nbre;
        matricule="M0"+nbre;
        
    }

    public Etudiant(String nom, String prenom, String matricule, String tuteur) {
        super(nom, prenom);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role= Role.Etudiant;
        nbre++;
        id=nbre;
        matricule="M0"+nbre;
    }

    public Etudiant(int id, String nom, String prenom, String matricule, String tuteur) {
        super(id, nom, prenom);
        this.matricule = matricule;
        this.tuteur = tuteur;
        role= Role.Etudiant;
    }

    public Etudiant(String nom, String prenom, String tuteur) {
        super(nom, prenom);
        this.tuteur = tuteur;
        role= Role.Etudiant;
        nbre++;
        id=nbre;
        matricule="M0"+nbre;
    }

    //attributs navigationnelles
    private List<Inscription> inscriptions= new ArrayList<>();
    private Classe classe;


   

    //Fonction navigationnelle
    public List<Inscription> getInscriptions() {
        return inscriptions;
    }
    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    //Getters
    public String getMatricule() {
        return matricule;
    }

    public String getTuteur() {
        return tuteur;
    }


    //setters
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    public void setTuteur(String tuteur) {
        this.tuteur = tuteur;
    }

    @Override
    public String toString() {
        return "Etudiant [matricule=" + matricule + ", tuteur=" + tuteur + "]"+super.toString();
    }
    


    
}
