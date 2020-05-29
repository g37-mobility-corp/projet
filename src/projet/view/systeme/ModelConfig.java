package projet.view.systeme;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import jfox.commun.exception.ExceptionAnomaly;


public class ModelConfig {
	
	
	// Champs
	
	private File		dossierFichier;
	
	
	// Initialisations
	
	@PostConstruct
	public void init() {
		
		
		// Lecture du fichier de configuration
		Properties props = new Properties();
		String chemin = "META-INF/config.properties";
		InputStream in =  ClassLoader.getSystemResourceAsStream( chemin );
		if ( in == null ) {
			throw new ExceptionAnomaly( "Impossible de charger le fichier de configuration :\n" + chemin );
		}
		try {
			props.load( in );
			in.close();
		} catch (IOException e) {
			throw new RuntimeException( e );
		}
		
		
		String valeur = props.getProperty( "dossier.fichier" );
		if ( valeur == null ) {
			throw new ExceptionAnomaly( 
				"Paramètre absent dans le fichier de configuration :\n"
				+ "dossier.fichier" );
		}
		dossierFichier = new File( valeur );
		if ( ! dossierFichier.exists() ) {
			throw new ExceptionAnomaly( 
					"Le dossier des fichiers n'existe pas :\n"
					+ dossierFichier.toString() );
		}
		
	}
	
	
	// Getters
	
	public File getDossierFichier() {
		return dossierFichier;
	}

}
