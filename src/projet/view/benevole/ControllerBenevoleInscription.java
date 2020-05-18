package projet.view.benevole;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalDate;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Categorie;
import projet.data.Participant;
import projet.view.participant.ListenerFocusValidation;
import projet.view.participant.ModelParticipant;
import projet.data.Benevole;

public class ControllerBenevoleInscription {
	
	
	// Composants de la vue
	
		// Toujours Visible
			@FXML
			private TextField		textFieldId;
			
		
		// Information
			@FXML
			private TextField		textFieldNomBenevole;
			@FXML
			private TextField		textFieldPrenomBenevole;
			@FXML
			private DatePicker		datePickerBirthBenevole;
			@FXML
			private TextField		textFieldNumeroBenevole;
			@FXML
			private TextField		textFieldEmailBenevole;
			@FXML
			private TextField		textFieldAdresseBenevole;
			@FXML
			private TextField		textFieldVilleBenevole;
			@FXML
			private TextField		textFieldCodePostaleBenevole;
			
		// Réglement
			
			@FXML
			private ComboBox<poste>	comboBoxPoste;
			@FXML
			private CheckBox		checkBoxPermisConduire;
			@FXML
			private TextField		textFieldPlaqueImma;
			@FXML
			private CheckBox		checkBoxBrevetSecourisme;
			
			
			private Benevole courant;
			@Inject
			private IManagerGui		managerGui;
			@Inject
			private ModelBenevole	modelBenevole;
			
			@FXML
			private void initialize() {
				// Data binding
				courant = modelBenevole.getCourant();
								
			// Toujours Visible
				// id
				textFieldId.textProperty().bindBidirectional( courant.idProperty(), new ConverterStringInteger()  );
				
			// Benevole
				// Nom
				textFieldNomBenevole.textProperty().bindBidirectional( courant.nomProperty() );
				// Prénom
				textFieldPrenomBenevole.textProperty().bindBidirectional( courant.prenomProperty() );
				// Birthday
				datePickerBirthBenevole.getEditor().textProperty().bindBidirectional( courant.birthdateProperty(), new ConverterStringLocalDate());
				datePickerBirthBenevole.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courant.birthdateProperty())  );
				UtilFX.bindBidirectional( datePickerBirthBenevole.getEditor(), courant.birthdateProperty(), new ConverterStringLocalDate() );
				// Numero
				textFieldNumeroBenevole.textProperty().bindBidirectional( courant.telephoneProperty());
				// Email
				textFieldEmailBenevole.textProperty().bindBidirectional( courant.emailBenevoleProperty() );
				// Adresse
				textFieldAdresseBenevole.textProperty().bindBidirectional( courant.adresseBenevoleProperty() );
				// Code Postale
				textFieldCodePostaleBenevole.textProperty().bindBidirectional( courant.codePostaleBenevoleProperty(), new ConverterStringInteger()  );
				// Ville
				textFieldVilleBenevole.textProperty().bindBidirectional( courant.villeBenevoleProperty() );
				
			// Réglement
				
				// Poste
				//final ObservableList<String> postes = FXCollections.observableArrayList("HOMME", "FEMME", "MIXTE", "VAE");
				comboBoxPoste.setItems(postes);
				comboBoxPoste.valueProperty().bindBidirectional( courant.posteProperty() );
				//Permis de conduire
				checkBoxPermisConduire.selectedProperty().bindBidirectional( courant.permisConduireProperty());
				//Numéro de plaque
				textFieldPlaqueImma.textProperty().bindBidirectional( courant.plaqueImmaProperty() );
				//Brevet de secourisme
				checkBoxBrevetSecourisme.selectedProperty().bindBidirectional( courant.brevetSecourismeProperty());
				
			}

}
