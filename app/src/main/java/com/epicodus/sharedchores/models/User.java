package com.epicodus.sharedchores.models;

import com.google.firebase.database.IgnoreExtraProperties;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel

@IgnoreExtraProperties
public class User {
    String name;
    String email;
    List<String> choreList = new ArrayList<>();
    //Strin uid;

  private String pushId;

       public User(){}


      public User(String name, String email){
        this.name = name;
       this.email = email;
        }

    public List<String> getChoreList() {
        return choreList;
    }

    public void setChoreList(List<String> choreList) {
        this.choreList = choreList;
    }

   public String getName() {
          return name;
   }
     public String getEmail(){
           return email;
       }

    public String getPushId() {
           return pushId;
       }

       public void setPushId(String pushId) {
      this.pushId = pushId;  }
    }

