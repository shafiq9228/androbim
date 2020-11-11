package com.library.androbim;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class Andro {

    public static Context mycontext;
   public ProgressDialog dialog;


    public Andro(Context context)
    {
         mycontext = context;
        dialog = new ProgressDialog(context);

       // Toast.makeText(context, "Intro", Toast.LENGTH_SHORT).show();
    }

    public static void Init(Context context)
    {
        if(mycontext == null)
        {
            mycontext = context;
            Toast.makeText(mycontext, "Initialized", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(mycontext, "Already existed", Toast.LENGTH_SHORT).show();
        }
    }

    public static void ShowToast(String S1)
    {
        Toast.makeText(mycontext, ""+S1, Toast.LENGTH_SHORT).show();
    }

    public void WriteProgreeDialog(String title, String msg)
    {
        dialog.setTitle(""+title);
        dialog.setMessage(""+msg);

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


}
