package com.example.socialPlannerApp.Controller;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Model.EventsoftheDayAdapter;
import com.example.socialPlannerApp.Model.Globals;
import com.example.socialPlannerApp.Model.StoreEvents;

public class ShowEventsofDay extends Activity {

	public String date;
	private Globals data = Globals.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_eventsof_day);

		// Retrieves the date information passed from the previous	
		//activity
		@SuppressWarnings("unused")
		Intent i = getIntent();
		date = getIntent().getExtras().getString("eventDate");

		// Adding the adapter to this current activity
		final TextView view = (TextView) findViewById(R.id.show_text);
		final ListView show_events = (ListView) findViewById(R.id.show_view);
		
			
			
		if (events().size() > 0) {
			view.setText("Events for the day ! "); 

				
			
		} else {
			view.setText("No Events ! ");	
			
			
		}
		//Setting the events Adapter
		show_events.setAdapter(new EventsoftheDayAdapter(getBaseContext(),
				events(), view));
		
		
		// setting events on buttons
		
		
			
			
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_eventsof_day, menu);
		return true;
	}

	public ArrayList<StoreEvents> events() {

		ArrayList<StoreEvents> events = new ArrayList<StoreEvents>();
		for (int i = 0; i < data.getArrayList().size(); i++) {
			if (data.getArrayList().get(i).getDate().compareTo(date) == 0) {
				events.add(data.getArrayList().get(i));
				// we probably also have to sort them out by date
			}

		}

		return events;

	}	
		
	public void addevents()	
	{	
		Intent activity =new Intent(getBaseContext(),SubActivity.class);	
		startActivity(activity);
			
			
		
	}
			
			
		
	}
		
	


