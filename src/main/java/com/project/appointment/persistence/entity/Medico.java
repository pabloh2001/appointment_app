package com.project.citasapp.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medicos")
public class Medico {
    @Id
    @Column(name = "id_medico")
    private String idMedico;
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "tipo_id")
    private String tipoId;
    @Column(name = "num_tarjeta_pro")
    private String numTarjetaProfesional;
    @Column(name = "anos_experiencia")
    private Double tiempoExperiencia;
    @Column(name = "hora_inicio")
    private String horaInicio;
    @Column(name = "hora_fin")
    private String horaFin;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", insertable = false, updatable = false)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    public String getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(String idMedico) {
        this.idMedico = idMedico;
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

    public String getNumTarjetaProfesional() {
        return numTarjetaProfesional;
    }

    public void setNumTarjetaProfesional(String numTarjetaProfesional) {
        this.numTarjetaProfesional = numTarjetaProfesional;
    }

    public Double getTiempoExperiencia() {
        return tiempoExperiencia;
    }

    public void setTiempoExperiencia(Double tiempoExperiencia) {
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }
}
