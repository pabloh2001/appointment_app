package com.project.appointment.persistence.crud;

import com.project.appointment.persistence.entity.Cita;
import com.project.appointment.persistence.entity.Cita;
import com.project.appointment.persistence.entity.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CitaCrudRepository extends CrudRepository<Cita, String> {
    Optional<List<Cita>> findByIdMedico(String idMedico);
    Optional<List<Cita>> findByIdPaciente(String idPaciente);
}
