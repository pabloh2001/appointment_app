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
import java.time.LocalTime;
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

    public List<Appointment> getAll(){
        return appointmentRepository.getAll();
    }

    public Optional<Appointment> getAppointment(String appointmentId){
        return appointmentRepository.getAppointment(appointmentId);
    }

    public Optional<List<Appointment>> getByDoctor(String doctorId){
        return appointmentRepository.getByDoctor(doctorId);
    }

    public Optional<List<Appointment>> getByPatient(String patientId){
        return appointmentRepository.getByPatient(patientId);
    }

    public Appointment save(Appointment appointment){
        if (!doctorRepository.getDoctor(appointment.getDoctorId()).isPresent()){
            throw new NoSuchElementException("Error. El medico con id " + appointment.getDoctorId() + " no existe");
        }

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

        if (appointment.getTime().getMinute() != 0){
            throw new IllegalArgumentException("Error. La hora ingresada no es validad, ejemplo de horas validas: 9:00, 10:00, 11:00...");
        }

        if (appointment.getDate().equals(LocalDate.now()) && appointment.getTime().getMinute() < LocalTime.now().getMinute()){
            throw new IllegalArgumentException("Error. No puede ingresar una hora que ya ha transcurrido");
        }

        getAll().stream()
                .filter(actual -> actual.getDate().equals(appointment.getDate()) && actual.getDoctorId().equals(appointment.getDoctorId()))
                .forEach(aux -> {

                    if (aux.getTime().equals(appointment.getTime())){
                        throw new IllegalArgumentException("Error. Hora no disponible");
                    }

                    if (!aux.validateSpaceBetweenAppointments(appointment.getTime())){
                        throw new IllegalArgumentException("Error. Hora no disponible, el espacio entre citas es de 1 hora.");
                    }
                });

        return appointmentRepository.save(appointment);
    }

    public boolean delete(String appointmentId){
        return getAppointment(appointmentId)
                .map(appointment -> {
                    appointmentRepository.delete(appointmentId);
                    return true;
                })
                .orElse(false);
    }
}
