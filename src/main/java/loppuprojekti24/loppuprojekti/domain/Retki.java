package loppuprojekti24.loppuprojekti.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Retki {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long retkiId;

    @NotEmpty (message = "Retkelle on annettava nimi")
    private String retkinimi;
    private String kuvaus;
    private LocalDate paivamaara;

    @ManyToOne
    @JoinColumn(name = "kaupunki_id")
    private Kaupunki kaupunki;

    @OneToMany(mappedBy = "retki", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<Osallistuja> osallistujat = new HashSet<>();

    public Retki() {

    }

    public Retki(String retkinimi, String kuvaus, Kaupunki kaupunki, LocalDate paivamaara, Set<Osallistuja> osallistujat) {
        this.retkinimi = retkinimi;
        this.kuvaus = kuvaus;
        this.kaupunki = kaupunki;
        this.osallistujat = osallistujat;
        this.paivamaara = paivamaara;
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

    public LocalDate getPaivamaara() {
        return paivamaara;
    }
    public void setPaivamaara(LocalDate paivamaara) {
        this.paivamaara = paivamaara;
    }

    public Set<Osallistuja> getOsallistujat() {
        return osallistujat;
    }

    public void setOsallistujat(Set<Osallistuja> osallistujat) {
        this.osallistujat = osallistujat;
    }

    @Override
    public String toString() {
        return "Retki [retkiId=" + retkiId + ", retkinimi=" + retkinimi + ", kuvaus=" + kuvaus + ", paivamaara="
                + paivamaara + ", kaupunki=" + kaupunki + ", osallistujat=" + osallistujat + "]";
    }


    

    // viimeinen sulku
}
