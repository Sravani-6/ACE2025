package coment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CommentDAO{
	public List<Comment>getAllComment(){
		List<Comment> c=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from Comment");
			while(rs.next())
			{
				int commentId=rs.getInt("commentId");
				int postId=rs.getInt("postId");
				int userId=rs.getInt("userId");
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
}