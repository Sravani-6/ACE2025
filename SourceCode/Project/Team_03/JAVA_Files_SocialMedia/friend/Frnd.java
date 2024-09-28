package friend;

public class Frnd  {
	private int friendId;
	private int userId1;
	private String status;
	private int userId2;
	
public Frnd(int friendId,int userId1,String status, int userId2) {
	this.friendId = friendId;
	this.userId1 = userId1;
	this.status = status;
	this.userId2=userId2;
}
public int getFriendId() {
	return friendId;
}
public int getUserId1() {
	return userId1;
}
public int getUserId2() {
	return userId2;
}
public String getStatus() {
	return status;
}
public void setFriendId(int friendId) {
	this.friendId = friendId;
}
public void setUserId1(int userId1) {
	this.userId1 = userId1;
}
public void setUserId2(int userId2) {
	this.userId2 = userId2;
}
public void setStatus(String status) {
	this.status = status;
}
}
