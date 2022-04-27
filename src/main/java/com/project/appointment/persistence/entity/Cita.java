package com.project.appointment.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @Column(name = "id_cita")
    private String idCita;
    @Column(name = "medicos_id_medico")
    private String idMedico;
    @Column(name = "pacientes_id_paciente")
    private String idPaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "medicos_id_medico", insertable = false, updatable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "pacientes_id_paciente", insertable = false, updatable = false)
    private Paciente paciente;

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
