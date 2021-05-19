package ru.uiqkos.carproject.services.vehicle;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uiqkos.carproject.services.trafficaccident.TrafficAccident;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Integer vehicleId;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "trafficAccidentId")
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<TrafficAccident> trafficAccidents;

    private String make;
    private String model;
    private String bodyType;
    private Integer modelYear;
    private Double price;
}