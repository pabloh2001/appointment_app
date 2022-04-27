package com.project.appointment.domain.service;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Optional<Doctor> getById(String doctorId){
        return doctorRepository.getDoctor(doctorId);
    }

    public List<Doctor> getAll(){
        return doctorRepository.getAll();
    }

    public Doctor saveDoctor(Doctor doctor){
        if (!doctor.getStartTime().isAfter(LocalTime.of(06, 00))
        && doctor.getEndTime().isBefore(LocalTime.of(20, 00))){
            throw new IllegalArgumentException("Error. El rango de horas de atención para un doctor" +
                    " debe estar entre 06:00 y las 20:00 horas.");
        }
        return doctorRepository.save(doctor);
    }

    public boolean delete(String doctorId){
        return getById(doctorId).map(doctor -> {
            doctorRepository.delete(doctorId);
            return true;
        }).orElse(false);
    }
}
