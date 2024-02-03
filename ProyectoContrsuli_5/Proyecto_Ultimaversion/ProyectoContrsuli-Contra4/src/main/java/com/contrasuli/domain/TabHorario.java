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
@Table(name="tab_horario")
public class TabHorario implements Serializable {
    //Para utilizarlo en la generación de la llave primaria autoincremental
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hor_codigo")
    private Long horCodigo;
    
    int rutId;
    int busId;
    String horHora;
    String horServicio;
    

            
    public TabHorario (){

    }

    public TabHorario(int rutId, int busId, String horHora, String horServicio) {
        this.rutId = rutId;
        this.busId = busId;
        this.horHora = horHora;
        this.horServicio = horServicio;
    }


    

    
}
