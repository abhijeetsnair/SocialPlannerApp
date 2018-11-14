package com.example.socialPlannerApp.Controller;

import com.example.socialPlannerApp.Model.Globals;
import com.example.socialPlannerApp.Model.StoreEvents;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SpinnerItemSelected implements OnItemSelectedListener {
	
	private Globals data = Globals.getInstance();
	private Context context;
	private StoreEvents events;		
	private EditText eventDate;
	private EditText time;
	private EditText eventVenue;
	private EditText eventLocation; 
	private EditText eventNote;
	private EditText eventAttendees; 
	private Button save_button;
	private String event_name;
	

	public SpinnerItemSelected(Context context, EditText eventDate,
			EditText time,EditText eventVenue, EditText eventLocation, EditText eventNote,
			EditText eventAttendees,Button save_button) {	
		this.context=context;
		this.eventDate = eventDate;
		this.time=time;
		this.eventVenue = eventVenue;
		this.eventLocation = eventLocation;
		this.eventNote = eventNote;
		this.eventAttendees = eventAttendees;
		this.save_button =save_button;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
		Toast.makeText(parent.getContext(), "On item Selected Listener  : "+ parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
		
			//searches and gets the event Item from the array with eventName
			events =searchEvent(parent.getItemAtPosition(position).toString());					
				
			event_name =parent.getItemAtPosition(position).toString();
			eventDate.setText(events.getDate());	
			time.setText(events.getTime());
			eventVenue.setText(events.getVenue());
			eventLocation.setText(events.getLocation());
			eventNote.setText(events.getNote());
			eventAttendees.setText(events.getAttendees());
			
			
			save_button.setTag(events);
			save_button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					saveData(event_name,eventDate.getText().toString(),eventVenue.getText().toString(),eventLocation.getText().toString(),eventNote.getText().toString(),eventAttendees.getText().toString());
					 ((Activity)(context)).finish();
				}
			});
		
		
			
			
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
		//when you do not select anything	
			 
			
		
	}
	
	public StoreEvents searchEvent(String event) 	
	{	
		
	for( int i=0;i<data.getArrayList().size();i++)
	{		
		if(event.compareTo(data.getArrayList().get(i).getEventName())==0)
		{	
			 events =new StoreEvents(data.getArrayList().get(i).getEventName(), data.getArrayList().get(i).getDate(),data.getArrayList().get(i).getTime(), data.getArrayList().get(i).getVenue(), data.getArrayList().get(i).getLocation(), data.getArrayList().get(i).getNote(), data.getArrayList().get(i).getAttendees(), data.getArrayList().get(i).getId());
		}
	}
		return events;
	}
	
	public void saveData(String eventName,String date,String venue,String location,String note,String attendees ) 	
	{	
		
	for( int i=0;i<data.getArrayList().size();i++)
	{		
		if(eventName.compareTo(data.getArrayList().get(i).getEventName())==0)
		{	
			 data.getArrayList().get(i).setEventName(eventName);
			 data.getArrayList().get(i).setDate(date);
			 data.getArrayList().get(i).setVenue(venue);
			 data.getArrayList().get(i).setLocation(location);
			 data.getArrayList().get(i).setNote(note);
			 data.getArrayList().get(i).setAtttendees(attendees);
			 
		
			
		}
	}
	

	
	
	}
	

	
	
	
		
	
}
