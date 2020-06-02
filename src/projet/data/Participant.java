
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
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final StringProperty		telephone	= new SimpleStringProperty();
	private final StringProperty		email		= new SimpleStringProperty();
	private final StringProperty		adresse		= new SimpleStringProperty();
	private final StringProperty		ville		= new SimpleStringProperty();
	private final StringProperty		codePostale		= new SimpleStringProperty();
	private final Property<Integer>		repas		=new SimpleObjectProperty<>(0); 
	private final Property<Boolean>		reglement		=new SimpleObjectProperty<>(false); 
	private final Property<LocalDate>	birthdate	= new SimpleObjectProperty<>();


	// Constructeurs

	public Participant() {
	}

	public Participant( int id, String nom, String prenom, String telephone, String email, String adresse, String ville, String codePostale, int repas, boolean reglement, LocalDate birthdate) {
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		setTelephone(telephone);
		setEmail(email);
		setAdresse(adresse);
		setVille(ville);
		setCodePostale(codePostale);
		setRepas(repas);
		setReglement(reglement);
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
		return Objects.hash(id.getValue());
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

	public final StringProperty emailProperty() {
		return this.email;
	}
	

	public final String getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	

	public final StringProperty adresseProperty() {
		return this.adresse;
	}
	

	public final String getAdresse() {
		return this.adresseProperty().get();
	}
	

	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	

	public final StringProperty villeProperty() {
		return this.ville;
	}
	

	public final String getVille() {
		return this.villeProperty().get();
	}
	

	public final void setVille(final String ville) {
		this.villeProperty().set(ville);
	}
	

	public final StringProperty codePostaleProperty() {
		return this.codePostale;
	}
	

	public final String getCodePostale() {
		return this.codePostaleProperty().get();
	}
	

	public final void setCodePostale(final String codePostale) {
		this.codePostaleProperty().set(codePostale);
	}
	

	public final Property<Integer> repasProperty() {
		return this.repas;
	}
	

	public final Integer getRepas() {
		return this.repasProperty().getValue();
	}
	

	public final void setRepas(final Integer repas) {
		this.repasProperty().setValue(repas);
	}
	

	public final Property<Boolean> reglementProperty() {
		return this.reglement;
	}
	

	public final Boolean getReglement() {
		return this.reglementProperty().getValue();
	}
	

	public final void setReglement(final Boolean reglement) {
		this.reglementProperty().setValue(reglement);
	}
	

}
