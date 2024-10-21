package socialMedia.Postpackage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class PostUtility {
	    private PostTypeDAO postDAO;
	    private Scanner sc;

	    // Constructor to initialize PostUtility with PostTypeDAO
	    public PostUtility(Connection conn) {
	        this.postDAO = new PostTypeDAO(conn);
	        this.sc = new Scanner(System.in);
	    }

	    // Create a new Post
	    public void createPost() {
	        try {
	            System.out.println("Enter User ID:");
	            String userId = sc.nextLine();

	            System.out.println("Enter Post Content:");
	            String content = sc.nextLine();

	            System.out.println("Enter Visibility (public, friends, private):");
	            String visibility = sc.nextLine();

	            Post newPost = new Post(userId, content, visibility);
	            if (postDAO.addPost(newPost)) {
	                System.out.println("Post created successfully.");
	            } else {
	                System.out.println("Failed to create post.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (PostException.InvalidVisibilityException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Display a Post by ID
	    public void displayPostById() {
	        try {
	            System.out.println("Enter Post ID to retrieve:");
	            int postId = sc.nextInt();
	            sc.nextLine();  // Consume the newline

	            Post post = postDAO.getPostById(postId);
	            System.out.println(post);

	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (PostException.PostNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Display all Posts
	    public void displayAllPosts() throws SQLException {
	        List<Post> postList = postDAO.getAllPosts();
			for (Post post : postList) {
			    System.out.println(post);
			}
	    }

	    // Update a Post
	    public void updatePost() {
	        try {
	            System.out.println("Enter Post ID to update:");
	            int postId = sc.nextInt();
	            sc.nextLine();  // Consume newline

	            Post post = postDAO.getPostById(postId);
	            if (post != null) {
	                System.out.println("Enter new Post Content:");
	                String newContent = sc.nextLine();

	                System.out.println("Enter new Visibility (public, friends, private):");
	                String newVisibility = sc.nextLine();

	                System.out.println("Enter number of likes:");
	                int likes = sc.nextInt();

	                System.out.println("Enter number of comments:");
	                int comments = sc.nextInt();

	                post.setContent(newContent);
	                post.setVisibility(newVisibility);
	                post.setLikes(likes);
	                post.setComments(comments);

	                if (postDAO.updatePost(post)) {
	                    System.out.println("Post updated successfully.");
	                } else {
	                    System.out.println("Failed to update post.");
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (PostException.InvalidVisibilityException | PostException.PostNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Delete a Post
	    public void deletePost() {
	        try {
	            System.out.println("Enter Post ID to delete:");
	            int postId = sc.nextInt();

	            if (postDAO.deletePost(postId)) {
	                System.out.println("Post deleted successfully.");
	            } else {
	                System.out.println("Failed to delete post.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (PostException.PostNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	

}
