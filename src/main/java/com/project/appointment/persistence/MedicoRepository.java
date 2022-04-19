package com.project.appointment.persistence;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.repository.DoctorRepository;
import com.project.appointment.persistence.crud.MedicoCrudRepository;
import com.project.appointment.persistence.entity.Medico;
import com.project.appointment.persistence.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MedicoRepository implements DoctorRepository {

    @Autowired
    private MedicoCrudRepository medicoCrudRepository;
    @Autowired
    private DoctorMapper mapper;

    @Override
    public List<Doctor> getAll() {
        List<Medico> medicos = (List<Medico>) medicoCrudRepository.findAll();
        return mapper.toDoctors(medicos);
    }

    @Override
    public Optional<List<Doctor>> getBySpeciality(long specialityId) {
        List<Medico> medicos = medicoCrudRepository.findByIdEspecialidad(specialityId);
        return Optional.of(mapper.toDoctors(medicos));
    }

    @Override
    public Optional<Doctor> getDoctor(String doctorId) {
        return medicoCrudRepository.findById(doctorId).map(medico -> mapper.toDoctor(medico));
    }

    @Override
    public Doctor save(Doctor doctor) {
        Medico medico = mapper.toMedico(doctor);
        return mapper.toDoctor(medicoCrudRepository.save(medico));
    }

    @Override
    public void delete(String doctorId) {
        medicoCrudRepository.deleteById(doctorId);
    }
}
