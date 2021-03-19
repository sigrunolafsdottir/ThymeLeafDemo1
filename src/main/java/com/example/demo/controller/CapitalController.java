package com.example.demo.controller;

import com.example.demo.models.Capital;
import com.example.demo.models.Country;
import com.example.demo.repositories.CapitalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/capital")
public class CapitalController {

    private static final Logger log = LoggerFactory.getLogger(CapitalController.class);

        @Autowired
        private CapitalRepository capitalRepository;

        @GetMapping(path = "/add")
        public @ResponseBody String addNewCapital(@RequestParam String name) {

            log.info("A new Capital was added by name "+name);

            Capital n = new Capital();
            n.setName(name);
            capitalRepository.save(n);
            return name + " is Saved";
        }
/*
    @GetMapping("/addByView")
    public String formGreeting() {
        return "addCapital";
    }
 */

    @GetMapping("/addByView")
    public String formGreeting(Model model) {
        Capital cap = new Capital();
        model.addAttribute("capital", cap);
        return "addCapitalThymeLeaf";
    }

    @GetMapping(path = "/getAllAfterAddByView")
    public String addNewCapitalByView(@RequestParam String name, Model model) {
        Capital n = new Capital();
        n.setName(name);
        capitalRepository.save(n);
        return getAllCapitalsByView(model);
    }

        @GetMapping(path="/all")
        public @ResponseBody Iterable<Capital> getAllCapitals() {
            log.info("All capitals displayed" );
            return capitalRepository.findAll();
        }

    @GetMapping(path="/allByView")
    public String getAllCapitalsByView(Model model) {
        Iterable<Capital> allCapitals = capitalRepository.findAll();
        model.addAttribute("allCapitals", allCapitals);
        model.addAttribute("capitalListTitle", "Alla huvudstäder");
        model.addAttribute("tableTitle_id", "Id");
        model.addAttribute("tableTitle_capital", "Huvudstad");
        //return "allCapitalListing";
        return "allCapitalListingDelete";
        //return "allCapitalListingEditDelete";
    }

    @GetMapping(path="/getById")
    public @ResponseBody Capital getCapById(@RequestParam Long id) {
        return capitalRepository.findById(id).get();
    }

    @GetMapping(path="/deleteById/{id}")
    public String deleteCap(@PathVariable Long id, Model model) {
        capitalRepository.deleteById(id);
        return getAllCapitalsByView(model);
    }

    @GetMapping("/editByView/{id}")
    public String editByView(Model model, @PathVariable Long id) {
        Capital cap = capitalRepository.findById(id).get();
        model.addAttribute("capital", cap);
        return "editCapitalThymeLeaf";
    }

    @PostMapping(path="/update")
    public String editCap(@ModelAttribute Capital cap, Model model) {
        capitalRepository.save(cap);
        return getAllCapitalsByView(model);
    }



}
