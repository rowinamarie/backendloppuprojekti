package loppuprojekti24.loppuprojekti.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Osallistuja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String osallistujanimi;

    @ManyToMany(mappedBy = "osallistujat", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Tapahtuma> tapahtumat = new HashSet<>();
    //Set on Java Collections Frameworkin rajapinta, joka edustaa kokoelmaa, jossa sama alkio voi esiintyä vain kerran.


    public Osallistuja () {
    }


    public Osallistuja(String osallistujanimi, Set<Tapahtuma> tapahtumat) {
        super ();
        this.osallistujanimi = osallistujanimi;
        this.tapahtumat = tapahtumat;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getOsallistujanimi() {
        return osallistujanimi;
    }


    public void setOsallistujanimi(String osallistujanimi) {
        this.osallistujanimi = osallistujanimi;
    }


    public Set<Tapahtuma> getTapahtumat() {
        return tapahtumat;
    }


    public void setTapahtumat(Set<Tapahtuma> tapahtumat) {
        this.tapahtumat = tapahtumat;
    }


    @Override
    public String toString() {
        return "Osallistuja [id=" + id + ", osallistujanimi=" + osallistujanimi + ", tapahtumat=" + tapahtumat + "]";
    }


    public void lisaaTapahtuma(Tapahtuma tapahtuma) {
        if (tapahtuma != null) {
            this.tapahtumat.add(tapahtuma);
        }
    }
    

  
    
}
