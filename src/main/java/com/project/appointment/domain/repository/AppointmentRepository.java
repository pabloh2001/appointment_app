package com.project.appointment.domain.repository;

import com.project.appointment.domain.dto.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    List<Appointment> getAll();
    Optional<Appointment> getAppointment(String appointmentId);
    Optional<List<Appointment>> getByDoctor(String doctorId);
    Optional<List<Appointment>> getByPatient(String patientId);
    Appointment save(Appointment appointment);
    void delete(String appointmentId);
}
