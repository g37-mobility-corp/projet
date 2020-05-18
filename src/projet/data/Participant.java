
package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Participant {


	// Données observables

	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final Property<Integer>		equipe		= new SimpleObjectProperty<>();
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final StringProperty		telephone	= new SimpleStringProperty();
	private final Property<LocalDate>	birthdate	= new SimpleObjectProperty<>();
	
	
	// Constructeurs
	
	public Participant() {
	}
	
	public Participant( int id, int equipe, String nom, String prenom, String telephone, LocalDate birthdate) {
		setId(id);
		setEquipe(equipe);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setBirthdate(birthdate);
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
	

	public final StringProperty prenomProperty() {
		return this.prenom;
	}
	

	public final String getPrenom() {
		return this.prenomProperty().get();
	}
	

	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	

	public final StringProperty telephoneProperty() {
		return this.telephone;
	}
	

	public final String getTelephone() {
		return this.telephoneProperty().get();
	}
	

	public final void setTelephone(final String telephone) {
		this.telephoneProperty().set(telephone);
	}
	

	public final Property<LocalDate> birthdateProperty() {
		return this.birthdate;
	}
	

	public final LocalDate getBirthdate() {
		return this.birthdateProperty().getValue();
	}
	

	public final void setBirthdate(final LocalDate birthdate) {
		this.birthdateProperty().setValue(birthdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return Objects.equals(id.getValue(), other.id.getValue());
	}
	
	public String toString() {
		return this.getNom()+' '+this.getPrenom();
	}

	public final Property<Integer> equipeProperty() {
		return this.equipe;
	}
	

	public final Integer getEquipe() {
		return this.equipeProperty().getValue();
	}
	

	public final void setEquipe(final Integer equipe) {
		this.equipeProperty().setValue(equipe);
	}
	
	
	
	
}
