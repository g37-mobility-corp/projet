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

INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (3,'neque.non.quam@nasceturridiculusmus.edu','Gary','Jerome','737-9401 Massa Rd.','Langley','119899','true',2,'02 97 53 45 33','19-06-63'),(4,'Vivamus.nisi.Mauris@Aliquamornarelibero.net','Hoyt','Brendan','1375 Integer Ave','Buzet','42922','true',2,'09 09 33 51 60','20-11-99'),(5,'dictum.eu.eleifend@Fuscefeugiat.net','Amery','Lamar','894-7467 Sem Ave','Badin','3820 IF','true',2,'09 15 40 43 63','05-03-71'),(6,'ullamcorper.Duis@felisadipiscingfringilla.edu','Tiger','Slade','292-2044 Augue Road','Westerlo','72835-754','true',2,'07 98 39 36 10','03-01-59'),(7,'congue.a@eu.net','Axel','Declan','P.O. Box 547, 4635 Augue Ave','Jamshedpur','187225','true',1,'02 04 79 23 09','14-10-91'),(8,'erat.vel.pede@vulputatenisisem.ca','Ferdinand','Orson','4670 Turpis. Avenue','Coalville','933898','true',2,'03 10 90 19 85','16-05-02'),(9,'at.libero@Sed.ca','Erasmus','Gary','P.O. Box 110, 3897 Curabitur St.','Karlsruhe','783658','true',2,'05 89 21 12 99','14-07-73'),(10,'dignissim.Maecenas.ornare@etnetus.org','Ignatius','Demetrius','5943 Elit Ave','Donosti','VM4W 8VG','true',1,'07 44 23 46 29','20-07-95'),(11,'interdum.Curabitur.dictum@eumetus.co.uk','Brandon','Garth','721-8251 In St.','Baltasound','811626','false',2,'08 32 82 05 16','14-06-76'),(12,'fermentum.metus.Aenean@sagittis.edu','Nero','Hall','9116 Ornare Ave','Zuccarello','07122','true',1,'03 05 71 65 96','02-01-97');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (13,'bibendum.fermentum.metus@orci.com','Ryan','Otto','341-4043 Orci. St.','Troyes','53649','false',1,'06 68 84 46 55','27-09-96'),(14,'Curabitur.vel@interdumligula.co.uk','Kasper','Keegan','Ap #754-1275 Et Street','Trieste','15260-224','true',2,'02 38 04 21 40','25-05-71'),(15,'Donec@metusVivamuseuismod.ca','Uriah','Judah','P.O. Box 800, 1864 Lorem Rd.','Beerzel','24715-40243','false',2,'03 08 27 73 21','20-09-68'),(16,'et.netus.et@volutpatornare.net','Norman','Ronan','4411 Neque. Avenue','Madison','679109','false',1,'07 34 28 27 87','23-07-80'),(17,'Quisque@sagittis.com','Salvador','Jacob','Ap #115-287 Velit. Ave','Navsari','120464','true',1,'03 30 07 27 09','24-10-04'),(18,'lectus@Donecnibh.ca','Magee','Marshall','391-6721 Neque. Av.','Gavirate','075836','true',1,'09 16 39 45 62','19-10-78'),(19,'massa.Vestibulum@dictummi.ca','Brandon','Basil','112-2851 Dui Road','Harrogate','26290','false',1,'03 82 59 53 12','20-06-92'),(20,'ac@magnaPhasellus.edu','Beau','Dorian','P.O. Box 196, 5447 Lacus. St.','Kimberly','620680','false',2,'03 82 94 15 08','09-03-61'),(21,'congue.a@sollicitudin.ca','Dolan','Ray','P.O. Box 792, 1157 Molestie Rd.','Falisolle','4893','false',1,'06 52 37 64 70','25-10-03'),(22,'Sed@enim.ca','Dalton','Ali','P.O. Box 215, 6299 Ullamcorper Street','Dessau','517852','false',1,'09 81 31 87 22','06-05-04');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (33,'dui@diameu.co.uk','Stewart','Burton','Ap #731-1718 Non St.','Macerata','72232','true',1,'06 40 89 60 84','22-10-07'),(34,'eleifend.non.dapibus@dapibus.edu','Fritz','Garth','P.O. Box 290, 3764 Ut St.','Inuvik','45735','false',2,'03 19 62 80 47','16-12-14'),(35,'Nullam.vitae.diam@suscipitnonummyFusce.org','Zachery','Macon','290-5513 Quisque Road','Salamanca','Q6K 8NL','true',2,'03 93 85 05 43','29-04-81'),(36,'rutrum.urna.nec@posuereatvelit.org','Hasad','Colorado','8518 Enim, Road','Colico','06-265','false',1,'05 98 52 10 03','11-01-57'),(37,'pede.blandit.congue@malesuadavel.org','Axel','Jonas','Ap #858-4993 Vel Ave','Joinville','774031','false',1,'08 84 58 84 23','20-09-03'),(38,'fringilla@venenatisa.co.uk','Carter','Brett','1343 Ad Av.','Russell','27290-275','false',1,'04 89 95 44 15','27-07-81'),(39,'Aenean.euismod@nequevenenatis.ca','Colby','Carl','3011 Metus Road','Pietracatella','30893','false',2,'05 53 10 38 71','28-10-12'),(40,'diam@consectetueradipiscingelit.ca','Mufutau','Chaney','P.O. Box 798, 5429 Aliquam Ave','Sydney','297448','true',1,'01 96 42 74 06','29-03-72'),(41,'Suspendisse@estvitaesodales.co.uk','James','Stone','P.O. Box 189, 8149 Varius Avenue','Hospet','73784-38385','true',2,'01 16 03 21 45','17-01-16'),(42,'Cum.sociis.natoque@faucibusid.ca','Aladdin','Rashad','P.O. Box 656, 8194 Arcu St.','Kanpur','72404','true',1,'08 86 64 34 04','29-09-62');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (43,'a@atpretium.edu','Len','Ryan','8236 Iaculis St.','Gore','77406','false',1,'04 57 39 50 05','24-10-20'),(44,'egestas.Sed@VivamusrhoncusDonec.edu','Colorado','Cadman','Ap #787-6041 Sagittis St.','Södertälje','71781','false',1,'03 83 53 84 63','26-07-65'),(45,'massa@velit.edu','Troy','Vincent','5268 Fringilla St.','Lambusart','55166','true',2,'09 78 55 37 43','13-05-63'),(46,'sagittis.semper@ante.co.uk','Logan','Linus','P.O. Box 810, 6022 Lorem St.','Torchiarolo','00304-818','false',1,'07 67 48 70 85','21-12-18'),(47,'nisi.Mauris.nulla@mauris.org','Akeem','Jason','614-4073 Non Av.','Scanzano Jonico','39789','true',1,'08 77 22 08 74','07-06-89'),(48,'odio.sagittis.semper@lectusquismassa.net','Jermaine','Myles','Ap #354-9022 Aliquam Ave','Paglieta','483089','true',1,'08 48 07 51 81','04-03-87'),(49,'orci.luctus.et@faucibus.net','Anthony','Dolan','P.O. Box 770, 1680 Fringilla Street','Kingston','35140-61508','false',2,'02 70 64 10 65','14-06-85'),(50,'eleifend@acrisusMorbi.ca','Jakeem','Scott','7872 Vel Avenue','Bontang','70187','true',1,'09 31 60 08 17','10-06-69'),(51,'ut.nulla.Cras@aultricies.net','Austin','Peter','9247 Cursus. Ave','Zaltbommel','487889','true',1,'02 88 60 57 30','13-07-79'),(52,'orci.adipiscing.non@egetmassaSuspendisse.org','Laith','Clinton','1048 Erat Ave','Anzi','22417-64556','true',2,'04 73 50 25 73','16-11-12');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (53,'libero@elit.net','Ishmael','Cade','6051 Accumsan Av.','Bouge','5811','false',2,'03 06 18 56 34','21-02-03'),(54,'vitae.aliquet@eleifendCrassed.co.uk','Hector','Branden','7349 Lorem, Av.','Kasur','45085','false',2,'01 28 32 10 64','08-11-97'),(55,'orci.Ut@nonhendrerit.net','Francis','Sean','492 Ut Rd.','Delmenhorst','6888','true',1,'06 34 08 81 20','21-11-81'),(56,'Nullam.suscipit.est@congue.org','Linus','Malachi','P.O. Box 758, 5201 Leo. Road','West Valley City','30434','false',2,'02 70 38 73 91','10-05-88'),(57,'sit.amet.nulla@Crasvehiculaaliquet.net','Anthony','Rogan','P.O. Box 319, 5545 Scelerisque St.','Oromocto','10704','false',2,'01 90 10 20 62','23-07-00'),(58,'tincidunt.aliquam.arcu@consequatdolor.com','Anthony','Asher','Ap #435-5514 Lacus. Avenue','Guardia Sanframondi','Z0272','true',2,'06 52 14 83 39','26-03-74'),(59,'pharetra@Donecfelisorci.ca','Herman','Burke','8188 Lectus. Rd.','Montemignaio','910678','true',2,'09 38 83 86 51','12-11-89'),(60,'erat.Vivamus.nisi@adui.net','Griffin','Thane','Ap #663-9923 Dictum Ave','Panguipulli','47803','true',2,'07 16 08 74 96','25-12-78'),(61,'eleifend.Cras.sed@mollisnec.ca','Barclay','Cullen','468-5018 Neque. St.','Wevelgem','520816','true',2,'02 34 82 19 27','07-11-15'),(62,'Aliquam@arcuimperdiet.org','Ishmael','Ira','7832 Etiam Avenue','Fort St. John','76-388','true',1,'01 97 35 41 99','17-10-85');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (63,'facilisis@sedhendrerita.com','Charles','Nathan','634-7025 Ultrices Av.','Geesthacht','70484','true',2,'03 77 83 94 76','22-10-90'),(64,'leo.Morbi.neque@placeratCras.com','Vaughan','Dalton','1923 Quisque Ave','Bromley','665597','true',1,'01 92 32 15 27','12-03-85'),(65,'risus@tinciduntaliquamarcu.edu','Fitzgerald','Stuart','4041 A St.','Erode','80203','true',2,'01 60 74 65 46','18-07-20'),(66,'Nulla.interdum@atpedeCras.co.uk','Hall','Zeph','884-5612 Tortor. Ave','Bonnyville','25530','false',2,'08 90 31 40 21','20-01-18'),(67,'ullamcorper@Vivamusnonlorem.org','Graham','Yasir','Ap #753-6653 Vestibulum Road','Milazzo','35550','false',1,'07 60 42 96 44','28-07-99'),(68,'a.enim.Suspendisse@maurissit.net','Leonard','Brady','Ap #197-9033 Arcu. Av.','Port Moody','4425','false',2,'03 54 78 70 20','04-02-55'),(69,'risus.Quisque.libero@amet.ca','Melvin','Lewis','P.O. Box 335, 8314 Maecenas St.','Leernes','21778-095','false',2,'08 84 78 87 16','02-07-77'),(70,'ac.sem.ut@Duisat.com','Flynn','Xander','742-7310 Cras Rd.','Kacchi','04422-87038','true',1,'06 53 35 52 88','24-02-85'),(71,'elementum@molestietellus.ca','Holmes','Emery','P.O. Box 697, 4866 Dapibus Avenue','Diets-Heur','82-246','false',2,'02 41 77 03 63','13-05-96'),(72,'odio.Nam@semperNam.edu','Emerson','Jerome','686 Nec, Ave','Vico nel Lazio','23145','true',1,'03 81 88 08 59','11-11-85');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (73,'massa.rutrum@enimgravida.edu','Darius','Brennan','Ap #409-3950 Semper Rd.','Central Jakarta','96598','false',2,'03 68 36 07 85','11-09-09'),(74,'magnis.dis@necorci.ca','Geoffrey','Nigel','Ap #970-2842 Luctus Road','Lang','933116','true',1,'03 98 89 39 23','13-09-68'),(75,'dictum.augue@augueeutellus.edu','Michael','Harlan','P.O. Box 659, 1587 Facilisis Avenue','Otranto','2884','false',1,'02 78 02 98 19','27-02-93'),(76,'In.at.pede@Pellentesque.ca','Daquan','Maxwell','Ap #844-1868 A Avenue','Kirriemuir','572306','false',2,'08 32 69 53 90','12-10-19'),(77,'Suspendisse.non@enim.net','Keith','Allistair','6664 Eu, Ave','Leamington','99583','false',2,'05 55 33 94 14','08-11-14'),(78,'vel.lectus@ridiculus.edu','Barry','Sebastian','2746 Quis St.','Wijshagen','21611-73517','false',1,'03 78 23 54 26','12-06-94'),(79,'dictum.magna.Ut@vitaenibhDonec.ca','Richard','Merritt','P.O. Box 930, 1869 Nulla Street','Panchià','08299-419','false',2,'01 57 09 47 75','23-07-11'),(80,'magna@libero.com','Yoshio','Gannon','605-5828 Fusce St.','Maple Creek','89576','true',2,'02 13 20 78 67','20-03-15'),(81,'Morbi.sit.amet@id.net','Ciaran','Howard','P.O. Box 516, 8917 Sem Avenue','Cobourg','B3E 4NE','false',1,'04 37 59 19 40','31-07-54'),(82,'sed@nonummy.co.uk','Kenyon','Arsenio','Ap #646-1306 Semper Rd.','Metro','6486 ZA','true',1,'04 75 18 91 64','07-09-94');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (83,'Curabitur@nascetur.net','Linus','Walter','P.O. Box 501, 627 Erat Road','Kupang','3917','false',2,'07 40 45 86 93','08-12-99'),(84,'neque@quisturpisvitae.edu','Thane','Lewis','557-310 Facilisi. Avenue','Haddington','303552','true',2,'09 80 53 42 42','28-01-21'),(85,'velit@ullamcorper.edu','Ivan','Darius','P.O. Box 628, 5457 Duis Av.','Camborne','3214','true',2,'03 90 59 97 51','08-04-63'),(86,'et.tristique@Duis.co.uk','Gabriel','Ryder','8100 Quis Avenue','Köthen','4456 AE','true',2,'09 58 24 11 54','14-08-75'),(87,'mauris@ametrisus.co.uk','Ciaran','Hakeem','2262 Tempor Street','Melsele','522853','false',1,'02 96 56 55 04','18-06-98'),(88,'ipsum@eu.net','Jermaine','Jasper','P.O. Box 433, 585 Odio, Road','Lumaco','7916','true',1,'05 45 33 42 28','13-04-81'),(89,'vitae.sodales.nisi@semegestasblandit.net','Tucker','Preston','220-8503 Aliquam Rd.','Saint-Georges','9206','false',1,'05 93 71 22 84','18-11-80'),(90,'montes.nascetur.ridiculus@Integer.edu','Avram','Branden','P.O. Box 825, 9429 Magna. Rd.','Llanquihue','40828','true',2,'05 03 65 47 56','04-12-08'),(91,'purus.in@DuisgravidaPraesent.com','Michael','Vincent','935-3522 Ac Avenue','Marcedusa','G8L 2H0','false',1,'07 08 23 10 92','10-05-98'),(92,'quis@Quisqueornare.co.uk','Hamilton','Lawrence','7151 Arcu. Ave','Vieuxville','14211','true',1,'08 70 81 93 02','28-05-69');
INSERT INTO "participant" (idparticipant,email,nom,prenom,adresse,ville,codePostale,reglement,repas,telephone,birthdate) VALUES (93,'sem.magna@gravidanon.ca','Jerome','Chase','Ap #198-8531 Eros Av.','Caldera','21-555','false',2,'06 97 80 68 16','02-02-79'),(94,'bibendum.fermentum@dui.net','Charles','Donovan','Ap #898-853 Nullam St.','Burnie','36074-12319','false',1,'09 18 41 53 39','31-03-12'),(95,'mauris.erat.eget@Donec.com','Gary','Zane','1141 Malesuada Ave','Denpasar','995482','false',1,'07 25 44 26 29','09-09-86'),(96,'magna@facilisisfacilisis.co.uk','Lawrence','Keegan','7422 Lectus Ave','Betim','28711-933','false',1,'02 23 67 67 55','24-05-75'),(97,'sodales.at.velit@nisi.ca','Cedric','Cody','3194 Suspendisse Av.','Puerto Vallarta','05211','true',2,'01 01 99 63 47','03-06-19'),(98,'velit.Quisque@Quisquevarius.org','Hamish','Omar','589-7702 Eu, Rd.','San Fabián','68640','true',1,'08 45 65 71 04','24-02-67'),(99,'cursus@laoreetlibero.com','Thomas','Dieter','9453 Duis Rd.','Margate','637615','true',1,'08 36 06 97 85','11-02-75'),(100,'Cum.sociis@maurisrhoncusid.ca','Mason','Aquila','6286 Purus. Rd.','Ottawa-Carleton','K3R 9T0','false',1,'02 84 13 52 67','20-12-11'),(101,'primis.in.faucibus@purusinmolestie.ca','Tyler','Jamal','P.O. Box 641, 3433 Donec Road','Flamierge','75575','false',2,'03 56 58 91 37','18-05-72'),(102,'risus.Morbi@arcuVivamus.com','Adrian','Hedley','Ap #321-3600 Amet, Street','Marburg','545398','true',2,'08 89 37 21 31','17-03-70');


ALTER TABLE participant ALTER COLUMN idparticipant RESTART WITH 91;

-- Insertion des participants dans l'équipe
UPDATE equipe SET idchef = 3, idcoequipier = 4 WHERE idequipe =  1;

-- Poste

INSERT INTO poste (idposte, nom, lieu, fonction ) VALUES
  ( 1, 'Poste n°1', 'Buvette', 'Descriptif 1' ),
  ( 2, 'Poste n°2', 'Parking', 'Descriptif 2' ),
  ( 3, 'Poste n°3', 'Arrivée', 'Descriptif 3');

ALTER TABLE poste ALTER COLUMN idposte RESTART WITH 4;

-- Benevole

INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (1,2,'justo.eu.arcu@netusetmalesuada.co.uk','Aquila','Vincent','1871 Neque Av.','Pocheon','887677','06 30 74 59 73','22-04-21','true','888431459-00005','false'),(2,1,'vulputate.posuere.vulputate@erategetipsum.com','Damian','Daquan','P.O. Box 394, 494 Odio. St.','Fontenoille','15037','01 95 53 40 23','06-01-61','false','894424498-00000','false'),(3,2,'et@nonarcuVivamus.net','Xavier','Zeus','Ap 653-5654 Amet Ave','Joué-lès-Tours','48548','02 32 68 50 16','05-01-66','false','687545665-00006','true'),(4,2,'enim.sit.amet@tortor.com','Burton','Silas','7383 Pede Rd.','Pierrefonds','129313','07 31 09 12 30','11-10-85','false','823034947-00007','true'),(5,3,'dui.in@auctor.com','Zachary','Judah','P.O. Box 125, 4876 Luctus Rd.','Aalbeke','64937','02 19 98 73 22','12-12-71','true','731204996-00003','false'),(6,1,'enim.condimentum@ridiculusmusProin.edu','Coby','Brendan','Ap #965-7432 Neque Av.','Duque de Caxias','565945','05 09 40 30 86','02-03-93','true','284273430-00009','false'),(7,3,'dictum@ullamcorpereu.ca','Aaron','Damian','P.O. Box 680, 5239 Quis, St.','March','90218','09 30 65 00 43','01-02-68','true','477526362-00009','true'),(8,1,'dis@magna.ca','Dalton','Xenos','P.O. Box 537, 9063 Lobortis. Street','Puerto Vallarta','36385','01 41 77 91 38','21-10-56','true','013010707-00001','false'),(9,1,'velit.Cras@volutpat.com','Barrett','Ulysses','650 Lacus. Rd.','San Antonio','43357-360','05 58 48 32 13','27-09-62','true','486984446-00006','false'),(10,3,'ultrices.Duis@Sed.ca','Nicholas','Tobias','Ap #883-731 Vestibulum Street','Sperlinga','699832','07 46 41 73 69','12-05-79','false','388149809-00005','false');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (11,3,'libero.Proin@eratvitae.org','Ian','Thomas','966-3016 Id Street','Troon','2290 VB','09 75 14 92 67','17-11-91','false','201568565-00000','false'),(12,2,'a@tellus.net','Cooper','Emery','Ap #896-5916 Felis. Road','Castle Douglas','290870','06 94 48 55 14','06-01-61','false','543227920-00005','true'),(13,3,'dictum@euismodenim.com','Gregory','Ahmed','P.O. Box 731, 413 Vestibulum Avenue','Thurso','60642','03 69 42 10 39','23-02-20','false','212333371-00004','true'),(14,1,'accumsan.interdum.libero@diamluctus.com','Lane','Chancellor','562-7336 Nisi. St.','Meeswijk','78816','01 38 79 88 29','11-02-09','true','779983469-00007','false'),(15,1,'ut.pellentesque.eget@eleifendvitaeerat.ca','Levi','Andrew','2177 Semper St.','Lacombe','72264','05 57 31 19 88','15-03-80','false','302202593-00000','true'),(16,1,'semper@Phasellus.co.uk','Simon','Michael','223-1851 Vel, St.','Ligney','3622','06 49 95 11 47','24-09-06','false','651302432-00000','false'),(17,2,'Aliquam.rutrum@vehiculaetrutrum.edu','Duncan','Baker','764-4697 Pede, Avenue','Maple Ridge','383319','02 75 09 17 21','02-09-78','true','301050167-00008','true'),(18,2,'amet.consectetuer.adipiscing@egestas.ca','Graham','Ray','Ap #408-9722 Euismod Av.','Lac Ste. Anne','331945','08 04 91 46 33','15-07-71','true','194041950-00008','true'),(19,3,'libero.mauris.aliquam@sociisnatoquepenatibus.co.uk','Gil','Ulric','9622 Sit Avenue','Lehri','12367','01 60 13 75 31','24-07-85','true','705409688-00003','true'),(20,3,'sollicitudin.commodo@fringillaest.edu','Addison','Aaron','3396 Nec St.','Ancaster Town','02541','02 52 96 93 12','06-06-76','true','565624905-00008','false');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (21,1,'venenatis.lacus@ipsumprimis.ca','Luke','Felix','Ap #698-6008 Nunc Avenue','Piedecuesta','01340','06 20 89 03 56','25-08-14','true','136688991-00001','true'),(22,3,'Fusce@arcuvelquam.org','Herrod','Armando','4946 Et Rd.','Sandy','41634','06 52 39 51 29','02-12-04','true','305421430-00003','true'),(23,3,'ac.feugiat.non@odio.co.uk','Guy','Carlos','8480 Quis Av.','Fredericton','229230','02 88 50 58 70','19-02-05','true','230290629-00008','false'),(24,1,'accumsan.sed.facilisis@molestie.edu','Magee','Holmes','849-9688 Pede, Avenue','Llangollen','JI8 9VG','04 95 15 82 81','10-01-56','true','145057238-00001','true'),(25,1,'Proin.non.massa@augue.com','Kermit','Hasad','P.O. Box 114, 2113 Maecenas Rd.','Thionville','8210','02 21 63 20 44','18-06-54','true','137162434-00005','false'),(26,2,'eu.lacus.Quisque@Nunc.ca','Lee','Herman','2488 Feugiat Rd.','Bressoux','83-550','06 39 68 94 27','30-08-06','true','400536611-00009','false'),(27,1,'semper@adipiscinglacus.ca','Steven','Jordan','Ap #935-2064 Erat Road','Telfs','775024','07 51 34 84 32','17-06-57','false','594109886-00004','true'),(28,3,'egestas@Duismienim.org','Amery','Edan','1828 Fusce Av.','Maidenhead','43485','02 32 21 32 17','02-05-98','false','453120602-00009','false'),(29,3,'congue@in.ca','Ian','Gregory','9941 Ac Ave','Ahmedabad','314103','09 53 48 75 77','29-11-62','false','203390380-00004','true'),(30,2,'neque@dui.org','Branden','Giacomo','P.O. Box 617, 313 Amet Av.','Sacheon','11-950','06 87 22 51 08','10-10-67','false','136389491-00004','true');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (31,1,'semper.rutrum@non.net','Stewart','Porter','P.O. Box 382, 2672 Ante Rd.','Lamont','2134','04 38 99 34 95','18-10-09','false','712693761-00009','true'),(32,3,'nulla.at@Nulladignissim.net','Craig','Jamal','P.O. Box 100, 530 Elit, St.','Colledimacine','RK3 5BL','09 35 47 67 53','25-08-14','true','835029752-00002','true'),(33,3,'posuere.at.velit@sagittislobortismauris.edu','Colorado','Dalton','Ap #780-821 Nullam St.','Pincher Creek','441699','05 12 45 61 96','12-09-60','false','230239337-00002','false'),(34,3,'Morbi.vehicula@congue.ca','Jin','Amery','Ap #558-2826 Non, Avenue','Gougnies','Z9765','01 46 21 01 75','21-03-82','true','309725323-00005','true'),(35,2,'eu.eros.Nam@musDonec.co.uk','Ulysses','Rafael','Ap #864-4146 Auctor St.','A Coruña','83044','06 01 58 17 25','14-11-64','true','495052664-00002','false'),(36,1,'erat.nonummy.ultricies@erosProin.com','Porter','Nero','8388 Pellentesque Rd.','Maryborough','135124','03 12 90 73 57','10-05-98','true','485207096-00002','true'),(37,1,'nec@mi.co.uk','Mason','Uriah','P.O. Box 275, 6826 Et St.','Glastonbury','03122','02 11 13 36 51','30-05-57','false','737021667-00008','true'),(38,1,'non@faucibus.org','Griffin','Emerson','356-2716 Integer Av.','Göppingen','G0Y 0B2','02 05 55 50 30','23-11-89','false','759176027-00002','false'),(39,3,'felis.Donec@Nullam.org','Kato','Kareem','6762 Aenean Rd.','Goiânia','15595-642','09 14 81 10 93','13-10-98','false','808648000-00004','false'),(40,2,'sed.facilisis.vitae@magnaetipsum.ca','Tyler','Troy','313-4844 Ligula. St.','Allappuzha','391284','07 70 51 49 20','07-03-57','false','798054847-00008','true');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (41,1,'nisi.dictum@euenimEtiam.ca','Zeus','Hammett','P.O. Box 687, 5646 Elementum Ave','Achalpur','7374 SA','01 51 32 98 51','22-06-88','true','155462591-00001','false'),(42,1,'eleifend.vitae@acurna.com','Noah','Hall','146 Pede. Avenue','San Martino in Pensilis','74657','06 76 02 30 13','11-09-91','false','447298365-00001','false'),(43,3,'aliquet.Phasellus.fermentum@sedliberoProin.com','Ian','Keefe','P.O. Box 168, 7090 Dolor Rd.','San Luis Potosí','77-702','08 13 77 24 02','18-05-92','false','206799769-00008','true'),(44,2,'eu.eleifend@necluctusfelis.ca','Hamilton','Peter','768 Phasellus Ave','Rajapalaiyam','382614','06 08 46 55 63','03-09-14','false','045104122-00002','false'),(45,3,'tempor.est@milaciniamattis.org','Reece','Zephania','872-616 Proin Av.','Oberursel','1578','04 71 23 01 80','28-12-88','true','928671809-00004','false'),(46,1,'mauris@malesuada.edu','Harper','Wylie','P.O. Box 483, 8696 Eu Rd.','San Maurizio Canavese','79853-090','04 03 79 02 06','03-11-15','true','591373477-00007','true'),(47,1,'vulputate@ultrices.net','Rajah','Xander','587-161 Ante St.','Ravenstein','1049','09 11 71 98 88','05-05-82','false','511418154-00007','true'),(48,2,'vestibulum.nec@eteuismodet.org','Griffith','Sylvester','4935 In Avenue','Kharabali','82987','08 44 57 58 28','08-12-62','false','628549776-00001','false'),(49,1,'sed.consequat@hendrerit.ca','Acton','Boris','P.O. Box 717, 6508 Convallis, Road','Anzio','176992','05 64 09 92 50','07-11-06','false','966641391-00000','true'),(50,2,'eleifend.nunc@Duismienim.edu','Palmer','Caesar','Ap #834-4385 Facilisis Avenue','Ulm','51410','03 65 64 88 74','15-09-95','true','981103997-00004','true');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (51,3,'vitae.purus@atvelitPellentesque.co.uk','Daquan','Colton','3767 Sit Rd.','Hallaar','813195','05 46 69 04 86','29-07-78','true','458551231-00004','true'),(52,2,'ornare.lectus@consequat.edu','Fritz','Aaron','606-8823 Non St.','Saint-Prime','513330','07 18 98 60 74','06-03-63','false','508332897-00000','true'),(53,3,'Maecenas.libero@Aliquamerat.com','Edward','Evan','Ap #182-3659 Nisl Rd.','Buren','99796','03 06 96 03 66','05-04-13','true','170439889-00008','false'),(54,2,'a@utodiovel.net','Logan','Devin','886-8874 Ultrices Av.','Lipetsk','56304-05893','01 39 94 62 85','03-10-13','true','623246329-00006','false'),(55,2,'nunc.In.at@inceptoshymenaeos.edu','Grady','Hamish','4273 Magna. St.','Moignelee','71-801','02 90 60 84 82','01-09-75','false','134708072-00001','true'),(56,3,'parturient.montes@facilisis.net','Dalton','Macaulay','8398 Lorem. Road','Retford','57-831','07 85 01 62 32','10-11-81','true','065901498-00009','true'),(57,2,'Cras.pellentesque@afelis.org','Benjamin','Keith','113-1599 Imperdiet St.','Borghetto di Vara','70417','03 73 88 04 71','06-04-81','false','435126271-00004','true'),(58,3,'volutpat@metus.co.uk','Brandon','Rogan','Ap #824-5393 Sapien Street','Cessnock','X5Z 6Y1','04 10 63 10 33','07-08-05','false','600397418-00002','false'),(59,3,'ridiculus.mus@quisurnaNunc.co.uk','Dalton','Thomas','811 Et St.','Terlago','47013','07 10 05 72 47','15-09-91','false','583410592-00005','true'),(60,1,'Nunc.ac.sem@Quisquelibero.net','Amery','Felix','P.O. Box 980, 2559 Eu Avenue','Booischot','H0R 7R6','08 00 32 06 92','27-11-03','false','800454217-00004','false');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (61,2,'non.leo.Vivamus@dolor.net','Brian','Hayes','7817 Vivamus Road','Kursk','312871','05 86 93 92 02','25-09-89','false','123378523-00005','false'),(62,3,'et@nuncQuisqueornare.ca','Yuli','Garrett','P.O. Box 484, 4805 Ullamcorper. Ave','Montignoso','1588','01 51 96 01 25','08-02-87','true','677915431-00006','true'),(63,3,'Nam.porttitor.scelerisque@estmollis.ca','Kennedy','Gregory','Ap #117-4314 Penatibus Road','Lerwick','20233-345','03 21 63 03 51','06-11-80','true','437448137-00004','true'),(64,1,'convallis@imperdiet.ca','Colt','Malik','Ap #151-3683 Lorem, Av.','PiŽtrain','C7N 8M9','05 38 86 29 99','11-06-10','true','691464069-00000','false'),(65,1,'pharetra.ut.pharetra@nec.net','Alec','Joseph','P.O. Box 475, 7828 Ligula. Street','Naushahro Firoze','Z5208','03 71 85 46 69','18-04-07','false','058054305-00006','false'),(66,1,'semper@sagittisplaceratCras.co.uk','Magee','Kieran','6665 In Av.','Bokaro Steel City','9721','04 80 12 53 54','05-09-92','false','926752445-00003','false'),(67,1,'amet.lorem@In.org','Cullen','Tyler','2210 Ac, Ave','Wolfsberg','844924','07 61 08 32 94','02-11-00','true','173057316-00007','true'),(68,3,'sollicitudin.orci.sem@quistristiqueac.edu','Erasmus','Tanek','P.O. Box 306, 3981 Cras Rd.','Celle','W88 6ER','08 18 66 94 14','12-12-92','false','403815889-00007','false'),(69,1,'Curae.Donec@elementumduiquis.edu','Todd','Kato','3553 Elit Ave','Moerkerke','43355','04 04 34 52 64','28-08-60','false','533744827-00007','true'),(70,3,'ac.mattis@ligulaeuenim.com','Tad','Brandon','Ap #666-8885 Molestie Ave','Argyle','CU5L 5TL','06 92 78 45 95','04-02-83','false','960506590-00004','true');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (71,3,'gravida@consectetuer.co.uk','Oscar','Marshall','Ap #307-781 Aliquet, St.','La Baie','3987','03 38 23 38 16','12-05-61','true','437957772-00001','false'),(72,2,'Duis@Vivamus.edu','Yoshio','Kasper','Ap #906-6307 Rutrum, Rd.','Kooigem','B4Y 9X7','07 43 21 90 98','16-02-92','true','562668186-00009','false'),(73,2,'nonummy.ultricies@lectusantedictum.com','Lionel','Lionel','P.O. Box 130, 3126 Donec Avenue','Acoz','9687','04 37 31 86 21','04-09-88','true','551086655-00000','false'),(74,2,'Pellentesque.ultricies.dignissim@necmollis.edu','Davis','Lucius','P.O. Box 687, 9413 Fringilla St.','Dera Ghazi Khan','M6B 0Y1','07 26 90 92 45','10-07-68','false','422152983-00009','true'),(75,3,'est@porttitortellus.edu','Stone','Colorado','610-9164 Purus Av.','Cannole','22721','08 13 65 24 53','10-07-07','false','705815199-00009','false'),(76,3,'dui.lectus.rutrum@consectetuercursus.co.uk','Brody','Tate','3647 Dignissim. Rd.','Melsele','83745','07 92 49 15 52','06-02-11','false','921541777-00006','true'),(77,3,'diam.nunc.ullamcorper@eu.org','Tyler','Noah','Ap #964-6841 Ipsum. St.','Bhind','672071','05 52 44 42 00','20-09-62','true','011802188-00000','true'),(78,2,'vitae@nullaCras.org','Gareth','Xander','P.O. Box 794, 3487 Tincidunt Rd.','Paal','27127','03 02 88 09 83','08-08-77','true','555454685-00002','false'),(79,1,'vestibulum@malesuada.co.uk','Cody','Eagan','Ap #490-6563 Dignissim. St.','Marabá','9734','01 83 68 41 43','25-01-19','true','135311900-00009','false'),(80,1,'nunc.ac.mattis@accumsan.co.uk','Allistair','Samuel','Ap #974-7539 Dapibus Street','Olympia','62145','07 91 70 19 34','21-12-06','false','075670000-00001','true');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (81,3,'et.arcu@placerataugueSed.net','Lane','Tyler','4427 Arcu. Rd.','Salt Spring Island','236338','07 52 46 09 59','10-10-11','false','213560378-00001','false'),(82,3,'enim.sit.amet@ut.com','Lamar','Wylie','532-4345 Eu St.','Pettoranello del Molise','62852','07 69 43 08 21','10-08-02','false','490588381-00007','true'),(83,3,'Integer@lobortisaugue.com','Maxwell','Garth','Ap #100-1577 Cras Street','Queenstown','3398','01 50 97 66 01','04-05-13','false','899832570-00001','false'),(84,2,'ipsum@acturpisegestas.ca','Logan','Flynn','P.O. Box 832, 7359 Nec, Ave','Naushahro Firoze','600497','08 92 20 34 23','12-09-61','false','221260631-00009','false'),(85,2,'tempus.mauris@dictumProin.net','Lyle','Rashad','3685 Nec Road','Ahmadpur East','496781','01 25 31 61 72','19-02-92','false','900045139-00004','true'),(86,3,'nec@acfacilisis.com','Noble','Raja','898-9889 Lacus. Avenue','Kasur','50683','03 71 58 47 79','25-03-79','false','505822643-00001','false'),(87,2,'metus@elementumategestas.edu','Victor','Chancellor','4249 Curabitur Rd.','Wansin','0791','07 48 55 83 74','07-01-80','true','812006021-00008','true'),(88,3,'aliquet.magna.a@tortor.co.uk','Price','Dane','Ap #361-6078 Malesuada Ave','Viersel','19950','06 28 62 85 84','20-12-20','false','153962543-00002','false'),(89,3,'est@velest.com','Slade','Edward','P.O. Box 216, 1495 Diam. St.','St. Albert','40825','07 62 66 48 17','22-10-81','false','663317881-00006','false'),(90,2,'et.tristique@volutpat.org','Hyatt','Graham','9563 Diam. Road','Tarvisio','4217','03 68 73 61 66','22-04-07','true','534203484-00009','false');
INSERT INTO "benevole" (idbenevole,idposte,email,nom,prenom,adresse,ville,codePostale,telephone,birthdate,permis,plaqueImma,brevetSecourisme) VALUES (91,3,'Mauris.quis.turpis@MorbivehiculaPellentesque.ca','Ethan','Alden','P.O. Box 714, 3123 Sed Street','Oaxaca','26651','06 41 77 84 58','25-10-82','false','453671083-00005','true'),(92,2,'nec.urna.et@elementumat.edu','Dillon','Burton','Ap #129-1117 Sociis Rd.','Río Bueno','71806-952','09 55 54 23 28','24-12-64','true','925844680-00007','true'),(93,3,'gravida.nunc.sed@mauris.ca','Finn','Steel','953-6882 Magnis Street','Hartford','1208','05 30 21 58 29','15-07-19','true','100222025-00007','true'),(94,1,'Quisque.ornare.tortor@euodioPhasellus.com','Jesse','Lyle','4030 Ipsum St.','Charny','51607','06 01 78 18 21','23-01-17','false','116129396-00002','false'),(95,2,'ipsum@nonluctussit.net','Tyler','Connor','576-6947 Massa. Av.','Nonsan','Z5216','09 07 02 72 96','29-09-82','true','930662903-00002','true'),(96,1,'consequat.lectus@nonenim.ca','Abbot','Nicholas','Ap #601-3385 Ridiculus Avenue','Flint','0959 JV','08 33 14 01 16','27-10-64','true','269206686-00009','false'),(97,2,'Donec.dignissim.magna@lectus.org','Magee','Isaiah','P.O. Box 696, 7411 Netus Ave','Cartago','19139','04 11 64 35 08','31-07-54','true','181206293-00001','true'),(98,1,'sit@nisidictumaugue.co.uk','Coby','Alan','Ap #214-2720 Eleifend Avenue','St. Ives','62997','04 79 13 70 18','31-01-86','true','273144725-00002','false'),(99,1,'ac.metus@posuereenim.edu','Kareem','Vaughan','P.O. Box 504, 2427 Varius St.','Fiumara','479240','02 32 99 82 21','02-11-85','true','046974044-00003','true'),(100,3,'consequat.lectus.sit@Naminterdumenim.co.uk','Sean','Hop','Ap #438-9488 Aliquam Av.','Maastricht','21713','06 43 20 47 32','11-10-88','false','888733896-00003','false');


ALTER TABLE benevole ALTER COLUMN idbenevole RESTART WITH 101;


-- -- Media

-- INSERT INTO media ( idmedia, media_path ) VALUES


-- ALTER TABLE service ALTER COLUMN idservice RESTART WITH 5;
