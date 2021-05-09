package ru.uiqkos.carproject.services.salesagent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.uiqkos.carproject.services.vehicle.Vehicle;

public @Repository interface SalesAgentRepository extends JpaRepository<SalesAgent, String> {}
