package Likes;

public class LikeException {
	// Exception for when a user is not found
	public static class LikeNotFoundException extends RuntimeException {
	    public LikeNotFoundException(String message) {
	        super(message);
	    }

	    public LikeNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
	public static class DuplicateLikeException extends RuntimeException {
	    public DuplicateLikeException(String message) {
	        super(message);
	    }

	    public DuplicateLikeException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
	public static class InvalidLikeOperationException extends RuntimeException {
	    public InvalidLikeOperationException(String message) {
	        super(message);
	    }

	    public InvalidLikeOperationException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
	public static class LikeLimitExceededException extends RuntimeException {
	    public LikeLimitExceededException(String message) {
	        super(message);
	    }

	    public LikeLimitExceededException(String message, Throwable cause) {
	        super(message, cause);
	    }
	}
}
