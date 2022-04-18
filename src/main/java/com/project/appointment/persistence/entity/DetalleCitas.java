package com.project.citasapp.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalle_citas")
public class DetalleCitas {
    @EmbeddedId
    private DetalleCitasPK id;
    private String hora;

    @ManyToOne
    @MapsId("idCita")
    @JoinColumn(name = "id_cita", insertable = false, updatable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_medico", insertable = false, updatable = false)
    private Paciente paciente;

    public DetalleCitasPK getId() {
        return id;
    }

    public void setId(DetalleCitasPK id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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
