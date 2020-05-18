package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Parcours;


public class DaoParcours {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	

	
	// Actions

	public int inserer( Parcours parcours ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO parcours ( idparcours, nom, distance, infos ) VALUES( ?, ?, ?, ?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, parcours.getIdparcours() );
			stmt.setObject( 2, parcours.getNom() );
			stmt.setObject( 3, parcours.getDistance() );
			stmt.setObject( 4, parcours.getInfos() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			parcours.setIdparcours( rs.getObject( 1, Integer.class) );
			
			
			return parcours.getIdparcours();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Parcours parcours ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE parcours SET  nom = ?, distance = ?, infos = ? WHERE idparcours =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, parcours.getNom() );
			stmt.setObject( 2, parcours.getDistance() );
			stmt.setObject( 3, parcours.getInfos() );
			stmt.setObject( 4, parcours.getIdparcours() );
			
			stmt.executeUpdate();
			
			supprimerConcerner( parcours.getIdparcours() );

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idParcours ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			supprimerConcerner(idParcours);
			
			cn = dataSource.getConnection();
			sql = "DELETE FROM parcours WHERE idparcours = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idParcours );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Parcours retrouver( int idParcours ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM parcours WHERE idparcours = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idParcours);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireParcours( rs, true );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Parcours> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM parcours ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Parcours> parcourss = new LinkedList<>();
			while (rs.next()) {
				parcourss.add( construireParcours( rs, false ) );
			}
			return parcourss;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
    
	
	
	
	// Méthodes auxiliaires
	
	private Parcours construireParcours( ResultSet rs, boolean flagComplet ) throws SQLException {
		Parcours parcours = new Parcours();
		parcours.setIdparcours( rs.getObject( "idparcours", Integer.class ) );
		parcours.setNom( rs.getObject( "nom", String.class ) );
		parcours.setDistance( rs.getObject( "distance", Double.class ) );
		parcours.setInfos(rs.getObject("infos",String.class));
		
		
		return parcours;
	}


	private void supprimerConcerner( int idParcours ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM equipe WHERE idparcours = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idParcours );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	

}
