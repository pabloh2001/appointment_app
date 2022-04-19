package com.project.appointment.domain.service;

import com.project.appointment.domain.dto.Patient;
import com.project.appointment.domain.repository.PatientRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PatientService {

    private final Log LOGGER = LogFactory.getLog(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getById(String patientId){
        Optional<Patient> patient = patientRepository.getPatient(patientId);
        if (patient.isEmpty()){
            LOGGER.info("no existe el paciente con id:" + patientId);
            throw new NoSuchElementException("No existe el paciente con id:" + patientId);
        }
        return patient;
    }

    public List<Patient> getAll(){
        List<Patient> patients = patientRepository.getAll();
        if (patients.isEmpty()){
            throw new NoSuchElementException("No hay pacientes");
        }
        return patients;
    }

    public Optional<List<Patient>> getPatientsTypeId(String typeId){
        return patientRepository.getByTypeId(typeId);
    }

    public Patient savePatient(Patient patient){
        getAll().forEach(patient1 -> {
            if (patient1.getPatientId().contentEquals(patient.getPatientId())){
                throw new DuplicateKeyException("Ya existe el paciente con id:" + patient.getPatientId());
            }
        });
        return patientRepository.save(patient);
    }

    public boolean deletePatient(String patientId){
        return getById(patientId).map(patient -> {
            patientRepository.delete(patientId);
            return true;
        }).orElse(false);
    }
}
