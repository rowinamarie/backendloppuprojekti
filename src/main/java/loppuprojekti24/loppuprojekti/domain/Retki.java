package loppuprojekti24.loppuprojekti.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Retki {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long retkiId;
    private String retkinimi;
    private String kuvaus;


    @ManyToOne
    @JoinColumn(name = "kaupunki_id")
    private Kaupunki kaupunki;

   @OneToMany(mappedBy = "retki")
    @JsonManagedReference 
    private Set<Osallistuja> osallistujat = new HashSet<>();



    public Retki () {

    }


    public Retki(String retkinimi, String kuvaus, Kaupunki kaupunki, Set <Osallistuja> osallistujat) {
        this.retkinimi = retkinimi;
        this.kuvaus = kuvaus;
        this.kaupunki = kaupunki;
        this.osallistujat = osallistujat;
    }


    public Long getRetkiId() {
        return retkiId;
    }


    public void setRetkiId(Long retkiId) {
        this.retkiId = retkiId;
    }


    public String getRetkinimi() {
        return retkinimi;
    }


    public void setRetkinimi(String retkinimi) {
        this.retkinimi = retkinimi;
    }


    public String getKuvaus() {
        return kuvaus;
    }


    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    public Kaupunki getKaupunki() {
        return kaupunki;
    }


    public void setKaupunki(Kaupunki kaupunki) {
        this.kaupunki = kaupunki;
    }


  public Set<Osallistuja> getOsallistujat() {
        return osallistujat;
    }


    public void setOsallistujat(Set<Osallistuja> osallistujat) {
        this.osallistujat = osallistujat;
    } 


    @Override
    public String toString() {
        return "Retki [retkiId=" + retkiId + ", retkinimi=" + retkinimi + ", kuvaus=" + kuvaus + ", kaupunki=" + kaupunki + "]";
    }

    


    //viimeinen sulku
}
