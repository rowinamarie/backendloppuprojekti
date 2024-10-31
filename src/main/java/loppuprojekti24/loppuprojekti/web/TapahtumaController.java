package loppuprojekti24.loppuprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TapahtumaController {

@RequestMapping("/tapahtumat")
public String lista(@RequestParam (name= "parametrinnimi") String tapahtuma, Model model) {
    model.addAttribute("tapahtuma", tapahtuma);
    return "tapahtumatSivu";
}


@RequestMapping("osallistujat")
@ResponseBody
public String returnOsallistujat(@RequestParam (name="nimesi", required = false, defaultValue= "kirjoita nimesi ") String etunimi) {
    return "Hei " + etunimi;
}


// viimeinen loppusulku
}


