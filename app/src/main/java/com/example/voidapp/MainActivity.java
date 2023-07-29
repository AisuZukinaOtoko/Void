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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import kotlinx.coroutines.Job;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements RecyclerInterface{
    ArrayList<JobClass> jobs = new ArrayList<JobClass>();
    public static JobClass viewJob;
    JobAdapterClass adapterClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadJobs();
        RecyclerView recyclerView = findViewById(R.id.mRecycler);
        adapterClass = new JobAdapterClass(this, jobs, this);
        recyclerView.setAdapter(adapterClass);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadJobs(){
        String url = "https://lamp.ms.wits.ac.za/home/s2549501/loadServices.php";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    // Response from the server
                    String myResponse = response.body().string();
                    try{
                        JSONArray responseArray = new JSONArray(myResponse);

                        jobs.clear();
                        for (int i = 0; i < responseArray.length(); i++) {
                            JSONObject arrayObject = responseArray.getJSONObject(i);
                            String phoneNumber = arrayObject.getString("PHONE_NO");
                            String email = arrayObject.getString("EMAIL");
                            String name = arrayObject.getString("NAME");
                            String surname = arrayObject.getString("SURNAME");
                            String description = arrayObject.getString("DESCRIPTION");
                            String skills = arrayObject.getString("SKILLS");
                            String photo = "";//arrayObject.getString("PICTURE");
                            String location = "";//arrayObject.getString("LOCATION");
                            jobs.add(new JobClass(skills, description, photo, location, name, surname, phoneNumber, email));
                        }


                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapterClass.notifyDataSetChanged();
                            }
                        });

                    } catch (JSONException e){
                        e.printStackTrace();
                    }

                }
            }
        });


    }


    @Override
    public void onServiceClick(int position) {
        viewJob = jobs.get(position);
        Intent intent = new Intent(this, ServiceInfoView.class);
        startActivity(intent);
    }
}