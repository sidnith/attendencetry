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

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    ImageView eye;
    EditText pass;
    Selection sel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pass=(EditText)findViewById(R.id.pass);
        eye=(ImageView)findViewById(R.id.eye);
        eye.setOnTouchListener(this);
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
}
