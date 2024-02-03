package com.contrasuli.controller;

import com.contrasuli.domain.TabHorario;
import com.contrasuli.service.TabBusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.contrasuli.service.TabHorarioService;
import com.contrasuli.service.TabRutaService;

@Controller
@Slf4j
public class TabHorarioController {

    @Autowired
    private TabHorarioService tabHorarioService;

    @Autowired
    private TabRutaService tabRutaService;

    @Autowired
    private TabBusService tabBusService;

    @GetMapping("/tabHorario/listado")
    public String inicio(Model model) {       
        var tabHorarioes = tabHorarioService.getTabHorarioes();
        model.addAttribute("tabHorarioes",tabHorarioes);
        return "tabHorario/listado";
    }
  @GetMapping("/tabHorario/nuevo")
    public String nuevoTabHorario(TabHorario tabHorario, Model model){
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes", tabRutaes);
        var tabBuses = tabBusService.getTabBuses();
        model.addAttribute("tabBuses", tabBuses);
        return "tabHorario/modificar";
    }
    
    @PostMapping("/tabHorario/guardar")
    public String guardarTabHorario(TabHorario tabHorario){
        tabHorarioService.save(tabHorario);
        return "redirect:/tabHorario/listado";
    }
    
    @GetMapping("/tabHorario/modificar/{horCodigo}")
    public String modificarTabHorario(TabHorario tabHorario, Model model){
        tabHorario = tabHorarioService.getTabHorario(tabHorario);
        model.addAttribute("tabHorario", tabHorario);
        var tabRutaes = tabRutaService.getTabRutaes();
        model.addAttribute("tabRutaes", tabRutaes);
        var tabBuses = tabBusService.getTabBuses();
        model.addAttribute("tabBuses", tabBuses);
        return "tabHorario/modificar";
    }
    
    @GetMapping("/tabHorario/eliminar/{horCodigo}")
    public String eliminarTabHorario(TabHorario tabHorario){
        tabHorarioService.delete(tabHorario);
        return "redirect:/tabHorario/listado";
    }
    
}
