package com.project.appointment.persistence.mapper;

import com.project.appointment.domain.dto.Appointment;
import com.project.appointment.persistence.entity.Cita;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mappings({
            @Mapping(source = "idCita", target = "appointmentId"),
            @Mapping(source = "idMedico", target = "doctorId"),
            @Mapping(source = "idPaciente", target = "patientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "hora", target = "time"),
            @Mapping(source = "estado", target = "state")
    })
    Appointment toAppointment(Cita cita);
    List<Appointment> toAppointments(List<Cita> citas);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "medico", ignore = true),
            @Mapping(target = "paciente", ignore = true)
    })
    Cita toCita(Appointment appointment);
}
