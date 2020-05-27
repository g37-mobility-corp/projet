package projet.commun;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.data.Benevole;
import projet.data.Categorie;
import projet.data.Compte;
import projet.data.Equipe;
import projet.data.Parcours;
import projet.data.Participant;
import projet.data.Poste;


@Mapper
public interface IMapper {  
	
	Compte update( @MappingTarget Compte target, Compte source  );
	
	Categorie update( @MappingTarget Categorie target, Categorie source );

	@Mapping( target="chef", expression="java( source.getChef() )" )
	@Mapping( target="coequipier", expression="java( source.getCoequipier() )" )
	Equipe update( @MappingTarget Equipe target, Equipe source );

	Participant update( @MappingTarget Participant target, Participant source );
	
	Benevole update( @MappingTarget Benevole target, Benevole source );
	
	Parcours update( @MappingTarget Parcours target, Parcours source  );
	
	Poste update( @MappingTarget Poste target, Poste source  );
	
}
