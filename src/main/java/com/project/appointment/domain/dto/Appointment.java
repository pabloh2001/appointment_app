package com.project.appointment.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Appointment {
    private String appointmentId = UUID.randomUUID().toString();
    @NotBlank(message = "El campo doctorId es requerido")
    private String doctorId;
    @NotBlank(message = "El campo patientId es requerido")
    private String patientId;
    private LocalDate date;
    private LocalTime time;
    @NotBlank(message = "El campo state es requerido")
    private String state;

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean validateSpaceBetweenAppointments(LocalTime next){
        if (next.getHour() > this.time.getHour()+3) {
            return true;
        }
        if (next.getHour() < this.time.getHour()-3){
            return true;
        }
        if (this.time.getHour() < next.getHour()){
            if (this.time.plusHours(2).equals(next)){
                return true;
            }
        }
        if (this.time.getHour() > next.getHour()){
            if (this.time.minusHours(2).equals(next)){
                return true;
            }
        }
        return false;
    }
}
