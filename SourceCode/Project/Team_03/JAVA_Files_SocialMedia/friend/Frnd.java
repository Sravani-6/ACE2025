package friend;

public class Frnd  {
	private String friendId;
	private String userId1;
	private String status;
	private String userId2;
	
public Frnd(String friendId,String userId1,String userId2, String status) {
	this.friendId = friendId;
	this.userId1 = userId1;
	this.status = status;
	this.userId2=userId2;
}
public String getFriendId() {
	return friendId;
}
public String getUserId1() {
	return userId1;
}
public String getUserId2() {
	return userId2;
}
public String getStatus() {
	return status;
}
public void setFriendId(String friendId) {
	this.friendId = friendId;
}
public void setUserId1(String userId1) {
	this.userId1 = userId1;
}
public void setUserId2(String userId2) {
	this.userId2 = userId2;
}
public void setStatus(String status) {
	this.status = status;
}
}
