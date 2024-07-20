package SocialMedia;

public class Friend {
	private Int friendId;
	private Int userId1;
	private String status;
	
public Friend(Int friendId,Int userId1,String status) {
	this.friendId = friendId;
	this.userId1 = userId1;
	this.status = status;
}
public Int getFriendId() {
	return friendId;
}
public Int getUserId1() {
	return userId1;
}
public String getStatus() {
	return status;
}
public void setFriendId(Int friendId) {
	this.friendId = friendId;
}
public void setUserId1(Int userId1) {
	this.userId1 = userId1;
}
public void setStatus(String status) {
	this.status = status;
}
public void display() {
	System.out.println("Comment details");
	System.out.println("Friend Id: "+friendId);
	System.out.println("User Id: "+userId1);
	System.out.println("Status: "+status);
	
}

}
