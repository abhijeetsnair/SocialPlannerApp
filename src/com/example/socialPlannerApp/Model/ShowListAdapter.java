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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ayirumkannumai.R;

public class ShowListAdapter extends BaseAdapter {
	
	Context context;
	ArrayList<StoreEvents> array;
	LayoutInflater inflator;
	ListView view;
	ShowListAdapter adapter;	
	private int get_position;
	public ShowListAdapter(Context context ,
			ArrayList<StoreEvents> arrayList, ListView listview) {
		// TODO Auto-generated constructor stub
		this.context=context;
		inflator=LayoutInflater.from(context);
		this.array=arrayList;	
		this.view =listview;
		adapter =this;
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
public View getView(int position, View arg1, ViewGroup arg2) {
	viewHolder view;
	
	
	if(arg1==null)
    {	
			
			
		arg1 = inflator.inflate(R.layout.custom_view,null);	 
		
		//setting the view Holder
        view =new viewHolder();
        
        //Setting feilds to its proper text view
        view. eventName = (TextView)arg1.findViewById(R.id.eventName);	
        view.eventVenue =(TextView)arg1.findViewById(R.id.eventVenue);
        view.eventDescription = (TextView)arg1.findViewById(R.id.eventNote);
        view.eventtime = (TextView)arg1.findViewById(R.id.eventTime);	
        view. eventDate = (TextView)arg1.findViewById(R.id.eventDate);	
        view. eventInvitees = (TextView)arg1.findViewById(R.id.eventInvitees);
        view.eventLocation=(TextView)arg1.findViewById(R.id.location);
        
       
        
       	arg1.setTag(view);
       	//Setting text to the feilds
        view.eventName.setText(array.get(position).getEventName());	
        view.eventDescription.setText(array.get(position).getDescription());	 
        view.eventDate.setText(array.get(position).getDate());	
        view.eventInvitees.setText(array.get(position).getInvitees());	
        view.eventVenue.setText(array.get(position).getVenue());	 
        view.eventtime.setText(array.get(position).getTime());	
        view.eventLocation.setText(array.get(position).getLocation());	
        
        
        
        Button editbutton  =(Button)arg1.findViewById(R.id.button1);		
        Button delButton =(Button)arg1.findViewById(R.id.button2);		
        
        delButton.setTag(position);
        delButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder alertbox = new AlertDialog.Builder(v.getRootView().getContext());
			    alertbox.setMessage("Delete Event ?");
			    alertbox.setTitle("Warning");
			    
			    
			    final StoreEvents event =array.get((Integer)v.getTag());				    	
			    System.out.println(event.getEventName() +event.getDate()+event.getDescription());	
			    	
			    
//				adpater.notifyDataSetChanged();
				alertbox.setNeutralButton("OK",
			            new DialogInterface.OnClickListener() {

			                public void onClick(DialogInterface arg0,
			                        int arg1) {
//			                Deleting the items and Changing the related view.
//			                	array.remove(pos);
//			    				adapter.notifyDataSetChanged();	
			                		deleteElements(event);
			                		adapter.changeData(event);
			                		adapter.notifyDataSetChanged();
			                		
			                	
			                }
			            });
			  alertbox.show();
			}
		})	;
        	
        //Setting an action to the Delete Button
        				editbutton.setTag(position);
        				editbutton.setOnClickListener(new OnClickListener() {
        					
        		public void onClick(View v) {
					v.getId();
				System.err.println("The Edit Button was pressed	!");
				System.err.println( "Title clicked, row     " + get_position);
			 // Confirming with the user before deletion
			 
				LayoutInflater li = LayoutInflater.from(v.getRootView().getContext());
				View promptsView = li.inflate(R.layout.prompt, null);
				
				AlertDialog.Builder alertbox = new AlertDialog.Builder(v.getRootView().getContext());
				
				
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
			    
			    
			   int pos= (Integer)v.getTag();
				eventName.setText(array.get(pos).getEventName(),TextView.BufferType.EDITABLE);	

			    alertbox.setNeutralButton("OK",
			            new DialogInterface.OnClickListener() {

			                public void onClick(DialogInterface arg0,
			                        int arg1) {
			                	
			                	StoreEvents event =new StoreEvents(eventName.getText().toString(),eventDate.getText().toString(),
			                			"time",eventDescription.getText().toString(),invitees.getText().toString(),location.getText().toString(),"invitees","fancy stuff");
			                	
			                		changeData(event);	
			                		
			                		adapter.notifyDataSetChanged();
//			                		adapter.notifyDataSetInvalidated();
			                	
			                	
			                }
			            });
			  alertbox.show();
			 
										}		
										});			
        	

    }
	
	

	
	
	//the else condition
	
	else{	
			
		view =(viewHolder)arg1.getTag();
		   view.eventName.setText(array.get(position).getEventName());	
	        view.eventDescription.setText(array.get(position).getDescription());	 
	        view.eventDate.setText(array.get(position).getDate());	
	        view.eventInvitees.setText(array.get(position).getInvitees());	
	        view.eventVenue.setText(array.get(position).getVenue());	 
	        view.eventtime.setText(array.get(position).getTime());	
	        view.eventLocation.setText(array.get(position).getLocation());	
	        
	}
	
	
	
	
	
	
	
	
	
	
	
	
    return arg1;
}	
	

public void changeData(StoreEvents event){	
	
	for( int i=0;i<array.size();i++)	
		{	
			
				if(event.getEventName().compareTo(array.get(i).getEventName())==0)	
				{	
					array.get(i).setDate(event.getDate());	
					array.get(i).setDescription(event.getDescription());	
					array.get(i).setInvitees(event.getInvitees());
					array.get(i).setLocation(event.getLocation());	
						
				}
			
		}

	
	}


public void deleteElements(StoreEvents event)
{	
	
	for( int i=0;i<array.size();i++)	
	{
	
	if(event.getEventName().compareTo(array.get(i).getEventName())==0)
	{	
		array.remove(array.get(i));
		
	}
		
	}
		
}
	

static class viewHolder{	
	TextView eventName;
    TextView eventDescription ;
    TextView eventtime;
    TextView eventDate ;
    TextView eventInvitees; 
    TextView eventLocation;	
    TextView eventAttendees;
    TextView eventVenue;
	
}

}









