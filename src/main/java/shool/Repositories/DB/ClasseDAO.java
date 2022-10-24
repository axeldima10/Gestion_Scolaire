package shool.Repositories.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shool.Entities.Classe;
import shool.Entities.Professeur;
import shool.Repositories.Core.MySqlDB;
import shool.Repositories.Interface.IClasse;

public class ClasseDAO extends MySqlDB implements IClasse {
    
    public final String SQL_INSERT_AFFECTATION="INSERT INTO `professeur_classe` (`id_professeur`, `id_classe`)"
                                                +"VALUES (?, ?)";

    public final String SQL_INSERT="INSERT INTO `classe` (`libelle`) VALUES (?)";

    public final String SQL_SELECT_BY_LIBELLE="SELECT * FROM `classe` WHERE `libelle` like ?";

    public final String SQL_SELECT="SELECT * FROM `classe`";

    public final String SQL_SELECT_LIBELLE ="SELECT `libelle` FROM `classe`";

    public final String SQL_SELECT_CLASS_PROF="SELECT * FROM `classe` c , users p, professeur_classe pc " 
                                            +" WHERE pc.id_classe = c.id and  pc.id_professeur=p.id and p.nci like ? ";
                                            
    

    @Override
    public Classe insert(Classe classe) {
        this.openConnexionBD();

        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, classe.getLibelle());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {

                classe.setId(rs.getInt(1));
                
            }

        this.closeConnexionBD();
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return classe;
    
        
    }

    @Override
    public List<Classe> findAll() {
        List<Classe> classes= new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                Classe classe = new Classe(rs.getInt("id"),
                 rs.getString("libelle"));

                 classes.add(classe);
                
                
            }

        this.closeConnexionBD();


        } catch (SQLException e) {
            
            e.printStackTrace();
        }

        

        
        return classes;
        
        
    }

    


    @Override
    public void update(Classe classe) {
        // TODO Auto-gene
        
    }

    @Override
    public Classe findByLibelle(String libelle) {
        Classe classe=null;
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_BY_LIBELLE);
            ps.setString(1, libelle);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                classe = new Classe(rs.getInt("id"),
                 rs.getString("libelle"));
               
                
            }

        this.closeConnexionBD();

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return classe;
        
    }

    @Override
    public void Delete(Classe classe) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Classe> findClassProfesseur(String nci) {
        List<Classe> classeList = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_CLASS_PROF);
            ps.setString(1, nci);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classe classe = new Classe(rs.getInt("id"),
                rs.getString("libelle"));
                
                classeList.add(classe);
            }
            this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return classeList;
    }

    @Override
    public int affectClass(Classe classe, Professeur professeur) {
        int id_affectation=0;
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT_AFFECTATION, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, professeur.getId());
            ps.setInt(2, classe.getId());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {

                id_affectation=rs.getInt(1);
                
            }

        this.closeConnexionBD();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // TODO Auto-generated method stub
        return id_affectation;
    }

    @Override
    public List<String> findAllLibelle() {
        List<String> libelles = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps = conn.prepareStatement(SQL_SELECT_LIBELLE);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String libelle = rs.getString("libelle");
                libelles.add(libelle);
                
            }

        this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return libelles;
    }
    
}
