package shool.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import shool.App;

public class ControllerAC {
    @FXML
    AnchorPane anchorContent, anchorContentStudent;


    public void handleLogout() throws IOException{
        App.setRoot("connexion");
    }

    public void handleViewInscriptions() throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML("inscriptions");
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);

    }

    public void handleViewStudent() throws IOException{
        AnchorPane root = (AnchorPane) App.loadFXML("student");
        anchorContent.getChildren().clear();
        anchorContent.getChildren().add(root);

    }


    
}
