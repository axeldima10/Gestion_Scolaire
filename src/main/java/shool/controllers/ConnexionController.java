package shool.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import shool.App;
import shool.Entities.Role;
import shool.Entities.User;
import shool.Repositories.Core.Factory;


public class ConnexionController implements Initializable {

    @FXML
    Text lblError;
    @FXML
    TextField txtLogin;
    @FXML
    PasswordField txtPassword;
   

    private User user;


   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblError.setVisible(false);
    
    }  

    public void handleConnexion() throws IOException{
        String login= txtLogin.getText().trim();
        String pwd=txtPassword.getText().trim();
        user=Factory.getService().searchUserByLoginAndPassword(login, pwd);

        if(login.isEmpty() || pwd.isEmpty()){
            lblError.setText("Login/Password Obligatoire");
            lblError.setVisible(true);
            //txtErreur.setText("Login/Password Obligatoire");
            
        }else{
            if(user==null){
                lblError.setText("Login/Password Incorrect");
                lblError.setVisible(true);
            }
            else{
                   //cacher la fenetre de connexion
                //ouvrir la fenetre du home
                    
            
                    
                App.setRoot("homeRP");    
            

            }
             
                
                
        }
    }
}

 
  