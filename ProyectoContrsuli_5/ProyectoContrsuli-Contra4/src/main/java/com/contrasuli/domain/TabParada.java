
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
@Table(name="tab_parada")
public class TabParada implements Serializable {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_parada")
    private Long idParada;
     int rutId;
    String parNombre;
    
  

    public TabParada() {
    }

   public TabParada(int rutId, String parNombre) {
        this.rutId = rutId;
        this.parNombre = parNombre;
    }

    
}
