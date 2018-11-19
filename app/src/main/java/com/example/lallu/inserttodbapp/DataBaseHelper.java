package com.example.lallu.inserttodbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Lallu on 13-11-2018.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String TAG="RESULT";

    public static final String TABLE_NAME="Persons";
    public static final String KEY_ID="Person_Id";
    public static final String KEY_NAME="Name";
    public static final String KEY_DOB="dob";
    public static final String KEY_ADDRESS="Address";
    public static final String KEY_PHONE="phone";
    public static final String KEY_EMAIL="email";
    public static final String KEY_USERNAME="username";
    public static final String DATABASE_NAME="MyData.db";
    public static final String KEY_PASSWORD="password";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        Log.e(TAG,"Database Created");
    }
// creating the table
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Persons " +
                "(Person_Id integer,Name text, dob date " +
                ",Address text,phone text, email text primary key,username text ,password text)");
        Log.e(TAG,"Table Created");

    }


// if table is already exist then it will be drop (delte) the table and recreated
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
        Log.e(TAG,"Table Exist");

    }

    //  Insert method for inserting data into table
    //begin
    public boolean insertData(String person_name,String dat_of_birth,String person_Address,String person_phone,String person_email,String person_username,String person_password){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("Name",person_name);
        values.put("dob",dat_of_birth);
        values.put("Address",person_Address);
        values.put("phone",person_phone);
        values.put("email",person_email);
        values.put("username",person_username);
        values.put("password",person_password);
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        Log.e(TAG,"Data Inserted");
        return true;
    }

    // Selection
   // Selct id
    public ArrayList<String> getAllIDs() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_ID)));
            res.moveToNext();
        }
        return array_list;
    }

    // select name
    public ArrayList<String> getAllnames() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_NAME)));
            res.moveToNext();
        }
        return array_list;
    }

    // select dob
    public ArrayList<String> getAlldateofbirth() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_DOB)));
            res.moveToNext();
        }
        return array_list;
    }
    //select address
    public ArrayList<String> getAlladdress() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_ADDRESS)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllphone() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_PHONE)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllemail() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_EMAIL)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllusername() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_USERNAME)));
            res.moveToNext();
        }
        return array_list;
    }
    public ArrayList<String> getAllpasswords() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(KEY_PASSWORD)));
            res.moveToNext();
        }
        return array_list;
    }



    // update data

    public boolean updatedetails (String email,String name,String username,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,name);
        contentValues.put(KEY_USERNAME,username);
        contentValues.put(KEY_PASSWORD,password);

        db.update(TABLE_NAME, contentValues, "email =? ", new String[] { email } );
        return true;
    }

// number of rows

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    // Select all details
    public Cursor getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        //   Cursor res =  db.rawQuery( "select * from SchedledMeetings where Meeting_Id="+addeddate+"", null );
        Cursor res =  db.rawQuery( "select * from "+TABLE_NAME, null );

        return res;
    }


}
