package com.project.appointment.domain.service;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.domain.dto.AppointmentsDetail;
import com.project.appointment.domain.repository.AppointmentRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    private final Log LOGGER = LogFactory.getLog(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Optional<Appointment> getById(long appointmentId){
        return appointmentRepository.getAppointment(appointmentId);
    }

    public List<Appointment> getAll(){
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();
        String id4 = UUID.randomUUID().toString();
        LOGGER.info("identificador unico " + id1 + "longitud " + id1.length());
        LOGGER.info("identificador unico " + id2 + "longitud " + id2.length());
        LOGGER.info("identificador unico " + id3 + "longitud " + id3.length());
        LOGGER.info("identificador unico " + id4 + "longitud " + id4.length());
        return appointmentRepository.getAll();
    }

    public Optional<List<Appointment>> getByDoctor(String doctorId){
        return appointmentRepository.getByDoctor(doctorId);
    }

    public Appointment save(Appointment appointment){
        getByDoctor(appointment.getDoctorId()).map(appointments -> {
            appointments.forEach(actual -> {
                if (actual.getDate().equals(appointment.getDate())){
                    List<AppointmentsDetail> list = actual.getAppointments();
                    list.addAll(appointment.getAppointments());
                    appointment.setAppointments(list);
                    updateAll(appointment);
                }
            });
            return appointment;
        });
        LOGGER.info("No esta funcionando el return de la lambda");

        return appointmentRepository.save(appointment);
    }

    public void updateAll(Appointment appointment){
        appointmentRepository.save(appointment);
    }

}
