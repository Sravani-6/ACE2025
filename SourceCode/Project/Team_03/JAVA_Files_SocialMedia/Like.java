package SocialMedia;

public class Like {
	private Int likeId;
	private Int postId;
	private Int userId;
	
public Like(Int likeId,Int postId,Int userId) {
	this.likeId = likeId;
	this.postId = postId;
	this.userId = userId;
}
public Int getLikeId() {
	return likeId;
}
public Int getPostId() {
	return postId;
}
public Int getUSerId() {
	return userId;
}
public void setUserId(Int userId) {
	this.userId = userId;
}
public void setLikeId(Int likeId) {
	this.likeId = likeId;
}
public void setPostId(Int postId) {
	this.postId = postId;
}
public void display() {
	System.out.println("Like details");
	System.out.println("Like Id: "+likeId);
	System.out.println("User Id: "+userId);
	System.out.println("Post Id: "+postId);
}
}
public class LikeDAO{
	public List<Like>getAllLikes(){
		List<Like> l=new ArrayList();
		try {
			connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from like");
			while(rs.next())
			{
				int likeId=rs.getInt("likeId");
				int userId=rs.getInt("userId");
				int postId=rs.getInt("postId");
				
				Like l=new Like(likeId,userId,postID);
				l.add(li);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return l;
	}
}
public static void main(String[] args) {
	List<like> al=new ArrayList<>();
	System.out.format("%-5s %-15s %-10s %s\n","likeId","userId","postId");
	LikeDAO dao=new LikeDAO();
	al=dao.getAllLike();
	for(Like it:al) {
		System.out.format("%-5s %-15s %-10s %s\n",it.getLikeId(),it.getUserId(),it.getPostId());
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

