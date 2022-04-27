package com.project.appointment.domain.service;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.repository.AppointmentRepository;
import com.project.appointment.domain.repository.DoctorRepository;
import com.project.appointment.domain.repository.PatientRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AppointmentService {

    private final Log LOGGER = LogFactory.getLog(AppointmentService.class);

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Appointment> getById(String appointmentId){
        return appointmentRepository.getAppointment(appointmentId);
    }

    public List<Appointment> getAll(){
        return appointmentRepository.getAll();
    }

    public Optional<List<Appointment>> getByDoctor(String doctorId){
        return appointmentRepository.getByDoctor(doctorId);
    }

    public Appointment save(Appointment appointment){
        //recordar: hacer esta validacion a nivel de bd
        if (!doctorRepository.getDoctor(appointment.getDoctorId()).isPresent()){
            throw new NoSuchElementException("Error. El medico con id " + appointment.getDoctorId() + "" +
                    " no existe");
        }
        //recordar: hacer esta validacion al nivel de bd
        if (!patientRepository.getPatient(appointment.getPatientId()).isPresent()){
            throw new NoSuchElementException("Error. El paciente con id " + appointment.getPatientId() + "" +
                    " no existe");
        }
        if (appointment.getDate().compareTo(LocalDate.now()) < 0){
            throw new IllegalArgumentException("Error. La fecha introducida es anterior a la actual, por lo tanto es incorrecta");
        }
        Doctor doctor = doctorRepository.getDoctor(appointment.getDoctorId()).get();
        if (!doctor.isAvailable(appointment.getTime())){
            throw new IllegalArgumentException("Error. La hora de la cita esta fuera del rango para este doctor, " +
                    "debe ser de " + doctor.getStartTime() + " a " + doctor.getEndTime() + " horas");
        }

        getAll().stream()
                .filter(actual -> actual.getDate().equals(appointment.getDate()) && actual.getDoctorId().equals(appointment.getDoctorId()))
                .forEach(aux -> {
                    if (aux.getTime().equals(appointment.getTime())){
                        throw new IllegalArgumentException("Error. Hora no disponible");
                    }
                    if (appointment.getTime().compareTo(aux.getTime()) < 1){
                        throw new IllegalArgumentException("Error. Hora no disponible, el espacio entre citas es de 1 hora.");
                    }
                });

        return appointmentRepository.save(appointment);
    }

    public void updateAll(Appointment appointment){
        appointmentRepository.save(appointment);
    }

}
