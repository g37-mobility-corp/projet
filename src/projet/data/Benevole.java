package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Benevole {
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final Property<Poste>		idposte		= new SimpleObjectProperty<>();
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final StringProperty		telephone	= new SimpleStringProperty();
	private final StringProperty		email		= new SimpleStringProperty();
	private final StringProperty		adresse		= new SimpleStringProperty();
	private final StringProperty		ville		= new SimpleStringProperty();
	private final StringProperty		codePostale	= new SimpleStringProperty();
	private final Property<LocalDate>	birthdate	= new SimpleObjectProperty<>();
	private final Property<Boolean>		permisConduire		= new SimpleObjectProperty<>();
	private final StringProperty		plaqueImma	= new SimpleStringProperty();
	private final Property<Boolean>		brevetSecourisme	= new SimpleObjectProperty<>();
	
	// Constructeurs
	
		public Benevole() {
		}
		
		public Benevole( int id, Poste idposte, String nom, String prenom, String telephone, String email, String adresse, 
							String ville, String codepostale, LocalDate birthdate, Boolean permisConduire, 
							String plaqueImma, Boolean brevetSecourisme) {
			setId(id);
			setIdposte(idposte);
			setNom(nom);
			setPrenom(prenom);
			setTelephone(telephone);
			setAdresse(adresse);
			setVille(ville);
			setCodePostale(codepostale);
			setBirthdate(birthdate);
			setPermisConduire(permisConduire);
			setPlaqueImma(plaqueImma);
			setBrevetSecourisme(brevetSecourisme);
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
		
		public final Property<Poste> idposteProperty() {
			return this.idposte;
		}
		

		public final Poste getIdposte() {
			return this.idposteProperty().getValue();
		}
		

		public final void setIdposte(final Poste idposte) {
			this.idposteProperty().setValue(idposte);
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
			Benevole other = (Benevole) obj;
			return Objects.equals(id.getValue(), other.id.getValue());
		}
		
		public String toString() {
			return this.getNom()+' '+this.getPrenom();
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
		

		public final StringProperty emailProperty() {
			return this.email;
		}
		

		public final String getEmail() {
			return this.emailProperty().get();
		}
		

		public final void setEmail(final String email) {
			this.emailProperty().set(email);
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

		public final Property<Boolean> permisConduireProperty() {
			return this.permisConduire;
		}
		

		public final Boolean getPermisConduire() {
			return this.permisConduireProperty().getValue();
		}
		

		public final void setPermisConduire(final Boolean permisConduire) {
			this.permisConduireProperty().setValue(permisConduire);
		}
		

		public final StringProperty plaqueImmaProperty() {
			return this.plaqueImma;
		}
		

		public final String getPlaqueImma() {
			return this.plaqueImmaProperty().get();
		}
		

		public final void setPlaqueImma(final String plaqueImma) {
			this.plaqueImmaProperty().set(plaqueImma);
		}
		

		public final Property<Boolean> brevetSecourismeProperty() {
			return this.brevetSecourisme;
		}
		

		public final Boolean getBrevetSecourisme() {
			return this.brevetSecourismeProperty().getValue();
		}
		

		public final void setBrevetSecourisme(final Boolean brevetSecourisme) {
			this.brevetSecourismeProperty().setValue(brevetSecourisme);
		}
		
				

}
