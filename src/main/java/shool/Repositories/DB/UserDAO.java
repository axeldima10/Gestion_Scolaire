package shool.Repositories.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

import shool.Entities.User;
import shool.Repositories.Core.MySqlDB;
import shool.Repositories.Interface.IUser;

public class UserDAO extends MySqlDB implements IUser{
    private final String SQL_LOGIN_PASSWORD="SELECT * FROM users WHERE login like ? AND password like ?";

    @Override
    public shool.Entities.User findUserByLoginAndPassword(String login, String password) {
        this.openConnexionBD();
        User user = null;
        try {
            ps=conn.prepareStatement(SQL_LOGIN_PASSWORD);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs= ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom")
                , null,rs.getString("login"), rs.getString("password"));

                
            }
        this.closeConnexionBD();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return user;
    }
    
}
