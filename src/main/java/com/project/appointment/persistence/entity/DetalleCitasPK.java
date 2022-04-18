package com.project.citasapp.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DetalleCitasPK implements Serializable {
    @Column(name = "citas_id_cita")
    private Long idCitas;
    @Column(name = "medicos_id_medico")
    private String idMedico;

    public Long getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(Long idCitas) {
        this.idCitas = idCitas;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }
}
