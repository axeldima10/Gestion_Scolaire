package shool.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import shool.Entities.Classe;
import shool.Entities.Etudiant;
import shool.Entities.Inscription;
import shool.Repositories.Core.Factory;


public class InscriptionController implements Initializable {

    //ObservableList obEtudiants =FXCollections.observableList(Factory.getService().listerEtudiants());
    ObservableList obClasse = FXCollections.observableList(Factory.getService().ListerClasse());



    Etudiant etudiant;

    @FXML
    TextField txtFirstName,txtLastName,txtTutor,txtMatNew,txtMatOld;

    @FXML
    ComboBox<Classe> comboClasse = new ComboBox<>();

    @FXML
    AnchorPane pnlInscription,pgOld,pgNew;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       loadComboBoxClasse();
       handleNew();
        
    }

    public void handleNew(){
        pgNew.toFront();
        txtMatNew.setDisable(true);
    }

    public void handleOld(){
        pgOld.toFront();
    }


    private  void cleardField (){
        txtMatNew.clear();
        txtMatOld.clear();
        txtLastName.clear();
        txtFirstName.clear();
        txtTutor.clear();
        

    }

    public void handleSearchStudentForInscription(){
        String matricule = txtMatOld.getText().trim();
        etudiant= Factory.getService().searchEtudiantByMat(matricule);

        if (etudiant!=null) {
            pnlInscription.setDisable(true);
            txtFirstName.setText(etudiant.getPrenom());
            txtLastName.setText(etudiant.getNom());
            txtTutor.setText(etudiant.getTuteur());

            
            
        } else {
            cleardField();
            pnlInscription.setDisable(false);
            
        }

    }
   



    public void handleCreateInscription(){

        
        //Save the student information
        if (etudiant == null) {
            txtMatNew.setDisable(true);
            String nom = txtLastName.getText().trim();
            String prenom= txtFirstName.getText().trim();
            String tuteur = txtTutor.getText().trim();
            etudiant = new Etudiant(nom, prenom, tuteur);
            Factory.getService().ajouterEtudiant(etudiant);
            
            
            
        }

        //Affect to classe
        Classe classe=comboClasse.getSelectionModel().getSelectedItem();
        etudiant.setClasse(classe);
        

        // Create an inscription
        Inscription inscription = new Inscription();
        inscription.setEtudiant(etudiant);
        inscription.setClasse(classe);

        Factory.getService().addInscription(inscription);
        

        //obEtudiants.add(etudiant);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Inscription");
        alert.setContentText("New inscription has added succesfuled ! ");
        alert.show();

        
        cleardField();

    }



    public void loadComboBoxClasse(){
        comboClasse.setItems(obClasse);
       

    }


   
    
    

}
