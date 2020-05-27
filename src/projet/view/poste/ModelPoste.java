package projet.view.poste;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoPoste;
import projet.data.Poste;


public class ModelPoste  {
	
	
	// Données observables 
	
	private final ObservableList<Poste> liste = FXCollections.observableArrayList();
	
	private final Poste	courant = new Poste();
	

	
	// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoPoste			daoPoste;
	
    
	// Initialisations
	
	@PostConstruct
	public void init() {
	}
	
	
	// Getters 
	
	public ObservableList<Poste> getListe() {
		return liste;
	}
	
	public Poste getCourant() {
		return courant;
	}
	
	
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoPoste.listerTout() );
 	}
	
	public void actualiserListePersonnesPourDialogAjout() {
 	}


	// Actions
	
	public void preparerAjouter() {
		mapper.update( courant, new Poste() );
	}
	
	public void preparerModifier( Poste item ) {
		mapper.update( courant, daoPoste.retrouver( item.getIdposte() ) );
		
	}
	
	
	public void validerMiseAJour() {

		// Vérifie la validité des données
		
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom du poste ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 20 ) {
			message.append( "\nLe nom du poste est trop long : 20 maxi." );
		}

		

		
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		
		// Effectue la mise à jour
		
		if ( courant.getIdposte() == null ) {
			// Insertion
			courant.setIdposte( daoPoste.inserer( courant ) );
		} else {
			// modficiation
			daoPoste.modifier( courant );
		}

		
		
	}
	
	
	public void supprimer( Poste item ) {
		
		daoPoste.supprimer( item.getIdposte() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
		
	}

	
}