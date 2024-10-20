package socialMedia.User;
public class User {
	private String userId;
	private String username;
	private String emailID;
	private String passwd;
	public User(String userId,String username,String emailID, String passwd) {
		this.userId = userId;
		this.username = username;
		this.emailID = emailID;
		this.passwd = passwd;
	}
	public String getUserId() {
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
	public void setUserId(String userId) {
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
	 @Override
	    public String toString() {
	        return "User{" +
	                "userId=" + userId +
	                ", username='" + username + '\'' +
	                ", email='" + emailID + '\'' +
	                ", password='" + passwd + '\'' +
	                '}';
	    }
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        User user = (User) o;
	        return userId == user.userId && username.equals(user.username);
	    }
	// compareTo Method (compare by username)
	    public int compareTo(User otherUser) {
	        return this.username.compareTo(otherUser.username);
	    }
}