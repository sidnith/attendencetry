package com.sidharth.attendancemeter.TeacherAct;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.sidharth.attendancemeter.ClassAttr;
import com.sidharth.attendancemeter.MainActivity;
import com.sidharth.attendancemeter.R;
import com.sidharth.attendancemeter.Register;
import com.sidharth.attendancemeter.adapter.ClassAttrAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sidharth on 6/16/2017.
 */

public class ClassAdd extends MainActivity{
    private ListView listView;
    private List<ClassAttr> list;
   private  ClassAttrAdapter classAttrAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.classadd);
        listView= (ListView) findViewById(R.id.listViewProduct);

        list = new ArrayList<ClassAttr>();
        classAttrAdapter=new ClassAttrAdapter(this,list);
        listView.setAdapter(classAttrAdapter);

        Intent i=getIntent();
        list.add(new ClassAttr(i.getStringExtra("title"),i.getStringExtra("year"),i.getStringExtra("no")));
        list.add(new ClassAttr(i.getStringExtra("title"),i.getStringExtra("year"),i.getStringExtra("no")));
        classAttrAdapter.notifyDataSetChanged();

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
