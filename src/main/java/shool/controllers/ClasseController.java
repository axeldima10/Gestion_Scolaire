package shool.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import shool.Entities.Classe;
import shool.Repositories.Core.Factory;

public class ClasseController implements Initializable{

    @FXML
    private TableView<Classe> tableViewClasse= new TableView<>();

    @FXML
    private TableColumn<Classe, String> tableColumnId= new TableColumn<>();

    @FXML
    private TableColumn<Classe, String> tableColumnLibelle= new TableColumn<>();


    @FXML
    TextField txtLibelle; 

    @FXML
    AnchorPane pnlProf;
    


    ObservableList obClasses = FXCollections.observableList(Factory.getService().ListerClasse());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));


        //Abonnements
        tableViewClasse.setItems(obClasses);
        
        
    }

    public void handleCreateClass(){
        String libelle = txtLibelle.getText().trim();
        Classe classe = new Classe(libelle);
        Factory.getService().AjouterClasse(classe);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("School Management");
        alert.setContentText("Class is added succesfully !");
        alert.show();
        obClasses.add(classe);
        txtLibelle.clear();
    }

  
}

