package ru.uiqkos.carproject.services.trafficaccident;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "vehicleId")
    @JsonIdentityReference(alwaysAsId = true)
    private @ManyToOne Vehicle vehicle;
    private Date date;
    private String message;
}
