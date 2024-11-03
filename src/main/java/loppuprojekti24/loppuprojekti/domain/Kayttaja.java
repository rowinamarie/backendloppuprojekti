package loppuprojekti24.loppuprojekti.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="KayttajaTable")
public class Kayttaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    // Username with unique constraint
    @Column(name = "kayttajanimi", nullable = false, unique = true)
    private String kayttajanimi;

    @Column(name = "salasana", nullable = false)
    private String salasanaHash;

    @Column(name = "rooli", nullable = false)
    private String rooli;
    
    public Kayttaja() {
    }

    public Kayttaja(String kayttajanimi, String salasanaHash, String rooli) {
        super();
        this.kayttajanimi = kayttajanimi;
        this.salasanaHash = salasanaHash;
        this.rooli = rooli;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKayttajanimi() {
        return kayttajanimi;
    }

    public void setKayttajanimi(String kayttajanimi) {
        this.kayttajanimi = kayttajanimi;
    }

    public String getSalasanaHash() {
        return salasanaHash;
    }

    public void setSalasanaHash(String salasanaHash) {
        this.salasanaHash = salasanaHash;
    }

    public String getRooli() {
        return rooli;
    }

    public void setRooli(String rooli) {
        this.rooli = rooli;
    }
    
    
    

}
