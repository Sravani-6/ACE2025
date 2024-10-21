package socialMedia.NotifyPackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import config.DbConnection;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Notification> al=new ArrayList<>();
		//System.out.format("%-5s %s\n","NotificationId","UserId");
		//NotificationDAO dao=new NotificationDAO();
		//al=dao.getAllNotifications();
		//for(Notification it:al){
		 //   System.out.format("%-5s %s\n",it.getNotificationId(),it.getUserId());
		        try {
		            // Initialize the database connection (change as per your DB configuration)
		        	Connection conn = DbConnection.getConnection();
		            NotificationUtility notificationUtility = new NotificationUtility(conn);
		            Scanner sc = new Scanner(System.in);

		            while (true) {
		                System.out.println("\nNotification Management System:");
		                System.out.println("1. Create Notification");
		                System.out.println("2. View Notification by ID");
		                System.out.println("3. View All Notifications for a User");
		                System.out.println("4. Update Notification");
		                System.out.println("5. Delete Notification");
		                System.out.println("6. Exit");

		                System.out.print("Enter your choice: ");
		                int choice = sc.nextInt();
		                sc.nextLine();  // Consume newline

		                switch (choice) {
		                    case 1:
		                        notificationUtility.createNotification();
		                        break;
		                    case 2:
		                        notificationUtility.displayNotificationById();
		                        break;
		                    case 3:
		                        notificationUtility.displayAllNotificationsForUser();
		                        break;
		                    case 4:
		                        notificationUtility.updateNotification();
		                        break;
		                    case 5:
		                        notificationUtility.deleteNotification();
		                        break;
		                    case 6:
		                        System.out.println("Exiting...");
		                        sc.close();
		                        conn.close();
		                        System.exit(0);
		                    default:
		                        System.out.println("Invalid choice, please try again.");
		                }
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

}
