package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Equipe;
import projet.data.Personne;


public class DaoEquipe {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	@Inject
	private DaoCategorie	daoEquipe;
	@Inject
	private DaoPersonne		daoPersonne;

	
	// Actions

	public int inserer( Equipe equipe ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO equipe ( nom_equipe, categorie ) VALUES( ?, ? ) ";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, equipe.getNom() );
			stmt.setObject( 2, equipe.getCategorie() );
			
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			equipe.setId( rs.getObject( 1, Integer.class) );
			
			
			return equipe.getId();
	
		} catch ( SQLException e ) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public void modifier( Equipe equipe ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE equipe SET nom_equipe = ?, categorie = ? WHERE idequipe =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, equipe.getNom() );
			stmt.setObject( 2, equipe.getCategorie() );
			
			stmt.setObject( 3, equipe.getId() );
			stmt.executeUpdate();
			
			supprimerConcerner( equipe.getId() );

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}


	public void supprimer( int idEquipe ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			supprimerConcerner(idEquipe);
			
			cn = dataSource.getConnection();
			sql = "DELETE FROM equipe WHERE idequipe = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idEquipe );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	public Equipe retrouver( int idEquipe ) {

		Connection			cn 		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM equipe WHERE idequipe = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setInt(1, idEquipe);
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireEquipe( rs, true );
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public List<Equipe> listerTout() {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		ResultSet 			rs		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "SELECT * FROM equipe ORDER BY nom_equipe";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Equipe> equipes = new LinkedList<>();
			while (rs.next()) {
				equipes.add( construireEquipe( rs, false ) );
			}
			return equipes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	
    
	
	
	
	// Méthodes auxiliaires
	
	private Equipe construireEquipe( ResultSet rs, boolean flagComplet ) throws SQLException {
		Equipe equipe = new Equipe();
		equipe.setId( rs.getObject( "idequipe", Integer.class ) );
		equipe.setNom( rs.getObject( "nom_equipe", String.class ) );
		equipe.setCategorie( rs.getObject( "categorie", String.class ) );
		
		
		return equipe;
	}


	private void supprimerConcerner( int idEquipe ) {

		Connection			cn 		= null;
		PreparedStatement	stmt 	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();
			sql = "DELETE FROM participant WHERE idequipe = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setInt( 1, idEquipe );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}

	
	

}
