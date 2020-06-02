package projet.view;

import javafx.scene.Scene;
import jfox.javafx.view.IEnumView;


public enum EnumView implements IEnumView {

	
	// Valeurs
	Info					( "systeme/ViewInfo.fxml" ),
	Connexion				( "systeme/ViewConnexion.fxml" ),
	CompteListe				( "compte/ViewCompteListe.fxml" ),
	CompteForm				( "compte/ViewCompteForm.fxml" ),
	CategorieListe			( "personne/ViewCategorieListe.fxml" ),
	CategorieForm			( "personne/ViewCategorieForm.fxml" ),
	EquipeListe				( "equipe/ViewEquipeListe.fxml" ),
	EquipeForm				( "equipe/ViewEquipeForm.fxml" ),
	TestDaoEquipe			( "test/ViewTestDaoEquipe.fxml" ),
	TestDaoPoste			( "test/ViewTestDaoPoste.fxml" ),
	TestDaoParticipant		( "test/ViewTestDaoParticipant.fxml" ),
	TestDaoBenevole			( "test/ViewTestDaoBenevole.fxml" ),
	ParticipantListe		( "participant/ViewParticipantListe.fxml" ),
	ParticipantInscription	( "participant/ViewParticipantInscription.fxml" ),
	BenevoleInscription		( "benevole/ViewBenevoleInscription.fxml" ),
	BenevoleListe			( "benevole/ViewBenevoleListe.fxml" ),
	Maps					( "maps/ViewMaps.fxml"),
	;

	
	// Champs
	
	private String		path;
	private Object		controller;
	private Scene		scene;

	
	// Constructeur 
	
	EnumView( String path ) {
		this.path = path;
	}

	
	// Getters & setters

	@Override
	public String getPath() {
		return path;
	}
	
	@Override
	public Object getController() {
		return controller;
	}

	@Override
	public void setController(Object controller) {
		this.controller = controller;
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
	
	@Override
	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
