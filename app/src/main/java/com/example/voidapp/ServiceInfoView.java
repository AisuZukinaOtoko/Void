package com.example.voidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ServiceInfoView extends AppCompatActivity {
    TextView txtSkills, txtName, txtLocation, txtDescription, txtPhone, txtEmail;
    ImageView imgProfile;
    private JobClass viewJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_info_view);

        txtSkills = (TextView) findViewById(R.id.viewSkills);
        txtName = (TextView) findViewById(R.id.viewName);
        txtLocation = (TextView) findViewById(R.id.viewLocation);
        txtDescription = (TextView) findViewById(R.id.viewDescription);
        txtPhone = (TextView) findViewById(R.id.viewPhone);
        txtEmail = (TextView) findViewById(R.id.viewEmail);
        imgProfile = (ImageView) findViewById(R.id.viewImage);

        viewJob = MainActivity.viewJob;
        displayInfo();
    }

    private void loadInfo(int ID){

    }

    private void displayInfo(){
        ServiceInfoView.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                txtSkills.setText(viewJob.getSkills());
                txtName.setText(viewJob.getName());
                txtLocation.setText(viewJob.getLocation());
                txtDescription.setText(viewJob.getDescription());
                txtPhone.setText(viewJob.getPhoneNumber());
                txtEmail.setText(viewJob.getEmail());
            }
        });
    }
}
