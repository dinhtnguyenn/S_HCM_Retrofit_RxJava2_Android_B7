package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private ArrayList<User> alUser;
    private Context context;

    public UserAdapter(ArrayList<User> alUser, Context context) {
        this.alUser = alUser;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtUserName.setText(alUser.get(position).getName() + " (" + alUser.get(position).getId() + ")");
        holder.txtUserEmail.setText(alUser.get(position).getEmail());
        holder.txtUserMobile.setText(alUser.get(position).getContact().getMobile());
    }

    @Override
    public int getItemCount() {
        return alUser.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtUserName, txtUserEmail, txtUserMobile;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtUserName = itemView.findViewById(R.id.txtUserName);
            txtUserEmail = itemView.findViewById(R.id.txtUserEmail);
            txtUserMobile = itemView.findViewById(R.id.txtUserMobile);

        }


    }
}