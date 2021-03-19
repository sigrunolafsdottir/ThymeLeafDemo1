package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PetitionController {

    @GetMapping("/petition")
    public String petition() {
        System.out.println("in petition");
        return "petitionStart";
    }

    @GetMapping("/petitionSigned")
    public String thanks(@RequestParam String name,
                           @RequestParam String email,
                           Model model) {
        System.out.println("Underskrift från "+name +" "+ email);
        model.addAttribute("name", name);
        return "petitionThanks";
    }

}
