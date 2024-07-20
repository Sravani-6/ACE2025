package SocialMedia;

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

}
