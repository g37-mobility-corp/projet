package projet.view.equipe;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Equipe;
import projet.data.Parcours;
import projet.data.Equipe;
import projet.view.EnumView;


public class ControllerEquipeListe {
	
	
	// Composants de la vue

	@FXML
	private TableView<Equipe>		tableView;
	@FXML
	private TableColumn<Equipe,String> nomCol;
	@FXML
	private TableColumn<Equipe,String> parcoursCol;
	@FXML
	private TableColumn<Equipe,String> categorieCol;
	@FXML
	private TableColumn<Equipe,Boolean> valideCol;
	
	@FXML
	private Button				buttonModifier;
	@FXML
	private Button				buttonSupprimer;


	// Autres champs
	
	@Inject
	private IManagerGui			managerGui;
	@Inject
	private ModelEquipe		modelEquipe;
	
	
	// Initialisation du Controller

	@FXML
	private void initialize() {
		

		// Data binding
		
		// Defines how to fill data for each cell.
	    // Get value from property of UserAccount. .
		nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
	    parcoursCol.setCellValueFactory(new PropertyValueFactory<>("parcours"));
	    categorieCol.setCellValueFactory(new PropertyValueFactory<>("categorie"));
	    valideCol.setCellValueFactory(new PropertyValueFactory<>("valide"));
	    
	    nomCol.setSortType(TableColumn.SortType.DESCENDING);
	    // Display row data
	    tableView.setItems( modelEquipe.getListe() );
	    
	    //tableView.getColumns().addAll(nomCol, parcoursCol, categorieCol, valideCol);
	    
	      
		
		//tableView.setRowFactory(  UtilFX.cellFactory( item -> item.getNom() ));
		
		// Configuraiton des boutons
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
		});
		configurerBoutons();

	}
	
	public void refresh() {
		modelEquipe.actualiserListe();
		//UtilFX.selectInListView( tableView, modelEquipe.getCourant() );
		tableView.requestFocus();
	}

	
	// Actions
	
	@FXML
	private void doAjouter() {
		modelEquipe.preparerAjouter();;
		managerGui.showView( EnumView.EquipeForm );
	}

	@FXML
	private void doModifier() {
		Equipe item = tableView.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			modelEquipe.preparerModifier(item);
			managerGui.showView( EnumView.EquipeForm );
		}
	}

	@FXML
	private void doSupprimer() {
		Equipe item = tableView.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			boolean reponse = managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" );
			if ( reponse ) {
				modelEquipe.supprimer( item );
				refresh();
			}
		}
	}
	
	
	// Gestion des évènements

	// Clic sur la liste
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( tableView.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					doModifier();
				}
			}
		}
	}

	
	// Méthodes auxiliaires
	
	private void configurerBoutons() {
		
    	if( tableView.getSelectionModel().getSelectedItems().isEmpty() ) {
			buttonModifier.setDisable(true);
			buttonSupprimer.setDisable(true);
		} else {
			buttonModifier.setDisable(false);
			buttonSupprimer.setDisable(false);
		}
	}

}
