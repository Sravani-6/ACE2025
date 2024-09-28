package Likes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class LikeDAO{
	public List<Like>getAllLikes(){
		List<Like> l=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from likes");
			while(rs.next())
			{
				int likeId=rs.getInt("likeId");
				int postId=rs.getInt("postId");
				int userId=rs.getInt("userId");
				Like li=new Like(likeId,postId,userId);
				l.add(li);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}