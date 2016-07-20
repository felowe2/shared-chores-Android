package com.epicodus.sharedchores.models;

import org.parceler.Parcel;

@Parcel
public class Chore {

    private String title;
    private String doer;
    private String description;
    private String dueDate;
    private String pushId;

    public Chore(){}

    public Chore(String title,String doer, String description, String dueDate) {
        this.title = title;
        this.doer = doer;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDoer() {
        return doer;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return  dueDate;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
