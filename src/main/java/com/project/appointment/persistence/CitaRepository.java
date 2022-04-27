package com.project.appointment.persistence;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.domain.repository.AppointmentRepository;
import com.project.appointment.persistence.crud.CitaCrudRepository;
import com.project.appointment.persistence.entity.Cita;
import com.project.appointment.persistence.mapper.AppointmentMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CitaRepository implements AppointmentRepository {

    private final Log LOGGER = LogFactory.getLog(CitaRepository.class);

    @Autowired
    private CitaCrudRepository citaCrudRepository;

   @Autowired
   private AppointmentMapper mapper;

    @Override
    public List<Appointment> getAll() {
        List<Cita> citas = (List<Cita>) citaCrudRepository.findAll();
        return mapper.toAppointments(citas);
    }

    @Override
    public Optional<List<Appointment>> getByDoctor(String doctorId) {
        return citaCrudRepository.findByIdMedico(doctorId)
                .map(citas -> mapper.toAppointments(citas));
    }

    @Override
    public Optional<Appointment> getAppointment(String appointmentId) {
        return citaCrudRepository.findById(appointmentId)
                .map(cita -> mapper.toAppointment(cita));
    }

    @Override
    public Appointment save(Appointment appointment) {
        Cita cita = mapper.toCita(appointment);
        return mapper.toAppointment(citaCrudRepository.save(cita));
    }

    @Override
    public void delete(String appointmentId) {
        citaCrudRepository.deleteById(appointmentId);
    }
}
