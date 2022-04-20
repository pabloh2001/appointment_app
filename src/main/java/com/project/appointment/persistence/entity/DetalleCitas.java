package com.project.appointment.persistence.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "detalle_citas")
public class DetalleCitas {
    @EmbeddedId
    private DetalleCitasPK id;
    private LocalTime hora;

    @ManyToOne
    @MapsId("idCita")
    @JoinColumn(name = "citas_id_cita", insertable = false, updatable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_paciente", insertable = false, updatable = false)
    private Paciente paciente;

    public DetalleCitasPK getId() {
        return id;
    }

    public void setId(DetalleCitasPK id) {
        this.id = id;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

}
