package projet.report;


public enum EnumReport implements IEnumReport {

	
	// Valeurs
	
	ListeParticipant	( "Participant/ListeNom.jrxml" ),
	ListeBenevole	( "Benevole/ListeBenevole.jrxml" ),
	;

	
	// Champs
	
	private String		path;

	
	// Constructeur 
	
	EnumReport( String path ) {
		this.path = path;
	}

	
	// Getters & setters

	@Override
	public String getPath() {
		return path;
	}

}
