package com.project.appointment.persistence.crud;

import com.project.appointment.persistence.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PacienteCrudRepository extends CrudRepository<Paciente, String> {
    Optional<Paciente> findByIdPaciente(String idPaciente);
    List<Paciente> findByTipoId(String tipoId);
}
