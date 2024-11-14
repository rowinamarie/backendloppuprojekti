package loppuprojekti24.loppuprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;

@RestController
public class KaupunkiControllerRest {
    
    @Autowired
    private KaupunkiRepository kaupunkiRepository;


    // GET endpoint kaupungin hakemiseen
    @GetMapping("/cities")
    public List<Kaupunki> getAllKaupungit() {
        return (List<Kaupunki>) kaupunkiRepository.findAll();
    }

    // POST endpoint kaupungin lisäämiseen
    @PostMapping ("/cities")
    public Kaupunki addKaupunki(@RequestBody Kaupunki kaupunki) {
        return kaupunkiRepository.save(kaupunki);
    }

}
