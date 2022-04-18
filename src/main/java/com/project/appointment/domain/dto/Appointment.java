package com.project.citasapp.domain.dto;

import java.util.Date;
import java.util.List;

public class Appointment {
    private long appointmentId;
    private String doctorId;
    private Date date;
    private String state;
    private List<AppointmentsDetail> appointments;

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
