module shool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    


    

    opens shool.controllers to javafx.fxml;
    exports shool;
    exports shool.Entities;
    
}
