package projet.view.systeme;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class ControllerInfo {
	
	
	// Composants de la vue
	
	@FXML
	private Label		labelTitre;
	@FXML
	private ImageView		imageView;

	
	// Autres champs
	
	@Inject
	private ModelInfo	modelInfo;
	
	
	// Initialisation
	
	@FXML
	private void initialize() {
		
		// Data binding
		labelTitre.textProperty().bind( modelInfo.titreProperty() );
		
	}
	

}
