package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;


@Controller
public class TapahtumaController {

@Autowired
private TapahtumaRepository tapahtumaRepository;

// hakee kaikki tapahtumat listaukseen
@GetMapping ("/lista")
public String getTapahtumat (Model model) {
    model.addAttribute("tapahtumat", tapahtumaRepository.findAll());
    return "tapahtumatLista";
}


//hakee tapahtuman lisäyslomakkeen
//GET-metodi näyttää lomakkeen luomalla uuden Tapahtuma-objektin
@GetMapping("/lomake")
public String addTapahtuma(Model model) {
     model.addAttribute("tapahtuma", new Tapahtuma ());
    return "tapahtumaLomake";
}


// tallentaa yksittaisen tapahtuman
//POST-metodi tallentaa lomakkeen tiedot ja näyttää ne seuraavassa näkymässä.
@PostMapping("/lisaa")
	public String submitTapahtuma(Tapahtuma tapahtuma) {
		tapahtumaRepository.save(tapahtuma);
		return "tapahtuma";
	}


//Poistaa yksittäisen tapahtuman
 @GetMapping("/delete/{id}")
    public String deleteTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
    	tapahtumaRepository.deleteById(tapahtumaId);
        return "redirect:../lista";
    }    



// viimeinen loppusulku
}


