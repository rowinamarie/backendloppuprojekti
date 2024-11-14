package loppuprojekti24.loppuprojekti.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;



@RestController
@RequestMapping("/trips")
public class RetkiControllerRest {

    @Autowired
    private RetkiRepository retkiRepository;

    // GET endpoint kaupungin hakemiseen
    @PreAuthorize ("hasAuthority('OPETTAJA')")
    @GetMapping
    public List<Retki> getAllRetket() {
        return (List<Retki>) retkiRepository.findAll();
    }

    // POST endpoint kaupungin lisäämiseen
    @PostMapping ("")
    public Retki addRetki(@RequestBody Retki retki) {
        return retkiRepository.save(retki);
    }

    


}
