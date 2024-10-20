package socialMedia.NotifyPackage;

public class Notification {
	    private int notificationId;   // Unique notification ID (Primary Key)
	    private String message;       // Notification message content
	    private String recipient;     // The recipient of the notification
	    private boolean isRead;       // Whether the notification has been read
	    private String userId;        // The ID of the user related to the notification

	    // Constructor for creating a new notification (without ID)
	    public Notification(String message, String recipient, boolean isRead, String userId) {
	        this.message = message;
	        this.recipient = recipient;
	        this.isRead = isRead;
	        this.userId = userId;
	    }

	    // Constructor for fetching a notification (with ID)
	    public Notification(int notificationId, String message, String recipient, boolean isRead, String userId) {
	        this.notificationId = notificationId;
	        this.message = message;
	        this.recipient = recipient;
	        this.isRead = isRead;
	        this.userId = userId;
	    }

	    // Getters and Setters
	    public int getNotificationId() {
	        return notificationId;
	    }

	    public void setNotificationId(int notificationId) {
	        this.notificationId = notificationId;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public void setMessage(String message) {
	        this.message = message;
	    }

	    public String getRecipient() {
	        return recipient;
	    }

	    public void setRecipient(String recipient) {
	        this.recipient = recipient;
	    }

	    public boolean isRead() {
	        return isRead;
	    }

	    public void setRead(boolean isRead) {
	        this.isRead = isRead;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    @Override
	    public String toString() {
	        return "Notification [notificationId=" + notificationId + ", message=" + message 
	            + ", recipient=" + recipient + ", isRead=" + isRead + ", userId=" + userId + "]";
	    }

}
