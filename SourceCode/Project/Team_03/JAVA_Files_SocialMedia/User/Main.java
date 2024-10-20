package socialMedia.User;
import java.util.Scanner;

import socialMedia.User.UserException.DuplicateUserException;
import socialMedia.User.UserException.UserNotFoundException;
public class Main {
	private static UserUtility userUtility;

	public static void main(String[] args) throws UserNotFoundException, DuplicateUserException {
		Scanner sc = new Scanner(System.in);
        UserUtility userUtil = new UserUtility();
        userUtil.displayUserList();
        System.out.println("Add a new user:"+userUtil.addUser());
        userUtil.displayUserList();
        System.out.println("Enter userid to delete");
        String userid = sc.nextLine();
        System.out.println(userUtil.deleteUser(userid));
        userUtil.displayUserList();
        //get details by userid
        userUtil.getUserById();
        //update the user details
        //userUtil.updateUser();
        try {
            boolean success = userUtil.updateUser();
            if (success) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("User update failed.");
            }
        } catch (UserException.UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        userUtil.displayUserList();
	}
}
