package com.contrasuli.controller;

import com.contrasuli.domain.TabBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.contrasuli.service.TabBusService;
import com.contrasuli.service.TabRutaService;

@Controller
@Slf4j
public class TabBusController {

    @Autowired
    private TabBusService tabBusService;
    
    @Autowired
    private TabRutaService tabRutaService;

    @GetMapping("/tabBus/listado")
    public String inicio(Model model) {       
        var tabBuses = tabBusService.getTabBuses();
        model.addAttribute("tabBuses",tabBuses);
        return "tabBus/listado";
    }
    
  @GetMapping("/tabBus/nuevo")
    public String nuevoTabBus(TabBus tabBus, Model model){
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes", tabRutaes);
        return "tabBus/modificar";
    }
    
    
    @PostMapping("/tabBus/guardar")
    public String guardarTabBus(TabBus tabBus){
        tabBusService.save(tabBus);
        return "redirect:/tabBus/listado";
    }
    
    @GetMapping("/tabBus/modificar/{busId}")
    public String modificarTabBus(TabBus tabBus, Model model){
        tabBus = tabBusService.getTabBus(tabBus);
        model.addAttribute("tabBus", tabBus);
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutas", tabRutaes);
        return "tabBus/modificar";
    }
    
    @GetMapping("/tabBus/eliminar/{busId}")
    public String eliminarTabBus(TabBus tabBus){
        tabBusService.delete(tabBus);
        return "redirect:/tabBus/listado";
    }
    
}
