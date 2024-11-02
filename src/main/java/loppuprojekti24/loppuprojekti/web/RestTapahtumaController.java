package loppuprojekti24.loppuprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import loppuprojekti24.loppuprojekti.domain.Kaupunki;
import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

@RestController
public class RestTapahtumaController {
    
    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private KaupunkiRepository kaupunkiRepository;

// REST etsii kaikki tapahtumat
    @GetMapping("/tapahtumat")
    public @ResponseBody List<Tapahtuma> tapahtumaListRest() {	
        return (List<Tapahtuma>) tapahtumaRepository.findAll();
    }    

// REST etsii tapahtuman id:n perusteella
    @GetMapping("/tapahtumat/{id}")
    public @ResponseBody Optional<Tapahtuma> findTapahtumaRest(@PathVariable("id") Long tapahtumaId) {	
    	return tapahtumaRepository.findById(tapahtumaId);
    }   
    
    
// REST etsii kaikki kaupungit
    @GetMapping("/kaupungit")
    public @ResponseBody List<Kaupunki> kaupunkiListRest() {	
        return (List<Kaupunki>) kaupunkiRepository.findAll();
    } 
    
    // REST etsii kaupungin id:n perusteella
    @GetMapping("/kaupungit/{id}")
    public @ResponseBody Optional<Kaupunki> findKaupunkiRest(@PathVariable("id") Long kaupunkiid) {	
    	return kaupunkiRepository.findById(kaupunkiid);
    } 


}
