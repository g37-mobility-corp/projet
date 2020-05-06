package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Equipe  {

	
	// Données observables

	private final Property<Integer>	id			= new SimpleObjectProperty<>();
	private final Property<Integer>	idcompte	= new SimpleObjectProperty<>();
	private final Property<Integer>	idparcours	= new SimpleObjectProperty<>();
	private final StringProperty	nom	= new SimpleStringProperty();
	private final StringProperty	categorie 		= new SimpleStringProperty();
	
	
	// Constructeurs
	
	public Equipe() {
	}

	public Equipe( int id, int idcompte, int idparcours, String nom, String categorie ) {
		setId(id);
		setId(idcompte);
		setId(idparcours);
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

	public final Property<Integer> idcompteProperty() {
		return this.idcompte;
	}
	

	public final Integer getIdcompte() {
		return this.idcompteProperty().getValue();
	}
	

	public final void setIdcompte(final Integer idcompte) {
		this.idcompteProperty().setValue(idcompte);
	}
	

	public final Property<Integer> idparcoursProperty() {
		return this.idparcours;
	}
	

	public final Integer getIdparcours() {
		return this.idparcoursProperty().getValue();
	}
	

	public final void setIdparcours(final Integer idparcours) {
		this.idparcoursProperty().setValue(idparcours);
	}
	
	
	
	
	
	
}
