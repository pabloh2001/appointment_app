package com.project.appointment.domain.repository;
import com.project.appointment.domain.dto.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    List<Patient> getAll();
    Optional<List<Patient>> getByTypeId(String typeId);
    Optional<Patient> getPatient(String patientId);
    Patient save(Patient patient);
    void delete(String patientId);
}
