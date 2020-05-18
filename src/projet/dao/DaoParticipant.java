package projet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Participant;


public class DaoParticipant {

	
	// Champs

	@Inject
	private DataSource		dataSource;
	@Inject
	private DaoEquipe daoEquipe;

	
	// Actions

	public int inserer( Participant participant )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le participant
			sql = "INSERT INTO participant(idequipe, nom, prenom, telephone, birthdate) VALUES ( ?, ?, ?, ?, ? )";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ); 
			stmt.setObject( 1, participant.getEquipe());//.getIdequipe() ); 
			stmt.setObject( 2, participant.getNom() );
			stmt.setObject( 3, participant.getPrenom() );
			stmt.setObject( 4, participant.getTelephone() );
			stmt.setObject( 5, participant.getBirthdate() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			participant.setId( rs.getObject( 1, Integer.class) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
		
		// Retourne l'identifiant
		return participant.getId();
	}
	

	public void modifier( Participant participant )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le participant
			sql = "UPDATE participant SET idequipe = ?, nom = ?, prenom = ?, telephone = ?, birthdate = ? WHERE idparticipant =  ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, participant.getEquipe());//.getIdequipe() ); 
			stmt.setObject( 2, participant.getNom() );
			stmt.setObject( 3, participant.getPrenom() );
			stmt.setObject( 4, participant.getTelephone() );
			stmt.setObject( 5, participant.getBirthdate() );
			stmt.setObject( 6, participant.getId() );
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

	}
	

	public void supprimer( int idParticipant )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le participant
			sql = "DELETE FROM participant WHERE idparticipant = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, idParticipant );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public Participant retrouver( int idparticipant )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM participant WHERE idparticipant = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, idparticipant );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireParticipant( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	public List<Participant> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM participant ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Participant> participants = new ArrayList<>();
			while ( rs.next() ) {
				participants.add( construireParticipant(rs) );
			}
			return participants;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public Participant validerAuthentification( String email, String motDePasse )  {
		
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM participant WHERE email = ? AND motdepasse = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, email );
			stmt.setObject( 2, motDePasse );
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireParticipant( rs );			
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}

	
	
	// Méthodes auxiliaires
	
	private Participant construireParticipant( ResultSet rs ) throws SQLException {
		Participant participant = new Participant();
		participant.setId( rs.getObject( "idparticipant", Integer.class ) );
		participant.setEquipe( rs.getObject( "idequipe", Integer.class ) );
		
		//Integer idEquipe= rs.getObject( "idequipe", Integer.class );
		//if ( idEquipe!= null ) {
			//participant.setEquipe( daoEquipe.retrouver( idEquipe) );
		//}
		
		participant.setNom( rs.getObject( "nom", String.class ) );
		participant.setPrenom( rs.getObject( "prenom", String.class ) );
		participant.setTelephone( rs.getObject( "telephone", String.class ) );
		participant.setBirthdate( rs.getObject( "birthdate", LocalDate.class ) );
		return participant;
	}
	
}
