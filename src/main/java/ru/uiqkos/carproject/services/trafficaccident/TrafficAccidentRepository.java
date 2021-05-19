package ru.uiqkos.carproject.services.trafficaccident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.uiqkos.carproject.services.vehicle.Vehicle;

public @Repository interface TrafficAccidentRepository extends JpaRepository<TrafficAccident, String> {}

