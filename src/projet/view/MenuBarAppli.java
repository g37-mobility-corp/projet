package projet.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import jfox.javafx.view.IManagerGui;
import projet.commun.Roles;
import projet.data.Compte;
import projet.report.EnumReport;
import projet.report.ManagerReport;
import projet.view.systeme.ModelConnexion;


public class MenuBarAppli extends MenuBar {

	
	// Champs
	
	private Menu	menuDonnees;
	private Menu	menuEtats;
	private Menu	menuTests;
	
	private MenuItem itemDeconnecter;

	private MenuItem itemComptes;
	
	@Inject
	private IManagerGui 	managerGui;
	@Inject
	private ManagerReport 	managerReport;
	@Inject
	private ModelConnexion	modelConnexion;	
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {

		
		// Variables de travail
		Menu menu;
		MenuItem item;
		
		
		// Menu Système
		
		menu =  new Menu( "Système" );
		this.getMenus().add(menu);
		
		item = new MenuItem( "Se déconnecter" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Connexion )  );
		menu.getItems().add( item );
		itemDeconnecter = item;
		
		item = new MenuItem( "Quitter" );
		item.setOnAction(  (e) -> managerGui.exit()  );
		menu.getItems().add( item );

		
		// Manu Données
		
		menu =  new Menu( "Données" );;
		this.getMenus().add(menu);
		menuDonnees = menu;
		
		item = new MenuItem( "Liste Comptes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.CompteListe )  );
		menu.getItems().add( item );
		itemComptes = item;
		
		item = new MenuItem( "Equipes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.EquipeListe )  );
		menu.getItems().add( item );
		itemComptes = item;
		
		item = new MenuItem( "Benevoles" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.BenevoleListe )  );
		menu.getItems().add( item );
		itemComptes = item;
		
		item = new MenuItem( "Participant" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.ParticipantListe )  );
		menu.getItems().add( item );
		itemComptes = item;
		
		/*
		item = new MenuItem( "Inscription Participant" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.ParticipantInscription )  );
		menu.getItems().add( item );
		itemComptes = item;
		
		item = new MenuItem( "Inscription Benevole" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.BenevoleInscription )  );
		menu.getItems().add( item );
		itemComptes = item;
		*/
		
		item = new MenuItem( "Maps" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Maps )  );
		menu.getItems().add( item );
		itemComptes = item;
		// Menu Etats
		
		menu =  new Menu( "Etats" );;
		this.getMenus().add(menu);
		menuEtats = menu;
		
		item = new MenuItem( "Liste des Participants (viewer)" );
		item.setOnAction(  (e) ->  
				managerReport.showViewer( EnumReport.ListeParticipant, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des Bénévoles (viewer)" );
		item.setOnAction(  (e) ->  
				managerReport.showViewer( EnumReport.ListeBenevole, null ) );
		menu.getItems().add( item );
		
		item = new MenuItem( "Dossards des Participants (viewer)" );
		item.setOnAction(  (e) ->  
				managerReport.showViewer( EnumReport.ListeDossards, null ) );
		menu.getItems().add( item );
		
		
		// Manu Tests
		
		menu =  new Menu( "Tests" );;
		this.getMenus().add(menu);
		menuTests = menu;

		item = new MenuItem( "DaoEquipe" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoEquipe )  );
		menu.getItems().add( item );

		item = new MenuItem( "DaoParticipant" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoParticipant )  );
		menu.getItems().add( item );

		item = new MenuItem( "DaoBenevole" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoBenevole )  );
		menu.getItems().add( item );

		item = new MenuItem( "DaoPoste" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.TestDaoPoste )  );
		menu.getItems().add( item );

		// Configuration initiale du menu
		configurerMenu( modelConnexion.getCompteActif() );

		// Le changement du compte connecté modifie automatiquement le menu
		modelConnexion.compteActifProperty().addListener( (obs) -> {
					Platform.runLater( () -> configurerMenu( modelConnexion.getCompteActif() ) );
				}
			); 
		
	}

	
	// Méthodes auxiliaires
	
	private void configurerMenu( Compte compteActif  ) {

		itemDeconnecter.setDisable(true);
		
		menuDonnees.setVisible(false);
		itemComptes.setVisible(false);
		menuEtats.setVisible(false);
		menuTests.setVisible(false);
		menuEtats.setVisible(false);
		
		if( compteActif != null ) {
			itemDeconnecter.setDisable(false);
			if( compteActif.isInRole( Roles.UTILISATEUR) ) {
				menuDonnees.setVisible(true);
				menuEtats.setVisible(true);
			}
			if( compteActif.isInRole( Roles.ADMINISTRATEUR ) ) {
				menuDonnees.setVisible(true);
				itemComptes.setVisible(true);
				menuTests.setVisible(true);
			}
		}
	}
	
}
