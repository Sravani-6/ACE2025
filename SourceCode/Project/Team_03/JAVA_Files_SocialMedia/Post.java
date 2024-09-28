package SocialMedia;

public class Post {
	private Int postId;
	private Int userId;
	private String content;
	private String mediaType;
public Post(Int postId,Int userId,String content,String mediatype) {
	this.postId = postId;
	this.userId = userId;
	this.content = content;
	this.mediaType = mediaType;
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
public String getMediaType() {
	return mediaType;
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
public void setMediaType(String mediaType) {
	this.mediaType = mediaType;
}
public void display() {
	System.out.println("Post details");
	System.out.println("Post Id: "+postId);
	System.out.println("User Id: "+userId);
	System.out.println("Content: "+content);
	System.out.println("Media Type: "+mediaType);
}



}
