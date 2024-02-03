package com.contrasuli.service;

import com.contrasuli.domain.TabParada;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.contrasuli.dao.TabParadaDao;


@Service
public class TabParadaServicempl implements TabParadaService{
    
    //Se crea en tiempo de ejecución si aún no se ha creado...
    @Autowired
    private TabParadaDao tabParadaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TabParada> getTabParadaes() {
        var lista = (List<TabParada>) tabParadaDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(TabParada tabParada) {
        tabParadaDao.save(tabParada);
    }

    @Override
    @Transactional
    public void delete(TabParada tabParada) {
        tabParadaDao.delete(tabParada);
    }

    @Override
    @Transactional(readOnly = true)
    public TabParada getTabParada(TabParada tabParada) {
        return tabParadaDao.findById(tabParada.getIdParada()).orElse(null);
    }
    
    
}
