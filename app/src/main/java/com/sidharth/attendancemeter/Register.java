package com.sidharth.attendancemeter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Sidharth on 6/13/2017.
 */

public class Register extends Activity{
    EditText name;
    EditText year;
    EditText roll;
    EditText dob;
    Button reg;
    ProgressDialog progressDialog;
    DatabaseReference databaseadd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseadd= FirebaseDatabase.getInstance().getReference("Studentreg");
        setContentView(R.layout.register);
        name=(EditText)findViewById(R.id.name);
        year=(EditText)findViewById(R.id.year);
        roll=(EditText)findViewById(R.id.rollno);
        dob=(EditText)findViewById(R.id.dob);
        reg=(Button)findViewById(R.id.reg);
        progressDialog=new ProgressDialog(this);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
                progressDialog.setMessage("Registering User ....");
                progressDialog.show();
            }
        });
    }

    private void adddata(){
        String n=name.getText().toString().trim();
        String y=year.getText().toString().trim();
        String r=roll.getText().toString().trim();
        String d=dob.getText().toString().trim();

        if(!TextUtils.isEmpty(n)&&!TextUtils.isEmpty(r)&&!TextUtils.isEmpty(y)&&!TextUtils.isEmpty(d)){

            Add add=new Add(n,y,r,d);
            databaseadd.child(r).setValue(add);

            Toast.makeText(getApplicationContext(),"Student Registered",Toast.LENGTH_SHORT).show();
            finish();
            Intent i=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);

        }else{
            Toast.makeText(getApplicationContext(),"Enter valid information",Toast.LENGTH_SHORT).show();
        }
    }
}
