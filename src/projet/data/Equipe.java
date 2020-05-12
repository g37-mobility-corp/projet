package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Equipe  {

	
	// Données observables

	private final Property<Integer>	idequipe	= new SimpleObjectProperty<>();
	private final Property<Integer>	idcompte	= new SimpleObjectProperty<>();
	private final Property<Integer>	idparcours	= new SimpleObjectProperty<>();
	private final Property<Participant>	Chef	     = new SimpleObjectProperty<>();
	private final Property<Participant>	Coequipier = new SimpleObjectProperty<>();
	private final StringProperty	nom			= new SimpleStringProperty();
	private final StringProperty	categorie 	= new SimpleStringProperty();
	
	
	// Constructeurs
	
	public Equipe() {
	}

	public Equipe( int idequipe, int idcompte, int idparcours,int idchef,int idcoequipier ,String nom, String categorie ) {
		setIdequipe(idequipe);
		setIdcompte(idcompte);
		setIdparcours(idparcours);
		setNom(nom);
		setCategorie(categorie);
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

	public final Property<Integer> idequipeProperty() {
		return this.idequipe;
	}
	

	public final Integer getIdequipe() {
		return this.idequipeProperty().getValue();
	}
	

	public final void setIdequipe(final Integer idequipe) {
		this.idequipeProperty().setValue(idequipe);
	}

	public final Property<Participant> ChefProperty() {
		return this.Chef;
	}
	
	//getter & setters chef et coequipier

	public final Participant getChef() {
		return this.ChefProperty().getValue();
	}
	

	public final void setChef(final Participant Chef) {
		this.ChefProperty().setValue(Chef);
	}
	

	public final Property<Participant> CoequipierProperty() {
		return this.Coequipier;
	}
	

	public final Participant getCoequipier() {
		return this.CoequipierProperty().getValue();
	}
	

	public final void setCoequipier(final Participant Coequipier) {
		this.CoequipierProperty().setValue(Coequipier);
	}
	
	
}
