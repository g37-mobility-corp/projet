package projet.view.equipe;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.converter.IntegerStringConverter;
import jfox.javafx.view.IManagerGui;
import projet.data.Equipe;
import projet.data.Parcours;
import projet.data.Participant;
import projet.view.EnumView;


public class ControllerEquipeForm {

	
	// Composants de la vue
	
	@FXML
	private TextField		textFieldId;
	@FXML
	private TextField		textFieldNom;
	@FXML
	private ComboBox<Participant> comboBoxChef;
	@FXML
	private ComboBox<Participant> comboBoxCoequipier;
	@FXML 
	private CheckBox checkBoxValide;
	
	@FXML
	private ComboBox<Parcours> comboBoxParcours;
	

	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelEquipe	modelEquipe;


	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Equipe courant = modelEquipe.getCourant();

		textFieldId.textProperty().bindBidirectional( courant.idequipeProperty(), new IntegerStringConverter()  );

		textFieldNom.textProperty().bindBidirectional( courant.nomProperty() );
		
		comboBoxChef.setItems( modelEquipe.getParticipants() );
		comboBoxChef.valueProperty().bindBidirectional( courant.ChefProperty() );
		
		comboBoxCoequipier.setItems( modelEquipe.getParticipants() );
		comboBoxCoequipier.valueProperty().bindBidirectional( courant.CoequipierProperty() );
		
		checkBoxValide.setSelected(courant.getValide());
		
		comboBoxParcours.setItems( modelEquipe.getParcours() );
		comboBoxParcours.valueProperty().bindBidirectional( courant.parcoursProperty() );
		
		
		
		
	}
	
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.EquipeListe );
	}
	
	@FXML
	private void doValider() {
		modelEquipe.validerMiseAJour();
		managerGui.showView( EnumView.EquipeListe );
	}
	
	@FXML
	private void doSupprimerChef() {
	comboBoxChef.setValue( null );
	}
	
	@FXML
	private void doSupprimerCoequipier() {
	comboBoxCoequipier.setValue( null );
	}
	
}