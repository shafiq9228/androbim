package com.library.androbim;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class Easy {

    Context context;

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

    }

    public void WriteAlertDialog(String Title, String Message,String PostiveButtonText, String NegativeButtonText,boolean Cancelable,final DialogInt dialogInterface)
    {

        alertDialog.setTitle(Title);
        alertDialog.setMessage(Message);
        alertDialog.setCancelable(Cancelable);

        alertDialog.setNegativeButton(PostiveButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialogInterface.Negative(dialog);
            }
        });

        alertDialog.setPositiveButton(NegativeButtonText, new DialogInterface.OnClickListener() {
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



}
