CREATE DATABASE IF NOT EXISTS `thing` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

CREATE TABLE regie (
    rid INT(5) NOT NULL AUTO_INCREMENT,
    vorname VARCHAR(20),
    nachname VARCHAR(20),
    bio VARCHAR(200),
    gebdat DATE,
    PRIMARY KEY (rid)
);

CREATE TABLE filme (
    fid INT(5) NOT NULL AUTO_INCREMENT,
    titel VARCHAR(30),
    land CHAR(2),
    beschr VARCHAR(100),
    jahr DATE,
    sprache CHAR(2),
    rid INT(5),
    PRIMARY KEY (fid),
    FOREIGN KEY (rid) REFERENCES regie(rid)
);

CREATE TABLE medien (
    mid INT(5) NOT NULL AUTO_INCREMENT,
    fid INT(5),
    mtyp CHAR(3),
    PRIMARY KEY (mid),
    FOREIGN KEY (fid) REFERENCES filme(fid)
);

CREATE TABLE tarife (
    tnr INT(3) NOT NULL AUTO_INCREMENT,
    kdtyp CHAR(6),
    entleihe DECIMAL(5,2),
    ueberziehung DECIMAL(5,2),
    mitglied DECIMAL(5,2),
    PRIMARY KEY (tnr)
);

CREATE TABLE kunde (
    kdnr INT(5) NOT NULL AUTO_INCREMENT,
    vorname VARCHAR(20),
    nachname VARCHAR(30),
    strasse VARCHAR(30),
    hausnr VARCHAR(5),
    plz VARCHAR(5),
    ort VARCHAR(30),
    tel VARCHAR(20),
    email VARCHAR(30),
    gebdat DATE,
    typ INT(3),
    PRIMARY KEY (kdnr),
    FOREIGN KEY (typ) REFERENCES tarife(tnr)
);

CREATE TABLE ausleihe (
    anr INT(5) NOT NULL AUTO_INCREMENT,
    ausdat DATE,
    rueckdat DATE,
    kdnr INT(5),
    mid INT(5),
    status CHAR(1),
    PRIMARY KEY (anr),
    FOREIGN KEY (kdnr) REFERENCES kunde(kdnr),
    FOREIGN KEY (mid) REFERENCES medien(mid)
);
