package com.contrasuli.service;

import com.contrasuli.domain.TabTarifa;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.contrasuli.dao.TabTarifaDao;


@Service
public class TabTarifaServicempl implements TabTarifaService{
    
    //Se crea en tiempo de ejecución si aún no se ha creado...
    @Autowired
    private TabTarifaDao tabTarifaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TabTarifa> getTabTarifaes() {
        var lista = (List<TabTarifa>) tabTarifaDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(TabTarifa tabTarifa) {
        tabTarifaDao.save(tabTarifa);
    }

    @Override
    @Transactional
    public void delete(TabTarifa tabTarifa) {
        tabTarifaDao.delete(tabTarifa);
    }

    @Override
    @Transactional(readOnly = true)
    public TabTarifa getTabTarifa(TabTarifa tabTarifa) {
        return tabTarifaDao.findById(tabTarifa.getTarId()).orElse(null);
    }
    
    
}
