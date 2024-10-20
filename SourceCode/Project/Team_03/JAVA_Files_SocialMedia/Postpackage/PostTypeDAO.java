package socialMedia.Postpackage;
import config.DbConnection;
import socialMedia.User.User;
import socialMedia.User.UserException;

import java.sql.*;
import java.util.*;
public class PostTypeDAO {
	public List<Post>getAllPosts(){
		List<Post>p=new ArrayList<>();
		//method to get all posts
		try {
			Connection c = DbConnection.getConnection();
			Statement stm = c.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * from Post");
			while(rs.next()) {
				int postid = rs.getInt("post_id");
				String userid = rs.getString("userid");
				String content = rs.getString("content");
				Timestamp createdAt = rs.getTimestamp("created_at");
				int likes = rs.getInt("likes");
				int comments = rs.getInt("comments");
				String visibility = rs.getString("visibility");
				Post pi = new Post(postid,userid,content,createdAt,likes,comments,visibility);
				p.add(pi);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	    private Connection conn;

	    // Constructor to initialize the database connection
	    public PostTypeDAO(Connection conn) {
	        this.conn = conn;
	    }

	    // Add a new Post
	    public boolean addPost(Post post) throws SQLException, PostException.InvalidVisibilityException {
	        // Check for valid visibility
	        if (!post.getVisibility().equals("public") && !post.getVisibility().equals("friends") && !post.getVisibility().equals("private")) {
	            throw new PostException.InvalidVisibilityException("Invalid visibility option.");
	        }

	        String query = "INSERT INTO Post (userid, content, visibility) VALUES (?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, post.getUserId());
	            pstmt.setString(2, post.getContent());
	            pstmt.setString(3, post.getVisibility());

	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	        }
	    }

	    // Retrieve a Post by its ID
	    public Post getPostById(int postId) throws SQLException, PostException.PostNotFoundException {
	        String query = "SELECT * FROM Post WHERE post_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, postId);

	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Post(
	                    rs.getInt("post_id"),
	                    rs.getString("userid"),
	                    rs.getString("content"),
	                    rs.getTimestamp("created_at"),
	                    rs.getInt("likes"),
	                    rs.getInt("comments"),
	                    rs.getString("visibility")
	                );
	            } else {
	                throw new PostException.PostNotFoundException("Post with ID " + postId + " not found.");
	            }
	        }
	    }

	    // Update a Post
	    public boolean updatePost(Post post) throws SQLException, PostException.PostNotFoundException, PostException.InvalidVisibilityException {
	        // Check for valid visibility
	        if (!post.getVisibility().equals("public") && !post.getVisibility().equals("friends") && !post.getVisibility().equals("private")) {
	            throw new PostException.InvalidVisibilityException("Invalid visibility option.");
	        }

	        String query = "UPDATE Post SET content = ?, visibility = ?, likes = ?, comments = ? WHERE post_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, post.getContent());
	            pstmt.setString(2, post.getVisibility());
	            pstmt.setInt(3, post.getLikes());
	            pstmt.setInt(4, post.getComments());
	            pstmt.setInt(5, post.getPostId());

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new PostException.PostNotFoundException("Post with ID " + post.getPostId() + " not found.");
	            }
	            return true;
	        }
	    }

	    // Delete a Post
	    public boolean deletePost(int postId) throws SQLException, PostException.PostNotFoundException {
	        String query = "DELETE FROM Post WHERE post_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, postId);
	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new PostException.PostNotFoundException("Post with ID " + postId + " not found.");
	            }
	            return true;
	        }
	    }

}