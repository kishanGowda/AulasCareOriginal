package com.example.aulascare.AulasCareStudent.ModelClass;

public class VaccineCard {
    private String vaccineName,vaccineDescription;
    private int imageResource;

    public VaccineCard(String vaccineName, String vaccineDescription, int imageResource) {
        this.vaccineName = vaccineName;
        this.vaccineDescription = vaccineDescription;
        this.imageResource = imageResource;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public String getVaccineDescription() {
        return vaccineDescription;
    }

    public int getImageResource() {
        return imageResource;
    }
}