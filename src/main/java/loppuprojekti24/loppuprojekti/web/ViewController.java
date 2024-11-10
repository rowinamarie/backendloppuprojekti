package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
// Import required classes and packages
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import loppuprojekti24.loppuprojekti.domain.KaupunkiRepository;
import loppuprojekti24.loppuprojekti.domain.Osallistuja;
import loppuprojekti24.loppuprojekti.domain.OsallistujaRepository;
import loppuprojekti24.loppuprojekti.domain.Retki;
import loppuprojekti24.loppuprojekti.domain.RetkiRepository;

// Mark this class as a Controller to handle HTTP requests and views
@Controller
public class ViewController {

    @Autowired
    private RetkiRepository retkiRepository;

    @Autowired
    private KaupunkiRepository kaupunkiRepository;

    @Autowired
    private OsallistujaRepository osallistujaRepository;

    // RETKEN NÄKYMÄT

    // Hakee view -näkymän kaikista retkistä
    @RequestMapping(value = { "/", "/retket" })
    public String studentList(Model model) {
        model.addAttribute("retket", retkiRepository.findAll());
        return "retkilista";
    }

    // näyttää retkilomakkeen
    @RequestMapping(value = "/lisaa")
    public String addTrip(Model model) {
        model.addAttribute("retki", new Retki());
        model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "lisaaRetki";
    }

    // Tallentaa retken lomakkeella
    @PostMapping("/tallennaretki")
    public String saveTripForm(Retki retki) {
        retkiRepository.save(retki);
        return "redirect:retket";
    }

    //Näyttää retken muokkauslomakkeen
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") Long retkiId, Model model) {
        // Hae retki id:n perusteella tietokannasta
        Retki retki = retkiRepository.findById(retkiId).orElseThrow(() -> new IllegalArgumentException("Invalid retki ID: " + retkiId));
        model.addAttribute("retki", retki);
        model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "muokkaaRetki"; // palautetaan lomake
    }
    
    //Muokkaa retkeä
    @PostMapping("/edit/{id}")
    public String saveEditedTrip(@PathVariable("id") Long retkiId, Retki retki) {
        retki.setRetkiId(retkiId); // Varmistetaan, että oikea id on mukana
        retkiRepository.save(retki); // Tallennetaan muutokset
        return "redirect:/retket"; // Siirretään takaisin retkilistalle
    }
    



    // Poistaa retken
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTrip(@PathVariable("id") Long retkiId, Model model) {
        retkiRepository.deleteById(retkiId);
        return "redirect:../retket";
    }


    // OSALLISTUJAN NÄKYMÄT

    // näyttää osallistumislomakkeen
    @RequestMapping(value = "/osallistu")
    public String addParticipant(Model model) {
        model.addAttribute("osallistuja", new Osallistuja());
        model.addAttribute("retket", retkiRepository.findAll());
        return "osallistujaLomake";
    }

     // Tallentaa osallistujalomakkeen
     @PostMapping("/tallennaosallistuja")
     public String saveOsallistuja(Osallistuja osallistuja) {
         osallistujaRepository.save(osallistuja);
         return "redirect:retket";
     }

     

    // viimeinen sulku
}
