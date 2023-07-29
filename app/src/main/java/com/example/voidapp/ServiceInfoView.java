package com.example.voidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceInfoView extends AppCompatActivity {
    TextView txtTitle, txtName, txtLocation, txtDescription, txtPhone, txtEmail;
    ImageView imgProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info_view);

        txtTitle = (TextView) findViewById(R.id.viewTitle);
        txtName = (TextView) findViewById(R.id.viewName);
        txtLocation = (TextView) findViewById(R.id.viewLocation);
        txtDescription = (TextView) findViewById(R.id.viewDescription);
        txtPhone = (TextView) findViewById(R.id.viewPhone);
        txtEmail = (TextView) findViewById(R.id.viewEmail);
        imgProfile = (ImageView) findViewById(R.id.viewImage);
    }

    private void loadInfo(int ID){

    }

    private void displayInfo(InfoPackage infoPackage){
        ServiceInfoView.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtTitle.setText(infoPackage.getTitle());
                txtName.setText(infoPackage.getName());
                txtLocation.setText(infoPackage.getLocation());
                txtDescription.setText(infoPackage.getDescription());
                txtPhone.setText(infoPackage.getPhone());
                txtEmail.setText(infoPackage.getEmail());
            }
        });
    }
}

// An object with the service information
class InfoPackage{
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