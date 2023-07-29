package com.example.voidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/*
    YouTube tutorial:
    Practical Coding
    This entire class is from an online tutorial
 */
public class JobAdapterClass extends RecyclerView.Adapter<JobAdapterClass.MyViewHolder> {
    private final RecyclerInterface recyclerInterface;
    Context context;
    ArrayList<JobClass> jobList;


    public JobAdapterClass(Context context, ArrayList<JobClass> jobList, RecyclerInterface recyclerInterface){
        this.context = context;
        this.jobList = jobList;
        this.recyclerInterface = recyclerInterface;
    }

    @NonNull
    @Override
    public JobAdapterClass.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row, parent, false);
        return new JobAdapterClass.MyViewHolder(view, recyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull JobAdapterClass.MyViewHolder holder, int position) {
        holder.txtTitle.setText(jobList.get(position).getJobTitle());
        holder.txtLocation.setText(jobList.get(position).getLocation());
        holder.txtDescription.setText(jobList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return jobList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView txtTitle, txtLocation, txtDescription;



        public MyViewHolder(@NonNull View itemView, RecyclerInterface recyclerInterface) {
            super(itemView);

            image = itemView.findViewById(R.id.imgProfile);
            txtTitle = itemView.findViewById(R.id.txtJobTitle);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtDescription = itemView.findViewById(R.id.txtDescription);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerInterface != null){
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION){
                            recyclerInterface.onServiceClick(position);
                        }
                    }
                }
            });

        }
    }
}
