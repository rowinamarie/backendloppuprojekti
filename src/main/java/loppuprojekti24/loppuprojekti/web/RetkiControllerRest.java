package loppuprojekti24.loppuprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;



@RestController
public class RetkiControllerRest {

    @Autowired
    private RetkiRepository retkiRepository;

        // GET endpoint kaupungin hakemiseen
    @GetMapping("/trips")
    public List<Retki> getAllRetket() {
        return (List<Retki>) retkiRepository.findAll();
    }

    // POST endpoint kaupungin lisäämiseen
    @PostMapping ("/trips")
    public Retki addRetki(@RequestBody Retki retki) {
        return retkiRepository.save(retki);
    }


}
