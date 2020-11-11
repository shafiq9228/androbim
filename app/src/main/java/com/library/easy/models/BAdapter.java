package com.library.easy.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.library.androbim.CallModel;
import com.library.easy.R;

import java.util.ArrayList;

public class BAdapter<T> extends BaseAdapter {

    ArrayList<CallModel> list = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public BAdapter(Context context, ArrayList<CallModel> list)
    {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v1 = inflater.inflate(R.layout.my_view,null);// Pass Layoutview in parser

        TextView TV = v1.findViewById(R.id.number_id);


        TV.setText(""+list.get(position).name+ " - "+list.get(position).phone);


        return v1;
    }
}
