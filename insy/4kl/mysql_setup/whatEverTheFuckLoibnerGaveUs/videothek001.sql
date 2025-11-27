DROP DATABASE IF EXISTS videothek;

CREATE DATABASE IF NOT EXISTS videothek
	CHARACTER SET = 'utf8'
	COLLATE 'utf8_german2_ci';

USE videothek;

-- Tabelle medientyp
CREATE TABLE IF NOT EXISTS medientyp(
mtid SMALLINT UNSIGNED NOT NULL ,
typ CHAR(8) NOT NULL,
CONSTRAINT PRIMARY KEY(mtid)
);

-- Tabelle regie
CREATE TABLE IF NOT EXISTS regie(
rid SMALLINT UNSIGNED NOT NULL ,
vorname VARCHAR(30) NOT NULL,
nachname VARCHAR(30) NOT NULL,
bio VARCHAR(200),
gebdat DATE,
CONSTRAINT PRIMARY KEY(rid)
);

-- Tabelle filme
CREATE TABLE IF NOT EXISTS filme(
fid SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
titel VARCHAR(30) NOT NULL,
land CHAR(2) NOT NULL,
beschr VARCHAR(100),
jahr DATE,
sprache CHAR(2),
rid SMALLINT UNSIGNED NOT NULL,
CONSTRAINT PRIMARY KEY(fid),
CONSTRAINT FOREIGN KEY(rid) REFERENCES regie(rid)
ON DELETE NO ACTION
ON UPDATE CASCADE
);

-- Tabelle medien
CREATE TABLE IF NOT EXISTS medien(
mid SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
fid SMALLINT UNSIGNED NOT NULL,
mtyp SMALLINT UNSIGNED NOT NULL,
CONSTRAINT PRIMARY KEY(mid),
CONSTRAINT FOREIGN KEY(fid) REFERENCES filme(fid)
ON DELETE NO ACTION
ON UPDATE CASCADE,
CONSTRAINT FOREIGN KEY(mtyp) REFERENCES medientyp(mtid)
ON DELETE NO ACTION
ON UPDATE CASCADE
);

-- Tabelle Tarife
CREATE TABLE IF NOT EXISTS tarife(
tnr TINYINT UNSIGNED NOT NULL,
kdtyp CHAR(6) NOT NULL,
entleihe DECIMAL(5,2) NOT NULL,
ueberziehung DECIMAL(5,2) NOT NULL,
mitglied DECIMAL(5,2) NOT NULL,
CONSTRAINT PRIMARY KEY(tnr)
);

-- Tabelle kunde
CREATE TABLE IF NOT EXISTS kunde(
kdnr SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
vorname VARCHAR(30) NOT NULL,
nachname VARCHAR(30) NOT NULL,
strasse VARCHAR(30) NOT NULL,
hausnr VARCHAR(6) NOT NULL,
plz CHAR(4) NOT NULL,
ort VARCHAR(30) NOT NULL,
tel VARCHAR(20),
email VARCHAR(30) NOT NULL,
gebdat DATE NOT NULL,
typ TINYINT UNSIGNED NOT NULL,
CONSTRAINT FOREIGN KEY(typ) REFERENCES tarife(tnr)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT PRIMARY KEY(kdnr)
);

-- Tabelle ausleihe
CREATE TABLE IF NOT EXISTS ausleihe(
anr SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT,
ausdat DATE NOT NULL,
rueckdat DATE NOT NULL,
CONSTRAINT aus_date CHECK (rueckdat >= ausdat),
kdnr SMALLINT UNSIGNED NOT NULL,
mid SMALLINT UNSIGNED NOT NULL,
status CHAR(1) NOT NULL,
CONSTRAINT aus_status CHECK (status = 'e' OR status = 'ü'),
CONSTRAINT PRIMARY KEY(anr),
CONSTRAINT FOREIGN KEY(kdnr) REFERENCES kunde(kdnr)
ON DELETE NO ACTION
ON UPDATE CASCADE,
CONSTRAINT FOREIGN KEY(mid) REFERENCES medien(mid)
ON DELETE NO ACTION
ON UPDATE CASCADE
);

INSERT INTO medientyp VALUES (1, 'VHS');
INSERT INTO medientyp VALUES (2, 'DVD');
INSERT INTO medientyp VALUES (3, 'BLURAY');
INSERT INTO medientyp VALUES (4, 'STREAM');

INSERT INTO tarife VALUES (1, 'normal', 2.5, 3.5, 99.9);
INSERT INTO tarife VALUES (2, 'stammk', 1.5, 2.5, 79.9);
INSERT INTO tarife VALUES (3, 'super', 1.0, 2.0, 59.9);

INSERT INTO regie (rid, vorname, nachname) VALUES (1, 'Quentin', 'Tarantino');
INSERT INTO regie (rid, vorname, nachname) VALUES (2, 'John', 'Ford');
INSERT INTO regie (rid, vorname, nachname) VALUES (3, 'Michelangelo', 'Antonioni');
INSERT INTO regie (rid, vorname, nachname) VALUES (4, 'George', 'Lucas');
INSERT INTO regie (rid, vorname, nachname) VALUES (5, 'Jean Luc', 'Goddard');
INSERT INTO regie (rid, vorname, nachname) VALUES (6, 'Martin', 'Scorsese');
INSERT INTO regie (rid, vorname, nachname) VALUES (7, 'Stanley', 'Kubrick');

INSERT INTO filme (fid, titel, land, rid) VALUES (10001, 'Pulp Fiction', 'us', 1);
INSERT INTO filme (fid, titel, land, rid) VALUES (10002, 'Rio Grande', 'us', 2);
INSERT INTO filme (fid, titel, land, rid) VALUES (10003, 'Blow Up', 'gb', 3);
INSERT INTO filme (fid, titel, land, rid) VALUES (10004, 'Star Wars IV', 'us', 4);
INSERT INTO filme (fid, titel, land, rid) VALUES (10005, 'Star Wars V', 'us', 4);
INSERT INTO filme (fid, titel, land, rid) VALUES (10006, 'Star Wars VI', 'us', 4);
INSERT INTO filme (fid, titel, land, rid) VALUES (10007, 'Django Unchained', 'us', 1);
INSERT INTO filme (fid, titel, land, rid) VALUES (10008, 'Zabriskie Point', 'us', 3);
INSERT INTO filme (fid, titel, land, rid) VALUES (10009, 'Laventura', 'it', 3);
INSERT INTO filme (fid, titel, land, rid) VALUES (10010, 'The Passenger', 'us', 3);
INSERT INTO filme (fid, titel, land, rid) VALUES (10011, 'Weekend', 'fr', 5);
INSERT INTO filme (fid, titel, land, jahr, rid) VALUES (10012, 'Taxi Driver', 'us', '1977-01-01', 6);
INSERT INTO filme (fid, titel, land, jahr, rid) VALUES (10013, '2001 A - space Odyssey', 'gb', '1968-01-01', 7);

INSERT INTO medien (mid, fid, mtyp) VALUES (1, '10001', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (2, '10002', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (3, '10001', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (4, '10003', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (5, '10004', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (6, '10004', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (7, '10005', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (8, '10005', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (9, '10005', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (10, '10006', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (11, '10006', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (12, '10006', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (13, '10007', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (14, '10007', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (15, '10007', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (16, '10008', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (17, '10008', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (18, '10008', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (19, '10009', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (20, '10009', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (21, '10009', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (22, '10010', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (23, '10010', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (24, '10010', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (25, '10011', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (26, '10011', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (27, '10012', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (28, '10012', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (29, '10012', 2);
INSERT INTO medien (mid, fid, mtyp) VALUES (30, '10013', 1);
INSERT INTO medien (mid, fid, mtyp) VALUES (31, '10013', 3);
INSERT INTO medien (mid, fid, mtyp) VALUES (32, '10013', 2);

INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (1, 'Hans', 'Hüber', 'Donaustadtstrasse', '45', '1220', 'Wien', '0664-123456', 'hans@huber.at', '1985-10-20', 1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (2, 'Josef', 'Bauer', 'Gartenweg', '1', '1230', 'Wien', '0650-123456', 'josef@bauer.at', '1977-11-11', 1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (3, 'Fritz', 'Maier', 'Hauptstraße', '1', '1200', 'Wien', '0699-1234567', 'fritz@maier.at', '1970-09-20', 2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (4, 'Friedrich', 'Hinterhuber', 'Ottakringer Straße', '100', '1160', 'Wien', '01456789', 'fhh@gmx.at', '1978-11-01', 1);

INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (5,'Almute','Vollmar','Claudiusstraße','100','1220','Wien','','almute.vollmar@quickmail.none','2003-11-26',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (6,'Simon','Pflug','Hegebrockstraße','181','1230','Wien','05071/44138573','simon.pflug@domain.none','2002-01-04',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (7,'Henri','Bethmann','Weg am Berge','185','1200','Wien','07471/69854638','henri.bethmann@spam-mail.none','2003-11-16',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (8,'Sidonius','Ferreira','Stockberg','59','1230','Wien','07624/89273084','sidonius-ferreira@domain.none','2004-09-10',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (9,'Evalinde','Schuppe','Am Strauk','81','1220','Wien','02243/19597830','e-19@web.none','2004-07-19','2');
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (10,'Annegold','Schwaab','Flensburger Straße','145','1220','Wien','04625/11588090','annegold-schwaab@private.none','2002-10-24',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (11,'Christine','Drake','Horenfeld','38c','1220','Wien','0221/75673904','cdrake@ultramail.none','2005-09-04',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (12,'Ludger','Cole','Schwerinstraße','154 a','1220','Wien','02662/3983997','ludger-cole@bestmail.none','2004-12-30',3);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (13,'Erno','Jöns','Gäulenwaldstraße','46','2986','Biberach','','e-12@retromail.none','2003-10-12',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (14,'Sylvester','Ricker','Brachelener Straße','41','1220','Wien','07151/76856046','s1-12@hoster.none','2002-11-12',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (15,'Burgel','Mehrtens','Erkrather Straße','43','1220','Wien','0209/99386605','b-mehrtens@goggle-mail.none','2004-06-29',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (16,'Heinrich','Huck','Ruhrblick','17','1220','Wien','06581/26383919','otheinrich_huck@live-mail.none','2004-02-05',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (17,'Hannetraud','Phelps','Im Betterling','194','1220','Wien','06764/78835064','hannetraud_phelps@anymail.none','2002-05-26',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (18,'Birkhild','Beermann','Eisenacher Straße','87','1220','Wien','07371/98293116','b-beermann@private.none','2006-10-17',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (19,'Hertraud','Wodtke','Flughafenstraße','64','1220','Wien','07175/42371985','hertraud_wodtke@open-mail.none','2005-09-03',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (20,'Arkadius','Wieczorek','Etzelbachstraße','180','1230','Wien','05362/49849429','arkadius.wieczorek@email.none','2002-04-04',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (21,'Steffie','Hoppe','Walburgisstraße','78','1220','Wien','02741/30875427','steffie.hoppe@ultramail.none','2004-03-29',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (22,'Elselore','Klass','Pappelweg','114','1220','Wien','','e-klass@ultramail.none','2004-08-16',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (23,'Alhard','Busse','Saynwaldstraße','104','1220','Wien','0228/31571822','abusse@net-mail.none','2003-07-10',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (24,'Marhild','Bartusch','Spiekersstraße','36','2654','Greifenberg','08192/96668094','m-bartusch@open-mail.none','2006-07-27',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (25,'Elise','Rohrbach','Siebenstücken','175','1220','Wien','04234/20513209','elise-rohrbach@xyz.none','2002-08-12',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (26,'Pia','Bischoff','Stroheicher Straße','111','1220','Wien','04535/89979287','p0-25@spam-mail.none','2003-10-12',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (27,'Milena','Wachsmann','Sommerkamp','99a','1220','Wien','','milenawachsmann@net-mail.none','2006-10-16',1);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (28,'Arnfred','Behre','Müllerstraße','165','1220','Wien','05731/70242563','abehre@goggle-mail.none','2005-08-14',3);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (29,'Andrea','Färber','Johannes-Grüter-Straße','39','1220','Wien','07565/87615552','a-faerber@web.none','2006-01-23',2);
INSERT INTO kunde (kdnr, vorname, nachname, strasse, hausnr, plz, ort, tel, email, gebdat, typ) VALUES (30,'Desiree','Nuding','Am Seeblick','162','1220','Wien','','desireenuding@hoster.none','2002-04-17',1);



INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10001, '2023-11-01', '2023-11-11', 2, 1, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10002, '2023-11-01', '2023-11-11', 1, 2, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10003, '2023-11-08', '2023-11-18', 3, 3, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10004, '2023-011-02', '2023-11-22', 1, 4, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10005, '2023-11-01', '2023-12-01', 2, 5, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10006, '2023-11-01', '2023-12-01', 3, 6, 'e');
INSERT INTO ausleihe (anr, ausdat, rueckdat, kdnr, mid, status) VALUES (10007, '2023-11-01', '2023-12-01', 7, 6, 'e');
