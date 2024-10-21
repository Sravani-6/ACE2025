package socialMedia.Postpackage;

public class PostException {


	    // Exception for when the post is not found by ID
	    public static class PostNotFoundException extends Exception {
	        public PostNotFoundException(String message) {
	            super(message);
	        }
	    }

	    // Exception for when an invalid visibility is provided
	    public static class InvalidVisibilityException extends Exception {
	        public InvalidVisibilityException(String message) {
	            super(message);
	        }
	    }

	

}
