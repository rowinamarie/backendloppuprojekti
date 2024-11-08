/*package loppuprojekti24.loppuprojekti.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;


// Aktiviteetti-puolella käytetään @ManyToMany ja @JoinTable,
//koska tämä puoli omistaa suhteen ja hallitsee välitaulua (kuten RetkiAktiviteetti), joka yhdistää Retki- ja Aktiviteetti-taulut.

@Entity
public class Aktiviteetti {


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long aktiviteettiId;
    private String aktiviteettinimi;
    private String kuvaus;
    
    @ManyToMany
    @JoinTable(
        name = "RetkiAktiviteetti", //välitaulun nimi
        joinColumns = @JoinColumn(name = "aktiviteetti_id"),  // Aktiviteetti-taulussa käytetään aktiviteetti_id ulkoista avainta viittaamaan Retki-tauluun.
        inverseJoinColumns = @JoinColumn(name = "retki_id") // määrittää Retki-taulun viittaavan Aktiviteetti-tauluun käyttäen retki_id-kenttää.
    )
    private Set<Retki> retket = new HashSet<>();

    public Aktiviteetti () {

    }

    public Aktiviteetti(String aktiviteettinimi, String kuvaus, Set<Retki> retket) {
        this.aktiviteettinimi = aktiviteettinimi;
        this.kuvaus = kuvaus;
        this.retket = retket;
    }

    public Long getAktiviteettiId() {
        return aktiviteettiId;
    }



    public void setAktiviteettiId(Long aktiviteettiId) {
        this.aktiviteettiId = aktiviteettiId;
    }



    public String getAktiviteettinimi() {
        return aktiviteettinimi;
    }



    public void setAktiviteettinimi(String aktiviteettinimi) {
        this.aktiviteettinimi = aktiviteettinimi;
    }



    public String getKuvaus() {
        return kuvaus;
    }



    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }



    public Set<Retki> getRetket() {
        return retket;
    }



    public void setRetket(Set<Retki> retket) {
        this.retket = retket;
    }



    @Override
    public String toString() {
        return "Aktiviteetti [aktiviteettiId=" + aktiviteettiId + ", aktiviteettinimi=" + aktiviteettinimi + ", kuvaus="
                + kuvaus + ", retket=" + retket + "]";
    }

    


    

}*/
