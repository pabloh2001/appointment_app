package com.project.appointment.persistence;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.repository.DoctorRepository;
import com.project.appointment.domain.service.AppointmentService;
import com.project.appointment.persistence.crud.EspecialidadCrudRepository;
import com.project.appointment.persistence.crud.MedicoCrudRepository;
import com.project.appointment.persistence.entity.Especialidad;
import com.project.appointment.persistence.entity.Medico;
import com.project.appointment.persistence.mapper.DoctorMapper;
import com.project.appointment.persistence.mapper.SpecialityMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MedicoRepository implements DoctorRepository {

    private final Log LOGGER = LogFactory.getLog(MedicoRepository.class);

    @Autowired
    private MedicoCrudRepository medicoCrudRepository;
    @Autowired
    private EspecialidadCrudRepository especialidadCrudRepository;
    @Autowired
    private DoctorMapper mapper;
    @Autowired
    private SpecialityMapper specialityMapper;

    @Override
    public List<Doctor> getAll() {
        List<Medico> medicos = (List<Medico>) medicoCrudRepository.findAll();

        return mapper.toDoctors(medicos);
    }

    @Override
    public Optional<Doctor> getDoctor(String doctorId) {
        return medicoCrudRepository.findById(doctorId).map(medico -> mapper.toDoctor(medico));
    }

    @Override
    public Doctor save(Doctor doctor) {
        Medico medico = mapper.toMedico(doctor);
        medico.setEspecialidades(doctor.getSpecialities()
                .stream()
                .map(speciality -> {
                    Especialidad especialidad = specialityMapper.toEspecialidad(speciality);
                    if (especialidad.getIdEspecialidad() > 0L){
                        especialidad = especialidadCrudRepository.findById(especialidad.getIdEspecialidad()).get();
                    }
                    especialidad.addMedico(medico);
                    return especialidad;
                }).collect(Collectors.toSet())
        );
        return mapper.toDoctor(medicoCrudRepository.save(medico));
    }

    @Override
    public void delete(String doctorId) {
        medicoCrudRepository.deleteById(doctorId);
    }
}
