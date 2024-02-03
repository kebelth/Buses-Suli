package com.contrasuli.service;

import com.contrasuli.domain.TabBus;
import java.util.List;


public interface TabBusService {
    
  public List<TabBus> getTabBuses();
    
    public void save(TabBus tabBus);
    
    public void delete(TabBus tabBus);
    
    public TabBus getTabBus(TabBus tabBus);
    
    public TabBus getByRutId (int ruta);
    
}
