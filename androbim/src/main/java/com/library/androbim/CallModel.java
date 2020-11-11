package com.library.androbim;

public class CallModel{

    public String name;
    public String phone;
    public long date;
    public int type;
    public int duration;
    public String address;


    public CallModel()
    {

    }

    public CallModel(String name, String phone, long date, int type, int duration, String address) {
        this.name = name;
        this.phone = phone;
        this.date = date;
        this.type = type;
        this.duration = duration;
        this.address = address;


    }


    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public long getDate() {
        return date;
    }

    public int getType() {
        return type;
    }

    public int getDuration() {
        return duration;
    }


    public String getAddress() {
        return address;
    }



}
