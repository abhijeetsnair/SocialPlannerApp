package com.example.socialPlannerApp.Model;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ayirumkannumai.R;

public class EventsoftheDayAdapter extends BaseAdapter {
	
		
	//Variables
	private Context context;
	private LayoutInflater inflator;
	private ArrayList<StoreEvents> dates;
	private TextView events_header;
	private Adapter adapter;
	private Globals data = Globals.getInstance();

			
	//Constructor that takes three parameters the context,arraylist
	// and text view
	public EventsoftheDayAdapter(Context context,
			ArrayList<StoreEvents> arrayList, TextView view) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.dates = arrayList;
		this.events_header = view;
		inflator = LayoutInflater.from(this.context);
		adapter = this;

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return dates.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return dates.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@SuppressWarnings("static-access")
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		viewHolder view;
		if (arg1 == null) {

			view = new viewHolder();
			if (dates.size() > 0) {
				
				//Setting the elements according to the view holder pattern
				arg1 = inflator.inflate(R.layout.custom_view, null);
				view.eventName = (TextView) arg1.findViewById(R.id.eventName);
				view.eventDate = (TextView) arg1.findViewById(R.id.eventDate);
				view.eventTime=(TextView)arg1.findViewById(R.id.eventTime);	
					view.eventDescription = (TextView) arg1
						.findViewById(R.id.eventNote);
					view.eventVenue =(TextView)arg1.findViewById(R.id.eventVenue);
			view.eventLocation =(TextView)arg1.findViewById(R.id.location);
				view.eventInvitees = (TextView) arg1
						.findViewById(R.id.eventInvitees);	
					
					
				//Setting text to the text view elements
				arg1.setTag(view);
				view.eventName.setText(dates.get(arg0).getEventName());
				view.eventDate.setText(dates.get(arg0).getDate());
				view.eventTime.setText(dates.get(arg0).getTime());
				view.eventDescription.setText(dates.get(arg0).getDescription());
				view.eventVenue.setText(dates.get(arg0).getVenue());
				view.eventLocation.setText(dates.get(arg0).getLocation());
				view.eventInvitees.setText(dates.get(arg0).getInvitees());	
				

			}

			if (dates.size() == 0) {
				TextView eventName = (TextView) arg1
						.findViewById(R.id.eventName);
				eventName.setText("No Events for the day ! ");
				events_header.setVisibility(events_header.GONE);
			}
			// paste code

			Button editbutton = (Button) arg1.findViewById(R.id.button1);
			Button delButton = (Button) arg1.findViewById(R.id.button2);

			delButton.setTag(arg0);
			delButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					AlertDialog.Builder alertbox = new AlertDialog.Builder(v
							.getRootView().getContext());
					alertbox.setMessage("Delete Event ?");
					alertbox.setTitle("Warning");

					final StoreEvents event = dates.get((Integer) v.getTag());
					System.out.println(event.getEventName() + event.getDate()
							+ event.getDescription());

					// adpater.notifyDataSetChanged();
					alertbox.setNeutralButton("OK",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface arg0,
										int arg1) {
									// Deleting the items and Changing the
									// related view.
									deleteElements(event);
									deleteGlobalElements(event);
									notifyDataSetChanged();

								}
							});
					alertbox.show();
				}
			});

			// Setting an action to the Delete Button
			editbutton.setTag(arg0);
			editbutton.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					v.getId();

					LayoutInflater li = LayoutInflater.from(v.getRootView()
							.getContext());
					View promptsView = li.inflate(R.layout.prompt, null);

					AlertDialog.Builder alertbox = new AlertDialog.Builder(v
							.getRootView().getContext());

					alertbox.setView(promptsView);
					alertbox.setMessage("Set Event Details:-");
					alertbox.setTitle("Edit Event");

					final EditText eventName = (EditText) promptsView
							.findViewById(R.id.editText1);
					eventName.setEnabled(false);
					final EditText eventDate = (EditText) promptsView
							.findViewById(R.id.editText2);
					final EditText eventDescription = (EditText) promptsView
							.findViewById(R.id.editText3);
					final EditText location = (EditText) promptsView
							.findViewById(R.id.editText4);
					final EditText invitees = (EditText) promptsView
							.findViewById(R.id.editText5);

					int pos = (Integer) v.getTag();
					eventName.setText(dates.get(pos).getEventName(),
							TextView.BufferType.EDITABLE);

					alertbox.setNeutralButton("OK",
							new DialogInterface.OnClickListener() {

								public void onClick(DialogInterface arg0,
										int arg1) {

									StoreEvents event = new StoreEvents(
											eventName.getText().toString(),
											eventDate.getText().toString(),
											"time", eventDescription.getText()
													.toString(), invitees
													.getText().toString(),
											location.getText().toString(), "",
											"");

									changeData(event);
									changeGlobalData(event);
									((BaseAdapter) adapter)
											.notifyDataSetChanged();

								}
							});
					alertbox.show();

				}
			});

		}

		else {

			view = (viewHolder) arg1.getTag();
			view.eventName.setText(dates.get(arg0).getEventName());
			view.eventDate.setText(dates.get(arg0).getDate());
			view.eventTime.setText(dates.get(arg0).getTime());
			view.eventDescription.setText(dates.get(arg0).getDescription());
			view.eventVenue.setText(dates.get(arg0).getVenue());
			view.eventLocation.setText(dates.get(arg0).getLocation());
			view.eventInvitees.setText(dates.get(arg0).getInvitees());	
		}

		return arg1;

	}

	// Changes data from the local dates array as well as the global events
	// array
	public void changeData(StoreEvents event) {

		for (int i = 0; i < dates.size(); i++) {
			if (event.getEventName().compareTo(dates.get(i).getEventName()) == 0) {
				dates.get(i).setDate(event.getDate());
				dates.get(i).setDescription(event.getDescription());
				dates.get(i).setInvitees(event.getInvitees());
				dates.get(i).setLocation(event.getLocation());
			}
		}
	}

	public void changeGlobalData(StoreEvents event) {

		for (int i = 0; i < data.getArrayList().size(); i++) {

			if (event.getEventName().compareTo(
					data.getArrayList().get(i).getEventName()) == 0) {
				data.getArrayList().get(i).setDate(event.getDate());
				data.getArrayList().get(i)
						.setDescription(event.getDescription());
				data.getArrayList().get(i).setInvitees(event.getInvitees());
				data.getArrayList().get(i).setLocation(event.getLocation());

			}
		}

	}

	// Deletes elements from the local dates array as well as the global events
	// array
	public void deleteElements(StoreEvents event) {
		for (int i = 0; i < dates.size(); i++) {
			if (event.getEventName().compareTo(dates.get(i).getEventName()) == 0) {
				dates.remove(dates.get(i));
			}
		}

	}

	public void deleteGlobalElements(StoreEvents event) {
		for (int i = 0; i < data.getArrayList().size(); i++) {

			if (event.getEventName().compareTo(
					data.getArrayList().get(i).getEventName()) == 0) {
				data.getArrayList().remove(data.getArrayList().get(i));
			}

		}

	}

	static class viewHolder {
		TextView eventName;
		TextView eventDate;
		TextView eventTime;
		TextView eventDescription;
		TextView eventInvitees;
		TextView eventVenue;
		TextView eventLocation;
		TextView eventAttendees;

	}

}
