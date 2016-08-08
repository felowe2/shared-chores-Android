package com.epicodus.sharedchores.models;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import com.epicodus.sharedchores.Constants;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ServerValue;

import org.parceler.Parcel;

import java.util.HashMap;

@IgnoreExtraProperties

@Parcel
public class ChoreList {

    private String choreTitle;
    private String choreDoer;
    private String choreDescription;
    private Long choreDueDate;
    private HashMap<String, Object> timestampChoreLastChanged;
    private HashMap<String, Object> timestampChoreCreated;
    private HashMap<String, Object> timestampChoreLastChangedReverse;
    private HashMap<String, User> usersChore;

    public ChoreList() {
    }

    public ChoreList(String choreTitle, String choreDoer, String choreDescription, Long choreDueDate) {
        this.choreTitle = choreTitle;
        this.choreDoer = choreDoer;
        this.choreDescription = choreDescription;
        this.choreDueDate = choreDueDate;
        this.timestampChoreCreated = timestampChoreCreated;
        HashMap<String, Object> timestampNowObject = new HashMap<String, Object>();
        timestampNowObject.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
        this.timestampChoreLastChanged = timestampNowObject;
        this.timestampChoreLastChangedReverse = null;
        this.usersChore = new HashMap<>();
    }

    public String getChoreTitle() {
        return choreTitle;
    }

    public String getChoreDoer() {
        return choreDoer;
    }

    public String getChoreDescription() {
        return choreDescription;
    }

    public Long getChoreDueDate() {
        return choreDueDate;
    }

    public HashMap<String, Object> getTimestampChoreLastChanged() {
        return timestampChoreLastChanged;
    }

    public HashMap<String, Object> getTimestampChoreCreated() {
        return timestampChoreCreated;
    }

    public HashMap<String, Object> getTimestampChoreLastChangedReverse() {
        return timestampChoreLastChangedReverse;
    }

    public HashMap getUsersChore() {
        return usersChore;
    }

    public void setTimestampChoreLastChangedToNow() {
        HashMap<String, Object> timestampNowObject = new HashMap<String, Object>();
        timestampNowObject.put(Constants.FIREBASE_PROPERTY_TIMESTAMP, ServerValue.TIMESTAMP);
        this.timestampChoreLastChanged = timestampNowObject;
    }


    //    @JsonIgnore
    public long getTimestampChoreLastChangedLong() {

        return (long) timestampChoreLastChanged.get(Constants.FIREBASE_PROPERTY_TIMESTAMP);
    }

    //    @JsonIgnore
    public long getTimestampChoreCreatedLong() {
        return (long) timestampChoreLastChanged.get(Constants.FIREBASE_PROPERTY_TIMESTAMP);
    }

    //    @JsonIgnore
    public long getTimestampChoreLastChangedReverseLong() {
        return (long) timestampChoreLastChangedReverse.get(Constants.FIREBASE_PROPERTY_TIMESTAMP);
    }

}
