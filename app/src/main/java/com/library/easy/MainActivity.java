package com.library.easy;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.library.androbim.CallModel;
import com.library.androbim.CallTask;
import com.library.androbim.Easy;
import com.library.easy.models.BAdapter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    Button B1;

    TextView T1;

    public static int h1 =0;

    Easy easy;
    ListView LV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        easy = new Easy(MainActivity.this);
        LV = findViewById(R.id.LV);

        requestPermissions(new String[]{Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_CONTACTS}, 1);



        B1 = findViewById(R.id.B1);
       // T1 = findViewById(R.id.T1);


        B1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                easy.LoadCalls(LV);


            }
        });



    }






}