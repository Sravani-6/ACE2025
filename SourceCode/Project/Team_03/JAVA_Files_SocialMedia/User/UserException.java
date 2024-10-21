package socialMedia.User;

public class UserException {
	// Exception for when a user is not found
    public static class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
    // Exception for when the userId is invalid
    public static class InvalidUserIdException extends Exception {
        public InvalidUserIdException(String message) {
            super(message);
        }
    }
    // Exception for when a duplicate user is detected
    public static class DuplicateUserException extends Exception {
        public DuplicateUserException(String message) {
            super(message);
        }
    }
    // Exception for when the user input is invalid (empty username, password, etc.)
    public static class InvalidUserInputException extends Exception {
        public InvalidUserInputException(String message) {
            super(message);
        }
    }
}
