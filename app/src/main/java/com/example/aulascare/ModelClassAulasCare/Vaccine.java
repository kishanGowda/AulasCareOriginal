package com.example.aulascare.ModelClassAulasCare;

public class Vaccine {
    private String vaccineName,vaccineDescription;

    private boolean expanded;

    public Vaccine(String vaccineName, String vaccineDescription) {
        this.vaccineName = vaccineName;
        this.vaccineDescription = vaccineDescription;
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


}
