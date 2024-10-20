package Message;

public class MessageException extends Exception {
	public MessageException(String message) {
        super(message);
    }

    // Nested exception classes for specific cases
    public static class MessageNotFoundException extends MessageException {
        public MessageNotFoundException(String messageId) {
            super("Message with ID " + messageId + " not found.");
        }
    }

    public static class InvalidSenderException extends MessageException {
        public InvalidSenderException(String senderId) {
            super("Sender ID " + senderId + " is invalid.");
        }
    }

    public static class InvalidReceiverException extends MessageException {
        public InvalidReceiverException(String receiverId) {
            super("Receiver ID " + receiverId + " is invalid.");
        }
    }

}
