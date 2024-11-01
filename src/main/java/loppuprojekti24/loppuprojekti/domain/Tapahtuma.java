package loppuprojekti24.loppuprojekti.domain;

import org.springframework.boot.autoconfigure.web.WebProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Tapahtuma {

  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    
    private String nimi;
    private String sijainti;
    private String kuvaus;

    public Tapahtuma () {}

    public Tapahtuma(Long id, String nimi, String sijainti, String kuvaus) {
        this.id = id;
        this.nimi = nimi;
        this.sijainti = sijainti;
        this.kuvaus = kuvaus;
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
    public String getSijainti() {
        return sijainti;
    }
    public void setSijainti(String sijainti) {
        this.sijainti = sijainti;
    }
    public String getKuvaus() {
        return kuvaus;
    }
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    @Override
    public String toString() {
        return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", sijainti=" + sijainti + ", kuvaus=" + kuvaus
                + "]";
    }

    

}
