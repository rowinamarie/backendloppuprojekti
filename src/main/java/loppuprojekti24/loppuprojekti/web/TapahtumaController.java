package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import loppuprojekti24.loppuprojekti.domain.Tapahtuma;
import loppuprojekti24.loppuprojekti.domain.TapahtumaRepository;


@Controller
public class TapahtumaController {

@Autowired
private TapahtumaRepository tapahtumaRepository;

//hakee tapahtuman lisäyslomakkeen
//GET-metodi näyttää lomakkeen luomalla uuden Tapahtuma-objektin
@GetMapping("/lisaaTapahtuma")
public String addTapahtuma(Model model) {
     model.addAttribute("tapahtuma", new Tapahtuma ());
    return "tapahtumaLomake";
}


// avaa yksittäisen tapahtuman, muokkaa polkua myöhemmin
//POST-metodi tallentaa lomakkeen tiedot ja näyttää ne seuraavassa näkymässä.
@PostMapping("/tapahtumaid")
	public String submitTapahtuma(@ModelAttribute Tapahtuma tapahtuma, Model model) {
		model.addAttribute("tapahtuma", tapahtuma);
		return "tapahtuma";
	}


// hakee kaikki tapahtumat listaukseen
@GetMapping ("/lista")
public String getTapahtumat (Model model) {
    model.addAttribute("tapahtumat", tapahtumaRepository.findAll());
    return "tapahtumatLista";
}


// viimeinen loppusulku
}


