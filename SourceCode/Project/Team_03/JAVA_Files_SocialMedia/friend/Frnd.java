package friend;

public class Frnd  {
<<<<<<< HEAD
	private int friendId;
	private int userId1;
	private String status;
	private int userId2;
	
public Frnd(int friendId,int userId1,String status, int userId2) {
=======
	private String friendId;
	private String userId1;
	private String status;
	private String userId2;
	
public Frnd(String friendId,String userId1,String userId2, String status) {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	this.friendId = friendId;
	this.userId1 = userId1;
	this.status = status;
	this.userId2=userId2;
}
<<<<<<< HEAD
public int getFriendId() {
	return friendId;
}
public int getUserId1() {
	return userId1;
}
public int getUserId2() {
=======
public String getFriendId() {
	return friendId;
}
public String getUserId1() {
	return userId1;
}
public String getUserId2() {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	return userId2;
}
public String getStatus() {
	return status;
}
<<<<<<< HEAD
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public void setUserId1(int userId1) {
	this.userId1 = userId1;
}
public void setUserId2(int userId2) {
=======
public void setFriendId(String friendId) {
	this.friendId = friendId;
}
public void setUserId1(String userId1) {
	this.userId1 = userId1;
}
public void setUserId2(String userId2) {
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	this.userId2 = userId2;
}
public void setStatus(String status) {
	this.status = status;
}
}
