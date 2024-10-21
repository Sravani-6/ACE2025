package coment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import coment.CommentException;
public class CommentDAO{
	public List<Comment>getAllComment(){
		List<Comment> c=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Comment");
			while(rs.next())
			{
				String commentId=rs.getString("commentId");
				String postId=rs.getString("postId");
				String userId=rs.getString("userId");
				String content=rs.getString("content");
				Comment co=new Comment(commentId,postId,userId,content);
				c.add(co);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	public static boolean addComments(Comment u) {
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into comment(commentid,postId,userId,content) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getCommentId());
			ps.setString(2,u.getPostId());
			ps.setString(3,u.getUserId());
			ps.setString(4,u.getContent());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	public static boolean deleteComment1(String u) {
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from comment where commentid = ?";
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
	// Method to get a comment by ID
    public static Comment getCommentById(String commentId)throws CommentException.CommentNotFoundException {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from comment where commentid = ?")) {
            
            pstmt.setString(1, commentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Create and return a Comment object if found
                return new Comment(rs.getString("commentId"), rs.getString("postId"), rs.getString("userId"), rs.getString("content"));
            } else {
                throw new CommentException.CommentNotFoundException("Comment with ID " + commentId + " not found.");
            }
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 // Method to update a comment
    static boolean updateComment(Comment comment) throws CommentException.CommentNotFoundException, ClassNotFoundException{
    	// Check if the comment exists before updating
        if (!commentExists(comment.getCommentId())) {
            throw new CommentException.CommentNotFoundException("Comment with ID " + comment.getCommentId() + " not found.");
        }
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("Update comment SET postId = ?, userId = ?, content = ? WHERE commentId = ?;")) {
            
        	pstmt.setString(4, comment.getCommentId());
            pstmt.setString(1, comment.getPostId());
            pstmt.setString(2, comment.getUserId());
            pstmt.setString(3, comment.getContent());
         // Print values for debugging
            System.out.println("Updating comment with ID: " + comment.getCommentId());
            System.out.println("New PostId: " + comment.getPostId());
            System.out.println("New UserId: " + comment.getUserId());
            System.out.println("New Content: " + comment.getContent());
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
            return rowsAffected > 0;  // Return true if the update was successful
        } catch (SQLException e) {
        	 System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
	private static boolean commentExists(String commentId) throws ClassNotFoundException {
	// TODO Auto-generated method stub
		String query = "SELECT COUNT(*) FROM comment WHERE commentId = ?";
		try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setString(1, commentId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                return rs.getInt(1) > 0;  // Return true if the user exists
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	return false;
}
	//private boolean commentExists(String commentId, String postId) throws ClassNotFoundException {
        //String query = "SELECT COUNT(*) FROM comment WHERE commentId = ?";

        //try (Connection conn = DbConnection.getConnection();
          //   PreparedStatement pstmt = conn.prepareStatement(query)) {

            //pstmt.setString(1, commentId);
            //ResultSet rs = pstmt.executeQuery();

            //if (rs.next()) {
              //  return rs.getInt(1) > 0;  // Return true if the user exists
            //}

        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}

        //return false;  // Return false if the user does not exist
    }
