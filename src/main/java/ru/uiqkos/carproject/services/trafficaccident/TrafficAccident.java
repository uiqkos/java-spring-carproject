package ru.uiqkos.carproject.services.trafficaccident;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uiqkos.carproject.services.vehicle.Vehicle;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class TrafficAccident {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Integer trafficAccidentId;

    private @ManyToOne Vehicle vehicle;
    private Date date;
    private String message;
}
