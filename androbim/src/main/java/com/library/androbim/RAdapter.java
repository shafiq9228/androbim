package com.library.androbim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RAdapter extends RecyclerView.Adapter<RAdapter.MyViewHolder> {

    ArrayList<Object> list = new ArrayList<>();

    public static Runnable Initialize;
    public static Runnable Define;

    int ViewPath;


    public RAdapter(ArrayList<Object> list, int ViewPath )
    {
        this.list = list;
        this.ViewPath = ViewPath;
       // this.Initialize = Initialize;
       // this.Define = Define;

    }

    public RAdapter()
    {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(ViewPath, parent,false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }


}
