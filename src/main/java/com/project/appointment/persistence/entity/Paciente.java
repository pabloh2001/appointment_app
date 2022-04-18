package com.project.citasapp.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(name = "id_cliente")
    private String idPaciente;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "tipo_id")
    private String tipoId;
    @Column(name = "fecha_nacimiento")
    private Date fecha_nacimiento;
    @Column(name = "EPS")
    private String eps;
    @Column(name = "historia_clinica")
    private String historia_clinica;

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getHistoria_clinica() {
        return historia_clinica;
    }

    public void setHistoria_clinica(String historia_clinica) {
        this.historia_clinica = historia_clinica;
    }
}
