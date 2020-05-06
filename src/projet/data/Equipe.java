package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Equipe  {

	
	// Données observables
	
	private final Property<Integer>	id			= new SimpleObjectProperty<>();
	private final StringProperty	nom	= new SimpleStringProperty();
	private final StringProperty	categorie 		= new SimpleStringProperty();
	private final ObservableList<Participant> participant = FXCollections.observableArrayList();
	
	
	// Constructeurs
	
	public Equipe() {
	}

	public Equipe( int id, String nom, String categorie ) {
		setId(id);
		setNom(nom);
		setCategorie(categorie);
	}

	public final Property<Integer> idProperty() {
		return this.id;
	}
	

	public final Integer getId() {
		return this.idProperty().getValue();
	}
	

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final StringProperty categorieProperty() {
		return this.categorie;
	}
	

	public final String getCategorie() {
		return this.categorieProperty().get();
	}
	

	public final void setCategorie(final String categorie) {
		this.categorieProperty().set(categorie);
	}
	
	public String toString() {
		return this.getNom();
	}
	
	
	
	
	
}
