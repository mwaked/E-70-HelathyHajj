package com.mwtraking.beinmedia.hajjhealthy.models;

public class AdviceModel {

    private int id ;
    private String senderID ;
    private String senderName ;
    private String message ;
    private boolean other ;

    public AdviceModel(String senderName, String message, boolean other) {
        this.senderName = senderName;
        this.message = message;
        this.other = other;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }
}
