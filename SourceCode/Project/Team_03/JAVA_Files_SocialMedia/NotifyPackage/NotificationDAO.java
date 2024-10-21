package socialMedia.NotifyPackage;
import config.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class NotificationDAO {
	// Retrieve all notifications for a user
    public List<Notification> getAllNotificationsForUser(String userId) throws SQLException {
        List<Notification> notificationList = new ArrayList<>();
        String query = "SELECT * FROM notification WHERE userid = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userId);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Notification notification = new Notification(
                    rs.getInt("notification_id"),
                    rs.getString("message"),
                    rs.getString("type"),
                    rs.getBoolean("isRead"),
                    rs.getString("userid")
                );
                notificationList.add(notification);
            }
        }
        return notificationList;
    }

	    private Connection conn;

	    // Constructor to initialize the database connection
	    public NotificationDAO(Connection conn) {
	        this.conn = conn;
	    }

	    // Add a new notification
	    public boolean addNotification(Notification notification) throws SQLException {
	        String query = "INSERT INTO notification (notification_id,message, type, isRead, userid) VALUES (?,?, ?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	        	pstmt.setLong(1,notification.getNotificationId());
	            pstmt.setString(2, notification.getMessage());
	            pstmt.setString(3, notification.getRecipient());
	            pstmt.setBoolean(4, notification.isRead());
	            pstmt.setString(5, notification.getUserId());

	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	        }
	    }

	    // Retrieve a notification by its ID
	    public Notification getNotificationById(int notificationId) throws SQLException, NotificationException.NotificationNotFoundException {
	        String query = "SELECT * FROM notification WHERE notification_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, notificationId);

	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Notification(
	                    rs.getInt("notification_id"),
	                    rs.getString("message"),
	                    rs.getString("type"),
	                    rs.getBoolean("isRead"),
	                    rs.getString("userid")
	                );
	            } else {
	                throw new NotificationException.NotificationNotFoundException("Notification with ID " + notificationId + " not found.");
	            }
	        }
	    }

	    // Update a notification's message or isRead status
	    public boolean updateNotification(Notification notification) throws SQLException, NotificationException.NotificationNotFoundException {
	        String query = "UPDATE notification SET message = ?, isRead = ? WHERE notification_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, notification.getMessage());
	            pstmt.setBoolean(2, notification.isRead());
	            pstmt.setInt(3, notification.getNotificationId());

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new NotificationException.NotificationNotFoundException("Notification with ID " + notification.getNotificationId() + " not found.");
	            }
	            return true;
	        }
	    }

	    // Delete a notification by its ID
	    public boolean deleteNotification(int notificationId) throws SQLException, NotificationException.NotificationNotFoundException {
	        String query = "DELETE FROM notification WHERE notification_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, notificationId);
	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new NotificationException.NotificationNotFoundException("Notification with ID " + notificationId + " not found.");
	            }
	            return true;
	        }
	    }
	
}
