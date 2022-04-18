package com.project.citasapp.persistence.crud;

import com.project.citasapp.persistence.entity.Cita;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CitaCrudRepository extends CrudRepository<Cita, Long> {
    Optional<List<Cita>> findByIdPaciente();
}
