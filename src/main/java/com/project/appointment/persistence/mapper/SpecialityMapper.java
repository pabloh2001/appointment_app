package com.project.appointment.persistence.mapper;

import com.project.appointment.domain.dto.Speciality;
import com.project.appointment.persistence.entity.Especialidad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {

    @Mappings({
            @Mapping(source = "idEspecialidad", target = "specialityId"),
            @Mapping(source = "descripcion", target = "speciality"),
            @Mapping(source = "estado", target = "active")
    })
    Speciality toSpeciality(Especialidad especialidad);

    @InheritInverseConfiguration
    @Mapping(target = "medicos", ignore = true)
    Especialidad toEspecialidad(Speciality speciality);
}
