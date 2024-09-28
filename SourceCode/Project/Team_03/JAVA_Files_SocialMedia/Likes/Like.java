package Likes;
public class Like {
	private int likeId;
	private int postId;
	private int userId;
	
	
public Like(int likeId,int postId,int userId)
{
	this.likeId = likeId;
	this.postId = postId;
	this.userId = userId;
}
public int getLikeId() {
	return likeId;
}
public int getPostId() {
	return postId;
}
public int getUserId() {
	return userId;
}
public void setLikeId(int likeId) {
	this.likeId = likeId;
}
public void setPostId(int postId) {
	this.postId = postId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public void display() {
	System.out.println("Comment Details");
	System.out.println("Comment Id: "+likeId);
	System.out.println("Post Id: "+postId);
	System.out.println("User Id: "+userId);
}
}
