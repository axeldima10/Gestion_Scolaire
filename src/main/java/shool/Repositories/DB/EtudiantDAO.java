package shool.Repositories.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Etudiant;
import shool.Repositories.Core.MySqlDB;
import shool.Repositories.Interface.IEtudiant;

public class EtudiantDAO extends MySqlDB implements IEtudiant{

    private final String SQL_UPDATE="UPDATE `users` SET id_classe= ?";

    public final String SQL_INSERT="INSERT INTO `users` (`nom`, `prenom`,`role`,`matricule`, `tuteur`,`login`, `password`)"
                                    +"VALUES (?,?,'ROLE_ETUDIANT',?,?,'NULL','NULL')";

    public final String SQL_SELECT_BY_MAT="SELECT * FROM `users` WHERE `matricule` like ?"
                                            +" and `role` LIKE 'ROLE_ETUDIANT' ";

    //SELECT e* FROM `users`e, classe c WHERE `role` LIKE 'ROLE_ETUDIANT' and e.id_classe = c.id
    public final String SQL_SELECT="SELECT * FROM `users`e , inscriptions i , classe c WHERE i.id_classe = c.id"
    + " and i.id_etudiant = e.id and `role` LIKE 'ROLE_ETUDIANT' ";
    

    public final String SQL_SELECT_BY_CLASS="SELECT e.* FROM `users`e, classe c WHERE e.id_classe = c.id"
                                            + "and c.libelle like ?";


    public final String SQL_SELECT_BY_YEAR="SELECT * FROM `users` e , inscriptions i , classe c WHERE i.id_classe = c.id"
                                            + " and i.id_etudiant = e.id and i.annee_scolaire like ? ";


    public final String SQL_SELECT_INSCRITS_BY_CLASS_AND_YEAR="SELECT * FROM `users`e , inscriptions i , classe c WHERE i.id_classe = c.id"
                                                            + " and i.id_etudiant = e.id and i.annee_scolaire like ? and c.libelle like ?";
    



    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants= new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs= ps.executeQuery();
            while(rs.next()) {
                Etudiant etudiant = new Etudiant(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("matricule"),
                rs.getString("tuteur"));

            	Classe classe = new Classe(rs.getInt("id_classe"),
                rs.getString("libelle"));
                etudiant.setClasse(classe);

                etudiants.add(etudiant);

                
            }
        this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return etudiants;
    }

    
    @Override
    public Etudiant findByMat(String matricule) {
        Etudiant etudiant = null;
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_MAT);
            ps.setString(1, matricule);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                etudiant = new Etudiant(rs.getInt("id"), rs.getString("nom"),
                rs.getString("prenom"),rs.getString("matricule"),
                rs.getString("tuteur"));

                
            }
        this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return etudiant;
    }

    @Override
    public List<Etudiant> findInscritsByClasse(String libelle) {
        List<Etudiant> etudiants = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_CLASS);
            ps.setString(1,libelle);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(rs.getInt("id"),rs.getString("nom"),
                rs.getString("prenom"),rs.getString("matricule"),
                rs.getString("tuteur"));

                etudiants.add(etudiant);

      
      
            }

        this.closeConnexionBD();
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        
        return etudiants;
    }

    @Override
    public List<Etudiant> findInscritsByClasseAndYear(Classe classe, String annee) {
        List<Etudiant> etudiants = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_INSCRITS_BY_CLASS_AND_YEAR);
            ps.setString(1, classe.getLibelle());
            ps.setString(2, annee);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {

                Etudiant etudiant = new Etudiant(rs.getInt("id"),rs.getString("nom"),
                rs.getString("prenom"),rs.getString("matricule"),
                rs.getString("tuteur"));


                etudiants.add(etudiant);
                
                
            }

        this.closeConnexionBD();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        return etudiants;
    }

    @Override
    public List<Etudiant> findInscritsByAnnee(String annee) {
        List<Etudiant> etudiants = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_YEAR);
            ps.setString(1, annee);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant(rs.getInt("id"),rs.getString("nom"),
                rs.getString("prenom"),rs.getString("matricule"),
                rs.getString("tuteur"));


                etudiants.add(etudiant);
                
            }
        this.closeConnexionBD();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
       

        return etudiants;
    }

    @Override
    public Etudiant update(Etudiant etudiant) {
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_UPDATE, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, etudiant.getClasse().getId());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                
            }
            this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return etudiant;
    }


    @Override
    public Etudiant insert(Etudiant etudiant) {
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getMatricule());
            ps.setString(4, etudiant.getTuteur());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                etudiant.setId(rs.getInt(1));
                
            }
        this.closeConnexionBD();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        return etudiant;
    }
    
}
