package com.example.myapplication;

public class Records {
    private String Recorder;
    private String Reason;
    private Integer Value;
    //private ContactsContract.Data data;


    public String getRecorder() {
        return Recorder;
    }

    public String getReason() {
        return Reason;
    }

    public Integer getValue() {
        return Value;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public void setRecorder(String recorder) {
        Recorder = recorder;
    }

    public void setValue(Integer value) {
        Value = value;
    }

}
