package SocialMedia;
<<<<<<< HEAD

import java.sql.ResultSet;

=======
import java.util.*;
>>>>>>> a1dcbe8b0f4491c35f6e2ae49bb9193f1d164158
public class Comment {
	private Int commentId;
	private Int postId;
	private Int userId;
	private String content;
	
public Comment(Int commentId,Int postId,Int userId,String content)
{
	this.commentId = commentId;
	this.postId = postId;
	this.userId = userId;
	this.content = content;
}
public Int getCommentId() {
	return commentId;
}
public Int getPostId() {
	return postId;
}
public Int getUserId() {
	return userId;
}
public String getContent() {
	return content;
}
public void setCommentId(Int commentId) {
	this.commentId = commentId;
}
public void setPostId(Int postId) {
	this.postId = postId;
}
public void setUserId(Int userId) {
	this.userId = userId;
}
public void setContent(String content) {
	this.content = content;
}
public void display() {
	System.out.println("Comment Details");
	System.out.println("Comment Id: "+commentId);
	System.out.println("Post Id: "+postId);
	System.out.println("User Id: "+userId);
	System.out.println("Content: "+content);
}
}
public class CommentDAO{
	public List<Comment>getAllComment(){
		List<Comment> c=new ArrayList();
		try {
			connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Comment");
			while(rs.next())
			{
				int commentId=rs.getInt("commentId");
				int postId=rs.getInt("postId");
				int userId=rs.getInt("userId);
				String content=rs.getString("content");
				Comment co=new Comment(commentId,postID,userId,content);
				c.add(co);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
public static void main(String[] args) {
	List<comment> al=new ArrayList<>();
	System.out.format("%-5s %-15s %-10s %s\n","commentID","postId","userID","content");
	CommentDAO dao=new CommentDAO();
	al=dao.getAllUser();
	for(Comment it:al) {
		System.out.format("%-5s %-15s %-10s %s\n",it.getCommentId(),it.getPostId(),it.getUserId(),it.getContent());
	}
}
public class DdConnection{
	public static Connection getConnection()throws ClassNotFoundException,SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("mysql");
		String url = rb.getString("db.url");
		String username = rb.getString("db.username");
		String password = rb.getString("db.password");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriveManager.getConnection(url,username,password);
		return con;
	}
}

