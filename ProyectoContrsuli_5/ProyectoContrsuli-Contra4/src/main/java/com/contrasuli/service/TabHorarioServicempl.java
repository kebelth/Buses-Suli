package com.contrasuli.service;

import com.contrasuli.domain.TabHorario;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.contrasuli.dao.TabHorarioDao;


@Service
public class TabHorarioServicempl implements TabHorarioService{
    
    //Se crea en tiempo de ejecución si aún no se ha creado...
    @Autowired
    private TabHorarioDao tabHorarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<TabHorario> getTabHorarioes() {
        var lista = (List<TabHorario>) tabHorarioDao.findAll();
        return lista;
    }

    @Override
    @Transactional
    public void save(TabHorario tabHorario) {
        tabHorarioDao.save(tabHorario);
    }

    @Override
    @Transactional
    public void delete(TabHorario tabHorario) {
        tabHorarioDao.delete(tabHorario);
    }

    @Override
    @Transactional(readOnly = true)
    public TabHorario getTabHorario(TabHorario tabHorario) {
        return tabHorarioDao.findById(tabHorario.getHorCodigo()).orElse(null);
    }
    
    
}
