package com.project.appointment.persistence.mapper;

import com.project.appointment.domain.dto.AppointmentsDetail;
import com.project.appointment.persistence.entity.DetalleCitas;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {PatientMapper.class})
public interface AppointmentsDetailMapper {

    @Mappings({
            @Mapping(source = "id.idPaciente", target = "patientId"),
            @Mapping(source = "hora", target = "time"),
    })
    AppointmentsDetail toAppointmentsDetail(DetalleCitas detalleCitas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.idCita", ignore = true),
            @Mapping(target = "cita", ignore = true),
            @Mapping(target = "paciente", ignore = true)
    })
    DetalleCitas toDetalleCitas(AppointmentsDetail appointmentsDetail);
}
