package com.example.ashwinb.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//Database page.
public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "task_db";
    public static final String TABLE_NAME1="task_table";
    public static final String COL_11="tid";
    public static final String COL_12="tname";
    public static final String COL_13="latitude";
    public static final String COL_14="longitude";
    public static final String COL_15="start_time";
    public static final String COL_16="end_time";
    public static final String COL_17="date";
    public static final String TABLE_NAME2="user_table";
    public static final String COL_21="uid";
    public static final String COL_22="name";
    public static final String COL_23="email";
    public static final String COL_24="phone";
    public static final String COL_25="profile";
    public static final String TABLE_NAME3="local_vendor";
    public static final String COL_31="vid";
    public static final String COL_32="vendor_name";
    public static final String COL_33="vendor_phone";
    public static final String COL_34="latitude";
    public static final String COL_35="longitude";
    public static final String TABLE_NAME4="task_completion";
    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME1+" (tid INTEGER PRIMARY KEY AUTOINCREMENT,tname TEXT,latitude INTEGER,longitude INTEGER,start_time TEXT,end_time TEXT,date TEXT)");
        db.execSQL("create table "+TABLE_NAME2+" (uid INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, email TEXT,phone NUMBER,profile TEXT )");
        db.execSQL("create table "+TABLE_NAME3+" (vid INTEGER PRIMARY KEY AUTOINCREMENT,vendor_name TEXT,vendor_phone INTEGER,latitude INTEGER,longitude INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        onCreate(db);

    }
}
