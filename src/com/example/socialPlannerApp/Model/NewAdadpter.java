package com.example.socialPlannerApp.Model;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ayirumkannumai.R;

public class NewAdadpter extends BaseAdapter {

	int textview1;	
	public LayoutInflater inflator;	
	ArrayList<String> array;	
		
	public NewAdadpter(Context context, ArrayList<String> array) {
		
		inflator=LayoutInflater.from(context);
		this.array=array;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return array.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		if(arg1==null)
        {
            arg1 = inflator.inflate(R.layout.layout,null);	
            	
            TextView dates = (TextView)arg1.findViewById(R.id.textView1);
            arg1.setTag(dates);
            dates.setText(array.get(arg0));
            	
            
            
            
            
            
        }
		
		
        return arg1;
    }

	
	
	
	
	
	
		
		// TODO Auto-generated method stub
	}

	
