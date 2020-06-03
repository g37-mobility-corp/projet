package projet.data;

import java.util.Objects;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Parcours  {

	
	// Données observables

	private final Property<Integer>		idparcours	= new SimpleObjectProperty<>();
	private final StringProperty		nom			= new SimpleStringProperty();
	private final Property<Double>		distance 	= new SimpleObjectProperty<>();
	private final StringProperty 		infos 		= new SimpleStringProperty();
	
	
	// Constructeurs

	public Parcours(int idparcours, String nom, double distance, String infos) {
		setIdparcours(idparcours);
		setNom(nom);
		setDistance(distance);
		setInfos(infos);
	}

	public Parcours() {
		// TODO Auto-generated constructor stub
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
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final Property<Double> distanceProperty() {
		return this.distance;
	}
	

	public final double getDistance() {
		return this.distanceProperty().getValue();
	}
	

	public final void setDistance(final double distance) {
		this.distanceProperty().setValue(distance);
	}
	

	public final StringProperty infosProperty() {
		return this.infos;
	}
	

	public final String getInfos() {
		return this.infosProperty().get();
	}
	

	public final void setInfos(final String infos) {
		this.infosProperty().set(infos);
	}
	
	public final String toString() {
		return this.getNom();
	}

	@Override
	public int hashCode() {
		return Objects.hash(idparcours.getValue());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcours other = (Parcours) obj;
		return Objects.equals(idparcours.getValue(), other.idparcours.getValue());
	}
	
	
	
	
}
