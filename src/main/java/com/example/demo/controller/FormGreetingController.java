package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormGreetingController {

    @GetMapping("/formGreeting")
    public String formGreeting() {
        System.out.println("in form Greeting");
        return "formGreetingStart";
    }

    @GetMapping("/formGreetingThanks")
    public String thanks(@RequestParam String fname,
                           @RequestParam String lname,
                           Model model) {
        System.out.println("Hej från "+fname +" "+ lname);
        model.addAttribute("fname", fname);
        model.addAttribute("lname", lname);
        return "formGreetingThanks";
    }

}
