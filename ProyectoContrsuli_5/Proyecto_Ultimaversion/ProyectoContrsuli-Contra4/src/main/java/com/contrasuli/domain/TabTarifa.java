package com.contrasuli.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="tab_tarifa")
public class TabTarifa implements Serializable {
//Para utilizarlo en la generación de la llave primaria autoincremental
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tar_id")
    private Long tarId;

    double tarPrecio;
    int idParada;
    int rutId;
    
 

    public TabTarifa (){

    }

 public TabTarifa(double tarPrecio, int idParada, int rutId) {
        this.tarPrecio = tarPrecio;
        this.idParada = idParada;
        this.rutId = rutId;
    }
    

   
}
