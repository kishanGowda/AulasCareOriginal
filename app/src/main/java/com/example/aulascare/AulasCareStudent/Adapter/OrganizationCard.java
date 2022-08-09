package com.example.aulascare.AulasCareStudent.Adapter;

public class OrganizationCard {
    private String organizationName;
    private int imageResource;

    public OrganizationCard(String organizationName, int imageResource) {
        this.organizationName = organizationName;
        this.imageResource = imageResource;

    }

    public String getOrganizationName() {
        return organizationName;
    }

    public int getImageResource() {
        return imageResource;
    }
}
