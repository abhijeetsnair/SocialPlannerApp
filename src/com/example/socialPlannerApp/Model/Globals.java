package com.example.socialPlannerApp.Model;

import java.util.ArrayList;


public class Globals{
	   private static Globals instance;
	 
	   // Global variable
	   private int dataVariable;
	   private static ArrayList<StoreEvents> events;
	   // Restrict the constructor from being instantiated
	   private Globals(){}
	 
	   public void setData(int d){
	     this.dataVariable=d;
	   }
	   public int getData(){
	     return this.dataVariable;
	   }
	 
	   public static synchronized Globals getInstance(){
	     if(instance==null){
	       instance=new Globals();	
	       events =new ArrayList<StoreEvents>();	
	       	
	     }
	     return instance;
	   }
		public ArrayList<StoreEvents> getArrayList() {	
				return events;	
		}
			
		public  void addtoList(String eventname,String eventDate, String time,String  venue, String location,String note,String attendees,String id){	
					StoreEvents data =new StoreEvents(eventname,eventDate,time,venue,location,note,attendees,id);
					events.add(data);	
		}
		public void printData(){	
			
			for(int i =0;i<events.size();i++){	
					System.err.println("These are the items in the List" +events.get(i).getEventName());
					
			}
		}
			
		public void sortList(){	
			//This is a type of bubble sort
			StoreEvents temp ;
	        for (int i = 0; i < events.size() - 1; i++) {
	            for (int j = 1; j < (events.size() - i); j++) {
	                if (Integer.parseInt(events.get(j - 1).getDate())> Integer.parseInt(events.get(j).getDate())) {
	                    //swap the elements!
	                    temp = events.get(j - 1);
	                    events.set(j - 1, events.get(j));
	                    events.set(j, temp);
			    }
			}
					
				}
		
					
			
				
				
	   
	   
}
		}