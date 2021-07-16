package com.example.provaAPI.repository;

import com.example.provaAPI.model.Materias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Ricardo
 */
@Repository
public interface MateriasRepository extends JpaRepository<Materias, Long> {
}
