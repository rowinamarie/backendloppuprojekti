package loppuprojekti24.loppuprojekti.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Kaupunki {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kaupunkiId;
    private String kaupunkinimi;

    @OneToMany(mappedBy = "kaupunki")
    private Set<Retki> retket = new HashSet<>();


    public Kaupunki () {

    }

    public Kaupunki(String kaupunkinimi, Set<Retki> retket) {
        this.kaupunkinimi = kaupunkinimi;
        this.retket = retket;
    }


    public Long getKaupunkiId() {
        return kaupunkiId;
    }


    public void setKaupunkiId(Long kaupunkiId) {
        this.kaupunkiId = kaupunkiId;
    }


    public String getKaupunkinimi() {
        return kaupunkinimi;
    }


    public void setKaupunkinimi(String kaupunkinimi) {
        this.kaupunkinimi = kaupunkinimi;
    }


    public Set<Retki> getRetket() {
        return retket;
    }


    public void setRetket(Set<Retki> retket) {
        this.retket = retket;
    }

    @Override
    public String toString() {
        return "Kaupunki [kaupunkiId=" + kaupunkiId + ", kaupunkinimi=" + kaupunkinimi + ", retket=" + retket + "]";
    }

    


}
