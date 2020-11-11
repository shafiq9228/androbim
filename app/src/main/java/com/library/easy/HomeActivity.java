package com.library.easy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.library.androbim.Andro;
import com.library.androbim.Easy;

public class HomeActivity extends AppCompatActivity {

    Button B2;

    Easy easy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        B2 = findViewById(R.id.B2);
        easy = new Easy(HomeActivity.this);




        B2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Andro.ShowToast("Helllo Android");

                String[] s = new String[]{Manifest.permission.READ_CALL_LOG, Manifest.permission.READ_CONTACTS};

                String[] s1 = new String[]{Manifest.permission.READ_CALL_LOG};

               // requestPermissions(s1,1);


                if(!shouldShowRequestPermissionRationale(s1[0]))
                {

                    easy.WriteAlertDialogEasy(""  + " required", "Please allow it from Settings", new Easy.DialogInt() {
                        @Override
                        public void Positive(DialogInterface dialog2) {

                        }

                        @Override
                        public void Negative(DialogInterface dialog2) {

                        }
                    });
                    easy.ShowAlertDialog(true);
                }





            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        Toast.makeText(this, "  "+  grantResults[0], Toast.LENGTH_SHORT).show();

        easy.WriteAlertDialogEasy("" + permissions[0] + " required", "Please allow it from Settings", new Easy.DialogInt() {
            @Override
            public void Positive(DialogInterface dialog2) {

            }

            @Override
            public void Negative(DialogInterface dialog2) {

            }
        });


        if(grantResults[0] == -1)
        {
            easy.ShowAlertDialog(true);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}