package loppuprojekti24.loppuprojekti.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "kayttajat")
public class Kayttaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "kayttajatunnus", nullable = false, unique = true)
    private String kayttajatunnus;

    @Column(name = "salasana", nullable = false)
    private String salasanaHash;

    @Column(name = "role", nullable = false)
    private String role;


    public Kayttaja () {

    }


    public Kayttaja(String kayttajatunnus, String salasanaHash, String role) {
        super();
        this.kayttajatunnus = kayttajatunnus;
        this.salasanaHash = salasanaHash;
        this.role = role;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getKayttajatunnus() {
        return kayttajatunnus;
    }


    public void setKayttajatunnus(String kayttajatunnus) {
        this.kayttajatunnus = kayttajatunnus;
    }


    public String getSalasanaHash() {
        return salasanaHash;
    }


    public void setSalasanaHash(String salasanaHash) {
        this.salasanaHash = salasanaHash;
    }


    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    }

    

    



}