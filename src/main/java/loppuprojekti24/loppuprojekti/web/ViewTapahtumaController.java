package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;

@Controller
public class ViewTapahtumaController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private KaupunkiRepository kaupunkiRepository;


//kirjautuminen
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

// hakee kaikki tapahtumat näkymälistauksen
    @RequestMapping(value = {"/", "/lista"})
    public String getTapahtumat(Model model) {
        model.addAttribute("tapahtumat", tapahtumaRepository.findAll());
        return "tapahtumatLista";
    }

//hakee tapahtuman lisäyslomakkeen
//GET-metodi näyttää lomakkeen luomalla uuden Tapahtuma-objektin
    @RequestMapping(value = "/lomake")
    public String addTapahtuma(Model model) {
        model.addAttribute("tapahtuma", new Tapahtuma());
        model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "tapahtumaLomake";
    }

// tallentaa yksittaisen tapahtuman
//POST-metodi tallentaa lomakkeen tiedot ja näyttää ne seuraavassa näkymässä.
    @RequestMapping(value = "/lisaa", method = RequestMethod.POST)
    public String submitTapahtuma(Tapahtuma tapahtuma) {
        tapahtumaRepository.save(tapahtuma);
        return "tapahtuma";
    }


// Muokkaa yksittäistä tapahtumaa
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
    	model.addAttribute("tapahtuma", tapahtumaRepository.findById(tapahtumaId));
    	model.addAttribute("kaupungit", kaupunkiRepository.findAll());
    	return "tapahtumaMuokkaa";
    }   


//yksittäisen tapahtuman poistaminen
 // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
    	tapahtumaRepository.deleteById(tapahtumaId);
        return "redirect:../lista";
    }     

// viimeinen loppusulku
}
