package shool.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import shool.Entities.Classe;
import shool.Entities.Etudiant;
import shool.Repositories.Core.Factory;

public class EtudiantController implements Initializable {

    @FXML
    private GridPane GPstudent;

    @FXML
    private TableView<Etudiant> TblVstudent= new TableView<>();

    @FXML
    private TableColumn<Etudiant,String> TblCmat= new TableColumn<>();

    @FXML
    private TableColumn<Etudiant,String> TblCfirstName= new TableColumn<>();

    @FXML
    private TableColumn<Etudiant,String> TblClastName= new TableColumn<>();

    @FXML
    private TableColumn<Etudiant,String> TblCclasse= new TableColumn<>();

    @FXML
    ComboBox<Classe> ComboBoxClasse;

    @FXML
    ComboBox<String> cbYear;

    ObservableList obClasse;
   // ObservableList obYear = FXCollections.observableList(Factory.getService().ListYear());
    ObservableList obEtudiants;

    List<Etudiant> etudiants= new ArrayList<>();





    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTableViewEtudiant(etudiants);
        loadComboBoxClasse(ComboBoxClasse);
        //loadComboBoxAnnee();
        loadComboBoxAnnee(cbYear);
        
    }




    //Load Class
    public void loadComboBoxClasse(ComboBox<Classe> CbClasse){
        obClasse = FXCollections.observableList(Factory.getService().ListerClasse());
        ComboBoxClasse.setItems(obClasse);
       

    }


  /* 
    //Load Annee
    public void loadComboBoxAnnee(){

        comboBoxYear.setItems(obYear);

    } */

    public void loadComboBoxAnnee(ComboBox<String> comboBoxYear){
        comboBoxYear.getItems().add("2022-2023");
        comboBoxYear.getItems().add("2021-2022");
        comboBoxYear.getItems().add("2020-2021");
        comboBoxYear.getItems().add("2019-2020");
        comboBoxYear.getItems().add("2018-2019");
        comboBoxYear.getSelectionModel().selectFirst();
    }


 

    //Load students
    public void loadTableViewEtudiant( List<Etudiant> etudiants){

           // etudiants=Factory.getService().listerEtudiants();
            obEtudiants =FXCollections.observableList(etudiants);
            TblCmat.setCellValueFactory(new PropertyValueFactory<>("matricule"));
            TblCfirstName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            TblClastName.setCellValueFactory(new PropertyValueFactory<>("nom"));
            TblCclasse.setCellValueFactory(new PropertyValueFactory<>("classe"));

            TblVstudent.setItems(obEtudiants);
    }





    // Search
    public void handleSearchEtudiantByYearAndClasse() {

        Classe classe=ComboBoxClasse.getSelectionModel().getSelectedItem();
        String annee=cbYear.getSelectionModel().getSelectedItem();
        loadTableViewEtudiant(Factory.getService().ListerInscritClasseAndYear(classe, annee));


    }  
    

    
}


