
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
@Table(name="tab_bus")
public class TabBus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bus_id")
    private Long busId;
    
    int busUnidad;
    int rutId;
    int busCapacidad;
    
  

    public TabBus() {
    }

   
public TabBus(int busUnidad, int rutId, int busCapacidad) {
        this.busUnidad = busUnidad;
        this.rutId = rutId;
        this.busCapacidad = busCapacidad;
    }   
    
    
    
    
    
}
