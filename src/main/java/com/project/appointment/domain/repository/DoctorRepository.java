package com.project.appointment.domain.repository;
import com.project.appointment.domain.dto.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    List<Doctor> getAll();
    Optional<List<Doctor>> getBySpeciality(long specialityId);
    Optional<Doctor> getDoctor(String doctorId);
    Doctor save(Doctor doctor);
    void delete(String doctorId);
}
