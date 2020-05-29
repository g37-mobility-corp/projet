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
import projet.data.Benevole;


public class DaoBenevole {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	@Inject
	private DaoPoste daoPoste;

	
	// Actions

	public int inserer( Benevole benevole )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le Benevole
			sql = "INSERT INTO benevole(idbenevole, nom, prenom, telephone, birthdate, idposte, adresse, ville, codepostale, permisConduire, plaqueImma, brevetSecourisme) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			stmt = cn.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS ); 
			stmt.setObject( 1, benevole.getId() ); 
			stmt.setObject( 2, benevole.getNom() );
			stmt.setObject( 3, benevole.getPrenom() );
			stmt.setObject( 4, benevole.getTelephone() );
			stmt.setObject( 5, benevole.getBirthdate() );
			stmt.setObject( 6, benevole.getIdposte() );
			stmt.setObject( 7, benevole.getAdresse() );
			stmt.setObject( 8, benevole.getVille() );
			stmt.setObject( 9, benevole.getCodePostale() );
			stmt.setObject( 10, benevole.getPermisConduire() );
			stmt.setObject( 11, benevole.getPlaqueImma() );
			stmt.setObject( 12, benevole.getBrevetSecourisme() );
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			rs = stmt.getGeneratedKeys();
			rs.next();
			benevole.setId( rs.getObject( 1, Integer.class) );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
		
		// Retourne l'identifiant
		return benevole.getId();
	}
	

	public void modifier( Benevole benevole )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le benevole
			sql = "UPDATE benevole SET nom = ?, prenom = ?, telephone = ?, birthdate = ?, idposte = ?, "
					+ "permisConduire = ?, plaqueImma = ?, brevetSecourisme = ?, adresse = ?, "
					+ "ville = ?, codePostale = ? WHERE idbenevole =  ?";
			stmt = cn.prepareStatement( sql ); 
			stmt.setObject( 1, benevole.getNom() );
			stmt.setObject( 2, benevole.getPrenom() );
			stmt.setObject( 3, benevole.getTelephone() );
			stmt.setObject( 4, benevole.getBirthdate() );
			stmt.setObject( 5, benevole.getIdposte().getIdposte() );
			stmt.setObject( 6, benevole.getPermisConduire() );
			stmt.setObject( 7, benevole.getPlaqueImma() );
			stmt.setObject( 8, benevole.getBrevetSecourisme() );
			stmt.setObject( 9, benevole.getAdresse() );
			stmt.setObject( 10, benevole.getVille() );
			stmt.setObject( 11, benevole.getCodePostale() );
			stmt.setObject( 12, benevole.getId() );
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}

	}
	

	public void supprimer( int idbenevole )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le benevole
			sql = "DELETE FROM benevole WHERE idbenevole = ? ";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, idbenevole );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public Benevole retrouver( int idbenevole )  {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM benevole WHERE idbenevole = ?";
            stmt = cn.prepareStatement( sql );
            stmt.setObject( 1, idbenevole );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireBenevole( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	public List<Benevole> listerTout()   {

		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM benevole ORDER BY nom";
			stmt = cn.prepareStatement( sql );
			rs = stmt.executeQuery();

			List<Benevole> benevoles = new ArrayList<>();
			while ( rs.next() ) {
				benevoles.add( construireBenevole(rs) );
			}
			return benevoles;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public Benevole validerAuthentification( String email, String motDePasse )  {
		
		Connection			cn		= null;
		PreparedStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "SELECT * FROM benevole WHERE email = ? AND motdepasse = ?";
			stmt = cn.prepareStatement( sql );
			stmt.setObject( 1, email );
			stmt.setObject( 2, motDePasse );
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireBenevole( rs );			
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
	
	private Benevole construireBenevole( ResultSet rs ) throws SQLException {
		Benevole benevole = new Benevole();
		benevole.setId( rs.getObject( "idbenevole", Integer.class ) );
		benevole.setNom( rs.getObject( "nom", String.class ) );
		benevole.setPrenom( rs.getObject( "prenom", String.class ) );
		benevole.setTelephone( rs.getObject( "telephone", String.class ) );
		benevole.setBirthdate( rs.getObject( "birthdate", LocalDate.class ) );
		Integer idPoste = rs.getObject( "idposte", Integer.class );
		if ( idPoste != null ) {
			benevole.setIdposte( daoPoste.retrouver( idPoste ) );
		}
		benevole.setAdresse( rs.getObject( "adresse", String.class ) );
		benevole.setVille( rs.getObject( "ville", String.class ) );
		benevole.setCodePostale( rs.getObject( "codePostale", String.class ) );
		benevole.setPermisConduire( rs.getObject( "permisConduire", Boolean.class ) );
		benevole.setPlaqueImma( rs.getObject( "plaqueImma", String.class ) );
		benevole.setBrevetSecourisme( rs.getObject( "brevetSecourisme", Boolean.class ) );
		return benevole;
	}
	
}
