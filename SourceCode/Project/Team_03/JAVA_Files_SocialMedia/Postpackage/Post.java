package socialMedia.Postpackage;

import java.sql.Timestamp;

public class Post {
	private int postId;
	private String userId;
	private String content;
	private Timestamp createdAt;
    private int likes;
    private int comments;
    private String visibility;
 // Constructor without postId and createdAt (as they are auto-generated)
    public Post(String userId, String content, String visibility) {
        this.userId = userId;
        this.content = content;
        this.likes = 0;
        this.comments = 0;
        this.visibility = visibility;
    }
 // Constructor to include all fields when retrieving from the database
    public Post(int postId, String userId, String content, Timestamp createdAt, int likes, int comments, String visibility) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.createdAt = createdAt;
        this.likes = likes;
        this.comments = comments;
        this.visibility = visibility;
    }
	public int getPostId() {
		return postId;
	}
	public String getUserId() {
		return userId;
	}
	public String getContent() {
		return content;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public int getLikes() {
		return likes;
	}
	public int getComments() {
		return comments;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
	public void setLikes(int likes) {
        this.likes = likes;
    }
	public void setComments(int comments) {
        this.comments = comments;
    }
	public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
	@Override
    public String toString() {
        return "Post [postId=" + postId + ", userId=" + userId + ", content=" + content + ", createdAt=" + createdAt
                + ", likes=" + likes + ", comments=" + comments + ", visibility=" + visibility + "]";
    }
}
