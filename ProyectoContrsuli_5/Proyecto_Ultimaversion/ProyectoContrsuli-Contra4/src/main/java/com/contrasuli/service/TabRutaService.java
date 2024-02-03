package com.contrasuli.service;

import com.contrasuli.domain.TabRuta;
import java.util.List;


public interface TabRutaService {
    
    public List<TabRuta> getTabRutaes();
    
    public void save(TabRuta tabRuta);
    
    public void delete(TabRuta tabRuta);
    
    public TabRuta getTabRuta(TabRuta tabRuta);
    
}
