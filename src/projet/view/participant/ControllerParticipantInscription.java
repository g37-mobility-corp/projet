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

public class ControllerParticipantInscription {

	// Composants de la vue
	
	// Toujours Visible
		@FXML
		private TextField		textFieldId;
		@FXML
		private ComboBox<String>   		comboBoxCategorie;
		@FXML
		private TextField		textFieldNomEquipe;
		@FXML
		private TextArea		textAreaDocumentsCapitaine;
		@FXML
		private TextArea		textAreaDocumentsEquipier;
		
	
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
		
	// Toujours Equipier
		@FXML
		private TextField		textFieldNomEquipier;
		@FXML
		private TextField		textFieldPrenomEquipier;
		@FXML
		private DatePicker		datePickerBirthEquipier;
		@FXML
		private TextField		textFieldNumeroEquipier;
		@FXML
		private TextField		textFieldEmailEquipier;
		@FXML
		private TextField		textFieldAdresseEquipier;
		@FXML
		private TextField		textFieldVilleEquipier;
		@FXML
		private TextField		textFieldCodePostaleEquipier;
		
	// Reglement
		@FXML
		private CheckBox		checkBoxReglement;
		@FXML
		private ComboBox <Parcours>		comboBoxParcours;
		@FXML
		private TextField		textFieldRepas;
		
	// Autres champs
		private Equipe courantEquipe;
		private Participant courantCapitaine;
		private Participant courantEquipier;

		
		
		@Inject
		private IManagerGui		managerGui;
		@Inject
		private ModelParticipant	modelParticipant;
		@Inject
		private ModelEquipe	modelEquipe;
			
		
		
	// Initialisation du Controller

		@FXML
		private void initialize() {
			// Data binding
			courantEquipe = modelEquipe.getCourant();
			courantCapitaine = courantEquipe.getChef();
			courantEquipier = courantEquipe.getCoequipier();
							
			// Toujours Visible
			// id
			textFieldId.textProperty().bindBidirectional( courantEquipe.idequipeProperty(), new ConverterStringInteger()  );
							
			// Catégorie
			final ObservableList<String> categories = FXCollections.observableArrayList("HOMME", "FEMME", "MIXTE", "VAE");
			comboBoxCategorie.setItems(categories);
			comboBoxCategorie.valueProperty().bindBidirectional( courantEquipe.categorieProperty() );
							
			// Titre
			textFieldNomEquipe.textProperty().bindBidirectional( courantEquipe.nomProperty() );
							
			/*// Document
			textAreaDocumentsCapitaine.textProperty().bindBidirectional( courantCapitaine.documentsCapitaineProperty() );
			// Document
			textAreaDocumentsCapitaine.textProperty().bindBidirectional( courantEquipier.documentsEquipierProperty() );*/
					
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
					
			// Equipier
			// Nom
			textFieldNomEquipier.textProperty().bindBidirectional( courantEquipier.nomProperty() );
			// Prénom
			textFieldPrenomEquipier.textProperty().bindBidirectional( courantEquipier.prenomProperty() );
			// Birthday
			datePickerBirthEquipier.getEditor().textProperty().bindBidirectional( courantEquipier.birthdateProperty(), new ConverterStringLocalDate() );
			datePickerBirthEquipier.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courantEquipier.birthdateProperty())  );
			UtilFX.bindBidirectional( datePickerBirthEquipier.getEditor(), courantEquipier.birthdateProperty(), new ConverterStringLocalDate() );
			// Numero
			textFieldNumeroEquipier.textProperty().bindBidirectional( courantEquipier.telephoneProperty() );
			// Email
			textFieldEmailEquipier.textProperty().bindBidirectional( courantEquipier.emailProperty() );
			// Adresse
			textFieldAdresseEquipier.textProperty().bindBidirectional( courantEquipier.adresseProperty() );
			// Code Postale
			textFieldCodePostaleEquipier.textProperty().bindBidirectional( courantEquipier.codePostaleProperty());
			// Ville
			textFieldVilleEquipier.textProperty().bindBidirectional( courantEquipier.villeProperty() );
								
			// Reglement
			// Reglement fait?
			checkBoxReglement.selectedProperty().bindBidirectional( courantEquipier.reglementProperty() );
			// Repas
			textFieldRepas.textProperty().bindBidirectional( courantCapitaine.repasProperty(), new ConverterStringInteger()  );
			// Parcours
			//modelParticipant.actualiserListe();
			//modelEquipe.actualiserListe();
			comboBoxParcours.setItems( modelEquipe.getParcours() );
	        comboBoxParcours.valueProperty().bindBidirectional( courantEquipe.parcoursProperty() );
		}
		
		// Actions
		
		@FXML
		private void doAnnuler() {
			managerGui.showView( EnumView.ParticipantListe );
		}
		
		@FXML
		private void doValider() {
			modelEquipe.validerMiseAJour();
			modelParticipant.validerMiseAJour();
			managerGui.showView( EnumView.ParticipantListe );
		}
		
		
}
