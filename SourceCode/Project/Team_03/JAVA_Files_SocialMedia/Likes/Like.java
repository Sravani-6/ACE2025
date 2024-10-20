package Likes;
public class Like {
	private String likeId;
	private String postId;
	private String userId;
	
	
public Like(String likeId, String postId, String userId) {
	// TODO Auto-generated constructor stub
	this.likeId = likeId;
	this.postId = postId;
	this.userId = userId;
}
public String getLikeId() {
	return likeId;
}
public String getPostId() {
	return postId;
}
public String getUserId() {
	return userId;
}
public void setLikeId(String likeId) {
	this.likeId = likeId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public void display() {
	System.out.println("Like Details");
	System.out.println("Like Id: "+likeId);
	System.out.println("Post Id: "+postId);
	System.out.println("User Id: "+userId);
}
}
