package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.InfoCourse;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseImageAdapter extends RecyclerView.Adapter<CourseImageAdapter.ViewHolder> {

    private ArrayList<InfoCourse> alCourse;
    private Context context;

    public CourseImageAdapter(ArrayList<InfoCourse> alCourse, Context context) {
        this.alCourse = alCourse;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_image_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCourse.setText(alCourse.get(position).getCourse());
        holder.txtLink.setText(alCourse.get(position).getLink());

        Glide.with(context)
                .load(alCourse.get(position).getImage())
                .into(holder.ivLogo);

    }

    @Override
    public int getItemCount() {
        return alCourse.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCourse, txtLink;
        public ImageView ivLogo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCourse = itemView.findViewById(R.id.txtCourse);
            txtLink = itemView.findViewById(R.id.txtLink);
            ivLogo = itemView.findViewById(R.id.ivLogo);
        }
    }
}