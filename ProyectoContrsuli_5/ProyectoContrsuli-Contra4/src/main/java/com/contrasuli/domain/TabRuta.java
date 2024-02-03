package com.contrasuli.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="tab_ruta")
public class TabRuta implements Serializable {

    private static final long serialVersionUID = 1L;
     
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rut_id")
    @Id
    private Long rutId;
            
    int rutCod;
    
    String rutNombre;

    public TabRuta (){

    }

    public TabRuta(String rutNombre) {
        this.rutNombre = rutNombre;
    }

    
}
