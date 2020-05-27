package projet.data;

import java.time.LocalDate;
import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Benevole {
	
	private final Property<Integer>		id			= new SimpleObjectProperty<>();
	private final StringProperty		nom	 		= new SimpleStringProperty();
	private final StringProperty		prenom		= new SimpleStringProperty();
	private final StringProperty		telephone	= new SimpleStringProperty();
	private final Property<LocalDate>	birthdate	= new SimpleObjectProperty<>();
	private final Property<Poste>		idposte		= new SimpleObjectProperty<>();
	
	// Constructeurs
	
		public Benevole() {
		}
		
		public Benevole( int id, String nom, String prenom, String telephone, LocalDate birthdate, Poste idposte) {
			setId(id);
			setNom(nom);
			setPrenom(prenom);
			setTelephone(telephone);
			setBirthdate(birthdate);
			setIdposte(idposte);
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

}
