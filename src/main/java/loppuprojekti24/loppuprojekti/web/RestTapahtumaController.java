package loppuprojekti24.loppuprojekti.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

@RestController
public class RestTapahtumaController {
    
    @Autowired
    private TapahtumaRepository tapahtumaRepository;


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
    
    



}