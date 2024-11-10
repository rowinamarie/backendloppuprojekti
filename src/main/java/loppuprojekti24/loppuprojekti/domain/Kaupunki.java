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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long kaupunkiId;
    private String kaupunkinimi;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kaupunki")
	private List<Retki> retki;


    public Kaupunki () {

    }

    public Kaupunki(String kaupunkinimi) {
        this.kaupunkinimi = kaupunkinimi;
      
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


    @Override
    public String toString() {
        return "Kaupunki [kaupunkiId=" + kaupunkiId + ", kaupunkinimi=" + kaupunkinimi +  "]";
    }

    


}
