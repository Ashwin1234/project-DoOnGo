package com.example.ashwinb.myapplication;

public class task {
    String tname;
    String date;
    int uid;
    int tid;
    String location;
    String documentid;
    public task(String tname,String date,int uid,int tid,String location){
        tname=this.tname;
        date=this.date;
        uid=this.uid;
        tid=this.tid;
        location=this.location;
    }
    public String getDocumentId(){
        return documentid;
    }
    public void setDocumentId(String id){
        documentid=id;
    }
    public String getName(){
        return tname;
    }
    public String getDate(){
        return date;
    }
    public String getLocation(){
        return location;
    }
    public int getuid(){
        return uid;
    }
    public int tid(){
        return tid;
    }
}
