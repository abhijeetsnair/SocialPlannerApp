package com.example.socialPlannerApp.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Calender_model {
	
	// Setting the calender to the current month and default timezone
	Calendar localCalendar ;
	Date currentTime ;
	int currentDay;
	int currentMonth;
	int currentYear ;
	int currentDayOfWeek;
	int currentDayOfMonth;
	int CurrentDayOfYear ;
	int CurrentDaysinMonth;
	String currMonthString ;
	ArrayList<String> cal_months;
		//List of days in the current month
	private ArrayList<String> days_week ;
	public Calender_model() {
		
		
			//Instantiating the calendar
		localCalendar =Calendar.getInstance(TimeZone.getDefault());
		currentTime = localCalendar.getTime();
		currentDay = localCalendar.get(Calendar.DATE);
		 currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		 currentYear = localCalendar.get(Calendar.YEAR);
		 currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK);
		 currentDayOfMonth = localCalendar.get(Calendar.DAY_OF_MONTH);
		 CurrentDayOfYear = localCalendar.get(Calendar.DAY_OF_YEAR);
		 CurrentDaysinMonth = localCalendar
					.getActualMaximum(Calendar.DAY_OF_MONTH);
		 currMonthString = localCalendar.getDisplayName(Calendar.MONTH,
					Calendar.LONG, Locale.getDefault());
		
		cal_months =new ArrayList<String>();
		days_week = new ArrayList<String>();
	}
	
	
	
	
	
	
	
		
	public ArrayList<String> getDays_week() {
		return days_week;
	}

	public void setDays_week(ArrayList<String> days_week) {
		this.days_week = days_week;
	}

	
	// days of the week added to the view
	
	
	
	
	
	
	
	//Methods to retrive the above data
	public int getCurrentDaysinMonth() {
		return CurrentDaysinMonth;
	}

	public String getCurrMonthString() {
		return currMonthString;
	}

	public void setCurrMonthString(String currMonthString) {
		this.currMonthString = currMonthString;
	}



	// restricts the calender from getting instantiated
	



	public void getCalenderInfo() {

		// Methods to print the month details useful to debug
		System.err.println("Current Date and time details in local timezone");
		System.err.println("Current Date: " + currentTime);
		System.err.println("Current Day: " + currentDay);
		System.err.println("Current Month: " + currentMonth);
		System.err.println("Current Year: " + currentYear);
		System.err.println("Current Day of Week: " + currentDayOfWeek);
		System.err.println("Current Day of Month: " + currentDayOfMonth);
		System.err.println("Current Day of Year: " + CurrentDayOfYear);
		System.err.println("Current Days in the month " + CurrentDaysinMonth);
		System.err.println("The current month string" + currMonthString);

	}

	public Date getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(Date currentTime) {
		this.currentTime = currentTime;
	}

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public int getCurrentDayOfWeek() {
		return currentDayOfWeek;
	}

	public void setCurrentDayOfWeek(int currentDayOfWeek) {
		this.currentDayOfWeek = currentDayOfWeek;
	}

	public int getCurrentDayOfMonth() {
		return currentDayOfMonth;
	}

	public void setCurrentDayOfMonth(int currentDayOfMonth) {
		this.currentDayOfMonth = currentDayOfMonth;
	}

	public int getCurrentDayOfYear() {
		return CurrentDayOfYear;
	}

	public void setCurrentDayOfYear(int currentDayOfYear) {
		CurrentDayOfYear = currentDayOfYear;
	}

	public void setCurrentDaysinMonth(int currentDaysinMonth) {
		CurrentDaysinMonth = currentDaysinMonth;
	}

	public ArrayList<String> getCal_months() {
		return cal_months;
	}


		
	public void setMonths()		
	{	
			for( int i=0;i<getCurrentDaysinMonth();i++)
			{
					cal_months.add(i,""+(i+1));	
					
			}
			
			
		
	}
	
		public void setDaysWeek()	
		{	
			days_week.add("M");
			days_week.add("Tu");
			days_week.add("W");
			days_week.add("T");
			days_week.add("F");
			days_week.add("S");
			days_week.add("Su");	
				
			
		}
		

}
