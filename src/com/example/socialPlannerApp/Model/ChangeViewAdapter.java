package com.example.socialPlannerApp.Model;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.ayirumkannumai.R;

public class ChangeViewAdapter implements ListAdapter {

	public Context context;
	public ArrayList<String> array;	
	private LayoutInflater inflator;	
	Globals global = Globals.getInstance();

	
	public ChangeViewAdapter(Context context, ArrayList<String> array) {	
		
		this.context =context;
		this.array=array;	
		inflator =LayoutInflater.from(context);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		// TODO Auto-generated method stub
		
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

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ArrayList<String> selectedDates =new ArrayList<String>();
		for (int i=0;i<array.size();i++)
		{	
			for( int j=0;i<global.getArrayList().size();i++)
			{	
					if(global.getArrayList().get(j).getDate()==array.get(i))	
					{	
							selectedDates.add(array.get(i));
					}
			}
		}
	convertView =inflator.inflate(R.layout.layout, null);
	TextView view = (TextView)convertView.findViewById(R.id.textView1);
	view.setText(array.get(position));
	
	for(int i=0;i<selectedDates.size();i++)
	{	
	if(array.get(position)==selectedDates.get(i));
		view.setBackgroundColor(0xfff00000);
	}
	
		
		
		
		
		
		
		
		
		return convertView;
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled(int position) {
		// TODO Auto-generated method stub
		return false;
	}

}
