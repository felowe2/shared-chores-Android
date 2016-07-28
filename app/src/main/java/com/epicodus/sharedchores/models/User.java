package com.epicodus.sharedchores.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Parcel

@IgnoreExtraProperties
public class User {

    private String name;
    private String email;
    private String id;
    private List<String> choreIds = new ArrayList<>();

    public User() {
    }


    public User(String id, String name, String email, List<String> choreIds) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.choreIds = choreIds;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public List<String> getChoreIds() {
        return choreIds;
    }
    public void setChoreIds(List<String> choreIdList) {
        this.choreIds = choreIdList;
    }

    public void addChoreId(String choreId) {
        this.choreIds.add(choreId);
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("id", id);
        result.put("email", email);
        result.put("choreIds", choreIds);

        return result;
    }

}

