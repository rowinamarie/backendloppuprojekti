-- Tietokantataulu Kaupunki
CREATE TABLE Kaupunki (
    kaupunki_id BIGSERIAL PRIMARY KEY,
    kaupunkinimi VARCHAR(255) NOT NULL
);

-- Tietokantataulu Kayttajat
CREATE TABLE kayttajat (
    id BIGSERIAL PRIMARY KEY,
    kayttajatunnus VARCHAR(255) NOT NULL UNIQUE,
    salasana VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Tietokantataulu Retki
CREATE TABLE Retki (
    retki_id BIGSERIAL PRIMARY KEY,
    retkinimi VARCHAR(255) NOT NULL,
    kuvaus TEXT,
    paivamaara DATE,
    kaupunki_id BIGINT,
    FOREIGN KEY (kaupunki_id) REFERENCES Kaupunki(kaupunki_id)
);

-- Tietokantataulu Osallistuja
CREATE TABLE Osallistuja (
    osallistuja_id BIGSERIAL PRIMARY KEY,
    etunimi VARCHAR(255) NOT NULL,
    sukunimi VARCHAR(255) NOT NULL,
    sahkoposti VARCHAR(255) NOT NULL,
    retki_id BIGINT,
    FOREIGN KEY (retki_id) REFERENCES Retki(retki_id)
);


-- Lisätään testidata tauluun Kaupunki
INSERT INTO Kaupunki (kaupunkinimi) VALUES ('Saimaa');
INSERT INTO Kaupunki (kaupunkinimi) VALUES ('Inari');
INSERT INTO Kaupunki (kaupunkinimi) VALUES ('Turku');

-- Lisätään testidata tauluun Retki
INSERT INTO Retki (retkinimi, kuvaus, paivamaara, kaupunki_id) VALUES 
('Kesäretki Saimaalle', 'Kolmen päivän retki.', '2024-06-15', 1), -- kaupunki_id 1 (Saimaa)
('Ruskavaellus Lapissa', 'Nukkumista tähtitaivaan alla.', '2024-09-08', 2); -- kaupunki_id 2 (Inari)

-- Lisätään testidata tauluun Osallistuja
INSERT INTO Osallistuja (etunimi, sukunimi, sahkoposti, retki_id) VALUES 
('Matti', 'Meikaläinen', 'matti.meikalainen@sahkoposti.fi', 1), -- retki_id 1 (Kesäretki Saimaalle)
('Liisa', 'Korhonen', 'liisa@sahkposti.fi', 2); -- retki_id 2 (Ruskavaellus Lapissa)

-- Lisätään testidata tauluun Kayttaja
INSERT INTO kayttajat (kayttajatunnus, salasana, role) VALUES 
('Oppilas', '$2a$12$xb2011I0iidDDSNtDbmQGOPGkSKfePo2gCmB7T.77r.HrYAlw4W.C', 'OPPILAS'),
('Opettaja', '$2a$12$gNMXsAo29KleVf86UVrB1.4lPBiPN454rd3X0gYBMVy9AePtEhAXK', 'OPETTAJA');
