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
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final Log LOGGER = LogFactory.getLog(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Optional<Appointment> getById(long appointmentId){
        return appointmentRepository.getAppointment(appointmentId);
    }

    public List<Appointment> getAll(){
        return appointmentRepository.getAll();
    }

    public Optional<List<Appointment>> getByDoctor(String doctorId){
        return appointmentRepository.getByDoctor(doctorId);
    }

    public Appointment save(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

}
