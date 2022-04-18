package com.project.citasapp.domain.dto;

import java.util.Date;
import java.util.List;

public class Patient {
    private String patientId;
    private String fullName;
    private Date birthDate;
    private String eps;
    private String clinicHistory;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(String clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

}
