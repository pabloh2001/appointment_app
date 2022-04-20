package com.project.appointment.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @Column(name = "id_cita")
    private String idCita;
    @Column(name = "medicos_id_medico")
    private String idMedico;
    private LocalDate fecha;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "medicos_id_medico", insertable = false, updatable = false)
    private Medico medico;

    @OneToMany(mappedBy = "cita", cascade = {CascadeType.ALL})
    private List<DetalleCitas> detalles;

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public List<DetalleCitas> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleCitas> detalles) {
        this.detalles = detalles;
    }

}
