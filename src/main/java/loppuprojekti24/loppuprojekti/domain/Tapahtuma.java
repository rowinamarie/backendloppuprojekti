package loppuprojekti24.loppuprojekti.domain;



public class Tapahtuma {

  
    private Long id;
    private String nimi;
    private String sijainti;
    private String kuvaus;

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
