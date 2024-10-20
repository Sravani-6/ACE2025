package advertisement;

public class AdException {
	public static class AdNotFoundException extends Exception {
        public AdNotFoundException(String message) {
            super(message);
        }
    }
    // Exception for when the userId is invalid
    public static class InvalidAdIdException extends Exception {
        public InvalidAdIdException(String message) {
            super(message);
        }
    }
    // Exception for when a duplicate user is detected
    public static class DuplicateAdException extends Exception {
        public DuplicateAdException(String message) {
            super(message);
        }
    }
    // Exception for when the user input is invalid (empty Adid, password, etc.)
    public static class InvalidUserInputException extends Exception {
        public InvalidUserInputException(String message) {
            super(message);
        }
    }
}
