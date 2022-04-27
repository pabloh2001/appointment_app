package com.project.appointment.domain.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Appointment {
    private String appointmentId = UUID.randomUUID().toString();
    private String doctorId;
    private String patientId;
    private LocalDate date;
    private LocalTime time;
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

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", doctorId='" + doctorId + '\'' +
                ", date=" + date +
                ", state='" + state + '\'' +
                '}';
    }
}
