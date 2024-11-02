package loppuprojekti24.loppuprojekti.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Kaupunki {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kaupunkiid;

    String kaupunkinimi;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kaupunki")
	private List<Tapahtuma> tapahtumat;


    public Kaupunki() {
    }

    public Kaupunki(String kaupunkinimi) {
        super ();
        this.kaupunkinimi = kaupunkinimi;
    }

    public Long getKaupunkiid() {
        return kaupunkiid;
    }

    public void setKaupunkiid(Long kaupunkiid) {
        this.kaupunkiid = kaupunkiid;
    }

    public String getKaupunkinimi() {
        return kaupunkinimi;
    }

    public void setKaupunkinimi(String kaupunkinimi) {
        this.kaupunkinimi = kaupunkinimi;
    }

    public List<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }

    public void setTapahtumat(List<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }

    @Override
    public String toString() {
        return "Kaupunki [kaupunkiid=" + kaupunkiid + ", kaupunkinimi=" + kaupunkinimi + "]";
    }

   

    



}
