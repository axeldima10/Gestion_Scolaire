package shool.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import shool.App;

public class HomeControllerRP {

    @FXML
    private AnchorPane anchorContent;
    
    public void handleLogout() throws IOException{
        App.setRoot("connexion");

    }

    public void handleViewClasses() throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML("Classe");
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);

    }

    public void handleViewTeachers() throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML("Professeur");
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);

    }


    
}
