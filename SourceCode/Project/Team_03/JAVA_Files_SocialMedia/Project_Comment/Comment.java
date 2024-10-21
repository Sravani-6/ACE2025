package coment;
public class Comment {
	private String commentId;
	private String postId;
	private String userId;
	private String content;
	
public Comment(String commentId,String postId,String userId,String content)
{
	this.commentId = commentId;
	this.postId = postId;
	this.userId = userId;
	this.content = content;
}
public String getCommentId() {
	return commentId;
}
public String getPostId() {
	return postId;
}
public String getUserId() {
	return userId;
}
public String getContent() {
	return content;
}
public void setCommentId(String commentId) {
	this.commentId = commentId;
}
public void setPostId(String postId) {
	this.postId = postId;
}
public void setUserId(String userId) {
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
