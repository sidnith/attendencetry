package com.sidharth.attendancemeter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.Selection;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    ImageView eye;
    EditText pass;
    EditText id;
    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pass=(EditText)findViewById(R.id.pass);
        id=(EditText)findViewById(R.id.id);
        eye=(ImageView)findViewById(R.id.eye);
        eye.setOnTouchListener(this);
        ref= FirebaseDatabase.getInstance().getReference();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int pos=pass.getText().toString().length();

        Editable etext=pass.getText();
        switch ( event.getAction() ) {
            case MotionEvent.ACTION_DOWN:

                pass.setInputType(InputType.TYPE_CLASS_TEXT);
                pass.setSelection(pass.getText().length());
                break;
            case MotionEvent.ACTION_UP:

                pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                pass.setSelection(pass.getText().length());
                break;
        }
        return true;
    }

    public void onClick(View v){
        if(v.getId()==R.id.reg){
            Intent i=new Intent(this,Register.class);
            startActivity(i);
        }
    }

    public void onquery(View v) {
        final String idm=id.getText().toString().trim();
        final String passw=pass.getText().toString().trim();
        if (v.getId() == R.id.teachlog) {
            final Query query = ref.child("Studentreg").orderByChild("roll").equalTo(passw);
            query.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Query query1=ref.child("Studentreg").orderByChild("name").equalTo(idm);
                        query1.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                if(dataSnapshot.exists()){
                                    Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();

                                }

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
