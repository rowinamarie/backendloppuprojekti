package loppuprojekti24.loppuprojekti.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import loppuprojekti24.loppuprojekti.domain.*;


@Controller
public class ViewTapahtumaController {

    @Autowired
    private TapahtumaRepository tapahtumaRepository;

    @Autowired
    private OsallistujaRepository osallistujaRepository;

    @Autowired
    private TapahtumaService tapahtumaService;

    // hakee kaikki tapahtumat näkymälistauksen
    @RequestMapping(value = { "/", "/lista" })
    public String getTapahtumat(Model model) {
        model.addAttribute("tapahtumat", tapahtumaRepository.findAll());
        return "tapahtumatLista";
    }

    // hakee tapahtuman lisäyslomakkeen
    // GET-metodi näyttää lomakkeen luomalla uuden Tapahtuma-objektin
    @GetMapping("/lomake")
    public String showTapahtumaForm(Model model) {
        Tapahtuma tapahtuma = new Tapahtuma();
        model.addAttribute("tapahtuma", tapahtuma); // Tapahtuma-objekti lomakkeelle
        model.addAttribute("osallistujat", osallistujaRepository.findAll()); // Olemassa olevat osallistujat
        model.addAttribute("uusiOsallistuja", new Osallistuja()); // Uusi osallistuja lomakkeelle
        return "tapahtumaLomake";
    }

    // tallentaa yksittaisen tapahtuman
    // POST-metodi tallentaa lomakkeen tiedot ja näyttää ne seuraavassa näkymässä.
@RequestMapping(value = "/lisaa", method = RequestMethod.POST)
public String lisaaTapahtuma(@ModelAttribute Tapahtuma tapahtuma,
                              @RequestParam Set<Long> osallistujaIds,  // Muutettu Set->List
                              @ModelAttribute Osallistuja uusiOsallistuja) {
    // Käännä Set List-tyyppiseksi
    List<Long> osallistujaIdsList = new ArrayList<>(osallistujaIds);
    tapahtumaService.lisaaOsallistujaTapahtumaan(tapahtuma.getId(), osallistujaIdsList, uusiOsallistuja);
    return "redirect:/tapahtumat";
}
    // Muokkaa yksittäistä tapahtumaa
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
        model.addAttribute("tapahtuma", tapahtumaRepository.findById(tapahtumaId));
        return "tapahtumaMuokkaa";
    }

    // yksittäisen tapahtuman poistaminen
    // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteTapahtuma(@PathVariable("id") Long tapahtumaId, Model model) {
        tapahtumaRepository.deleteById(tapahtumaId);
        return "redirect:../lista";
    }

    // viimeinen loppusulku
}
