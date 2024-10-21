package SocialMedia;

public class post {
	private int postId;
	private int userId;
	private String content;
	private String mediaType;
	public post(int postId,int userId,String content,String mediatype,String mediaType) {
		this.postId = postId;
		this.userId = userId;
		this.content = content;
		this.mediaType = mediaType ;
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
	public String getMediaType() {
		return mediaType;
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
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}
}
