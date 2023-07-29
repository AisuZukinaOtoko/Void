package com.example.voidapp;

import java.util.ArrayList;

public class JobClass {
    // Main text message
    String jobTitle = "";
    String location = "";
    String description = "";

    int image = 0;
    int ID = 0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public JobClass(String title, String description, int image, String location) {
        this.jobTitle = title;
        this.description = description;
        this.image = image;
        this.location = location;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}

