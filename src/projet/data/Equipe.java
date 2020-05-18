package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Equipe  {

	
	// Données observables

	private final Property<Integer>		idequipe	= new SimpleObjectProperty<>();
	private final Property<Integer>		idcompte	= new SimpleObjectProperty<>();
	private final Property<Parcours>	parcours	= new SimpleObjectProperty<>();
	private final Property<Participant>	Chef		= new SimpleObjectProperty<>();
	private final Property<Participant>	Coequipier 	= new SimpleObjectProperty<>();
	private final StringProperty		nom			= new SimpleStringProperty();
	private final StringProperty		categorie 	= new SimpleStringProperty();
	private final Property<Boolean> 	valide 		= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Equipe() {
	}

	public Equipe( int idequipe, int idcompte, Parcours parcours, Participant chef, Participant coequipier , String nom, String categorie, Boolean valide ) {
		setIdequipe(idequipe);
		setIdcompte(idcompte);
		setParcours(parcours);
		setChef(chef);
		setCoequipier(coequipier);
		setNom(nom);
		setCategorie(categorie);
		setValide(valide);
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

	public final Property<Boolean> valideProperty() {
		return this.valide;
	}
	

	public final Boolean getValide() {
		return this.valideProperty().getValue();
	}
	

	public final void setValide(final Boolean valide) {
		this.valideProperty().setValue(valide);
	}

	public final Property<Parcours> parcoursProperty() {
		return this.parcours;
	}
	

	public final Parcours getParcours() {
		return this.parcoursProperty().getValue();
	}
	

	public final void setParcours(final Parcours parcours) {
		this.parcoursProperty().setValue(parcours);
	}
	
	
	
	
}
