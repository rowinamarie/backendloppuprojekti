/*package loppuprojekti24.loppuprojekti.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Osallistuja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long osallistujaId;
    
    private String etunimi;
    private String sukunimi;
    private String sahkoposti;

    @ManyToOne
    @JoinColumn(name = "retki_id") // Viittaa retkeen
    private Retki retki;

    public Osallistuja () {

    }

    public Osallistuja(String etunimi, String sukunimi, String sahkoposti, Retki retki) {
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sahkoposti = sahkoposti;
        this.retki = retki;
    }

    public Long getOsallistujaId() {
        return osallistujaId;
    }

    public void setOsallistujaId(Long osallistujaId) {
        this.osallistujaId = osallistujaId;
    }

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getSahkoposti() {
        return sahkoposti;
    }

    public void setSahkoposti(String sahkoposti) {
        this.sahkoposti = sahkoposti;
    }

    public Retki getRetki() {
        return retki;
    }

    public void setRetki(Retki retki) {
        this.retki = retki;
    }

    @Override
    public String toString() {
        return "Osallistuja [osallistujaId=" + osallistujaId + ", etunimi=" + etunimi + ", sukunimi=" + sukunimi
                + ", sahkoposti=" + sahkoposti + ", retki=" + retki + "]";
    }

    

}
*/