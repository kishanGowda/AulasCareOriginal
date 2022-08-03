package com.example.aulascare.ModelClassAulasCare;

public class ConversetionModelClass {
    String title,subTitle,notificationNumber,time,icon,views;
    int id;

    public ConversetionModelClass(String title, String subTitle, String notificationNumber, String time, String icon,String views,  int id) {
        this.title = title;
        this.subTitle = subTitle;
        this.notificationNumber = notificationNumber;
        this.time = time;
        this.icon = icon;
        this.views=views;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getNotificationNumber() {
        return notificationNumber;
    }

    public String getTime() {
        return time;
    }

    public String getIcon() {
        return icon;
    }

    public String getViews() {
        return views;
    }

    public int getId() {
        return id;
    }
}
