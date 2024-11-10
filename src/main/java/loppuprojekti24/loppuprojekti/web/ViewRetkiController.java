package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
// Import required classes and packages
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;

// Mark this class as a Controller to handle HTTP requests and views
@Controller
public class ViewRetkiController {

    @Autowired
    private RetkiRepository retkiRepository;

    @Autowired
    private KaupunkiRepository kaupunkiRepository;


    // Hakee view -näkymän kaikista retkistä
    @RequestMapping(value = { "/", "/retket" })
    public String studentList(Model model) {
        model.addAttribute("retket", retkiRepository.findAll());
        return "retkilista";
    }


    // näyttää retkilomakkeen
    @RequestMapping(value = "/lisaa")
    public String addTrip(Model model){
    	model.addAttribute("retki", new Retki());
    	model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "lisaaRetki";
    }


    //Tallentaa retken lomakkeella
    @PostMapping("/save")
    public String saveForm(Retki retki) {
        retkiRepository.save(retki);
        return "redirect:retket";
    }
    
 

    

    // viimeinen sulku
}
