package friend;
//create Exceptions
//Thrown when trying to create an entity that already exists.
public class FrndException {
	public static class FrndAlreadyExistsException extends Exception {
	    public FrndAlreadyExistsException(String message) {
	        super(message);
	    }
	}
	//Read Exceptions
	//Thrown when trying to read an entity that doesn't exist.
	public static class EntityNotFoundException extends Exception {
	    public EntityNotFoundException(String message) {
	        super(message);
	    }

	}
//Update Exception
	// Thrown when updates are not allowed due to system restrictions (e.g., a post is locked after a certain time, or user status can’t be updated after deactivation).
	public static class UpdateNotAllowedException extends Exception {
	    public UpdateNotAllowedException(String message) {
	        super(message);
	    }
	}
//delete Exception
	//Thrown when a user tries to delete an entity they don't have permission to delete (e.g., deleting another user's post or profile).
	public static class UnauthorizedDeletionException extends Exception {
	    public UnauthorizedDeletionException(String message) {
	        super(message);
	    }
	}
	}
