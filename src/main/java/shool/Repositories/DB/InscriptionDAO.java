package shool.Repositories.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shool.Entities.Inscription;
import shool.Repositories.Core.MySqlDB;
import shool.Repositories.Interface.IInscription;

public class InscriptionDAO extends MySqlDB implements IInscription{

    private final String SQL_INSERT="INSERT INTO `inscriptions` (`date_inscription`, `annee_scolaire`, `id_etudiant`, `id_classe`) VALUES (?,?,?,?)";
    private final String SQL_SELECT_ANNEE_SCOLAIRE="SELECT `annee_scolaire` FROM `inscriptions`";
   /*  @Override
    public void DoInscription(Etudiant etu, Classe classe, String annee) {
        // TODO Auto-generated method stub
        
    } */

    @Override
    public Inscription insert(Inscription inscription) {
      
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_INSERT,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, inscription.getDateInscription() );
            ps.setString(2, inscription.getAnneeScolaire());
            ps.setInt(3, inscription.getEtudiant().getId());
            ps.setInt(4, inscription.getClasse().getId());
            ps.executeUpdate();

            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
                inscription.setId(rs.getInt(1));
                
                
            }
        this.closeConnexionBD();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        return inscription;
    }

    @Override
    public List<String> findAllAcademicYear() {
        List<String> annees = new ArrayList<>();
        this.openConnexionBD();
        try {
            ps=conn.prepareStatement(SQL_SELECT_ANNEE_SCOLAIRE);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                String year = rs.getString("annee_scolaire");
                annees.add(year);
            
            }
        this.closeConnexionBD();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return annees;
    }
    
}
