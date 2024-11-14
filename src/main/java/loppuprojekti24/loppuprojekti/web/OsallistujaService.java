package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;

@Service
public class OsallistujaService {

    @Autowired
    private OsallistujaRepository osallistujaRepository;

    @Transactional
    public Osallistuja editParticipant(Long osallistujaId, Osallistuja editedParticipant) {
        // Etsi osallistuja ID:n perusteella
        Osallistuja existingParticipant = osallistujaRepository.findById(osallistujaId)
                .orElseThrow(() -> new ResourceNotFoundException("Osallistuja ei löydy ID:llä " + osallistujaId));
        
        // Päivitä vain nimi ja sähköposti
        existingParticipant.setEtunimi(editedParticipant.getEtunimi());
        existingParticipant.setSukunimi(editedParticipant.getSukunimi());
        existingParticipant.setSahkoposti(editedParticipant.getSahkoposti());
        
        // Tallenna ja palauta päivitetty osallistuja
        return osallistujaRepository.save(existingParticipant);
    }
}
