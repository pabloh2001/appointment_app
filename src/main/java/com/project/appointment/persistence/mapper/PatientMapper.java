package com.project.appointment.persistence.mapper;

import com.project.appointment.domain.dto.Patient;
import com.project.appointment.persistence.entity.Paciente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mappings({
            @Mapping(source = "idPaciente", target = "patientId"),
            @Mapping(source = "tipoId", target = "typeId"),
            @Mapping(source = "nombreCompleto", target = "fullName"),
            @Mapping(source = "fechaNacimiento", target = "birthDate"),
            @Mapping(source = "eps", target = "epsAfiliate"),
            @Mapping(source = "historiaClinica", target = "clinicHistory")
    })
    Patient toPatient(Paciente paciente);
    List<Patient> toPatients(List<Paciente> pacientes);

    @InheritInverseConfiguration
    @Mapping(target = "citas", ignore = true)
    Paciente toPaciente(Patient patient);
}
