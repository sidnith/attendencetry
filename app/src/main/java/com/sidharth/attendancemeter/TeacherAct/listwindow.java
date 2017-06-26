package com.sidharth.attendancemeter.TeacherAct;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sidharth.attendancemeter.R;

/**
 * Created by Sidharth on 6/18/2017.
 */

public class listwindow extends Activity {
    EditText year;
    EditText section;
    EditText no;
    EditText title;
    DatabaseReference data;
    ProgressDialog progressDialog;
    Button add;
    int i=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listwindow);
        data= FirebaseDatabase.getInstance().getReference("classadd");
        year=(EditText)findViewById(R.id.year);
        section=(EditText)findViewById(R.id.sec);
        no=(EditText)findViewById(R.id.no);
        title=(EditText)findViewById(R.id.title);
        progressDialog=new ProgressDialog(this);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                adddata();
                progressDialog.setMessage("Adding Class");
                progressDialog.show();
            }
        });

    }

    public void  adddata(){
       final String y=year.getText().toString().trim();
        final String sec=section.getText().toString().trim();
        final String n=no.getText().toString().trim();
        final String t=title.getText().toString().trim();
        data.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(y)){
                    exisadd(y,sec,n,t);
                }
                else{
                    adddo(y,sec,n,t);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    public  void adddo(String y,String sec,String n,String t){

            data=FirebaseDatabase.getInstance().getReference("classadd");
            TeacherClassAdd addr=new TeacherClassAdd(y,sec,n,t);
            data.child(sec).child(t).setValue(addr);
            Toast.makeText(getApplicationContext(),"Class Added",Toast.LENGTH_SHORT).show();
            Intent i=new Intent(getApplicationContext(),ClassAdd.class);
            i.putExtra("year",y);
            i.putExtra("sec",sec);
            i.putExtra("no",n);
            i.putExtra("title",t);
            startActivity(i);

    }

    public void exisadd(String y,String sec,String n,String t){
        data=FirebaseDatabase.getInstance().getReference("classadd").child(sec);
        TeacherClassAdd addr=new TeacherClassAdd(y,sec,n,t);
        data.child(t).setValue(addr);
        Toast.makeText(getApplicationContext(),"Class Added",Toast.LENGTH_SHORT).show();
        Intent i=new Intent(getApplicationContext(),ClassAdd.class);
        i.putExtra("year",y);

        i.putExtra("no",n);
        i.putExtra("title",t);
        startActivity(i);

    }
}
