package com.example.lallu.inserttodbapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText key_email_edt,name_edt,user_edt,pass_edt;
    String emailkey,strname,strusernam,strpass;
    DataBaseHelper dbupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        key_email_edt=findViewById(R.id.upemailedt);
        name_edt=findViewById(R.id.upnameedt);
        user_edt=findViewById(R.id.upuseredt);
        pass_edt=findViewById(R.id.uppassedt);
        dbupdate=new DataBaseHelper(this);

    }

    public void updatedata(View view) {
        emailkey=key_email_edt.getText().toString();
        strname=name_edt.getText().toString();
        strusernam=user_edt.getText().toString();
        strpass=pass_edt.getText().toString();
        if (dbupdate.updatedetails(emailkey,strname,strusernam,strpass)==true){
            Toast.makeText(UpdateActivity.this,"Updated",Toast.LENGTH_LONG).show();
        }
    }
}
