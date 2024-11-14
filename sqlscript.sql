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


