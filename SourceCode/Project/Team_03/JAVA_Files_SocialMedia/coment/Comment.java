package coment;
public class Comment {
	private int commentId;
	private int postId;
	private int userId;
	private String content;
	
public Comment(int commentId,int postId,int userId,String content)
{
	this.commentId = commentId;
	this.postId = postId;
	this.userId = userId;
	this.content = content;
}
public int getCommentId() {
	return commentId;
}
public int getPostId() {
	return postId;
}
public int getUserId() {
	return userId;
}
public String getContent() {
	return content;
}
public void setCommentId(int commentId) {
	this.commentId = commentId;
}
public void setPostId(int postId) {
	this.postId = postId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public void setContent(String content) {
	this.content = content;
}
public void display() {
	System.out.println("Comment Details");
	System.out.println("Comment Id: "+commentId);
	System.out.println("Post Id: "+postId);
	System.out.println("User Id: "+userId);
	System.out.println("Content: "+content);
}
}
