package shool.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Inscription {


    private int id;
    private String dateInscription, anneeScolaire;



    // constructors

    public Inscription(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }
    
    public Inscription() {
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateToday=LocalDate.now();
        int current_year= dateToday.getYear();
        int next_year= current_year;
        
        dateInscription=dtf1.format(dateToday);
        anneeScolaire= current_year+"-"+next_year;
    }
    

    
    public Inscription(int id, String dateInscription, String anneeScolaire, Etudiant etudiant, Classe classe) {
        this.id = id;
        this.dateInscription = dateInscription;
        this.anneeScolaire = anneeScolaire;
        this.etudiant = etudiant;
        this.classe = classe;
    }

    public Inscription(Etudiant etudiant, Classe classe) {
        this.etudiant = etudiant;
        this.classe = classe;
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateToday=LocalDate.now();
        int current_year= dateToday.getYear();
        int next_year= current_year+1;
        
        dateInscription=dtf1.format(dateToday);
        anneeScolaire= current_year+"-"+next_year;
    }


    //Attributs navigationnelles
    private Etudiant etudiant;
    private Classe classe;


    

    



    //Fonxtions navigationnelles
    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }


    //getters
    public int getId() {
        return id;
    }


    public String getDateInscription() {
        return dateInscription;
    }

    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

  

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }



    @Override
    public String toString() {
        return "Inscription [id=" + id + ", dateInscription=" + dateInscription + ", anneeScolaire=" + anneeScolaire
                + "]";
    }

    

    
}
