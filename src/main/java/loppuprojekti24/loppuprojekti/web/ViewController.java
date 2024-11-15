package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
// Import required classes and packages
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
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
    @PreAuthorize("hasAuthority('OPETTAJA') or hasAuthority('OPPILAS')")
    public String showAllTrips(Model model) {
        model.addAttribute("retket", retkiRepository.findAll());
        return "retkilista";
    }

    // näyttää retkilomakkeen

    @RequestMapping(value = "/lisaa")
    @PreAuthorize("hasAuthority('OPETTAJA') or hasAuthority('OPPILAS')")
    public String addTrip(Model model) {
        model.addAttribute("retki", new Retki());
        model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "lisaaRetki";
    }

    // Tallentaa retken lomakkeella
    @PostMapping("/tallennaretki")
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String saveTripForm(@Valid Retki retki, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("kaupungit", kaupunkiRepository.findAll());
            System.out.println("Error errors" + retki);
            return "lisaaRetki";

        }

        retkiRepository.save(retki);
        return "retkenTiedot";
    }

    // näyttää yksittäisen retken tiedot
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String showTrip(@PathVariable("id") Long retkiId, Model model) {
        Retki retki = retkiRepository.findById(retkiId)
                .orElseThrow(() -> new ResourceNotFoundException("Retki not found"));
        model.addAttribute("retki", retki); // Lisätään yksittäinen retki malliin
        return "retkenTiedot"; // Tämä on HTML-sivun nimi (esim. retkenTiedot.html)
    }

    // Näyttää retken muokkauslomakkeen
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String showEditForm(@PathVariable("id") Long retkiId, Model model) {
        // Hae retki id:n perusteella tietokannasta
        Retki retki = retkiRepository.findById(retkiId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid retki ID: " + retkiId));

        System.out.println("Paivamaara: " + retki.getPaivamaara());

        model.addAttribute("retki", retki);
        model.addAttribute("kaupungit", kaupunkiRepository.findAll());
        return "muokkaaRetki"; // palautetaan lomake
    }

    // Tallentaa muokatun retket
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String updateRetki(@PathVariable Long id, @ModelAttribute Retki updatedRetki, Model model) {
        Retki existingRetki = retkiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Retki not found"));

        // Päivietään vain tarvittavat kentät
        existingRetki.setRetkinimi(updatedRetki.getRetkinimi());
        existingRetki.setKuvaus(updatedRetki.getKuvaus());
        existingRetki.setPaivamaara(updatedRetki.getPaivamaara());

        // osallistujat pysyvät sellaisinaan
        retkiRepository.save(existingRetki);

        // Siirretään päivitetty retki malliin
        model.addAttribute("retki", existingRetki);

        // Ohjataan näyttämään retken tiedot
        return "retkenTiedot";
    }

    // Poistaa retken
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String deleteTrip(@PathVariable("id") Long retkiId, Model model) {
        retkiRepository.deleteById(retkiId);
        return "redirect:../retket";
    }

    // OSALLISTUJAN NÄKYMÄT

    // näyttää osallistumislomakkeen
    @RequestMapping(value = "/osallistu")
    @PreAuthorize("hasAuthority('OPETTAJA') or hasAuthority('OPPILAS')")
    public String addParticipant(Model model) {
        model.addAttribute("osallistuja", new Osallistuja());
        model.addAttribute("retket", retkiRepository.findAll());
        return "osallistujaLomake";
    }

    // Tallentaa osallistujalomakkeen
    @PostMapping("/tallennaosallistuja")
    @PreAuthorize("hasAuthority('OPETTAJA') or hasAuthority('OPPILAS')")
    public String saveOsallistuja(@Valid Osallistuja osallistuja, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Virheellinen osallistuja: " + osallistuja);

            // Palautetaan lomake virheilmoituksilla
            model.addAttribute("retket", retkiRepository.findAll());

            return "osallistujaLomake";
        }
        osallistujaRepository.save(osallistuja);
        return "redirect:retket";
    }

    // näyttää yhden retken kaikki osallistujat
    @RequestMapping(value = "/osallistujat/{id}")
    @PreAuthorize("hasAuthority('OPETTAJA')")
    public String showParticipants(@PathVariable("id") Long retkiId, Model model) {
        // Etsi retki ID:n perusteella
        Retki retki = retkiRepository.findById(retkiId)
                .orElseThrow(() -> new ResourceNotFoundException("Retki not found"));

        // Lisää retki ja sen osallistujat malliin
        model.addAttribute("retki", retki);

        // Palauta oikea näkymä
        return "naytaOsallistujat"; // HTML-sivun nimi
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // viimeinen sulku
}
