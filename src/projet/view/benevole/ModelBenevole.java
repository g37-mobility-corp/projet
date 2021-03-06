package projet.view.benevole;


import java.time.LocalDate;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBenevole;
import projet.data.Benevole;


public class ModelBenevole {
	
	
	// Données observables 
	
	private final ObservableList<Benevole> liste = FXCollections.observableArrayList(); 
	
	private final Benevole	courant = new Benevole();
	
	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevole		daoBenevole;
	
	
	// Getters
	
	public ObservableList<Benevole> getListe() {
		return liste;
	}

	public Benevole getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoBenevole.listerTout() );
 	}
	
	
	// Actions
	
	public void preparerAjouter() {
		Benevole benevole= new Benevole();
		benevole.setNom("Dylan");
		benevole.setPrenom("Bob");
		benevole.setTelephone("0656985236");
		benevole.setAdresse("rue des fougères");
		benevole.setEmail("bob@3il.fr");
		benevole.setCodePostale("87000");
		benevole.setVille("Limoges");
		benevole.setPlaqueImma("BS-659-RS");
		benevole.setBrevetSecourisme(false);
		benevole.setPermisConduire(false);
		benevole.setBirthdate(LocalDate.of(1985, 05, 15));
		mapper.update( courant, benevole );
	}

	
	public void preparerModifier( Benevole item ) {
		mapper.update( courant, daoBenevole.retrouver( item.getId() ) );
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();
		
		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		}
		
		if( courant.getPrenom() == null || courant.getPrenom().isEmpty() ) {
			message.append( "\nLe prenom ne doit pas être vide." );
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoBenevole.inserer( courant ) );
		} else {
			// modficiation
			daoBenevole.modifier( courant );
		}
	}
	
	
	public void supprimer( Benevole item ) {
		daoBenevole.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}

}
