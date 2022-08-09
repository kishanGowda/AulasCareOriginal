package com.example.aulascare.AulasCareStudent.ModelClass;

public class QuestionCards {
    private String aboutImageInfo;
    private int vaccineImage;

    public QuestionCards( int vaccineImage,String aboutImageInfo) {

        this.vaccineImage = vaccineImage;
        this.aboutImageInfo = aboutImageInfo;
    }

    public String getAboutImageInfo() {
        return aboutImageInfo;
    }

    public int getVaccineImage() {
        return vaccineImage;
    }
}
