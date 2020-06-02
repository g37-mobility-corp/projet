package projet.view.participant;

import javax.inject.Inject;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import jfox.javafx.util.ConverterStringDouble;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.ListenerFocusValidation;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Categorie;
import projet.data.Equipe;
import projet.data.Parcours;
import projet.data.Participant;
import projet.view.EnumView;
import projet.view.compte.ModelCompte;
import projet.view.equipe.ModelEquipe;

public class ControllerParticipantModif {

	// Composants de la vue
	
	// Toujours Visible
		@FXML
		private TextField		textFieldId;
	
	// Capitaine
		@FXML
		private TextField		textFieldNomCapitaine;
		@FXML
		private TextField		textFieldPrenomCapitaine;
		@FXML
		private DatePicker		datePickerBirthCapitaine;
		@FXML
		private TextField		textFieldNumeroCapitaine;
		@FXML
		private TextField		textFieldEmailCapitaine;
		@FXML
		private TextField		textFieldAdresseCapitaine;
		@FXML
		private TextField		textFieldVilleCapitaine;
		@FXML
		private TextField		textFieldCodePostaleCapitaine;
		
	// Autres champs
		private Participant courantCapitaine;

		
		
		@Inject
		private IManagerGui		managerGui;
		@Inject
		private ModelParticipant	modelParticipant;
			
		
		
	// Initialisation du Controller

		@FXML
		private void initialize() {
			// Data binding
			courantCapitaine = modelParticipant.getCourant();
							
			textFieldId.textProperty().bindBidirectional( courantCapitaine.idProperty(), new ConverterStringInteger() );
			// Capitaine
			// Nom
			textFieldNomCapitaine.textProperty().bindBidirectional( courantCapitaine.nomProperty() );
			// Prénom
			textFieldPrenomCapitaine.textProperty().bindBidirectional( courantCapitaine.prenomProperty() );
			// Birthday
			datePickerBirthCapitaine.getEditor().textProperty().bindBidirectional( courantCapitaine.birthdateProperty(), new ConverterStringLocalDate());
			datePickerBirthCapitaine.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courantCapitaine.birthdateProperty()) );
			UtilFX.bindBidirectional( datePickerBirthCapitaine.getEditor(), courantCapitaine.birthdateProperty(), new ConverterStringLocalDate() );
			// Numero
			textFieldNumeroCapitaine.textProperty().bindBidirectional( courantCapitaine.telephoneProperty());
			// Email
			textFieldEmailCapitaine.textProperty().bindBidirectional( courantCapitaine.emailProperty() );
			// Adresse
			textFieldAdresseCapitaine.textProperty().bindBidirectional( courantCapitaine.adresseProperty() );
			// Code Postale
			textFieldCodePostaleCapitaine.textProperty().bindBidirectional( courantCapitaine.codePostaleProperty());
			// Ville
			textFieldVilleCapitaine.textProperty().bindBidirectional( courantCapitaine.villeProperty() );
					
			
		}
		
		// Actions
		
		@FXML
		private void doAnnuler() {
			managerGui.showView( EnumView.ParticipantListe );
		}
		
		@FXML
		private void doValider() {
			modelParticipant.validerMiseAJour();
			managerGui.showView( EnumView.ParticipantListe );
		}
		
		
}
