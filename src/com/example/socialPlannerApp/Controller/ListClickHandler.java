package com.example.socialPlannerApp.Controller;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayirumkannumai.R;

public class ListClickHandler  extends Activity implements OnItemClickListener
{
	private Context context;
	View screenView;	
	public ListClickHandler	(Context context){
	this.context=context;	

}
	@Override
	public void onItemClick(AdapterView<?> Adapter, View view, int position, long arg3) {	
					this.screenView =view;		

					TextView listText =(TextView) view.findViewById(R.id.textView1);	
					
					
					//Opening up a new screen to take details of  the event
//					Intent intent = new Intent(context, SubActivity.class);
//					context.startActivity(intent);		
					
					// Showing all the events of the day
					Intent intent = new Intent(context, ShowEventsofDay.class);
				    intent.putExtra("eventDate",listText.getText());
					context.startActivity(intent);		
					
					
					
						
					
					
					
					
						
					String text =listText.getText().toString();	
					Toast.makeText(context, text+"EventCreated "+text.toString()+ position, Toast.LENGTH_SHORT).show();		
						
					
					
				    
	}
		
		
	
	
	
		
		public void changeView(String text){		
			TextView listText =(TextView)screenView.findViewById(R.id.textView002);
			listText.setText(text);		
			
			
			
		}
		

		
		
	
}