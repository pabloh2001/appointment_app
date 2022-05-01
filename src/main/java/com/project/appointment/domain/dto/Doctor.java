package com.project.appointment.domain.dto;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.constraints.NotBlank;
import java.time.LocalTime;
import java.util.Set;

public class Doctor {

    private final Log LOGGER = LogFactory.getLog(Doctor.class);
    @NotBlank(message = "el doctorId es requerido")
    private String doctorId;
    @NotBlank(message = "el typeId es requerido")
    private String typeId;
    @NotBlank(message = "el fullName es requerido")
    private String fullName;
    @NotBlank(message = "el experienceYears es requerido")
    private double experienceYears;
    @NotBlank(message = "el proCardNum es requerido")
    private String proCardNum;
    private LocalTime startTime;
    private LocalTime endTime;
    private Set<Speciality> specialities;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(double experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getProCardNum() {
        return proCardNum;
    }

    public void setProCardNum(String proCardNum) {
        this.proCardNum = proCardNum;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public boolean isAvailable(LocalTime time){
        LOGGER.info("entramos a este metodo");
        return (time.getHour() >= this.startTime.getHour() && time.getHour() <= this.endTime.getHour());
    }
}
