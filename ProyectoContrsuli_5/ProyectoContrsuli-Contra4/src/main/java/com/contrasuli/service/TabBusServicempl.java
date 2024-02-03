package com.contrasuli.service;

import com.contrasuli.domain.TabBus;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.contrasuli.dao.TabBusDao;


@Service
public class TabBusServicempl implements TabBusService{
    
    //Se crea en tiempo de ejecución si aún no se ha creado...
    @Autowired
    private TabBusDao tabBusDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TabBus> getTabBuses() {
        var lista = (List<TabBus>) tabBusDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(TabBus tabBus) {
        tabBusDao.save(tabBus);
    }

    @Override
    @Transactional
    public void delete(TabBus tabBus) {
        tabBusDao.delete(tabBus);
    }

    @Override
    @Transactional(readOnly = true)
    public TabBus getTabBus(TabBus tabBus) {
        return tabBusDao.findById(tabBus.getBusId()).orElse(null);
    }
    
     @Override
    @Transactional(readOnly = true)
    public TabBus getByRutId (int ruta){
        return ((List<TabBus>) tabBusDao.findByRutId(ruta)).get(0);
    }
}
