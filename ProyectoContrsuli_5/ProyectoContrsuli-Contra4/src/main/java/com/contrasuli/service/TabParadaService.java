package com.contrasuli.service;

import com.contrasuli.domain.TabParada;
import java.util.List;


public interface TabParadaService {
    
    public List<TabParada> getTabParadaes();
    
    public void save(TabParada tabParada);
    
    public void delete(TabParada tabParada);
    
    public TabParada getTabParada(TabParada tabParada);
    
}
