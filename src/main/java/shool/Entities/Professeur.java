package shool.Entities;

import java.util.ArrayList;
import java.util.List;

public class Professeur extends User{
   

    private String nci;
    private String grade;


    //constructors

    public Professeur(String nom, String prenom, String nci, String grade) {
        super(nom, prenom);
        this.nci = nci;
        this.grade = grade;
        role=Role.Professeur;
    }

    public Professeur(int id, String nom, String prenom, String nci, String grade) {
        super(id, nom, prenom);
        this.nci = nci;
        this.grade = grade;
        role=Role.Professeur;
    }

    public Professeur() {
        role=Role.Professeur;
    }
    
    //attributs navigationnelles
    List<Classe> classes = new ArrayList<>();

    //fonction navigationnelles

    public void addClasse(Classe classe) {
        classes.add(classe);
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }
    

    //Getters

    public String getNci() {
        return nci;
    }

    public String getGrade() {
        return grade;
    }


    //Setters
    public void setNci(String nci) {
        this.nci = nci;
    }

   

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Professeur [nci=" + nci + ", grade=" + grade + "]"+super.toString();
    }

   

    
}
