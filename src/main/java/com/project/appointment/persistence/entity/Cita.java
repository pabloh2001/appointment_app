package com.project.citasapp.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Long idCita;
    @Column(name = "id_paciente")
    private String idMedico;
    private Date fecha;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_medico", insertable = false, updatable = false)
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
