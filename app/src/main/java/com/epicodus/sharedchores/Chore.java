package com.epicodus.sharedchores;


public class Chore {

    private String mDoer;
    private String mDescription;
    private String mDueDate;


    public Chore(String doer, String description, String dueDate) {
        this.mDoer = doer;
        this.mDescription = description;
        this.mDueDate = dueDate;
    }

    public String getDoer() {
        return mDoer;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getDueDate() {
        return  mDueDate;
    }
}
