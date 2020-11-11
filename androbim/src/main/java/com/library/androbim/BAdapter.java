package com.library.androbim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BAdapter extends BaseAdapter {

    ArrayList<CallModel> list = new ArrayList<>();
    Context context;

    LayoutInflater inflater;

    public BAdapter(Context context,ArrayList<CallModel> list)
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

        TextView NameTV = v1.findViewById(R.id.name_id);
        TextView NumberTV = v1.findViewById(R.id.number_id);
        TextView DateTV = v1.findViewById(R.id.date_id);

        ImageView ProfileIV = v1.findViewById(R.id.profile_image_id);
        ImageView TypeIV = v1.findViewById(R.id.type_id);






        return v1;
    }
}
