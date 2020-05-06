package projet.view.participant;


import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoParticipant;
import projet.data.Compte;
import projet.data.Participant;


public class ModelParticipant {
	
	
	// Données observables 
	
	private final ObservableList<Participant> liste = FXCollections.observableArrayList(); 
	
	private final Participant	courant = new Participant();
	
	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoParticipant		daoParticipant;
	
	
	// Getters
	
	public ObservableList<Participant> getListe() {
		return liste;
	}

	public Participant getCourant() {
		return courant;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoParticipant.listerTout() );
 	}
	
	
	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Participant() );
	}

	
	public void preparerModifier( Participant item ) {
		mapper.update( courant, daoParticipant.retrouver( item.getId() ) );
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
			courant.setId( daoParticipant.inserer( courant ) );
		} else {
			// modficiation
			daoParticipant.modifier( courant );
		}
	}
	
	
	public void supprimer( Participant item ) {
		daoParticipant.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}

}
