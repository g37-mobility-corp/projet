package projet.view.participant;


import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoParticipant;
import projet.data.Parcours;
import projet.data.Participant;
import projet.view.parcours.ModelParcours;


public class ModelParticipant {
	
	
	// Données observables 
	
	private final ObservableList<Participant> liste = FXCollections.observableArrayList(); 

	private final Participant	courant = new Participant();
	private final Participant	courant2 = new Participant();
	
	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoParticipant		daoParticipant;
    @Inject
    private ModelParcours modelParcours;
	
	
	
	// Getters
	
	public ObservableList<Participant> getListe() {
		return liste;
	}
	
	public ObservableList<Parcours> getParcours() {
		return modelParcours.getListe();
	}

	public Participant getCourant() {
		return courant;
	}

	public Participant getCourant2() {
		return courant2;
	}
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoParticipant.listerTout() );
 	}
	
	
	// Actions
	
	public void preparerAjouter() {
		modelParcours.actualiserListe();
		mapper.update( courant, new Participant() );
	}

	
	public void preparerModifier( Participant item ) {
		modelParcours.actualiserListe();
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
