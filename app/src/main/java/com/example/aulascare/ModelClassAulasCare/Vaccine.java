package com.example.aulascare.ModelClassAulasCare;

public class Vaccine {
    private String vaccineName,vaccineDescription;
    private int vaccineImageResource;
    private boolean expanded;

    public Vaccine(String vaccineName, String vaccineDescription, int vaccineImageResource) {
        this.vaccineName = vaccineName;
        this.vaccineDescription = vaccineDescription;
        this.vaccineImageResource = vaccineImageResource;
        this.expanded = false;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getVaccineDescription() {
        return vaccineDescription;
    }

    public int getVaccineImageResource() {
        return vaccineImageResource;
    }
}
