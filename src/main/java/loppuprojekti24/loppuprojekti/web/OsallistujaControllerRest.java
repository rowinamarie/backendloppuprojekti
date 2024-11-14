package loppuprojekti24.loppuprojekti.web;

import java.util.List;

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
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;

@RestController
@RequestMapping("/participants")
public class OsallistujaControllerRest {

    @Autowired
    OsallistujaRepository osallistujaRepository;

    @Autowired
    private OsallistujaService osallistujaService;
    

    // GET endpoint osallistujien hakemiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @GetMapping
    public List<Osallistuja> getAllParticipants() {
        return (List<Osallistuja>) osallistujaRepository.findAll();
    }

    // POST endpoint osallistujan lisäämiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @PostMapping
    public Osallistuja addParticipant(@RequestBody Osallistuja osallistuja) {
        return osallistujaRepository.save(osallistuja);
    }

    // PUT endpoint osallistujan muokkaamiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
@PutMapping("/{osallistujaId}")
public ResponseEntity<?> editParticipant(@Valid @RequestBody Osallistuja editedParticipant, BindingResult bindingResult, @PathVariable Long osallistujaId) {
    if (bindingResult.hasErrors()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors());
    }

    // Käytä palvelua osallistujan päivittämiseen
    Osallistuja updatedParticipant = osallistujaService.editParticipant(osallistujaId, editedParticipant);
    return ResponseEntity.status(HttpStatus.OK).body(updatedParticipant);
}


    // DELETE endpoint osallistujan poistamiseen
    @PreAuthorize("hasAuthority('OPETTAJA')")
    @DeleteMapping("/{osallistujaId}")
    public ResponseEntity<Object> deleteOsallistuja(@PathVariable Long osallistujaId) {
        osallistujaRepository.deleteById(osallistujaId); // Tämä poistaa entiteetin id:n perusteella
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
