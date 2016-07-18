package com.epicodus.sharedchores.models;

import org.parceler.Parcel;

@Parcel
public class Group {

    private String name;
    private String pushId;

    public Group(){}

    public Group(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}