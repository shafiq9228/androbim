package com.library.androbim;

import android.content.Context;
import android.provider.CallLog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CallAdapter extends BaseAdapter {

    ArrayList<CallModel> list = new ArrayList<>();
    Context context;

    LayoutInflater inflater;

    public CallAdapter(Context context,ArrayList<CallModel> list)
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


        NameTV.setText(""+list.get(position).getName());

        NumberTV.setText(""+list.get(position).getPhone());

        if(list.get(position).getType() == CallLog.Calls.INCOMING_TYPE)
        {
            TypeIV.setImageResource(R.drawable.ic_baseline_call_received_24);
        }
        else if(list.get(position).getType() == CallLog.Calls.OUTGOING_TYPE)
        {
            TypeIV.setImageResource(R.drawable.ic_baseline_call_made_24);
        }

        else if(list.get(position).getType() == CallLog.Calls.MISSED_TYPE)
        {
            TypeIV.setImageResource(R.drawable.ic_baseline_call_missed_24);
        }



        return v1;
    }
}
