package coment;
public class CommentException {
	//Exception for when comment is not found
	
	public static class CommentNotFoundException extends Exception {
	    public CommentNotFoundException(String message) {
	        super(message);
	    }
	}
	// Exception for when a post not found
	public static class PostNotFoundException extends Exception {
	    public PostNotFoundException(String message) {
	        super(message);
	    }
	}
    // Exception for when the user is not found
	public static class UserNotFoundException extends Exception {
	    public UserNotFoundException(String message) {
	        super(message);
	    }
	}
    // Exception for when a content is null
	public static class EmptyContentException extends Exception {
	    public EmptyContentException() {
	        super("Comment content cannot be empty.");
	    }
	}
    // Exception for when the userId is invalid
	public static class InvalidCommentIdException extends Exception {
	    public InvalidCommentIdException(String message) {
	        super(message);
	    }
	}
	public static class ContentTooLongException extends Exception {
	    public ContentTooLongException(int maxLength) {
	        super("Comment content exceeds maximum length of " + maxLength + " characters.");
	    }
	}
}
