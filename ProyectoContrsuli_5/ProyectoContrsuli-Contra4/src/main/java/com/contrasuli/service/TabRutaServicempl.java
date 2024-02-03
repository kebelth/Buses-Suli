package com.contrasuli.service;

import com.contrasuli.domain.TabRuta;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.contrasuli.dao.TabRutaDao;

@Service
public class TabRutaServicempl implements TabRutaService{
    
    //Se crea en tiempo de ejecución si aún no se ha creado...
    @Autowired
    private TabRutaDao tabRutaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TabRuta> getTabRutaes() {
        var lista = (List<TabRuta>) tabRutaDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(TabRuta tabRuta) {
        tabRutaDao.save(tabRuta);
    }

    @Override
    @Transactional
    public void delete(TabRuta tabRuta) {
        tabRutaDao.delete(tabRuta);
    }

    @Override
    @Transactional(readOnly = true)
    public TabRuta getTabRuta(TabRuta tabRuta) {
        return tabRutaDao.findById(tabRuta.getRutId()).orElse(null);
    }
    
    
}
