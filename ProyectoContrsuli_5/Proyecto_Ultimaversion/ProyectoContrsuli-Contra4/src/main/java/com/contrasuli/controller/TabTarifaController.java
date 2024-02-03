package com.contrasuli.controller;

import com.contrasuli.domain.TabTarifa;
import com.contrasuli.service.TabParadaService;
import com.contrasuli.service.TabRutaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.contrasuli.service.TabTarifaService;

@Controller
@Slf4j
public class TabTarifaController {

    @Autowired
    private TabTarifaService tabTarifaService;

    @Autowired
    private TabRutaService tabRutaService;

    @Autowired
    private TabParadaService tabParadaService;

    @GetMapping("/tabTarifa/listado")
    public String inicio(Model model) {       
        var tabTarifaes = tabTarifaService.getTabTarifaes();
        model.addAttribute("tabTarifaes",tabTarifaes);
        return "tabTarifa/listado";
    }
    @GetMapping("/tabTarifa/nuevo")
    public String nuevoTabTarifa(TabTarifa tabTarifa, Model model){
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes", tabRutaes);
        var tabParadaes = tabParadaService.getTabParadaes();
        model.addAttribute("tabParadaes", tabParadaes);
        return "tabTarifa/modificar";
    }
    
    @PostMapping("/tabTarifa/guardar")
    public String guardarTabTarifa(TabTarifa tabTarifa){
        tabTarifaService.save(tabTarifa);
        return "redirect:/tabTarifa/listado";
    }
    
    @GetMapping("/tabTarifa/modificar/{tarId}")
    public String modificarTabTarifa(TabTarifa tabTarifa, Model model){
        tabTarifa = tabTarifaService.getTabTarifa(tabTarifa);
        model.addAttribute("tabTarifa", tabTarifa);
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes", tabRutaes);
        var tabParadaes = tabParadaService.getTabParadaes();
        model.addAttribute("tabParadaes", tabParadaes);
        return "tabTarifa/modificar";
    }
    
    @GetMapping("/tabTarifa/eliminar/{tarId}")
    public String eliminarTabTarifa(TabTarifa tabTarifa){
        tabTarifaService.delete(tabTarifa);
        return "redirect:/tabTarifa/listado";
    }
    
}
