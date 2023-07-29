package com.example.voidapp;

public class InfoPackage {
    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    String title;
    String name;
    String location;
    String description;
    String phone;
    String email;

    public InfoPackage(String title, String name, String location, String description, String phone, String email){
        this.title = title;
        this.name = name;
        this.location = location;
        this.description = description;
        this.phone = phone;
        this.email = email;
    }
}
