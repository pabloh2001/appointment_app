package com.project.appointment.domain.dto;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Appointment {
    private String appointmentId;
    private String doctorId;
    private LocalDate date;
    private String state;
    private List<AppointmentsDetail> appointments;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<AppointmentsDetail> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentsDetail> appointments) {
        this.appointments = appointments;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", doctorId='" + doctorId + '\'' +
                ", date=" + date +
                ", state='" + state + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
