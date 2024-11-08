/*package loppuprojekti24.loppuprojekti.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Tämä välitaulu yhdistää Retket ja Aktiviteetit, koska niillä on ManyToMany -suhde
public class RetkiAktiviteetti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long retkiakvititeettiId;

    @ManyToOne
    @JoinColumn(name = "retki_id", nullable = false)
    private Retki retki;

    @ManyToOne
    @JoinColumn(name = "aktiviteetti_id", nullable = false)
    private Aktiviteetti aktiviteetti;

    public RetkiAktiviteetti() {
    }

    public RetkiAktiviteetti(Retki retki, Aktiviteetti aktiviteetti) {
        this.retki = retki;
        this.aktiviteetti = aktiviteetti;
    }

    public Long getRetkiakvititeettiId() {
        return retkiakvititeettiId;
    }

    public void setRetkiakvititeettiId(Long retkiakvititeettiId) {
        this.retkiakvititeettiId = retkiakvititeettiId;
    }

    public Retki getRetki() {
        return retki;
    }

    public void setRetki(Retki retki) {
        this.retki = retki;
    }

    public Aktiviteetti getAktiviteetti() {
        return aktiviteetti;
    }

    public void setAktiviteetti(Aktiviteetti aktiviteetti) {
        this.aktiviteetti = aktiviteetti;
    }

    @Override
    public String toString() {
        return "RetkiAktiviteetti [retkiakvititeettiId=" + retkiakvititeettiId + ", retki=" + retki + ", aktiviteetti="
                + aktiviteetti + "]";
    }

    

}
 */