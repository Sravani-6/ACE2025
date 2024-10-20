package socialMedia.Grouppackage;

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
		//List<Group> al=new ArrayList<>();
		//System.out.format("%-5s %-15s %s\n","GroupId","GroupName","GroupMemberCount");
		//GroupDAO dao=new GroupDAO();
		//al=dao.getAllItemTypes();
		//for(Group it:al){
		  //  System.out.format("%-5s %-15s %s\n",it.getGroupId(),it.getGroupName(),it.getGpMemberCount());
		//}
		        try {
		            // Initialize the database connection (change as per your DB configuration)
		        	Connection conn = DbConnection.getConnection();
		            GroupUtility groupUtility = new GroupUtility(conn);
		            Scanner sc = new Scanner(System.in);

		            while (true) {
		                System.out.println("\nGroup Management System:");
		                System.out.println("1. Create Group");
		                System.out.println("2. View Group by ID");
		                System.out.println("3. View All Groups");
		                System.out.println("4. Update Group");
		                System.out.println("5. Delete Group");
		                System.out.println("6. Exit");

		                System.out.print("Enter your choice: ");
		                int choice = sc.nextInt();
		                sc.nextLine();  // Consume newline

		                switch (choice) {
		                    case 1:
		                        groupUtility.createGroup();
		                        break;
		                    case 2:
		                        groupUtility.displayGroupById();
		                        break;
		                    case 3:
		                        groupUtility.displayAllGroups();
		                        break;
		                    case 4:
		                        groupUtility.updateGroup();
		                        break;
		                    case 5:
		                        groupUtility.deleteGroup();
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
