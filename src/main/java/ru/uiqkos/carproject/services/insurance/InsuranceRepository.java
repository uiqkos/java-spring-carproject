package ru.uiqkos.carproject.services.insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.uiqkos.carproject.services.salesagent.SalesAgent;

public @Repository
interface InsuranceRepository extends JpaRepository<Insurance, String> {}
