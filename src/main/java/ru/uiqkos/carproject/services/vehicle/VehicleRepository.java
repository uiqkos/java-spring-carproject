package ru.uiqkos.carproject.services.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public @Repository interface VehicleRepository extends JpaRepository<Vehicle, String> {}

