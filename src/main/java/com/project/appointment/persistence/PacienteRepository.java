package com.project.appointment.persistence;

import com.project.appointment.domain.dto.Patient;
import com.project.appointment.domain.repository.PatientRepository;
import com.project.appointment.persistence.crud.PacienteCrudRepository;
import com.project.appointment.persistence.entity.Paciente;
import com.project.appointment.persistence.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PacienteRepository implements PatientRepository {
    @Autowired
    private PacienteCrudRepository pacienteCrudRepository;

    @Autowired
    private PatientMapper mapper;

    @Override
    public List<Patient> getAll() {
        List<Paciente> pacientes = (List<Paciente>) pacienteCrudRepository.findAll();
        return mapper.toPatients(pacientes);
    }

    @Override
    public Optional<List<Patient>> getByTypeId(String typeId) {
        List<Paciente> pacientes = pacienteCrudRepository.findByTipoId(typeId);
        return Optional.of(mapper.toPatients(pacientes));
    }

    @Override
    public Optional<Patient> getPatient(String patientId) {
        return pacienteCrudRepository.findByIdPaciente(patientId).map(paciente -> mapper.toPatient(paciente));
    }

    @Override
    public Patient save(Patient patient) {
        Paciente paciente = mapper.toPaciente(patient);
        return mapper.toPatient(pacienteCrudRepository.save(paciente));
    }

    @Override
    public void delete(String patientId) {
        pacienteCrudRepository.deleteById(patientId);
    }
}
