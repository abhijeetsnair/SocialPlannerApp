package com.example.socialPlannerApp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Controller.ListClickHandler;
import com.example.socialPlannerApp.Controller.PlannerListView;
import com.example.socialPlannerApp.Controller.Spinner_edit_view;
import com.example.socialPlannerApp.Controller.SubActivity;
import com.example.socialPlannerApp.Controller.UpdateCalender;
import com.example.socialPlannerApp.Model.Calender_model;
import com.example.socialPlannerApp.Model.Globals;
import com.example.socialPlannerApp.Model.NewAdadpter;
import com.example.socialPlannerApp.Model.StoreEvents;

public class MainActivity extends Activity {

	// Variables
	private Context context;
	public ArrayList<StoreEvents> eventPlanner;
	public GridView view;
	private String text;
	@SuppressWarnings("unused")
	private Globals data = Globals.getInstance();
	private Calender_model cal ;
	private NewAdadpter adapter;
	LayoutInflater inflator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		cal =new Calender_model();
		setContentView(R.layout.activity_main);
		context = this;
		inflator = LayoutInflater.from(context);
		
		//Initializing the calendar view
		cal.setMonths();
		cal.getCalenderInfo();
		cal.setDaysWeek();
		
		// Storing events in the event planner array
		eventPlanner = new ArrayList<StoreEvents>();
		GridView weekly_view = (GridView) findViewById(R.id.days_of_week);
		ArrayAdapter<String> days_adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, cal.getDays_week());
		weekly_view.setAdapter(days_adapter);

		// GridView for Calendar
		final GridView gridView = (GridView) findViewById(R.id.calender_view);
		this.view = gridView;
		
		adapter = new NewAdadpter(this, cal.getCal_months());
		gridView.setAdapter(adapter);	
			
			
		//Setting the Current month text view to the current month
		final TextView view = (TextView) findViewById(R.id.textView1);
		view.setText( "  "+cal.getCurrMonthString()+"  "+cal.getCurrentYear());	
			
		// Listener for the gridview component
		gridView.setOnItemClickListener(new ListClickHandler(context));

//		// Forward and Backward buttons on the view updates screen
//		final Button forwardButtton = (Button) findViewById(R.id.forward_button);
//		final Button backButton = (Button) findViewById(R.id.back_button);
//
//		
//		// Next calendar date
//		forwardButtton.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				gridView.setAdapter(new ArrayAdapter<String>(context,
//						R.layout.layout, R.id.textView1, cal.getCal_months()));
//				final TextView view = (TextView) findViewById(R.id.textView1);
//				view.setText("June 2014");
//
//			}
//		});
//
//		// Back button on the main screen
//		backButton.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				gridView.setAdapter(new ArrayAdapter<String>(context,
//						R.layout.layout, R.id.textView1, cal.getCal_months()));
//				final TextView view = (TextView) findViewById(R.id.textView1);
//				view.setText("May 2014");
//			}
//		});
//
		// Adding an Event to the calender
		Button add_event = (Button) findViewById(R.id.add_button);
		add_event.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				addEvents();
			}
		});

		Button editButton = (Button) findViewById(R.id.edit_Button);
		editButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getBaseContext(),
						Spinner_edit_view.class);
				startActivity(intent);

			}
		});

		// show all events in the List
		Button show_events = (Button) findViewById(R.id.show_all_events);
		show_events.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//Shows all events of the grid view
				// in a list view
				showAllEvents();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
//Adds events on clicking the add event(+) button on screen
	public void addEvents() {
		Intent intent = new Intent(this, SubActivity.class);
		startActivityForResult(intent, 2);
	}

	public void addtoList(StoreEvents event) {

		eventPlanner.add(event);
	}

	public ArrayList<StoreEvents> events() {
		return eventPlanner;
	}

	public void showAllEvents() {
		// Starting a new intent in which the Layout is defined!
		Intent intent = new Intent(context, PlannerListView.class);
		context.startActivity(intent);

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		refreshView();

		if (requestCode == 2) {

			if (null != data) {
				text = data.getStringExtra("MESSAGE");
				System.err.println("text     " + text);

			}
		}
	}

	@Override
	protected void onResume() {
		//updating the calendar with events in the 
		//calendar
		
		refreshView();	
		super.onResume();

	}

	public void refreshView() {
		//refreshes the adapter view
		UpdateCalender adapter=new UpdateCalender(this, cal.getCal_months());
		view.setAdapter(adapter);
	
			

	}
	
	
	
	
	
	
	
}
