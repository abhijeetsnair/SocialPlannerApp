package com.example.socialPlannerApp.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Model.ContactDataManager;
import com.example.socialPlannerApp.Model.ContactDataManager.ContactQueryException;
import com.example.socialPlannerApp.Model.Globals;

public class SubActivity extends Activity {

	// Constants declared for the contact Data Manager
	protected static final int PICK_CONTACTS = 100;
	private static final String LOG_TAG = ContactDataManager.class.getName();

	// Edit text fields defined
	private EditText view01;
	private EditText view02;
	private EditText view03;
	private EditText view04;
	private EditText view05;
	private EditText view06;
	private EditText view07;
	private String lattitude;
	private String longitude;
	private int counter = 0;
	// List click handler object
	public ListClickHandler handler;

	// Global instance to store variables
	Globals global = Globals.getInstance();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub);

		// Obtaining the text view elements from the layout
		view01 = (EditText) findViewById(R.id.editText1);
		view02 = (EditText) findViewById(R.id.editText7);
		view03 = (EditText) findViewById(R.id.editText3);
		view04 = (EditText) findViewById(R.id.editText4);
		view05 = (EditText) findViewById(R.id.editText5);
		view06 = (EditText) findViewById(R.id.editText6);
		view07 = (EditText) findViewById(R.id.editText2);
		
			
		view04.setVisibility(View.GONE);
		
		// Obtaining the venue to calculate the longitude
		// and the latitude of the venue.
		view06.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent contactPickerIntent = new Intent(Intent.ACTION_PICK,
						Contacts.CONTENT_URI);
				startActivityForResult(contactPickerIntent, PICK_CONTACTS);

			}
		});

		// Obtaining the text view information from the
		// edit view fields
		Button button = (Button) findViewById(R.id.buttonok);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Getting the string out of each of the edit text components
				String eventName = (String) view01.getText().toString();
				String date = (String) view02.getText().toString();
				String time =(String)view07.getText().toString();
				String venue = (String) view03.getText().toString();
				String location = (String) view04.getText().toString();
				String note = (String) view05.getText().toString();
				String attendees = (String) view06.getText().toString();

				// getLatLongfromAddress(): - Obtains the latitude and the latitude information
				//in longitude and lattitude co ordinates using geocoder
				
				//Obtaining the first token of a string
				 String arr[] =date.split("/", 0);
				 date=arr[0];
				//Making the location text view visible
				view04.setVisibility(View.VISIBLE)	;
				view04.setText(getLatLongFromAddress(venue));
				
					
				//LOCATION
				//setting the location to the string value mentioned
				//location= getLatLongFromAddress(venue);
					
				location="";

				// Generating a random id composed of text and numbers.
				UUID idnew = UUID.randomUUID();
				String id = idnew.toString();

				// Displaying the edited information to the user
				Toast.makeText(
						getBaseContext(),
						"EventCreated " + eventName + " " + location + " " + id,
						Toast.LENGTH_SHORT).show();

				// get the latitude and longitude information
				global.addtoList(eventName, date,time, venue, location, note,
						attendees, id);

				// Sends the event name information back to the previous
				// activity
				Intent output = new Intent();
				output.putExtra("MESSAGE", eventName);
				setResult(2, output);
				System.err.println("Prints this on the screen");
				// Then finishing the activity to take the user
				// back to previous calendar view
				finish();

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub, menu);
		return true;
	}

	@Override
	// Picks the attendees from the contact list when the user selects a contact
	// from the list
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == PICK_CONTACTS) {
			if (resultCode == RESULT_OK) {

				// Retrives the information back from the contacts manager
				ContactDataManager contactsManager = new ContactDataManager(
						this, data);
				String name = "";
				String email = "";
				try {
					name = contactsManager.getContactName();
					email = contactsManager.getContactEmail();	
						System.err.println("Name  " +name);
						System.err.println("Email  "+email);	
						
						//Checking to see if the string is empty
						if(view06.getText().toString().isEmpty()){
							view06.setText(name+" "+email);	
													}	
						else{
							view06.setText(view06.getText().toString()+","+name+email);	
							
						}
					
				} catch (ContactQueryException e) {
					Log.e(LOG_TAG, e.getMessage());
				}

			}

		}
	}

	// Obtains the latitude and longitude information using the
	// json,basically it embeds the information given by the user in the form of
	// a url
	// and obtains the longitude and latitude information from google maps using
	// geocoder
	public String getLatLongFromAddress(final String youraddress) {
		// Removes the restriction of running it from the main thread.
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();

			StrictMode.setThreadPolicy(policy);
		}

		try {
			String uri = "http://maps.google.com/maps/api/geocode/json?address="
					+ youraddress + "&sensor=false";
			HttpGet httpGet = new HttpGet(uri);
			HttpClient client = new DefaultHttpClient();
			HttpResponse response;
			StringBuilder stringBuilder = new StringBuilder();

			try {
				response = client.execute(httpGet);
				HttpEntity entity = response.getEntity();
				InputStream stream = entity.getContent();
				int b;
				while ((b = stream.read()) != -1) {
					stringBuilder.append((char) b);
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				lattitude = null;
				longitude = null;
			} catch (IOException e) {
				e.printStackTrace();
				lattitude = null;
				longitude = null;
			}

			JSONObject jsonObject = new JSONObject();
			try {
				jsonObject = new JSONObject(stringBuilder.toString());

				double lng = ((JSONArray) jsonObject.get("results"))
						.getJSONObject(0).getJSONObject("geometry")
						.getJSONObject("location").getDouble("lng");

				double lat = ((JSONArray) jsonObject.get("results"))
						.getJSONObject(0).getJSONObject("geometry")
						.getJSONObject("location").getDouble("lat");

				Log.d("latitude", "" + lat);
				Log.d("longitude", "" + lng);

				lattitude = Double.toString(lat);
				longitude = Double.toString(lng);
				System.err.println("latitude and Long " + lattitude + longitude
						+ "   " + counter++);
				// Abstracting the latitude and longitude values to another
				// method
				getLocation(lattitude, longitude);

			} catch (JSONException e) {
				e.printStackTrace();
				// Incase of any exceptions
				// setting both the values to null
				lattitude = null;
				longitude = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			lattitude = null;
			longitude = null;
		}
		return lattitude + longitude;
	}

	public String getLocation(String lat, String longitiude) {
		// returns the longitude and latitude information

		System.err.println("latitude and Long " + lattitude + longitude
				+ "get string method");
		if (lat == null || longitiude == null) {
			lat = "No location";
		}
		return lat + "  " + longitiude;

	}

}
