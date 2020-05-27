package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Poste  {

	
	// Données observables

	private final Property<Integer>		idposte		= new SimpleObjectProperty<>();
	private final StringProperty		nom			= new SimpleStringProperty();
	private final StringProperty		lieu	 	= new SimpleStringProperty();
	private final StringProperty 		fonction	= new SimpleStringProperty();
	
	
	// Constructeurs

	public Poste(int idposte, String nom, String lieu, String fonction) {
		setIdposte(idposte);
		setNom(nom);
		setLieu(lieu);
		setFonction(fonction);
	}

	public Poste() {
		// TODO Auto-generated constructor stub
	}
	
	public final String toString() {
		return this.getNom();
	}

	public final Property<Integer> idposteProperty() {
		return this.idposte;
	}
	

	public final Integer getIdposte() {
		return this.idposteProperty().getValue();
	}
	

	public final void setIdposte(final Integer idposte) {
		this.idposteProperty().setValue(idposte);
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
	

	public final StringProperty lieuProperty() {
		return this.lieu;
	}
	

	public final String getLieu() {
		return this.lieuProperty().get();
	}
	

	public final void setLieu(final String lieu) {
		this.lieuProperty().set(lieu);
	}
	

	public final StringProperty fonctionProperty() {
		return this.fonction;
	}
	

	public final String getFonction() {
		return this.fonctionProperty().get();
	}
	

	public final void setFonction(final String fonction) {
		this.fonctionProperty().set(fonction);
	}
	
	
	
	
	
}
