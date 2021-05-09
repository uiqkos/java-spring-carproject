package ru.uiqkos.carproject.services.deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public @Repository interface DealRepository extends JpaRepository<Deal, String> {}