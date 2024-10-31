package loppuprojekti24.loppuprojekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TapahtumaController {

@RequestMapping("/")
@ResponseBody
public String returnMessage() {
    return "Kokeilen että toimii";
}

}
