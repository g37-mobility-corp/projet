package projet.view.equipe;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoEquipe;
import projet.data.Equipe;
import projet.data.Parcours;
import projet.data.Participant;
import projet.view.parcours.ModelParcours;
import projet.view.participant.ModelParticipant;


public class ModelEquipe  {
	
	
	// Données observables 
	
	private final ObservableList<Equipe> liste = FXCollections.observableArrayList();
	
	private final Equipe	courant = new Equipe();
	

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoEquipe			daoEquipe;
    @Inject
    private ModelParticipant modelParticipant;
    @Inject
    private ModelParcours modelParcours;
	
    
	// Initialisations
	
	@PostConstruct
	public void init() {
	}
	
	
	// Getters 
	
	public ObservableList<Equipe> getListe() {
		return liste;
	}
	
	public Equipe getCourant() {
		return courant;
	}
	
	public ObservableList<Participant> getParticipants() {
		return modelParticipant.getListe();
		}
	
	public ObservableList<Parcours> getParcours() {
		return modelParcours.getListe();
		}
	
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoEquipe.listerTout() );
 	}
	
	public void actualiserListePersonnesPourDialogAjout() {
 	}


	// Actions
	
	public void preparerAjouter() {
		modelParticipant.actualiserListe();
		modelParcours.actualiserListe();
		mapper.update( courant, new Equipe() );
	}
	
	public void preparerModifier( Equipe item ) {
		modelParticipant.actualiserListe();
		modelParcours.actualiserListe();
		mapper.update( courant, daoEquipe.retrouver( item.getIdequipe() ) );
		
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom d'équipe ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom d'équipe est trop long : 50 maxi." );
		}

		

		
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getIdequipe() == null ) {
			// Insertion
			courant.setIdequipe( daoEquipe.inserer( courant ) );
		} else {
			// modficiation
			daoEquipe.modifier( courant );
		}

		
		
	}
	
	
	public void supprimer( Equipe item ) {
		
		daoEquipe.supprimer( item.getIdequipe() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
		
	}

	
}