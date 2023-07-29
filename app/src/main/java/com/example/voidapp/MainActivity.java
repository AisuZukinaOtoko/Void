package com.example.voidapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerInterface{
    ArrayList<JobClass> jobs = new ArrayList<JobClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJobs();
        RecyclerView recyclerView = findViewById(R.id.mRecycler);
        JobAdapterClass adapterClass = new JobAdapterClass(this, jobs, this);
        recyclerView.setAdapter(adapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadJobs(){
        for (int i = 0; i < 10; i++){
            jobs.add(new JobClass("", "", 0, ""));
        }
    }

    @Override
    public void onServiceClick(int position) {
        Intent intent = new Intent(this, ServiceInfoView.class);
        startActivity(intent);
    }
}