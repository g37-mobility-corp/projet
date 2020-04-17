SET search_path TO projet;


-- Supprimer toutes les données
DELETE FROM equipe;
DELETE FROM media;
DELETE FROM participant;
DELETE FROM parcours;
DELETE FROM benevole;
DELETE FROM poste;
DELETE FROM role;
DELETE FROM compte;


-- Compte

INSERT INTO compte (idcompte, email, motdepasse ) VALUES 
  (1, 'admin@3il.fr', 'admin' ),
  (2, 'user@3il.fr', 'user' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 3;


-- Role

INSERT INTO role (idcompte, role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' );

-- Parcours

INSERT INTO parcours (idparcours, nom, distance, infos ) VALUES 
  ( 1, 'Grand Bol', 10,'Infos du grand bol'),
  ( 2, 'Petit Bol', 3 ,'Infos du petit bol');

ALTER TABLE parcours ALTER COLUMN idparcours RESTART WITH 3;

-- Equipe
  
INSERT INTO equipe (idequipe, idcompte, idparcours, nom_equipe, categorie ) VALUES 
  (1,2,1,'MobilityCorp','MIXTE' );

ALTER TABLE equipe ALTER COLUMN idequipe RESTART WITH 2;


-- Participant

INSERT INTO participant (idparticipant, idequipe, nom, prenom,telephone,birthdate) VALUES 
  ( 1, 1, 'GRASSET', 'Jérôme','06XXXXXXXX', {d  '2020-02-25' } ),
  ( 2, 1, 'BOUBY', 'Claude', '06XXXXXXXX', {d  '2020-01-12' } );

ALTER TABLE participant ALTER COLUMN idparticipant RESTART WITH 3;

-- Poste

INSERT INTO poste (idposte, nom, lieu, fonction ) VALUES 
  ( 1, 'Poste n°1', 'Buvette', 'Descriptif 1' ),
  ( 2, 'Poste n°2', 'Parking', 'Descriptif 2' ),
  ( 3, 'Poste n°3', 'Arrivée', 'Descriptif 3');

ALTER TABLE poste ALTER COLUMN idposte RESTART WITH 4;

-- -- Benevole

-- INSERT INTO benevole (idbenevole, idposte) VALUES 
--   ( 1, 1 ),
--   ( 1, 2 ),
--   ( 1, 3 ),
--   ( 2, 1 ),
--   ( 2, 2 );


-- -- Media

-- INSERT INTO media ( idmedia, media_path ) VALUES 


-- ALTER TABLE service ALTER COLUMN idservice RESTART WITH 5;

