package loppuprojekti24.loppuprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import loppuprojekti24.loppuprojekti.domain.Tapahtuma;



@Controller
public class TapahtumaController {

@RequestMapping("/tapahtumat")
public String lista(@RequestParam (name= "parametrinnimi") String tapahtuma, Model model) {
    model.addAttribute("tapahtuma", tapahtuma);
    return "tapahtumatSivu";


}


@GetMapping("/lisaaTapahtuma")
public String addTapahtuma(@ModelAttribute Tapahtuma tapahtuma, Model model) {
     model.addAttribute("tapahtuma", tapahtuma);
    
    return "tapahtumaLomake";
}



// viimeinen loppusulku
}


