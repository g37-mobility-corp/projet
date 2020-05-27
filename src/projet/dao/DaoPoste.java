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
import projet.data.Poste;


public class DaoPoste {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	

	
	// Actions

	public int inserer( Poste poste ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO poste ( idposte, nom, lieu, fonction ) VALUES( ?, ?, ?, ?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, poste.getIdposte() );
			stmt.setObject( 2, poste.getNom() );
			stmt.setObject( 3, poste.getLieu() );
			stmt.setObject( 4, poste.getFonction() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			poste.setIdposte( rs.getObject( 1, Integer.class) );
			
			
			return poste.getIdposte();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Poste poste ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE poste SET  nom = ?, lieu = ?, fonction = ? WHERE idposte =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, poste.getNom() );
			stmt.setObject( 2, poste.getLieu() );
			stmt.setObject( 3, poste.getFonction() );
			stmt.setObject( 4, poste.getIdposte() );
			
			stmt.executeUpdate();
			
			supprimerConcerner( poste.getIdposte() );

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idPoste ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			supprimerConcerner(idPoste);
			
			cn = dataSource.getConnection();
			sql = "DELETE FROM poste WHERE idposte = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idPoste );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Poste retrouver( int idPoste ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM poste WHERE idposte = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idPoste);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construirePoste( rs, true );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Poste> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM poste ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Poste> postes = new LinkedList<>();
			while (rs.next()) {
				postes.add( construirePoste( rs, false ) );
			}
			return postes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
    
	
	
	
	// Méthodes auxiliaires
	
	private Poste construirePoste( ResultSet rs, boolean flagComplet ) throws SQLException {
		Poste poste = new Poste();
		poste.setIdposte( rs.getObject( "idposte", Integer.class ) );
		poste.setNom( rs.getObject( "nom", String.class ) );
		poste.setLieu( rs.getObject( "lieu", String.class ) );
		poste.setFonction(rs.getObject("fonction",String.class));
		
		
		return poste;
	}


	private void supprimerConcerner( int idPoste ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM equipe WHERE idposte = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idPoste );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	

}
