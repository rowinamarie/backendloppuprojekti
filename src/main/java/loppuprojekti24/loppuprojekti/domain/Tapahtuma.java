package loppuprojekti24.loppuprojekti.domain;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Tapahtuma {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nimi;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "tapahtuma_osallistuja",
        joinColumns = @JoinColumn(name = "tapahtuma_id"),
        inverseJoinColumns = @JoinColumn(name = "osallistuja_id")
    )

    private Set<Osallistuja> osallistujat = new HashSet<>();
//Set on Java Collections Frameworkin rajapinta, joka edustaa kokoelmaa, jossa sama alkio voi esiintyä vain kerran.

    public Tapahtuma () {
    }

    public Tapahtuma(String nimi, Set<Osallistuja> osallistujat) {
        super ();
        this.nimi = nimi;
        this.osallistujat = osallistujat;
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

    public Set<Osallistuja> getOsallistujat() {
        return osallistujat;
    }

    public void setOsallistujat(Set<Osallistuja> osallistujat) {
        this.osallistujat = osallistujat;
    }

    @Override
    public String toString() {
        return "Tapahtuma [id=" + id + ", nimi=" + nimi + ", osallistujat=" + osallistujat + "]";
    }

    public void lisaaOsallistuja(Osallistuja osallistuja) {
        if (osallistuja != null && !this.osallistujat.contains(osallistuja)) {
            this.osallistujat.add(osallistuja);
            osallistuja.lisaaTapahtuma(this);
        }
    }
    
 
 
}