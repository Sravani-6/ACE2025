package socialMedia.Grouppackage;

public class GroupException {

	    // Exception for when a group is not found by ID
	    public static class GroupNotFoundException extends Exception {
	        public GroupNotFoundException(String message) {
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
