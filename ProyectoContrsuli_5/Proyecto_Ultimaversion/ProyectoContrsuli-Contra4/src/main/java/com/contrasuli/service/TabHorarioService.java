package com.contrasuli.service;

import com.contrasuli.domain.TabHorario;
import java.util.List;


public interface TabHorarioService {
    
    public List<TabHorario> getTabHorarioes();
    
    public void save(TabHorario tabHorario);
    
    public void delete(TabHorario tabHorario);
    
    public TabHorario getTabHorario(TabHorario tabHorario);
    
}
