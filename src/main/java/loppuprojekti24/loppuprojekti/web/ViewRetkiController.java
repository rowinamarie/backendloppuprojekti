package loppuprojekti24.loppuprojekti.web;

import org.springframework.beans.factory.annotation.Autowired;
// Import required classes and packages
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import loppuprojekti24.loppuprojekti.domain.RetkiRepository;


// Mark this class as a Controller to handle HTTP requests and views
@Controller
public class ViewRetkiController {

    @Autowired
    private RetkiRepository retkiRepository;


        @RequestMapping(value= {"/", "/retket"})
    public String studentList(Model model) {	
        model.addAttribute("retket", retkiRepository.findAll());
        return "retkilista";
    }

    // viimeinen sulku
}
