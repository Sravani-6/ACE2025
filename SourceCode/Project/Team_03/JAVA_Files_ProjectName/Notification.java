package SocialMedia;

public class Notification {
	private Int notificationId;
	private Int userId;
	
public Notification(Int notificationId,Int userId) {
	this.notificationId = notificationId;
	this.userId = userId;
}
public Int getNotificationId() {
	return notificationId;
}
public Int getUserId() {
	return userId;
}
public void setNotificationId(Int notificationId)
{
	this.notificationId = notificationId;
}
public void setUserId(Int userId) {
	this.userId = userId;
}
public void display() {
	System.out.println("Notification Details");
	System.out.println("Notification Id: "+notificationId);
	System.out.println("User Id: "+userId);
}
}
