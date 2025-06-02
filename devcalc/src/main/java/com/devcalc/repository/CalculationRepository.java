package com.devcalc.repository;

import com.devcalc.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculationRepository extends JpaRepository<Calculation, Long> {
    // JpaRepository já fornece métodos CRUD básicos
}
