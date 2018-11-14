package com.example.socialPlannerApp.Controller;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Model.Globals;

public class UpdateCalender extends BaseAdapter {
	private Globals data = Globals.getInstance();
	private ArrayList<String> array ;
	private LayoutInflater inflator;
	
	
	public UpdateCalender(Context context,
			ArrayList<String> dates) {	
			array =dates;
			inflator = LayoutInflater.from(context);
			
		
		// TODO Auto-generated constructor stub
	}

	@SuppressLint({ "ViewHolder", "InflateParams" })
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		// TODO Auto-generated method stub
		
		if(convertView==null){
		ArrayList<String> selectedDates = new ArrayList<String>();
		for (int i = 0; i < array.size(); i++) {

			for (int j = 0; j < data.getArrayList().size(); j++) {
				if (data.getArrayList().get(j).getDate()
						.compareTo(array.get(i)) == 0) {
					selectedDates.add(array.get(i));
				}
			}

		}

		convertView = inflator.inflate(R.layout.layout, null);
		TextView view = (TextView) convertView
				.findViewById(R.id.textView1);
		view.setText(array.get(position));

		for (int i = 0; i < selectedDates.size(); i++) {
			if (array.get(position) == selectedDates.get(i)) {
				view.setBackgroundColor(0xfff00000);
			}
		}
		
		}
		return convertView;
		
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return array.get(position);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.size();
	}

	
}
