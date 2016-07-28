package com.epicodus.sharedchores.models;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import java.util.HashMap;
import java.util.Map;


@IgnoreExtraProperties

@Parcel
public class Chore {

    private String title;
    private String doer;
    private String description;
    private String dueDate;
    private String timestamp;
    private String id;
    private String uid;

    public Chore(){}

    public Chore(String id, String title,String doer, String description, String dueDate, String timestamp) {
        this.id = id;
        this.title = title;
        this.doer = doer;
        this.description = description;
        this.dueDate = dueDate;
        this.timestamp = timestamp;

    }

    public String getId() {
        return id;
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
    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public void setChore(String id, String title,String doer, String description, String dueDate, String timestamp) {
        this.id = id;
        this.title = title;
        this.doer = doer;
        this.description = description;
        this.dueDate = dueDate;
        this.timestamp = timestamp;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("title", title);
        result.put("doer", doer);
        result.put("description", description);
        result.put("dueDate", dueDate);
        result.put("timestamp", timestamp);
        result.put("uid", uid);

        return result;
    }

}
