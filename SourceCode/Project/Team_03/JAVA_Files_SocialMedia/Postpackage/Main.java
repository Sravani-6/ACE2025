package socialMedia.Postpackage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import config.DbConnection;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//List<Post> al = new ArrayList<>();
		//System.out.format("%-5s %-15s %-30s %-20s %-8s %-10s %s\n","ID", "User", "Content", "Created At", "Likes", "Comments", "Visibility");
		//PostTypeDAO dao = new PostTypeDAO();
		//al = dao.getAllPosts();
		//for(Post p:al) {
			//System.out.format("%-5d %-15s %-30s %-20s %-8d %-10d %s\n", 
              //      p.getPostId(), 
                //    p.getUserId(), 
                  //  p.getContent(), 
                    //p.getCreatedAt(), 
                    //p.getLikes(), 
                    //p.getComments(), 
                    //p.getVisibility());
		//}
		// PostUtility postUtil = new PostUtility();
	       // postUtil.displayPostList();
	       // System.out.println("Add a new user:"+postUtil.addPost());
	        //postUtil.displayPostList();
		        try {
		            // Initialize the database connection (change as per your DB configuration)
		        	Connection conn = DbConnection.getConnection();
		            PostUtility postUtility = new PostUtility(conn);
		            Scanner sc = new Scanner(System.in);

		            while (true) {
		                System.out.println("\nPost Management System:");
		                System.out.println("1. Create Post");
		                System.out.println("2. View Post by ID");
		                System.out.println("3. View All Posts");
		                System.out.println("4. Update Post");
		                System.out.println("5. Delete Post");
		                System.out.println("6. Exit");

		                System.out.print("Enter your choice: ");
		                int choice = sc.nextInt();
		                sc.nextLine();  // Consume newline

		                switch (choice) {
		                    case 1:
		                        postUtility.createPost();
		                        break;
		                    case 2:
		                        postUtility.displayPostById();
		                        break;
		                    case 3:
		                        postUtility.displayAllPosts();
		                        break;
		                    case 4:
		                        postUtility.updatePost();
		                        break;
		                    case 5:
		                        postUtility.deletePost();
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