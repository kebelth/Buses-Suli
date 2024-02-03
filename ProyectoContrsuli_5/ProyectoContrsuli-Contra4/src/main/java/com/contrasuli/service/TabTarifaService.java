package com.contrasuli.service;

import com.contrasuli.domain.TabTarifa;
import java.util.List;


public interface TabTarifaService {
    
    public List<TabTarifa> getTabTarifaes();
    
    public void save(TabTarifa tabTarifa);
    
    public void delete(TabTarifa tabTarifa);
    
    public TabTarifa getTabTarifa(TabTarifa tabTarifa);
    
}
