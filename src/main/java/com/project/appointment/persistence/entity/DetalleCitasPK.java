package com.project.appointment.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DetalleCitasPK implements Serializable {
    @Column(name = "citas_id_cita")
    private Long idCita;
    @Column(name = "pacientes_id_paciente")
    private String idPaciente;

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
        this.idCita = idCita;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "DetalleCitasPK{" +
                "idCita=" + idCita +
                ", idPaciente='" + idPaciente + '\'' +
                '}';
    }
}
