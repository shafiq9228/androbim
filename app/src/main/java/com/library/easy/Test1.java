package com.library.easy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Test1 {


    Context context;

    public void Inr(final Context context, final int V){

        this.context = context;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                View v1 = inflater.inflate(V,new LinearLayout(context));

                TextView TV= v1.findViewById(R.id.T1);

                TV.setText("Hello Android");
                // TT.setText("gfchvjbkn");
            }
        };

        runnable.run();


        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
    }
}
