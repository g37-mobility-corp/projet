package projet.view.equipe;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoEquipe;
import projet.data.Categorie;
import projet.data.Equipe;
import projet.data.Participant;
import projet.view.participant.ModelParticipant;
import projet.view.systeme.ModelConfig;


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
	
	
	
	
	// Actualisations
	
	public void actualiserListe() {
		liste.setAll( daoEquipe.listerTout() );
 	}
	
	public void actualiserListePersonnesPourDialogAjout() {
 	}


	// Actions
	
	public void preparerAjouter() {
		modelParticipant.actualiserListe();
		mapper.update( courant, new Equipe() );
	}
	
	public void preparerModifier( Equipe item ) {
		modelParticipant.actualiserListe();
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
