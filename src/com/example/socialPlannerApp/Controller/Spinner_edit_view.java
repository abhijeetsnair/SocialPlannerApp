package com.example.socialPlannerApp.Controller;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Model.Globals;

public class Spinner_edit_view extends Activity {

	private Spinner spinner;
	private Globals data = Globals.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_edit_view);	

//Adds items in the spinner view 
//based on the layout mentioned in
//the specification sheet		
		addItems();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.spinner_edit_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handles action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void addItems() {
		spinner = (Spinner) findViewById(R.id.spinner1);
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < data.getArrayList().size(); i++) {
			list.add(data.getArrayList().get(i).getEventName());
		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);

		final EditText eventDate = (EditText) findViewById(R.id.date);	
		final EditText eventTime = (EditText) findViewById(R.id.time);	
		final EditText eventVenue = (EditText) findViewById(R.id.venue);
		final EditText eventLocation = (EditText) findViewById(R.id.location);
		final EditText eventNote = (EditText) findViewById(R.id.note);
		final EditText eventAttendees = (EditText) findViewById(R.id.attendees);
		final Button save_button = (Button) findViewById(R.id.button1);

		spinner.setOnItemSelectedListener(new SpinnerItemSelected(this,
				eventDate,eventTime, eventVenue, eventLocation, eventNote,
				eventAttendees, save_button));

	}

}
