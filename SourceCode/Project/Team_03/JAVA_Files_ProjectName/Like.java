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
