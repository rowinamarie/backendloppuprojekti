package loppuprojekti24.loppuprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;

@RestController
@RequestMapping("/trips")
public class RetkiControllerRest {

    @Autowired
    private RetkiRepository retkiRepository;

    @Autowired
    private KaupunkiRepository kaupunkiRepository;

    // GET endpoint retketn hakemiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @GetMapping
    public List<Retki> getAllRetket() {
        return (List<Retki>) retkiRepository.findAll();
    }

    // POST endpoint retken lisäämiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @PostMapping
    public Retki addRetki(@RequestBody Retki retki) {
        return retkiRepository.save(retki);
    }

    // PUT endpoint retken muokkaamiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @PutMapping("/{retkiId}")
    public ResponseEntity<?> editRetki(@Valid @RequestBody Retki editedRetki, BindingResult bindingResult,
            @PathVariable Long retkiId) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
        }

        // Etsii olemassa olevan retken id:n perusteella
        Optional<Retki> existingRetkiOptional = retkiRepository.findById(retkiId);
        if (existingRetkiOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Retki with id " + retkiId + " not found.");
        }

        Retki existingRetki = existingRetkiOptional.get();

        // Päivitä olemassa olevan Retki -entiteetin kentät
        existingRetki.setRetkinimi(editedRetki.getRetkinimi());
        existingRetki.setKuvaus(editedRetki.getKuvaus());
        existingRetki.setPaivamaara(editedRetki.getPaivamaara());


    // Tässä varmistetaan, että kaupunkiId liitetään oikeaan kaupunkiin
    if (editedRetki.getKaupunki() != null && editedRetki.getKaupunki().getKaupunkiId() != null) {
        Optional<Kaupunki> kaupunkiOptional = kaupunkiRepository.findById(editedRetki.getKaupunki().getKaupunkiId());
        if (kaupunkiOptional.isPresent()) {
            existingRetki.setKaupunki(kaupunkiOptional.get());
        }
    }

        // Tallentaa päivitetyn entiteetin
        Retki updatedRetki = retkiRepository.save(existingRetki);

        return ResponseEntity.status(HttpStatus.OK).body(updatedRetki);
    }

    // DELETE endpoint retken poistamiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @DeleteMapping("/{retkiId}")
    public ResponseEntity<Object> deleteRetki(@PathVariable Long retkiId) {
        retkiRepository.deleteById(retkiId); // Tämä poistaa entiteetin id:n perusteella
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
