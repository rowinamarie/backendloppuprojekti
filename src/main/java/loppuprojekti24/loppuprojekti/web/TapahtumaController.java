package loppuprojekti24.loppuprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import loppuprojekti24.loppuprojekti.domain.Tapahtuma;


@Controller
public class TapahtumaController {

//hakee tapahtuman lisäyslomakkeen
//GET-metodi näyttää lomakkeen luomalla uuden Tapahtuma-objektin
@GetMapping("/lisaaTapahtuma")
public String addTapahtuma(Model model) {
     model.addAttribute("tapahtuma", new Tapahtuma ());
    return "tapahtumaLomake";
}

// avaa yksittäisen tapahtuman, muokkaa polkua myöhemmin
//POST-metodi tallentaa lomakkeen tiedot ja näyttää ne seuraavassa näkymässä.
@PostMapping("/tapahtumaLista")
	public String submitTapahtuma(@ModelAttribute Tapahtuma tapahtuma, Model model) {
		model.addAttribute("tapahtuma", tapahtuma);
		return "tapahtumatLista";
	}


// viimeinen loppusulku
}


