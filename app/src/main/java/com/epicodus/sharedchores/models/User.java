package com.epicodus.sharedchores.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Parcel

@IgnoreExtraProperties
public class User {

    private String name;
    private String email;
    private HashMap<String, Object> timestampUser;
    private boolean hasUserLoggedIn;

    public User() {
    }

    public User(String name, String email, HashMap<String, Object> timestampUser) {
        this.name = name;
        this.email = email;
       this.timestampUser = timestampUser;
        this.hasUserLoggedIn = false;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public  HashMap<String, Object> getTimestampUser(){
    return timestampUser;
    }

    public boolean hasUserLoggedIn(){
      return hasUserLoggedIn;
    }


}

