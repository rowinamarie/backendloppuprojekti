package loppuprojekti24.loppuprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;

@RestController
public class OsallistujaControllerRest {


@Autowired
OsallistujaRepository osallistujaRepository;

    // GET endpoint osallistujien hakemiseen
    @GetMapping("/participants")
    public List<Osallistuja> getAllParticipants() {
        return (List<Osallistuja>) osallistujaRepository.findAll();
    }

    // POST endpoint kaupungin lisäämiseen
    @PostMapping ("/participants")
    public Osallistuja addOsallistuja(@RequestBody Osallistuja osallistuja) {
        return osallistujaRepository.save(osallistuja);
    }

}
