package socialMedia.NotifyPackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class NotificationUtility {
	    private NotificationDAO notificationDAO;
	    private Scanner sc;

	    // Constructor to initialize NotificationUtility with NotificationDAO
	    public NotificationUtility(Connection conn) {
	        this.notificationDAO = new NotificationDAO(conn);
	        this.sc = new Scanner(System.in);
	    }

		// Create a new notification
	    public void createNotification() {
	        try {
	        	System.out.println("Enetr the notification id:");
	        	int id = sc.nextInt();
	            System.out.println("Enter Notification Message:");
	            String message = sc.nextLine();

	            System.out.println("Enter Recipient:");
	            String recipient = sc.nextLine();

	            System.out.println("Is the notification read? (true/false):");
	            boolean isRead = sc.nextBoolean();
	            sc.nextLine();  // Consume the newline

	            System.out.println("Enter User ID:");
	            String userId = sc.nextLine();

	            Notification notification = new Notification(id,message, recipient, isRead, userId);
	            if (notificationDAO.addNotification(notification)) {
	                System.out.println("Notification created successfully.");
	            } else {
	                System.out.println("Failed to create notification.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        }
	    }

	    // Retrieve a notification by ID
	    public void displayNotificationById() {
	        try {
	            System.out.println("Enter Notification ID to retrieve:");
	            int notificationId = sc.nextInt();
	            sc.nextLine();  // Consume the newline

	            Notification notification = notificationDAO.getNotificationById(notificationId);
	            System.out.println(notification);

	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (NotificationException.NotificationNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Retrieve all notifications for a user
	    public void displayAllNotificationsForUser() {
	        try {
	            System.out.println("Enter User ID to retrieve notifications:");
	            String userId = sc.nextLine();

	            List<Notification> notificationList = notificationDAO.getAllNotificationsForUser(userId);
	            for (Notification notification : notificationList) {
	                System.out.println(notification);
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        }
	    }

	    // Update a notification
	    public void updateNotification() {
	        try {
	            System.out.println("Enter Notification ID to update:");
	            int notificationId = sc.nextInt();
	            sc.nextLine();  // Consume newline

	            Notification notification = notificationDAO.getNotificationById(notificationId);
	            if (notification != null) {
	                System.out.println("Enter new Notification Message:");
	                String newMessage = sc.nextLine();

	                System.out.println("Is the notification read? (true/false):");
	                boolean isRead = sc.nextBoolean();

	                notification.setMessage(newMessage);
	                notification.setRead(isRead);

	                if (notificationDAO.updateNotification(notification)) {
	                    System.out.println("Notification updated successfully.");
	                } else {
	                    System.out.println("Failed to update notification.");
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (NotificationException.NotificationNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Delete a notification
	    public void deleteNotification() {
	        try {
	            System.out.println("Enter Notification ID to delete:");
	            int notificationId = sc.nextInt();

	            if (notificationDAO.deleteNotification(notificationId)) {
	                System.out.println("Notification deleted successfully.");
	            } else {
	                System.out.println("Failed to delete notification.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (NotificationException.NotificationNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

}
