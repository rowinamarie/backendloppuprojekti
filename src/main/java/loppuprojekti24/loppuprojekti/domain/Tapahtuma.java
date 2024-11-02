package loppuprojekti24.loppuprojekti.domain;

import java.time.LocalDate;

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
    private LocalDate paivamaara;

    public Tapahtuma () {}


    public Tapahtuma(String nimi, String sijainti, String kuvaus, LocalDate paivamaara) {
        super ();
        this.nimi = nimi;
        this.sijainti = sijainti;
        this.kuvaus = kuvaus;
        this.paivamaara = paivamaara;
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

    
    
    public LocalDate getPaivamaara() {
        return paivamaara;
    }

    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }


    @Override
    public String toString() {
        return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", sijainti=" + sijainti + ", kuvaus=" + kuvaus
                + ", paivamaara=" + paivamaara + "]";
    }

   



    

}
