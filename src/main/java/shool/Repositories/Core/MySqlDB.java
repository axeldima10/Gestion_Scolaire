package shool.Repositories.Core;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySqlDB implements IDatabase {
    protected Connection conn;
    protected PreparedStatement ps;
    @Override
    public void openConnexionBD() {
       //1- Chargement du Driver
       try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2- ouvrir la connexion 
        conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/Gestion_Inscription", "root", "root");
        
    } 
    catch (SQLException e){
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
 
        
    }

    @Override
    public void closeConnexionBD() {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }

    

    
}
