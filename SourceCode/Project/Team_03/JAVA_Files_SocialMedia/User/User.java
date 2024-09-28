package User;
public class User {
	private int userId;
	private String username;
	private String emailID;
	private String passwd;
	public User(int userId,String username,String emailID, String passwd) {
		this.userId = userId;
		this.username = username;
		this.emailID = emailID;
		this.passwd = passwd;
	}
	public int getUserId() {
		return userId;
	}
	public String getUsername() {
		return username;
	}
	public String getEmailID() {
		return emailID;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public void display() {
		System.out.println("User Details");
		System.out.println("User Id: "+userId);
		System.out.println("User Name: "+username);
		System.out.println("User Email: "+emailID);
		System.out.println("User passwd: "+passwd);
	}
}