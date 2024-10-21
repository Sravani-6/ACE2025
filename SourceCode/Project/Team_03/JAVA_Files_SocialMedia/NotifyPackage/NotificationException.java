package socialMedia.NotifyPackage;

	public class NotificationException extends Exception {

	        // Exception for when a notification is not found by ID
	        public static class NotificationNotFoundException extends Exception {
	            public NotificationNotFoundException(String message) {
	                super(message);
	            }
	        }


}
