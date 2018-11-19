package com.example.lallu.inserttodbapp;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView displaylist;
    adapter ad;
    DataBaseHelper dbselect;
    ArrayList<String> listid,listname,listdob,listaddr,listphn,listemail,listuser,listpass;
  //  ArrayList<Integer>idlis;
    Button select,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        displaylist=(ListView)findViewById(R.id.datalistview);
        select=(Button)findViewById(R.id.selectbtn);
        update=findViewById(R.id.updatebtn);
        dbselect=new DataBaseHelper(this);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listid=dbselect.getAllIDs();
                listname=dbselect.getAllnames();
                listdob=dbselect.getAlldateofbirth();
                listaddr=dbselect.getAlladdress();
                listphn=dbselect.getAllphone();
                listemail=dbselect.getAllemail();
                listuser=dbselect.getAllusername();
                listpass=dbselect.getAllpasswords();
listname=new ArrayList<String>(66);
                String str = null;
                Cursor rs=dbselect.getData();
                rs.moveToFirst();
                int i = 0;
                while (!rs.isAfterLast()){

                   // listname.add(rs.getString(rs.getColumnIndex(DataBaseHelper.KEY_NAME)));
                  //  listname.add(i,rs.getString(rs.getColumnIndex(DataBaseHelper.KEY_NAME)));
                   // listname.add("sss");
                    i++;

                    rs.moveToNext();


                }
                ad=new adapter();
                displaylist.setAdapter(ad);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DisplayActivity.this,UpdateActivity.class));
            }
        });



    }

   /* @Override
    protected void onResume() {
        listid=dbselect.getAllIDs();
        listname=dbselect.getAllnames();
        listdob=dbselect.getAlldateofbirth();
        listaddr=dbselect.getAlladdress();
        listphn=dbselect.getAllphone();
        listemail=dbselect.getAllemail();
        listuser=dbselect.getAllusername();
        listpass=dbselect.getAllpasswords();
        ad=new adapter();
        displaylist.setAdapter(ad);
        super.onResume();
    }
*/
    class adapter extends BaseAdapter{
        LayoutInflater inflater;

        @Override
        public int getCount() {
            return dbselect.numberOfRows();
            //return listid.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            inflater=(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.content,null);
            ViewHolder holder=new ViewHolder();
           // holder.idtxt=(TextView)view.findViewById(R.id.idtextview);
            holder.nametxt=(TextView)view.findViewById(R.id.nametextview);
            holder.dobtxt=(TextView)view.findViewById(R.id.dobtextview);
            holder.addresstxt=(TextView)view.findViewById(R.id.addresstextview);
            holder.phntxt=(TextView)view.findViewById(R.id.phntextview);
            holder.emailtxt=(TextView)view.findViewById(R.id.emailtextview);
            holder.usertxt=(TextView)view.findViewById(R.id.usertextview);
            holder.passtxt=(TextView)view.findViewById(R.id.passtextview);

          //  holder.idtxt.setText(""+idlis.get(position));
            holder.nametxt.setText(listname.get(position));
            holder.dobtxt.setText(listdob.get(position));
            holder.addresstxt.setText(listaddr.get(position));
            holder.phntxt.setText(listphn.get(position));
            holder.emailtxt.setText(listemail.get(position));
            holder.usertxt.setText(listuser.get(position));
            holder.passtxt.setText(listpass.get(position));
//         int i=0;
//





            return view;
        }
    }
    class ViewHolder{
       // TextView idtxt;
        TextView nametxt;
        TextView dobtxt;
        TextView addresstxt;
        TextView phntxt;
        TextView emailtxt;
        TextView usertxt;
        TextView passtxt;




    }
}
