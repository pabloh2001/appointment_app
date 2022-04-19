package com.project.appointment.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class Patient {
    @NotNull(message = "el id no debe ser nulo")
    private String patientId;
    @NotNull(message = "el tipo de identificacion no debe ser nulo")
    private String typeId;
    @NotNull(message = "el nombre no debe ser nulo")
    private String fullName;
    private LocalDate birthDate;
    private String epsAfiliate;
    private String clinicHistory;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEpsAfiliate() {
        return epsAfiliate;
    }

    public void setEpsAfiliate(String epsAfiliate) {
        this.epsAfiliate = epsAfiliate;
    }

    public String getClinicHistory() {
        return clinicHistory;
    }

    public void setClinicHistory(String clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId='" + patientId + '\'' +
                ", typeId='" + typeId + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", epsAfiliate='" + epsAfiliate + '\'' +
                ", clinicHistory='" + clinicHistory + '\'' +
                '}';
    }
}
