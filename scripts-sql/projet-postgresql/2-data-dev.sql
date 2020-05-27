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

INSERT INTO equipe (idequipe, idcompte, idparcours, nom_equipe, categorie ,valide) VALUES
  (1,2,1,'MobilityCorp','MIXTE',true );

ALTER TABLE equipe ALTER COLUMN idequipe RESTART WITH 2;


-- Participant

INSERT INTO participant (idparticipant, nom, prenom,telephone,birthdate) VALUES
  ( 1, 'GRASSET', 'Jérôme','06XXXXXXXX', {d  '2020-02-25' } ),
  ( 2, 'BOUBY', 'Claude', '06XXXXXXXX', {d  '2020-01-12' } ),
  (3,'Brynn','Cailin','0571217323','19-11-04'),
  (4,'Carl','Philip','05 97 59 48 85','19-11-10'),
  (5,'James','Ali','07 67 82 02 62','19-06-03'),
  (6,'Aline','Tad','01 02 61 01 14','20-10-31'),
  (7,'Rogan','Frances','06 50 31 57 43','20-10-01'),
  (8,'Nita','Gavin','05 42 76 63 05','20-01-26'),
  (9,'Gloria','Malcolm','06 70 05 17 03','19-09-16'),
  (10,'Wynne','Aimee','06 40 77 85 16','19-11-16'),
  (11,'Kibo','Ivana','05 43 37 00 07','19-10-23'),
  (12,'Elton','Rahim','05 15 08 82 10','20-08-26');

ALTER TABLE participant ALTER COLUMN idparticipant RESTART WITH 13;

-- Insertion des participants dans l'équipe
UPDATE equipe SET idchef = 1, idcoequipier = 2 WHERE idequipe =  1;

-- Poste

INSERT INTO poste (idposte, nom, lieu, fonction ) VALUES
  ( 1, 'Poste n°1', 'Buvette', 'Descriptif 1' ),
  ( 2, 'Poste n°2', 'Parking', 'Descriptif 2' ),
  ( 3, 'Poste n°3', 'Arrivée', 'Descriptif 3');

ALTER TABLE poste ALTER COLUMN idposte RESTART WITH 4;

-- Benevole

INSERT INTO benevole (idbenevole, idposte, nom, prenom, birthdate) VALUES
--  ( 1, 1, 'test', 'test', {d  '2020-02-25' } ),
--  ( 1, 2, 'test2', 'test', {d  '2020-02-25' } ),
  ( 1, 3, 'test3', 'test', {d  '2020-02-25' } ),
--  ( 2, 1, 'test4', 'test', {d  '2020-02-25' } ),
  ( 2, 2, 'test4', 'test', {d  '2020-02-25' } );

ALTER TABLE benevole ALTER COLUMN idbenevole RESTART WITH 3;


-- -- Media

-- INSERT INTO media ( idmedia, media_path ) VALUES


-- ALTER TABLE service ALTER COLUMN idservice RESTART WITH 5;
