package com.example.aulascare.AulasCareStudent.ModelClass;

public class VaccineDrive {
    private String vaccineReg;
    private String totalVaccines;
    private String perDayvaccine;

    public VaccineDrive(String vaccineReg, String totalVaccines, String perDayvaccine) {
        this.vaccineReg = vaccineReg;
        this.totalVaccines = totalVaccines;
        this.perDayvaccine = perDayvaccine;
    }

    public String getVaccineReg() {
        return vaccineReg;
    }

    public String getTotalVaccines() {
        return totalVaccines;
    }

    public String getPerDayvaccine() {
        return perDayvaccine;
    }
}
