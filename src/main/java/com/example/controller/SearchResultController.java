package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static java.lang.System.out;


@Controller
public class SearchResultController {
    @RequestMapping("/searchResult")
    private String doSave(@RequestParam String searchField,Model model){
        model.addAttribute("searchField", searchField);
        System.out.println(searchField);
        return "searchResult";
    }
}
