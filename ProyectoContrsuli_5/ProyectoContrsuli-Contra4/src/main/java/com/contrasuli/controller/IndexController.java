package com.contrasuli.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
        
   @GetMapping("/")
    public String inicio(Model model) {           
        return "index";
    }
        
    @GetMapping("/about/empresa")
    public String about(Model model) {           
        return "/about/empresa";
    }
    
     
 
    
}
