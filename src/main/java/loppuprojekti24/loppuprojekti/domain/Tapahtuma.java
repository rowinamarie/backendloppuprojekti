package loppuprojekti24.loppuprojekti.domain;

import java.time.LocalDate;

import org.springframework.boot.autoconfigure.web.WebProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Tapahtuma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nimi;
    private String kuvaus;
    private LocalDate paivamaara;

    @ManyToOne
    @JoinColumn(name = "kaupunkiid")
    private Kaupunki kaupunki;

    public Tapahtuma() {
    }

    public Tapahtuma(String nimi, String kuvaus, LocalDate paivamaara, Kaupunki kaupunki) {
        super();
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.paivamaara = paivamaara;
        this.kaupunki = kaupunki;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    public Kaupunki getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(Kaupunki kaupunki) {
        this.kaupunki = kaupunki;
    }

    @Override
    public String toString() {
        if (this.kaupunki != null) 
            return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", paivamaara=" + paivamaara
                    + ", kaupunki=" + this.getKaupunki() + "]"; 
        else 
            return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", kuvaus=" + kuvaus + ", paivamaara=" + paivamaara
                    + "]";
    }
}