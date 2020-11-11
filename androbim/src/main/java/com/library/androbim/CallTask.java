package com.library.androbim;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.text.TextUtils;

import java.util.ArrayList;

public class CallTask extends AsyncTask<Void,Void, ArrayList<CallModel>> {


    ProgressDialog dialog;
    Context context;

    MyLogs logs;

    public CallTask(ProgressDialog dialog, MyLogs logs)
    {
        this.dialog = dialog;
        context = dialog.getContext();
        this.logs = logs;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();

    }

    private String queryPhone(String number)
    {

        String name = null;
        Uri uri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        Cursor cursor = context.getContentResolver().query(uri, new String[]{ContactsContract.PhoneLookup.DISPLAY_NAME}, null, null, null);
        if (cursor.moveToFirst()) {
            name = cursor.getString(0);
        }
        cursor.close();
        return name;
    }

    @Override
    protected ArrayList<CallModel> doInBackground(Void... voids) {

        long tt = 30*24*60*60*1000L;
        long ln = System.currentTimeMillis() - tt;

        ArrayList<CallModel> MyList = new ArrayList<>();
       // "phone_account_address"

        String[] clmns= {CallLog.Calls.CACHED_NAME,CallLog.Calls.NUMBER,"date",CallLog.Calls.TYPE,CallLog.Calls.DURATION,"phone_account_address"};
        Cursor cursor = context.getContentResolver().query(Uri.parse("content://call_log/calls"),clmns,"date>"+ln,null, "date DESC LIMIT 2000");

//            for (String s:cursor.getColumnNames())
//            {
//                MyList.add(s);
//            }

        if(cursor.moveToFirst())
        {
            do{

                String CachedName = cursor.getString(0);
                String number = cursor.getString(1);

                if(TextUtils.isEmpty(CachedName))
                {
                    CachedName = queryPhone(number);

                }

                CallModel callSetter= new CallModel(CachedName,cursor.getString(1),cursor.getLong(2),cursor.getShort(3),cursor.getShort(4),cursor.getString(5));
                MyList.add(callSetter);


            }while (cursor.moveToNext());


        }
        else
        {
            cursor.close();
            return MyList;
        }
        cursor.close();

        return MyList;
    }

    @Override
    protected void onPostExecute(ArrayList<CallModel> callSetters) {
        super.onPostExecute(callSetters);

        dialog.dismiss();

        logs.LogResults(callSetters);


        // Toast.makeText(context, ""+callSetters.get(0).phone, Toast.LENGTH_SHORT).show();
    }

    public interface MyLogs
    {
        void LogResults(ArrayList<CallModel> list);
    }
}