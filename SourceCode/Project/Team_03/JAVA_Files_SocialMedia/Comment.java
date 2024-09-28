package SocialMedia;
import java.util.*;
public class Comment {
	private Int commentId;
	private Int postId;
	private Int userId;
	private String content;
	
public Comment(Int commentId,Int postId,Int userId,String content)
{
	this.commentId = commentId;
	this.postId = postId;
	this.userId = userId;
	this.content = content;
}
public Int getCommentId() {
	return commentId;
}
public Int getPostId() {
	return postId;
}
public Int getUserId() {
	return userId;
}
public String getContent() {
	return content;
}
public void setCommentId(Int commentId) {
	this.commentId = commentId;
}
public void setPostId(Int postId) {
	this.postId = postId;
}
public void setUserId(Int userId) {
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
