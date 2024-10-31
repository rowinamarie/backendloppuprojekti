package loppuprojekti24.loppuprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TapahtumaController {

@RequestMapping("/")
@ResponseBody
public String returnTapahtumat() {
    return "Listataan tähän tapahtumat automaattisesti";
}


@RequestMapping("osallistujat")
@ResponseBody
public String returnOsallistujat(@RequestParam (name="nimesi") String etunimi) {
    return "Hei " + etunimi;
}


// viimeinen loppusulku
}


