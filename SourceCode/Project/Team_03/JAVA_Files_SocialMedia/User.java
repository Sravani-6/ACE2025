package SocialMedia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class User {
	private Int userId;
	private String userName;
	private String email;
	private String password;
public User(Int userId,String userName,String email, String password) {
	this.userId = userId;
	this.userName = userName;
	this.email = email;
	this.password = password;
}
public Int getUserId() {
	return userId;
}
public String getUserName() {
	return userName;
}
public String getEmail() {
	return email;
}
public String getPassword() {
	return password;
}
public void setUserId(Int userId) {
	this.userId = userId;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public void setEmail(String emai) {
	this.email = email;
}
public void setPassword(String password) {
	this.password = password;
}
public void display() {
	System.out.println("User Details");
	System.out.println("User Id: "+userId);
	System.out.println("User Name: "+userName);
	System.out.println("User Email: "+email);
	System.out.println("User password: "+password);
}


public class UserDAO{
	public List<User>getAllUsers(){
		List<User> u=new ArrayList();
		try {
			connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				int id=rs.getInt("userId");
				String username=rs.getString("username");
				String email=rs.getString("email");
				String password=rs.getString("password");
				User us=new User(userId,username,email,password)
				u.add(ur);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
public static void main(String[] args) {
	List<user> al=new ArrayList<>();
	System.out.format("%-5s %-15s %-10s %s\n","userId","username","email","password");
	UserDAO dao=new UserDAO();
	al=dao.getAllUser();
	for(User it:al) {
		System.out.format("%-5s %-15s %-10s %s\n",it.getUserId(),it.getUserName(),it.getEmail(),it.getPassword());
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
}
