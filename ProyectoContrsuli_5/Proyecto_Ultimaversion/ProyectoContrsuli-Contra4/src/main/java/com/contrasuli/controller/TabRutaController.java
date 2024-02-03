package com.contrasuli.controller;

import com.contrasuli.domain.TabRuta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.contrasuli.service.TabRutaService;

@Controller
@Slf4j
public class TabRutaController {

    @Autowired
    private TabRutaService tabRutaService;

    @GetMapping("/tabRuta/listado")
    public String listado(Model model) {       
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes",tabRutaes);
        return "/tabRuta/listado";
    }
    
    @GetMapping("/tabRuta/nuevo")
    public String nuevoTabRuta(TabRuta tabRuta){
        return "tabRuta/modificar";
    }
    
 @PostMapping("/tabRuta/guardar")
    public String guardarTabRuta(TabRuta tabRuta){
        tabRutaService.save(tabRuta);
        return "redirect:/tabRuta/listado";
    }
    
    @GetMapping("/tabRuta/modificar/{rutId}")
    public String modificarTabRuta(TabRuta tabRuta, Model model){
        tabRuta = tabRutaService.getTabRuta(tabRuta);
        model.addAttribute("tabRuta", tabRuta);
        return "tabRuta/modificar";
    }
    
    @GetMapping("/tabRuta/eliminar/{rutId}")
    public String eliminarTabRuta(TabRuta tabRuta){
        tabRutaService.delete(tabRuta);
        return "redirect:/tabRuta/listado";
    }
    
}
