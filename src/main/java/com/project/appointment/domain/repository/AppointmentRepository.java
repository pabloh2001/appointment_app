package com.project.appointment.domain.repository;

import com.project.appointment.domain.dto.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {
    List<Appointment> getAll();
    Optional<List<Appointment>> getByDoctor(String doctorId);
    Optional<Appointment> getAppointment(String appointmentId);
    Appointment save(Appointment appointment);
    void delete(String appointmentId);
}
