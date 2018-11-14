package com.example.socialPlannerApp.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.ayirumkannumai.R;
import com.example.socialPlannerApp.Model.Globals;
import com.example.socialPlannerApp.Model.ShowListAdapter;

public class PlannerListView extends Activity {		
	Globals g = Globals.getInstance();
		
	public PlannerListView(){	
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		setContentView(R.layout.activity_planner_list_view);
			
		ListView view =(ListView)findViewById(R.id.list_view_planner);		
		
		//sorts the list before the adapter is set
		g.sortList();
		final ShowListAdapter adapter =new ShowListAdapter(getBaseContext(),g.getArrayList(),view);
		view.setAdapter(adapter);	
			
		
		view.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(final AdapterView<?> parent, View view,
					int position, long id) {	
					
				// TODO Auto-generated method stub
				
			}
		});

		
			
			
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.planner_list_view, menu);
		return true;
	}	
		

	

		
	

}
