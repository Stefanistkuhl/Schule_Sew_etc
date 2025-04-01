drop database if exists viennabybike;
create database viennabybike CHARACTER SET = 'utf8' COLLATE = 'utf8_german2_ci';;
use viennabybike;

create table kunden (
	kid int unsigned not null,
	vorname varchar(50) not null,
	nachname varchar(50) not null,
	strasse varchar(59) not null,
	ort varchar(30) not null,
	plz varchar(8) not null,
	land varchar(30) not null,
	email varchar(60) not null,
	telefon varchar(20) not null,
	ausweisnr varchar(30) not null,
	ausweistyp enum ('pass', 'paw','fs'),
	primary key (kid)
);

create table hersteller (
	hid tinyint unsigned not null,
	bezeichnung varchar(30) not null,
	strasse varchar(59),
	ort varchar(30),
	plz varchar(8),
	land varchar(30),
	email varchar(60),
	telefon varchar(20),
	primary key (hid)
	);

create table bikes (
	bid smallint unsigned not null,
	hersteller tinyint unsigned not null,
	typ enum ('cb', 'mtb', 'rr', 'gb'),
	farbe varchar(10) not null,
	groesse enum ('20', '21','22','23','24'),
	beschreibung varchar(100) not null,
	primary key (bid),
	foreign key (hersteller) references hersteller(hid)
);

create table tarife (
	tid tinyint unsigned not null,
	bezeichnung varchar(25) not null,
	preis decimal(6,2) not null,
	primary key (tid)
);

create table verleih (
	eid int unsigned not null,
	kunde int unsigned not null,
	bike smallint unsigned not null,
	entdate date not null,
	entzeit time not null,
	tarif tinyint unsigned not null,
	rueckdate date,
	rueckzeit time,
	status enum ('gebucht', 'abgeholt', 'retour') not null,
	primary key (eid),
	foreign key (kunde) references kunden (kid),
	foreign key (bike) references bikes (bid),
	foreign key (tarif) references tarife (tid)
);


INSERT INTO kunden (kid, vorname, nachname, strasse, ort, plz, land, email, telefon, ausweisnr, ausweistyp) VALUES
(1, 'Anna', 'Schmidt', 'Hauptstraße 12', 'Wien', '1010', 'Österreich', 'anna.schmidt@example.at', '+43 123456789', 'AT123456', 'pass'),
(2, 'Max', 'Müller', 'Am Bach 5', 'Berlin', '10115', 'Deutschland', 'max.mueller@example.de', '+49 123456789', 'DE987654', 'pass'),
(3, 'Emily', 'Johnson', '123 Oak Street', 'New York', '10001', 'USA', 'emily.johnson@example.com', '+1 123456789', 'US654321', 'pass'),
(4, 'David', 'Leitner', 'Bergweg 7', 'Salzburg', '5020', 'Österreich', 'david.leitner@example.at', '+43 123456789', 'AT456789', 'paw'),
(5, 'Sophie', 'Schneider', 'Friedrichstraße 8', 'München', '80333', 'Deutschland', 'sophie.schneider@example.de', '+49 123456789', 'DE456789', 'paw'),
(6, 'Michael', 'Brown', '456 Maple Avenue', 'Los Angeles', '90001', 'USA', 'michael.brown@example.com', '+1 123456789', 'US987654', 'paw'),
(7, 'Julia', 'Hofmann', 'Kaiserstraße 15', 'Graz', '8010', 'Österreich', 'julia.hofmann@example.at', '+43 123456789', 'AT789456', 'fs'),
(8, 'Benjamin', 'Becker', 'Schlossallee 3', 'Hamburg', '20095', 'Deutschland', 'benjamin.becker@example.de', '+49 123456789', 'DE123456', 'fs'),
(9, 'Olivia', 'Davis', '789 Elm Street', 'Chicago', '60601', 'USA', 'olivia.davis@example.com', '+1 123456789', 'US123789', 'fs'),
(10, 'Simon', 'Weber', 'Hauptplatz 20', 'Linz', '4020', 'Österreich', 'simon.weber@example.at', '+43 123456789', 'AT789123', 'pass'),
(11, 'Hannah', 'Schwarz', 'Sonnengasse 6', 'Dresden', '01067', 'Deutschland', 'hannah.schwarz@example.de', '+49 123456789', 'DE789123', 'pass'),
(12, 'Liam', 'Martinez', '1010 Pine Street', 'San Francisco', '94108', 'USA', 'liam.martinez@example.com', '+1 123456789', 'US456789', 'pass'),
(13, 'Lena', 'Wagner', 'Bachstraße 14', 'Innsbruck', '6020', 'Österreich', 'lena.wagner@example.at', '+43 123456789', 'AT456123', 'paw'),
(14, 'Felix', 'Koch', 'Lindenweg 2', 'Stuttgart', '70176', 'Deutschland', 'felix.koch@example.de', '+49 123456789', 'DE654789', 'paw'),
(15, 'Emma', 'Garcia', '888 Maple Street', 'Miami', '33132', 'USA', 'emma.garcia@example.com', '+1 123456789', 'US789123', 'paw'),
(16, 'Leon', 'Huber', 'Hauptplatz 5', 'Graz', '8010', 'Österreich', 'leon.huber@example.at', '+43 123456789', 'AT987654', 'fs'),
(17, 'Mia', 'Bauer', 'Ahornweg 9', 'Hannover', '30159', 'Deutschland', 'mia.bauer@example.de', '+49 123456789', 'DE321654', 'fs'),
(18, 'Noah', 'Rodriguez', '555 Oak Lane', 'New York', '10001', 'USA', 'noah.rodriguez@example.com', '+1 123456789', 'US321789', 'fs'),
(19, 'Sophia', 'Fischer', 'Neugasse 3', 'Salzburg', '5020', 'Österreich', 'sophia.fischer@example.at', '+43 123456789', 'AT654321', 'pass'),
(20, 'Ethan', 'Schulz', 'Birkenweg 11', 'Frankfurt', '60306', 'Deutschland', 'ethan.schulz@example.de', '+49 123456789', 'DE987321', 'pass');



INSERT INTO hersteller (hid, bezeichnung, strasse, ort, plz, land, email, telefon) VALUES
(1, 'Radmeister GmbH', 'Hauptstraße 25', 'Berlin', '10115', 'Deutschland', 'info@radmeister.de', '+49 123456789'),
(2, 'AlpenFahrrad AG', 'Bergweg 8', 'Innsbruck', '6020', 'Österreich', 'info@alpenfahrrad.at', '+43 123456789'),
(3, 'RapidCycles Inc.', '123 Main Street', 'Los Angeles', '90001', 'USA', 'info@rapidcycles.com', '+1 123456789'),
(4, 'Velospeed GmbH', 'Hafenstraße 12', 'Hamburg', '20095', 'Deutschland', 'info@velospeed.de', '+49 123456789'),
(5, 'MountainKing AG', 'Berggasse 10', 'Graz', '8010', 'Österreich', 'info@mountainking.at', '+43 123456789'),
(6, 'CityBikes Ltd.', 'Broadway 45', 'New York', '10001', 'USA', 'info@citybikes.com', '+1 123456789'),
(7, 'EcoWheels GmbH', 'Grüngasse 3', 'Salzburg', '5020', 'Österreich', 'info@ecowheels.at', '+43 123456789'),
(8, 'UrbanCycles GmbH', 'Stadtweg 7', 'München', '80333', 'Deutschland', 'info@urbancycles.de', '+49 123456789'),
(9, 'TrailBlazer Ltd.', 'Forest Road 15', 'Seattle', '98101', 'USA', 'info@trailblazer.com', '+1 123456789'),
(10, 'BikeWorks GmbH', 'Fahrradstraße 2', 'Frankfurt', '60306', 'Deutschland', 'info@bikeworks.de', '+49 123456789');

INSERT INTO bikes (bid, hersteller, typ, farbe, groesse, beschreibung) VALUES
(1, 1, 'cb', 'Rot', '22', 'Citybike mit 7-Gang Schaltung und Korb'),
(2, 1, 'mtb', 'Blau', '23', 'Mountainbike mit 29-Zoll Rädern und Federung'),
(3, 2, 'rr', 'Schwarz', '21', 'Rennrad aus Carbon mit Shimano 105 Schaltung'),
(4, 2, 'gb', 'Grün', '22', 'Gravelbike mit Scheibenbremsen und Schutzblechen'),
(5, 3, 'cb', 'Weiß', '20', 'Citybike mit Rücktrittbremse und Frontkorb'),
(6, 3, 'mtb', 'Grau', '23', 'Mountainbike mit 27.5-Zoll Rädern und Dämpfer'),
(7, 4, 'rr', 'Rot', '22', 'Rennrad aus Aluminium mit Shimano Tiagra Schaltung'),
(8, 4, 'gb', 'Schwarz', '21', 'Gravelbike mit 700x40c Reifen und Gepäckträger'),
(9, 5, 'cb', 'Blau', '24', 'Citybike mit 3-Gang Nabenschaltung und Beleuchtung'),
(10, 5, 'mtb', 'Rot', '22', 'Mountainbike mit 26-Zoll Rädern und V-Bremse'),
(11, 6, 'rr', 'Weiß', '23', 'Rennrad aus Carbon mit elektronischer Schaltung'),
(12, 6, 'gb', 'Grau', '24', 'Gravelbike mit 650b Laufrädern und Tubeless Reifen'),
(13, 7, 'cb', 'Schwarz', '21', 'Citybike mit 6-Gang Schaltung und Rahmenschloss'),
(14, 7, 'mtb', 'Grün', '23', 'Mountainbike mit 27.5-Plus Reifen und Dropper-Sattelstütze'),
(15, 8, 'rr', 'Blau', '22', 'Rennrad aus Aluminium mit Shimano Sora Schaltung'),
(16, 8, 'gb', 'Rot', '21', 'Gravelbike mit Carbonrahmen und hydraulischen Scheibenbremsen'),
(17, 9, 'cb', 'Grau', '23', 'Citybike mit 8-Gang Nabenschaltung und gefedertem Sattel'),
(18, 9, 'mtb', 'Schwarz', '22', 'Mountainbike mit 29-Zoll Laufrädern und Boost-Naben'),
(19, 10, 'rr', 'Rot', '24', 'Rennrad aus Carbon mit elektrischer Schaltung'),
(20, 10, 'gb', 'Blau', '21', 'Gravelbike mit Carbon-Gabel und 1x11 Antrieb');


INSERT INTO tarife (tid, bezeichnung, preis)
VALUES
	(1, 'stunden', 5.0),
	(2, 'tage',35.50),
	(3, 'woche', 152.70);

SET @vorvorgestern:= SUBDATE(CURDATE(), INTERVAL 3 DAY);
SET @vorgestern:= SUBDATE(CURDATE(), INTERVAL 2 DAY);
SET @gestern:= SUBDATE(CURDATE(), INTERVAL 1 DAY);
SET @heute:= CURDATE();
SET @morgen:= DATE_ADD(CURDATE(), INTERVAL 1 DAY);
SET @vor30min:=timestampadd(minute, -30, TIME(now()));
SET @vor20min:=timestampadd(minute, -20, TIME(now()));
SET @vor10min:=timestampadd(minute, -10, TIME(now()));
SET @vor5min:=timestampadd(minute, -5, TIME(now()));


-- Einträge für die Tabelle "verleih"
INSERT INTO verleih (eid, kunde, bike, entdate, entzeit, tarif, rueckdate, rueckzeit, status)
VALUES
    (1, 1, 1, @vorvorgestern, '08:00:00', 2, @vorvorgestern, '16:00:00', 'retour'),
    (2, 1, 2, @vorvorgestern, '09:00:00', 2, @vorvorgestern, '18:00:00', 'retour'),
    (3, 2, 3, @vorvorgestern, '10:00:00', 1, @vorvorgestern, '17:00:00', 'retour'),
    (4, 4, 4, @vorvorgestern, '11:00:00', 1, @vorgestern, '18:00:00', 'retour'),
    (5, 6, 5, @vorvorgestern, '12:00:00', 1, @vorgestern, '16:00:00', 'retour'),
    (6, 6, 6, @vorgestern, '12:00:00', 1, @vorgestern, '16:00:00', 'retour'),
    (7, 7, 7, @vorgestern, '14:00:00', 1, @vorgestern, '19:00:00', 'retour'),
    (8, 8, 8, @gestern, '10:00:00', 2, @gestern, '17:00:00', 'retour'),
    (9, 8, 9, @gestern, '10:00:00', 2, @gestern, '17:00:00', 'retour'),
    (10, 10, 10, @gestern, '09:00:00', 2, @gestern, '17:00:00', 'retour'),
    (11, 11, 11, @gestern, '08:30:00', 2, @gestern, '18:30:00', 'retour'),
    (12, 12, 12, @gestern, '10:30:00', 1, @gestern, '17:30:00', 'retour'),
    (13, 12, 13, @gestern, '10:30:00', 1, @gestern, '17:30:00', 'retour'),
    (14, 14, 14, @gestern, '08:30:00', 1, @gestern, '14:30:00', 'abgeholt'),
    (15, 14, 15, @gestern, '08:30:00', 1, @gestern, '14:30:00', 'abgeholt'),
    (16, 16, 16, @gestern, '13:30:00', 2, @gestern, '13:30:00', 'retour'),
    (17, 17, 17, @heute, '10:30:00', 2, @heute, '14:30:00', 'retour'),
    (18, 18, 18, @heute, '11:30:00', 2, @heute, '15:30:00', 'retour'),
    (19, 19, 19, @heute, '10:30:00', 2, @heute, '14:30:00', 'retour'),
    (20, 20, 20, @heute, '09:30:00', 2, @heute, '15:30:00', 'retour'),
    (21, 5, 8, @heute, '09:30:00', 2, @heute, '16:30:00', 'retour'),
    (22, 3, 1, @heute, '09:30:00', 3, NULL, NULL, 'abgeholt'),
    (23, 3, 7, @heute, '09:30:00', 3, NULL, NULL, 'abgeholt'),
    (24, 15, 9, @heute, '09:30:00', 2, NULL, NULL, 'abgeholt'),
    (25, 15, 1, @heute, '09:30:00', 2, NULL, NULL, 'abgeholt'),
    (26, 14, 3, @morgen, '10:00:00', 1, NULL, NULL, 'gebucht'),
    (27, 13, 5, @morgen, '10:00:00', 1, NULL, NULL, 'gebucht');
