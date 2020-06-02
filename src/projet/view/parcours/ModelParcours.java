package projet.view.parcours;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoParcours;
import projet.data.Parcours;


public class ModelParcours  {
	
	
	// Données observables 
	
	private final ObservableList<Parcours> liste = FXCollections.observableArrayList();
	
	private final Parcours	courant = new Parcours();
	

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoParcours			daoParcours;
    @Inject
	private ModelParcours			modelParcours;
	
    
	// Initialisations
	
	@PostConstruct
	public void init() {
	}
	
	
	// Getters 
	
	public ObservableList<Parcours> getListe() {
		return liste;
	}
	
	public Parcours getCourant() {
		return courant;
	}
	
	
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoParcours.listerTout() );
 	}
	
	public void actualiserListePersonnesPourDialogAjout() {
 	}


	// Actions
	
	public void preparerAjouter() {
		
		mapper.update( courant, new Parcours() );
	}
	
	public void preparerModifier( Parcours item ) {
		modelParcours.actualiserListe();
		mapper.update( courant, daoParcours.retrouver( item.getIdparcours() ) );
		
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
		
		if ( courant.getIdparcours() == null ) {
			// Insertion
			courant.setIdparcours( daoParcours.inserer( courant ) );
		} else {
			// modficiation
			daoParcours.modifier( courant );
		}

		
		
	}
	
	
	public void supprimer( Parcours item ) {
		
		daoParcours.supprimer( item.getIdparcours() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
		
	}

	
}