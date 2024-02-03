package com.contrasuli.dao;

import com.contrasuli.domain.TabBus;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface TabBusDao extends CrudRepository<TabBus, Long> {

         public List<TabBus> findByRutId(int ruta);
}
