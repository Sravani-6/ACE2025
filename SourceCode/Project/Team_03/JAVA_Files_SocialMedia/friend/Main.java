package friend;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

public class Main {

	public static void main(String[] args) {
		List<Frnd> al=new ArrayList<>();
		System.out.format("%-10s %-15s %-10s   %-15s\n","FriendId","UserId1","Status","UserId2");
		FrndDAO dao=new FrndDAO();
		al=dao.getAllFrnds();
		for(Frnd m:al){
			System.out.format("%-10s %-15s  %-10s   %-15s\n",m.getFriendId(),m.getUserId1(),m.getStatus(),m.getUserId2());
		}

	}

=======
import java.util.Scanner;

import friend.FrndException.EntityNotFoundException;
import friend.FrndException.FrndAlreadyExistsException;


public class Main {

	public static void main(String[] args) throws FrndAlreadyExistsException, EntityNotFoundException {
		List<Frnd> al=new ArrayList<>();
		System.out.format("%-10s %-15s %-10s   %-15s\n","FriendId","UserId1","UserId2","Status");
		FrndDAO dao=new FrndDAO();
		al=dao.getAllFrnds();
		for(Frnd m:al){
			System.out.format("%-10s %-15s  %-10s   %-15s\n",m.getFriendId(),m.getUserId1(),m.getUserId2(),m.getStatus());
		}
		Scanner sc = new Scanner(System.in);
       FrndUtility userUtil = new FrndUtility();
        System.out.println("Add a new Frnd:"+userUtil.addFriend());
        userUtil.displayUserList();
        System.out.println("Enter Frndid to delete");
        String userid = sc.nextLine();
        System.out.println("FrndId to delete"+userUtil.deleteUser(userid));
        userUtil.displayUserList();  
        userUtil.getUserById();
        //update the user details
        //userUtil.updateUser();
        try {
            boolean success = userUtil.updateUser();
            if (success) {
                System.out.println("Ad updated successfully.");
            } else {
                System.out.println("Ad update failed.");
            }
        } catch (EntityNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        userUtil.displayUserList();
	}
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
}
