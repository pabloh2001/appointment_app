package com.project.appointment.domain.dto;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class Patient {
    @NotBlank(message = "el id es requerido")
    private String patientId;
    @NotBlank(message = "el typeId es requerido")
    private String typeId;
    @NotBlank(message = "el fullName es requerido")
    private String fullName;
    @Future(message = "La fecha es posterior a la actual, por lo tanto es invalida.")
    private LocalDate birthDate;
    @NotBlank(message = "el epsAfiliate es requerido")
    private String epsAfiliate;
    @NotBlank(message = "el clinicHistory es requerido")
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
