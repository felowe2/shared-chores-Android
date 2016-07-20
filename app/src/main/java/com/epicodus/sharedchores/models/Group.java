package com.epicodus.sharedchores.models;

import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Group {
    private String name;
    private String pushId;
    private List<String> members;

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

    public List<String> getMembers() {
        return members;
    }

    public void addMember(User member){

    }
}