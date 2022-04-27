package com.project.appointment.persistence.mapper;

import com.project.appointment.domain.dto.Doctor;
import com.project.appointment.domain.dto.Patient;
import com.project.appointment.persistence.entity.Medico;
import com.project.appointment.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SpecialityMapper.class})
public interface DoctorMapper {

    @Mappings({
            @Mapping(source = "idMedico", target = "doctorId"),
            @Mapping(source = "tipoId", target = "typeId"),
            @Mapping(source = "nombreCompleto", target = "fullName"),
            @Mapping(source = "tiempoExperiencia", target = "experienceYears"),
            @Mapping(source = "numTarjetaProfesional", target = "proCardNum"),
            @Mapping(source = "horaInicio", target = "startTime"),
            @Mapping(source = "horaFin", target = "endTime"),
            @Mapping(source = "especialidades", target = "specialities")

    })
    Doctor toDoctor(Medico medico);
    List<Doctor> toDoctors(List<Medico> medicos);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    Medico toMedico(Doctor doctor);
}
