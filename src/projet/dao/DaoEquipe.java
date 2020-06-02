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
import projet.data.Equipe;


public class DaoEquipe {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	
	@Inject
	private DaoParticipant daoParticipant;
	
	@Inject
	private DaoParcours daoParcours;

	
	// Actions

	public int inserer( Equipe equipe ) {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs		= null;
		String				sql;
		
		daoParticipant.inserer(equipe.getChef());
		daoParticipant.inserer(equipe.getCoequipier());
		
		try {
			cn = dataSource.getConnection();
			sql = "INSERT INTO equipe ( idcompte, idparcours, nom_equipe, categorie, idchef, idcoequipier,valide ) VALUES( ?, ?, ?, ?, ? ,?,?)";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
			stmt.setObject( 1, equipe.getIdcompte() );
			stmt.setObject( 2, equipe.getParcours().getIdparcours() );
			stmt.setObject( 3, equipe.getNom() );
			stmt.setObject( 4, equipe.getCategorie() );
			if ( equipe.getChef() == null ) {
				stmt.setObject( 5, null );
			} else {
				stmt.setObject( 5,equipe.getChef().getId() );
			}
			if ( equipe.getCoequipier() == null ) {
				stmt.setObject( 6, null );
			} else {
				stmt.setObject( 6, equipe.getCoequipier().getId() );
			}
			stmt.setObject(7, equipe.getValide());
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			equipe.setIdequipe( rs.getObject( 1, Integer.class) );
			
			
			return equipe.getIdequipe();
	
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
		

		daoParticipant.modifier(equipe.getChef());
		daoParticipant.modifier(equipe.getCoequipier());

		try {
			cn = dataSource.getConnection();
			sql = "UPDATE equipe SET idcompte = ?, idparcours = ?, nom_equipe = ?, categorie = ?, idchef = ?, idcoequipier = ?, valide = ? WHERE idequipe =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, equipe.getIdcompte() );
			stmt.setObject( 2, equipe.getParcours().getIdparcours() );
			stmt.setObject( 3, equipe.getNom() );
			stmt.setObject( 4, equipe.getCategorie() );
			
			if ( equipe.getChef() == null ) {
				stmt.setObject( 5, null );
			} else {
				stmt.setObject( 5,equipe.getChef().getId() );
			}
			if ( equipe.getCoequipier() == null ) {
				stmt.setObject( 6, null );
			} else {
				stmt.setObject( 6, equipe.getCoequipier().getId() );
			}
			stmt.setObject( 7, equipe.getValide() );
			stmt.setObject( 8, equipe.getIdequipe() );
			
			
			stmt.executeUpdate();
			
			//supprimerConcerner( equipe.getIdequipe() );

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
		
		Equipe equipe= retrouver(idEquipe);

		try {
			//supprimerConcerner(idEquipe);
			
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
		
		daoParticipant.supprimer(equipe.getChef().getId());
		daoParticipant.supprimer(equipe.getCoequipier().getId());
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
		equipe.setIdequipe( rs.getObject( "idequipe", Integer.class ) );
		equipe.setIdcompte( rs.getObject( "idcompte", Integer.class ) );
		
		Integer idParcours= rs.getObject( "idparcours", Integer.class );
		if ( idParcours != null ) {
			equipe.setParcours( daoParcours.retrouver( idParcours ) );
		}
		
		equipe.setNom( rs.getObject( "nom_equipe", String.class ) );
		equipe.setCategorie( rs.getObject( "categorie", String.class ) );
		equipe.setValide(rs.getObject("valide",Boolean.class));
		Integer idChef= rs.getObject( "idchef", Integer.class );
		if ( idChef != null ) {
			equipe.setChef( daoParticipant.retrouver( idChef ) );
		}
		
		Integer idCoequipier= rs.getObject( "idcoequipier", Integer.class );
		if ( idCoequipier!= null ) {
			equipe.setCoequipier( daoParticipant.retrouver( idCoequipier) );
		}
		
		
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
