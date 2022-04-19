package com.project.appointment.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;
    @Column(name = "medicos_id_medico")
    private String idMedico;
    private LocalDate fecha;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "medicos_id_medico", insertable = false, updatable = false)
    private Medico medico;

    @OneToMany(mappedBy = "cita", cascade = {CascadeType.ALL})
    private List<DetalleCitas> detalles;

    public Long getIdCita() {
        return idCita;
    }

    public void setIdCita(Long idCita) {
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

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", idMedico='" + idMedico + '\'' +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                ", medico=" + medico +
                ", detalles=" + detalles +
                '}';
    }
}
