CREATE DATABASE ViennaByBike;
USE ViennaByBike;

CREATE TABLE Kunde (
    KundenID INT(24) PRIMARY KEY,
    Vorname VARCHAR(50) NOT NULL,
    Nachname VARCHAR(50) NOT NULL,
    Land VARCHAR(50) NOT NULL,
    Ort VARCHAR(30) NOT NULL,
    Plz CHAR(8) NOT NULL,
    Straße VARCHAR(50) NOT NULL,
    Hausnummer INT NOT NULL,
    Türnummer INT,
    Telefonummer INT(15),
    Email VARCHAR(50),
    Ausweisnummer VARCHAR(30)
);

CREATE TABLE Tarif (
    TarifID INT(24) PRIMARY KEY,
    Dauer TIME NOT NULL,
    Preis INT NOT NULL
);

CREATE TABLE Fahrrad (
    FahrradID INT(24) PRIMARY KEY,
    Hersteller VARCHAR(50) NOT NULL,
    Typ VARCHAR(50) NOT NULL,
    Farbe VARCHAR(50) NOT NULL,
    Länge INT NOT NULL,
    Breite INT NOT NULL,
    Beschreibung VARCHAR(200) NOT NULL
);

CREATE TABLE Ausleihe (
    AusleiheID INT(24) PRIMARY KEY,
    KundenID INT(24),
    FahrradID INT(24),
    Ausleihdatum DATE NOT NULL,
    Rückgabedatum DATE NOT NULL,
    TarifID INT(24),
    FOREIGN KEY (KundenID) REFERENCES Kunde(KundenID),
    FOREIGN KEY (FahrradID) REFERENCES Fahrrad(FahrradID),
    FOREIGN KEY (TarifID) REFERENCES Tarif(TarifID)
);

CREATE TABLE Hersteller (
    HerstellerID INT PRIMARY KEY,
    Bezeichnung VARCHAR(45),
    Email VARCHAR(45)
);
