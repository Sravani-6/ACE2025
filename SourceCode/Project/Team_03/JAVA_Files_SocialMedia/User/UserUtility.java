package socialMedia.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import socialMedia.User.UserException.DuplicateUserException;
import socialMedia.User.UserException.UserNotFoundException;

public class UserUtility {
	private List<User> userList = new ArrayList<User>();
	public void displayUserList() {
		UserDAO ud = new UserDAO();
		userList = ud.getAllUsers();
		for(User it:userList) {
			System.out.format("%-5s %-10s %-10s %-25s\n",it.getUserId(),it.getUsername(),it.getEmailID(),it.getPasswd());
		}
	}
	// Add a new user
    public boolean addUser() throws DuplicateUserException {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the username");
    	String username = sc.nextLine();
    	System.out.println("Enter the email");
    	String email = sc.nextLine();
    	System.out.println("Enter the password");
    	String password = sc.nextLine();
    	User nu = new User("135",username,email,password);
    	userList.add(nu);
    	UserDAO uda = new UserDAO();
    	return uda.addUser(nu);
    }
    //delete a user
    public boolean deleteUser(String u) throws UserNotFoundException {
    	Scanner sc = new Scanner(System.in);
    	   // Find user in the local list and remove
        User userToDelete = null;
        for (User user : userList) {
            if (user.getUserId().equals(u)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            userList.remove(userToDelete);  // Remove from local list
            UserDAO ud = new UserDAO();  // Remove from the database
            return ud.deleteUser(u);  // Call the DAO to delete from the database
        } else {
            System.out.println("User with ID " + u + " not found.");
            return false;
        }
    	
    	
    }
    //Get a user by ID
    public void getUserById() throws UserNotFoundException {
        System.out.println("Enter user ID to fetch:");
        Scanner sc = new Scanner(System.in);
        String userId = sc.nextLine();
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(userId);
        
        if (user != null) {
            System.out.println("User found: " + user.getUsername() + " | " + user.getEmailID());
        } else {
            System.out.println("User not found.");
        }
    }
    // Update a user
    public boolean updateUser() throws UserNotFoundException {
    	try {
        System.out.println("Enter user ID to update:");
        Scanner sc = new Scanner(System.in);
        String userId = sc.nextLine();
        UserDAO userDAO = new UserDAO();
        // Check if the user exists first
        User existingUser = userDAO.getUserById(userId);
        if (existingUser == null) {
            System.out.println("User not found.");
            return false;
        }
        System.out.println("Enter new username:");
        String newUsername = sc.nextLine();
        System.out.println("Enter new email:");
        String newEmail = sc.nextLine();
        System.out.println("Enter new password:");
        String newPassword = sc.nextLine();
        
        // Create updated user object
        User updatedUser = new User(userId, newUsername, newEmail,newPassword);
        validateUserInput(updatedUser);

        // Call UserDAO to update the user
        return userDAO.updateUser(updatedUser);
    	}
     catch (UserException.UserNotFoundException | UserException.InvalidUserInputException e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
        
    }
    // Validate user ID
    private void validateUserId(String userId) throws UserException.InvalidUserIdException {
        if (userId == null || userId.trim().isEmpty()) {
            throw new UserException.InvalidUserIdException("User ID cannot be null or empty.");
        }
    }

    // Validate user input
    private void validateUserInput(User user) throws UserException.InvalidUserInputException {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new UserException.InvalidUserInputException("Username cannot be null or empty.");
        }
        if (user.getPasswd() == null || user.getPasswd().trim().isEmpty()) {
            throw new UserException.InvalidUserInputException("Password cannot be null or empty.");
        }
        if (user.getEmailID() == null || user.getEmailID().trim().isEmpty()) {
            throw new UserException.InvalidUserInputException("Email cannot be null or empty.");
        }
    }
    // Check user login
    public boolean loginUser(String userId, String password) {
        for (User user : userList) {
            if (user.getUserId().equals(userId) && user.getPasswd().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
