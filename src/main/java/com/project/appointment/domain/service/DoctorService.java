package com.project.appointment.domain.service;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public Optional<List<Doctor>> getBySpeciality(long specialityId){
        return doctorRepository.getBySpeciality(specialityId);
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public boolean delete(String doctorId){
        return getById(doctorId).map(doctor -> {
            doctorRepository.delete(doctorId);
            return true;
        }).orElse(false);
    }
}
