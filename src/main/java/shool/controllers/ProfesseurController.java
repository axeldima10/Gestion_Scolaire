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
import shool.Entities.Professeur;
import shool.Repositories.Core.Factory;

public class ProfesseurController implements Initializable{

    Professeur professeur;

    @FXML
    private TableView<Professeur> TblVProfesseur =new TableView<>();

    @FXML
    private TableColumn<Professeur, String> TblNci = new TableColumn<>() ;

    @FXML
    private TableColumn<Professeur, String> TblCfirstName = new TableColumn<>();

    @FXML
    private TableColumn<Professeur, String> TblClastName = new TableColumn<>();

    @FXML
    private TableColumn<Professeur, String> TblCgrade = new TableColumn<>();

    @FXML
    private TableView<Classe> TblClasse = new TableView<>();

    @FXML
    private TableColumn<Classe, String> TblCid = new TableColumn<>();

    @FXML
    private TableColumn<Classe, String> TblCLibelle = new TableColumn<>();


    @FXML
    TextField txtNci,txtFirstName,txtLastName,txtGrade; 

    @FXML
    AnchorPane pnlProf;


    private  void cleardField (){
        txtNci.clear();
        txtLastName.clear();
        txtFirstName.clear();
        txtGrade.clear();

    }

    

    ObservableList obProfesseur = FXCollections.observableList(Factory.getService().listerProfesseur());
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TblNci.setCellValueFactory(new PropertyValueFactory<>("nci"));
        TblCfirstName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        TblClastName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TblCgrade.setCellValueFactory(new PropertyValueFactory<>("grade"));

        TblVProfesseur.setItems(obProfesseur);
        
    }

    public void handleSearchProf(){
        String nci = txtNci.getText().trim();
        Professeur professeur = Factory.getService().searchProfesseurByNci(nci);

        if (professeur!=null) {
            pnlProf.setDisable(true);
            txtFirstName.setText(professeur.getPrenom());
            txtLastName.setText(professeur.getNom());
            txtGrade.setText(professeur.getGrade());
            loadTableClasse(nci);
            
        } else {
            pnlProf.setDisable(false);
            
        }

    }

    public void handleAddProf(){
        if (professeur == null) {
            String nci = txtNci.getText().trim();
            String nom = txtLastName.getText().trim();
            String prenom= txtFirstName.getText().trim();
            String grade = txtGrade.getText().trim();
            professeur= new Professeur(nom, prenom, nci, grade);

            Factory.getService().ajouterProfesseur(professeur);

            cleardField();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("School Management");
            alert.setContentText("Teacher has been added succesfull ! ");
            alert.show();
    
            obProfesseur.add(professeur);
                
        }
        

       
        
        

    }

    private void loadTableClasse(String nci){

        //convert  List to Observable List
        ObservableList obsListesClasses = FXCollections.observableList(Factory.getService().ListerClasseProfesseurs(nci));
   
        //Abonnement or suscription
        TblClasse.setItems(obsListesClasses);

        // Construct column 
        TblCid.setCellValueFactory(new PropertyValueFactory<>("id"));
        TblCLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));

    }

    

}

