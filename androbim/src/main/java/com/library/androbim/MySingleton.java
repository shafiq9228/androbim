package com.library.androbim;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {

    private static MySingleton instance;
    private Context context;

    private RequestQueue requestQueue;

    MySingleton(Context context)
    {
        this.context = context;
        this.requestQueue = GetQueue();
    }


    public static synchronized MySingleton getInstance(Context context)
    {

        if(instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }
    public RequestQueue GetQueue()
    {

        requestQueue = Volley.newRequestQueue(context);

        return requestQueue;
    }

    public<T> void AddRequest(Request<T> request)
    {
        requestQueue.add(request);
    }

}
