SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;


-- Tables

CREATE TABLE compte (
	idcompte		INT				GENERATED BY DEFAULT AS IDENTITY,
	email			VARCHAR(100)	NOT NULL,
	motdepasse		VARCHAR(25) 	NOT NULL,
	PRIMARY KEY (idcompte),
	UNIQUE (email)
);

CREATE TABLE role (
	idcompte		INT				NOT NULL,
	role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR','PARTICIPANT','BENEVOLE') ),	
	PRIMARY KEY (idcompte, role),
	FOREIGN KEY (idcompte) REFERENCES compte (idcompte)
);

CREATE TABLE equipe (
	idequipe			INT				GENERATED BY DEFAULT AS IDENTITY,
	idcompte 			INT						,
	nom_equipe			VARCHAR(25)		NOT NULL,
	categorie 			VARCHAR(25)		NOT NULL,
	CHECK( categorie IN ('HOMME','FEMME','MIXTE') ),	
	PRIMARY KEY (idequipe),
	FOREIGN KEY (idcompte) REFERENCES compte (idcompte)
);


CREATE TABLE participant (
	idparticipant	INT				GENERATED BY DEFAULT AS IDENTITY,
	idequipe		INT				NOT NULL,
	nom				VARCHAR(25)  	NOT NULL,
	prenom			VARCHAR(25) 	NOT NULL,
	telephone		VARCHAR(10)				,
	birthdate		DATE			NOT NULL,
	PRIMARY KEY (idparticipant),
 	FOREIGN KEY (idequipe) REFERENCES equipe (idequipe)
);

CREATE TABLE parcours (
	idparcours		INT				GENERATED BY DEFAULT AS IDENTITY,
	idequipe		INT				NOT NULL,
	nom				VARCHAR(25)  	NOT NULL,
	distance		INT			 	NOT NULL,
	infos			TEXT					,
	PRIMARY KEY (idparcours),
 	FOREIGN KEY (idequipe) REFERENCES equipe (idequipe)
);

CREATE TABLE poste (
	idposte			INT				GENERATED BY DEFAULT AS IDENTITY,
	nom				VARCHAR(25)  	NOT NULL,
	lieu			VARCHAR(255) 	NOT NULL,
	fonction		TEXT					,
	PRIMARY KEY (idposte)
);

CREATE TABLE benevole (
	idbenevole		INT				GENERATED BY DEFAULT AS IDENTITY,
	idposte			INT						,
	nom				VARCHAR(25)  	NOT NULL,
	prenom			VARCHAR(25) 	NOT NULL,
	telephone		VARCHAR(10)				,
	birthdate		DATE			NOT NULL,
	PRIMARY KEY (idbenevole),
 	FOREIGN KEY (idposte) REFERENCES poste (idposte)
);

-- MEDIAS

CREATE TABLE media (
	idmedia			INT				GENERATED BY DEFAULT AS IDENTITY,
	idbenevole		INT							,
	idparticipant	INT							,
	media_path			VARCHAR(255)  	NOT NULL,
	PRIMARY KEY (idmedia),
 	FOREIGN KEY (idbenevole) REFERENCES benevole (idbenevole),
	FOREIGN KEY (idparticipant) REFERENCES participant (idparticipant)
);

-- CREATE TABLE telephone (
-- 	idtelephone		INT				GENERATED BY DEFAULT AS IDENTITY,
-- 	idpersonne		INT			 	NOT NULL,
-- 	Libelle			VARCHAR(25)		NOT NULL,
-- 	Numero			VARCHAR(25)		NOT NULL,
-- 	PRIMARY KEY (idtelephone),
-- 	FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne)
-- );

-- CREATE TABLE memo (	
-- 	idmemo 			INT				GENERATED BY DEFAULT AS IDENTITY, 
-- 	titre 			VARCHAR(50)		NOT NULL, 
-- 	description		VARCHAR(1000), 
-- 	flagurgent		BOOLEAN			NOT NULL, 
-- 	statut			SMALLINT		NOT NULL	DEFAULT 0,
-- 	effectif		INT,
-- 	budget			DOUBLE PRECISION,
-- 	echeance		Date,
-- 	idcategorie		INT,
-- 	CHECK( statut BETWEEN 0 AND 2 ),	
-- 	PRIMARY KEY (idmemo),
--  	FOREIGN KEY (idcategorie) REFERENCES categorie (idcategorie)
-- );

-- CREATE TABLE concerner (
-- 	idmemo		INT				NOT NULL,
-- 	idpersonne	INT				NOT NULL,
-- 	PRIMARY KEY (idmemo, idpersonne),
-- 	FOREIGN KEY (idmemo) REFERENCES memo (idmemo),
-- 	FOREIGN KEY (idpersonne) REFERENCES personne (idpersonne)
-- );

-- CREATE TABLE service (	
-- 	idservice 		INT				GENERATED BY DEFAULT AS IDENTITY, 
-- 	nom 			VARCHAR(50)		NOT NULL, 
-- 	description		VARCHAR(1000), 
-- 	anneecreation	SMALLINT,
-- 	flagsiege		BOOLEAN			NOT NULL, 
-- 	PRIMARY KEY (idservice)
-- );


-- Vues

CREATE VIEW v_compte_avec_roles AS
	SELECT c.*, ARRAY_AGG( r.role ) AS roles
	FROM compte c 
	LEFT JOIN ROLE r ON c.idcompte = r.idcompte
	GROUP BY c.idcompte;

