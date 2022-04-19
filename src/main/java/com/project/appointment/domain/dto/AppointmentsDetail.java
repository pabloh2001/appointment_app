package com.project.appointment.domain.dto;

import java.time.LocalTime;

public class AppointmentsDetail {
    private String patientId;
    private LocalTime time;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AppointmentsDetail{" +
                "patientId='" + patientId + '\'' +
                ", time=" + time +
                '}';
    }
}
