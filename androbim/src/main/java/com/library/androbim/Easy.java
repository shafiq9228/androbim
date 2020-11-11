package com.library.androbim;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;

public class Easy {

    private Context context;

    ProgressDialog dialog;

    AlertDialog.Builder alertDialog;
    AlertDialog dialog1;



    public Easy(Context context)
    {
        this.context = context;
        dialog = new ProgressDialog(context);


        alertDialog = new AlertDialog.Builder(context);



    }


    public void ShowToast(String S1)
    {
        Toast.makeText(context, ""+S1, Toast.LENGTH_SHORT).show();

    }

    public void WriteProgreeDialog(String title, String msg)
    {
        dialog.setTitle(""+title);
        dialog.setMessage(""+msg);
        dialog.setCancelable(false);

    }

    public ProgressDialog SampleDialog()
    {
        dialog.setTitle("Please Wait");
        dialog.setMessage("Loading....");
       dialog.setCancelable(false);

       return dialog;
    }

    public void WriteAlertDialog(String Title, String Message,String PostiveButtonText, String NegativeButtonText,boolean Cancelable,final DialogInt dialogInterface)
    {

        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.setCancelable(Cancelable);

        alertDialog.setNegativeButton(NegativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialogInterface.Negative(dialog);
            }
        });

        alertDialog.setPositiveButton(PostiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogInterface.Positive(dialog);
            }
        });

        dialog1 = alertDialog.create();


    }

    public void WriteAlertDialogEasy(String Title, String Message,final DialogInt dialogInterface)
    {

        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.setCancelable(false);

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialogInterface.Negative(dialog);
            }
        });

        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialogInterface.Positive(dialog);
            }
        });

        dialog1 = alertDialog.create();


    }



    public void ShowAlertDialog(boolean bool)
    {
        if(bool)
        {
            dialog1.show();
        }
        else
        {
            dialog1.dismiss();
        }
    }

    public void ShowDialog(boolean bool)
    {
        if(bool)
        {
            dialog.show();
        }
        else
        {
            dialog.dismiss();
        }

    }



    public interface DialogInt
    {
        void Positive(DialogInterface dialog2);
        void Negative(DialogInterface dialog2);
    }

    public void Post(String url, JSONObject obj, final int RequestCode, final ResponseListener ResponseListener)
    {

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.POST, url, obj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                ResponseListener.Response(response, RequestCode);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                ResponseListener.Error(error, RequestCode);
            }
        });

        MySingleton.getInstance(context).AddRequest(objectRequest);

    }


    public interface ResponseListener
    {
        void Response(JSONObject response, int RequestCode);
        void Error(VolleyError error, int RequestCode);
    }

    public void Permissions(final String[] per, final Activity activity)
    {


        for (int i = 0 ;i<per.length;i++)
        {
            if(ContextCompat.checkSelfPermission(context,per[i]) == PackageManager.PERMISSION_GRANTED)
            {
               // Toast.makeText(context, "Hello go", Toast.LENGTH_SHORT).show();

            }
            else
            {
                ActivityCompat.requestPermissions(activity,per,1);
            }
        }

    }

    public void LoadCalls(final ListView LV)
    {
        CallTask callTask = new CallTask(SampleDialog(), new CallTask.MyLogs() {
            @Override
            public void LogResults(ArrayList<CallModel> list) {

                CallAdapter adapter = new CallAdapter(context,list);

                LV.setAdapter(adapter);

            }
        });

        callTask.execute();
    }






}
