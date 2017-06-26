package com.sidharth.attendancemeter.TeacherAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.sidharth.attendancemeter.MainActivity;
import com.sidharth.attendancemeter.R;
import com.sidharth.attendancemeter.Register;

/**
 * Created by Sidharth on 6/16/2017.
 */

public class ClassAdd extends MainActivity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classadd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.add)
        {
            Intent i=new Intent(getApplicationContext(),listwindow.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    
}
