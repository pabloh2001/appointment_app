package com.project.citasapp.persistence.crud;

import com.project.citasapp.persistence.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface PacienteCrudRepository extends CrudRepository<Paciente, String> {
    Paciente findByIdPaciente(String idPaciente);
}
