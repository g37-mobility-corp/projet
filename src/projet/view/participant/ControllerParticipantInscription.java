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
import projet.data.Participant;
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
		private TextArea		textAreaDocuments;
		
	
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
		private ToggleGroup		toggleGroupFormule;
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
			courantCapitaine = modelParticipant.getCourant();
			courantEquipier = modelParticipant.getCourant();
							
			// Toujours Visible
			// id
			textFieldId.textProperty().bindBidirectional( courantEquipe.idequipeProperty(), new ConverterStringInteger()  );
							
			// Catégorie
			final ObservableList<String> categories = FXCollections.observableArrayList("HOMME", "FEMME", "MIXTE", "VAE");
			comboBoxCategorie.setItems(categories);
			comboBoxCategorie.valueProperty().bindBidirectional( courantEquipe.categorieProperty() );
							
			// Titre
			textFieldNomEquipe.textProperty().bindBidirectional( courantEquipe.nomProperty() );
							
			// Document
			textAreaDocuments.textProperty().bindBidirectional( courant.documentProperty() );
					
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
			textFieldEmailCapitaine.textProperty().bindBidirectional( courantCapitaine.emailCapitaineProperty() );
			// Adresse
			textFieldAdresseCapitaine.textProperty().bindBidirectional( courantCapitaine.adresseCapitaineProperty() );
			// Code Postale
			textFieldCodePostaleCapitaine.textProperty().bindBidirectional( courantCapitaine.codePostaleCapitaineProperty(), new ConverterStringInteger()  );
			// Ville
			textFieldVilleCapitaine.textProperty().bindBidirectional( courantCapitaine.villeCapitaineProperty() );
					
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
			textFieldEmailEquipier.textProperty().bindBidirectional( courantEquipier.emailEquipierProperty() );
			// Adresse
			textFieldAdresseEquipier.textProperty().bindBidirectional( courantEquipier.adresseEquipierProperty() );
			// Code Postale
			textFieldCodePostaleEquipier.textProperty().bindBidirectional( courantEquipier.codePostaleEquipierProperty(), new ConverterStringInteger()  );
			// Ville
			textFieldVilleEquipier.textProperty().bindBidirectional( courantEquipier.villeEquipierProperty() );
								
			// Regelement
			// Reglement
			checkBoxReglement.selectedProperty().bindBidirectional( courantEquipe.reglementProperty() );
			// Repas
			textFieldRepas.textProperty().bindBidirectional( courantEquipe.repasProperty() );
			// Formule
			toggleGroupFormule.selectedToggleProperty().addListener( obs -> actualiserStatutDansModele() ) ; 
			courantEquipe.statutProperty().addListener(  obs -> actualiserStatutDansVue() );
			actualiserStatutDansVue();			
		}
	
		// Méthodes auxiliaires
		
		private void actualiserFormuleDansModele() {
			// Modifie le statut en fonction du bouton radio sélectionné 
			Toggle bouton = toggleGroupFormule.getSelectedToggle();
			int formule = toggleGroupFormule.getToggles().indexOf( bouton  );
			modelParticipant.getCourant().setStatut( formule );
		}
		
		private void actualiserFormuleDansVue() {
			// Sélectionne le bouton radio correspondant au statut
			int formule = modelParticipant.getCourant().getStatut();
			Toggle bouton = toggleGroupFormule.getToggles().get( formule );
			toggleGroupFormule.selectToggle(  bouton );
		}
		
		
		
}
