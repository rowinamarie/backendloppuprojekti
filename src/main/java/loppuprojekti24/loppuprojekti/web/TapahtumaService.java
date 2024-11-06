package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;
import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TapahtumaService {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private OsallistujaRepository osallistujaRepository;

    @Transactional
    public void lisaaOsallistujaTapahtumaan(Long tapahtumaId, List<Long> osallistujaIds, Osallistuja uusiOsallistuja) {
        // Haetaan tapahtuma
        Optional<Tapahtuma> tapahtumaOpt = tapahtumaRepository.findById(tapahtumaId);

        if (tapahtumaOpt.isPresent()) {
            Tapahtuma tapahtuma = tapahtumaOpt.get();

            // Hakee kaikki valitut osallistujat ID:n perusteella
            List<Osallistuja> osallistujat = osallistujaRepository.findAllById(osallistujaIds);

            // Lisätään osallistujat tapahtumaan
            for (Osallistuja osallistuja : osallistujat) {
                tapahtuma.lisaaOsallistuja(osallistuja);
            }

            // Jos uusi osallistuja on annettu ja hänellä on nimi, lisätään hänet
            if (uusiOsallistuja != null && uusiOsallistuja.getOsallistujanimi() != null && !uusiOsallistuja.getOsallistujanimi().isEmpty()) {
                osallistujaRepository.save(uusiOsallistuja);  // Tallenna uusi osallistuja
                tapahtuma.lisaaOsallistuja(uusiOsallistuja);  // Lisää uusi osallistuja tapahtumaan
            }

            // Tallennetaan tapahtuma
            tapahtumaRepository.save(tapahtuma);
        }
    }
}
