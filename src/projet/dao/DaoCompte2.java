package projet.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.sql.DataSource;

import jfox.dao.jdbc.UtilJdbc;
import projet.data.Compte;


public class DaoCompte2 {

	
	// Champs

	@Inject
	private DataSource		dataSource;

	
	// Actions

	public int inserer( Compte compte )  {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			// Insère le compte
			sql = "{ CALL compte_inserer( ?, ?, ?, ? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject( 1, compte.getMotDePasse() );
			stmt.setObject( 2, compte.getEmail() );
			stmt.registerOutParameter( 3, Types.INTEGER );
			try {
				stmt.setObject( 4, cn.createArrayOf( "VARCHAR", compte.getRoles().toArray() ) );
			} catch ( SQLFeatureNotSupportedException e) {
				stmt.setObject( 4, compte.getRoles().stream().collect( Collectors.joining( "," ) ) );
			}
			stmt.executeUpdate();

			// Récupère l'identifiant généré par le SGBD
			compte.setId( stmt.getInt( 3 ) );
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
		
		// Retourne l'identifiant
		return compte.getId();
	}
	

	public void modifier( Compte compte )  {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Modifie le compte
			sql = "{ CALL compte_modifier( ?, ?, ?, ? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject( 1, compte.getMotDePasse() );
			stmt.setObject( 2, compte.getEmail() );
			stmt.setObject( 3, compte.getId() );
			try {
				stmt.setObject( 4, cn.createArrayOf( "VARCHAR", compte.getRoles().toArray() ) );
			} catch ( SQLFeatureNotSupportedException e) {
				stmt.setObject( 4, compte.getRoles().stream().collect( Collectors.joining( "," ) ) );
			}
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public void supprimer( int idCompte )  {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		String 				sql;

		try {
			cn = dataSource.getConnection();

			// Supprime le compte
			sql = "{ CALL compte_supprimer( ? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject( 1, idCompte );
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( stmt, cn );
		}
	}
	

	public Compte retrouver( int idCompte )  {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "{ CALL compte_retrouver( ? ) } ";
            stmt = cn.prepareCall( sql );
            stmt.setObject( 1, idCompte );
            rs = stmt.executeQuery();

            if ( rs.next() ) {
                return construireCompte( rs );
            } else {
            	return null;
            }
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}
	

	public List<Compte> listerTout()   {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "{ CALL compte_lister_tout() } ";
			stmt = cn.prepareCall( sql );
			rs = stmt.executeQuery();

			List<Compte> comptes = new ArrayList<>();
			while ( rs.next() ) {
				comptes.add( construireCompte(rs) );
			}
			return comptes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public Compte validerAuthentification( String email, String motDePasse )  {
		
		Connection			cn		= null;
		CallableStatement	stmt	= null;
		ResultSet 			rs 		= null;
		String				sql;

		try {
			cn = dataSource.getConnection();

			sql = "{ CALL compte_valider_authentification( ?, ? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject( 1, email );
			stmt.setObject( 2, motDePasse );
			rs = stmt.executeQuery();

			if ( rs.next() ) {
				return construireCompte( rs );			
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close( rs, stmt, cn );
		}
	}


	public boolean verifierUnicitePseudo( String pseudo, Integer idCompte )   {

		Connection			cn		= null;
		CallableStatement	stmt	= null;
		String				sql;

		if ( idCompte == null ) idCompte = 0;

		try {
			cn = dataSource.getConnection();

			sql = "{ CALL compte_verifier_unicite_pseudo( ?, ?, ? ) } ";
			stmt = cn.prepareCall( sql );
			stmt.setObject(	1, pseudo );
			stmt.setObject(	2, idCompte );
			stmt.registerOutParameter( 3, Types.BOOLEAN); 
			stmt.execute();
			
			return stmt.getBoolean( 3 );
	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			UtilJdbc.close(  stmt, cn );
		}
	}
	
	
	// Méthodes auxiliaires
	
	private Compte construireCompte( ResultSet rs ) throws SQLException {
		Compte compte = new Compte();
		compte.setId( rs.getObject( "idcompte", Integer.class ) );
		compte.setMotDePasse( rs.getObject( "motdepasse", String.class ) );
		compte.setEmail( rs.getObject( "email", String.class ) );
		try {
			compte.getRoles().setAll( (String[]) rs.getArray( "roles" ).getArray() );
		} catch ( SQLFeatureNotSupportedException e) {
			String roles = rs.getString("roles");
			if ( roles != null ) {
				compte.getRoles().setAll( roles.split(",") );
			}
		}
		return compte;
	}
	
}
