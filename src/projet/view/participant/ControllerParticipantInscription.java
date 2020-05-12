package projet.view.participant;

import javax.inject.Inject;

import javafx.beans.binding.Bindings;
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
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Categorie;
import projet.data.Participant;
import projet.view.compte.ModelCompte;

public class ControllerParticipantInscription {

	// Composants de la vue
	
	// Toujours Visible
		@FXML
		private TextField		textFieldId;
		@FXML
		private ComboBox<Categorie>	comboBoxCategorie;
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
		private Participant courant;
		
		@Inject
		private IManagerGui		managerGui;
		@Inject
		private ModelParticipant	modelParticipant;
			
		
		
	// Initialisation du Controller

		@FXML
		private void initialize() {
			// Data binding
			courant = modelParticipant.getCourant();
							
			// Toujours Visible
			// id
			textFieldId.textProperty().bindBidirectional( courant.idProperty(), new ConverterStringInteger()  );
							
			// Catégorie
			comboBoxCategorie.setItems( courant.getCategories());
			comboBoxCategorie.valueProperty().bindBidirectional( courant.categorieProperty() );
							
			// Titre
			textFieldNomEquipe.textProperty().bindBidirectional( courant.nomEquipeProperty() );
							
			// Document
			textAreaDocuments.textProperty().bindBidirectional( courant.documentProperty() );
					
			// Capitaine
			// Nom
			textFieldNomCapitaine.textProperty().bindBidirectional( courant.nomCapitaineProperty() );
			// Prénom
			textFieldPrenomCapitaine.textProperty().bindBidirectional( courant.prenomCapitaineProperty() );
			// Birthday
			datePickerBirthCapitaine.getEditor().textProperty().bindBidirectional( courant.birthCapitaineProperty(), new ConverterStringLocalDate());
			datePickerBirthCapitaine.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courant.birthCapitaineProperty())  );
			UtilFX.bindBidirectional( datePickerBirthCapitaine.getEditor(), courant.birthCapitaineProperty(), new ConverterStringLocalDate() );
			// Numero
			textFieldNumeroCapitaine.textProperty().bindBidirectional( courant.numeroCapitaineProperty(), new ConverterStringInteger()  );
			// Email
			textFieldEmailCapitaine.textProperty().bindBidirectional( courant.emailCapitaineProperty() );
			// Adresse
			textFieldAdresseCapitaine.textProperty().bindBidirectional( courant.adresseCapitaineProperty() );
			// Code Postale
			textFieldCodePostaleCapitaine.textProperty().bindBidirectional( courant.codePostaleCapitaineProperty(), new ConverterStringInteger()  );
			// Ville
			textFieldVilleCapitaine.textProperty().bindBidirectional( courant.villeCapitaineProperty() );
					
			// Equipier
			// Nom
			textFieldNomEquipier.textProperty().bindBidirectional( courant.nomEquipierProperty() );
			// Prénom
			textFieldPrenomEquipier.textProperty().bindBidirectional( courant.prenomEquipierProperty() );
			// Birthday
			datePickerBirthEquipier.getEditor().textProperty().bindBidirectional( courant.birthEquipierProperty(), new ConverterStringLocalDate() );
			datePickerBirthEquipier.getEditor().focusedProperty().addListener(new ListenerFocusValidation( courant.birthEquipierProperty())  );
			UtilFX.bindBidirectional( datePickerBirthEquipier.getEditor(), courant.birthEquipierProperty(), new ConverterStringLocalDate() );
			// Numero
			textFieldNumeroEquipier.textProperty().bindBidirectional( courant.numeroEquipierProperty(), new ConverterStringInteger()  );
			// Email
			textFieldEmailEquipier.textProperty().bindBidirectional( courant.emailEquipierProperty() );
			// Adresse
			textFieldAdresseEquipier.textProperty().bindBidirectional( courant.adresseEquipierProperty() );
			// Code Postale
			textFieldCodePostaleEquipier.textProperty().bindBidirectional( courant.codePostaleEquipierProperty(), new ConverterStringInteger()  );
			// Ville
			textFieldVilleEquipier.textProperty().bindBidirectional( courant.villeEquipierProperty() );
								
			// Regelement
			// Reglement
			checkBoxReglement.selectedProperty().bindBidirectional( courant.reglementProperty() );
			// Repas
			textFieldRepas.textProperty().bindBidirectional( courant.repasProperty() );
			// Formule
			toggleGroupFormule.selectedToggleProperty().addListener( obs -> actualiserStatutDansModele() ) ; 
			courant.statutProperty().addListener(  obs -> actualiserStatutDansVue() );
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
