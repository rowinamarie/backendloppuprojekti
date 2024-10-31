package loppuprojekti24.loppuprojekti.domain;

import java.time.LocalDate;



@
public class Tapahtuma {

  
    private Long id;
    private String nimi;
    private String sijainti;
    private String kuvaus;
    private LocalDate paivamaara;


    
    public Tapahtuma(Long id, String nimi, String sijainti, String kuvaus, LocalDate paivamaara) {
        this.id = id;
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
