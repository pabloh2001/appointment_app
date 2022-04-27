package com.project.appointment.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @Column(name = "id_paciente")
    private String idPaciente;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "tipo_id")
    private String tipoId;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "EPS")
    private String eps;
    @Column(name = "historia_clinica")
    private String historiaClinica;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(String historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

}
