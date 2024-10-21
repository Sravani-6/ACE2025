package Likes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Likes.LikeException.*;
public class LikeDAO{
	public List<Like>getAllLikes(){
		List<Like> l=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from likes");
			while(rs.next())
			{
				String likeId=rs.getString("likeID");
				String postId=rs.getString("postID");
				String userId=rs.getString("userId");
				Like li=new Like(likeId,postId,userId);
				l.add(li);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	public boolean addLikes(Like u){
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into likes(likeID,postID,userId) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getLikeId());
			ps.setString(2,u.getPostId());
			ps.setString(3,u.getUserId());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	public boolean deleteLike(String u) {
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from likes where likeID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u);
			return ps.executeUpdate()>0;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to delete");
			return false;
		}
}
	// Method to get a like by ID
    public static Like getLikeById(String likeId)throws LikeException.LikeNotFoundException {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from likes where likeID = ?")) {
            
            pstmt.setString(1, likeId);
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                // Create and return a like object if found
                return new Like(rs.getString("likeID"), rs.getString("postID"), rs.getString("userId"));
            } else {
                throw new LikeException.LikeNotFoundException("Like with ID " + likeId + " not found.");
            }
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 // Method to update a like
    public static boolean updateLike(Like like) throws LikeException.LikeNotFoundException, ClassNotFoundException{
    	// Check if the like exists before updating
    	String query="Update likes SET postID = ?, userId = ? Where likeID = ?";
        if (!likeExists(like.getLikeId())) {
            throw new LikeException.LikeNotFoundException("Like with ID " + like.getLikeId() + " not found.");
        }
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
        	pstmt.setString(3, like.getLikeId());
            pstmt.setString(1, like.getPostId());
            pstmt.setString(2, like.getUserId());
         // Print values for debugging
            System.out.println("Updating like with ID: " + like.getLikeId());
            System.out.println("New PostId: " + like.getPostId());
            System.out.println("New UserId: " + like.getUserId());
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
            return rowsAffected > 0;  // Return true if the update was successful
        } catch (SQLException e) {
        	 System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    private static boolean likeExists(String likeId) throws ClassNotFoundException {
        String query = "SELECT COUNT(*) FROM user WHERE likeID = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, likeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;  // Return true if the like exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Return false if the like does not exist
    }
}