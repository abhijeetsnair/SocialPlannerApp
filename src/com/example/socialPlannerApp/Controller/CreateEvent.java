package com.example.socialPlannerApp.Controller;




import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class CreateEvent extends Activity {
	
	Context context;
	
	public CreateEvent(Context context) {
		this.context=context;	
		startActivity(new Intent(context,SubActivity.class));	
 
 	
 
	}


	
	
	
	
	
	
	
	

}
