package com.example.socialPlannerApp.Model;

public class StoreEvents {

	private String eventName = "";
	private String date = "";
	private String venue = "";
	private String location = "";
	private String note = "";
	private String id = "";
	private String invitees = "";
	private String time = " ";

	public StoreEvents(String eventName, String date, String time,
			String venue, String location, String note, String invitees,
			String id) {
		this.eventName = eventName;
		this.date = date;
		this.venue = venue;
		this.invitees = invitees;
		this.location = location;
		this.time=time;	
		this.note=note;
		this.id=id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAttendees() {
		return invitees;
	}

	public void setAtttendees(String atttendees) {
		this.invitees = atttendees;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEventName() {

		return eventName;
	}

	public void setEventName(String EVname) {
		this.eventName = EVname;

	}

	public String getLocation() {
		return location;

	}

	public void setLocation(String location) {
		this.location = location;

	}

	public String getDescription() {

		return note;
	}

	public void setDescription(String note) {

		this.note = note;
	}

	public String getInvitees() {
		return invitees;

	}

	public void setInvitees(String invitees) {

		this.invitees = invitees;

	}

}
