package com.sidharth.attendancemeter.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sidharth.attendancemeter.ClassAttr;
import com.sidharth.attendancemeter.R;

import java.util.List;

/**
 * Created by Sidharth on 6/26/2017.
 */

public class ClassAttrAdapter extends ArrayAdapter<ClassAttr> {
    private Context context;
    private List<ClassAttr> list;
    public ClassAttrAdapter( Context context,  List<ClassAttr>list) {
        super(context, R.layout.class_layout,list);
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.class_layout,parent,false);
        TextView title= (TextView) v.findViewById(R.id.title);
        title.setText(list.get(position).getTitle());
        TextView year= (TextView) v.findViewById(R.id.y);
        year.setText(list.get(position).getYear());
        TextView no= (TextView) v.findViewById(R.id.number);
        no.setText(list.get(position).getNo());
        return v;
    }
}
