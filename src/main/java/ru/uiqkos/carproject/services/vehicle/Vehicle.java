package ru.uiqkos.carproject.services.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Integer vehicleId;
    private String make;
    private String model;
    private String bodyType;
    private Integer modelYear;
    private Double price;
}