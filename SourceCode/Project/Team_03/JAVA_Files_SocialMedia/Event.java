package SocialMedia;

public class Event {
	private Int eventId;
	private String eventName;
	private Int organizerId;
	private String date;
	private String location;
	
public Event(Int eventId,String eventName,Int organizerId,String date,String location) {
	this.eventId = eventId;
	this.eventName = eventName;
	this.organizerId = organizerId;
	this.date = date;
	this.location = location;
}
public Int getEventId() {
	return eventId;
}
public String getEventName() {
	return eventName;
}
public Int getOrganizerId() {
	return organizerId;
}
public String getDate() {
	return date;
}
public String getLocation() {
	return location;
}
public void setEventID(Int eventId) {
	this.eventId = eventId;
}
public void setEventName(String eventName) {
	this.eventName = eventName;
}
public void setOrganizerId(Int OrganizerId) {
	this.organizerId = organizerId;
}
public void setDate(String date) {
	this.date = date;
}
public void setLocation(String location) {
	this.location = location;
}
public void display() {
	System.out.println("Event Details");
	System.out.println("Event Id: "+eventId);
	System.out.println("Event Name: "+eventname);
	System.out.println("Organizer Id: "+organizerId);
	System.out.println("Date: "+date);
	System.out.println("Location: "+location);
}
}
