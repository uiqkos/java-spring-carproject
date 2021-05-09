package ru.uiqkos.carproject.services.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.uiqkos.carproject.services.salesagent.SalesAgent;

public @Repository interface CustomerRepository extends JpaRepository<Customer, String> {}