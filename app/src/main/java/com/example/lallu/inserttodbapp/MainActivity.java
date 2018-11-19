package com.example.lallu.inserttodbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtname,edtdob,edtaddress,edtphone,edtemail,edtuser,edtpass;
    String name,dob,address,phone,email,username,password;


    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DataBaseHelper(this);
        edtname=findViewById(R.id.nameedt);
        edtdob=findViewById(R.id.dateedt);
        edtaddress=findViewById(R.id.addressedt);
        edtphone=findViewById(R.id.phnedt);
        edtemail=findViewById(R.id.emailedt);
        edtuser=findViewById(R.id.usernameedt);
        edtpass=findViewById(R.id.passwordedt);
       // edt
    }

    public void saveData(View view) {
        name=edtname.getText().toString();
        dob=edtdob.getText().toString();
        address=edtaddress.getText().toString();
        phone=edtphone.getText().toString();
        email=edtemail.getText().toString();
        username=edtuser.getText().toString();
        password=edtpass.getText().toString();
        if (db.insertData(name,dob,address,phone,email,username,password)){
            Log.e("Data","Inserted");
        }
        else
            Log.e("Data","Not Inserted");
        startActivity(new Intent(MainActivity.this,DisplayActivity.class));
        finish();
    }

    public void clearData(View view) {
    }
}
