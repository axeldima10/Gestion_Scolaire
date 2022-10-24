package shool.Repositories.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import shool.Entities.Professeur;
import shool.Repositories.Core.MySqlDB;
import shool.Repositories.Interface.IProfesseur;

public class ProfesseurDAO extends MySqlDB implements IProfesseur{

   
    //public final String SQL_INSERT="INSERT INTO `professeurs` (`prenom`, `nom`, `nci`, `grade`) VALUES (?,?,?,?)";
    public final String SQL_INSERT="INSERT INTO `users` (`nom`, `prenom`,`role`,`nci`, `grade`,`login`, `password`) VALUES (?,?,'ROLE_PROFESSEUR',?,?,'NULL','NULL')";
    public final String SQL_SELECT_BY_NCI="SELECT * FROM `users` WHERE `nci` LIKE ?";
    public final String SQL_SELECT="SELECT * FROM `users` WHERE `role` LIKE 'ROLE_PROFESSEUR' ";
    public final String SQL_SELECT_BY_NOM="SELECT * FROM `professeurs` WHERE `nom` LIKE ?";
   
    
    @Override
    public Professeur insert(Professeur professeur) {
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, professeur.getPrenom());
            ps.setString(2 ,professeur.getNom());
            ps.setString(3, professeur.getNci());
            ps.setString(4, professeur.getGrade());
   
            ps.executeUpdate();

            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                professeur.setId(rs.getInt(1));
            }
        this.closeConnexionBD();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return professeur;

        
    }

    @Override
    public List<Professeur> findAll() {
       List<Professeur> profs = new ArrayList<>();
       this.openConnexionBD();
       try {
        ps=conn.prepareStatement(SQL_SELECT);
        ResultSet rs=ps.executeQuery();
        while (rs.next()) {
            Professeur professeur = new Professeur(rs.getInt("id"), rs.getString("nom"),
            rs.getString("prenom"),rs.getString("nci"),
            rs.getString("grade"));

            profs.add(professeur);
        
            
        }
        this.closeConnexionBD();


    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return profs;
    }

    @Override
    public Professeur update(Professeur professeur) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int delete(Professeur professeur) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Professeur findByNci(String nci) {
        Professeur professeur = null;
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NCI);
            ps.setString(1, nci);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                professeur = new Professeur(rs.getInt("id"), rs.getString("nom"),
                rs.getString("prenom"),rs.getString("nci"),
                rs.getString("grade"));
                
                
            }

        this.closeConnexionBD();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return professeur;
    }

    @Override
    public Professeur findByNom(String nom) {
        Professeur professeur = null;
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_NOM);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                professeur = new Professeur(rs.getInt("id"), rs.getString("nom"),
                rs.getString("prenom"),rs.getString("nci"),
                rs.getString("grade"));
                
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return professeur;
    }


    

   
    /* public <T> T map(ResultSet resultSet, T type){
        T t=type.newInstance();
        return t;
        
    } */
    
}

