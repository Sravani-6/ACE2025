package advertisement;

import java.util.*;

<<<<<<< HEAD
public class Main {

	public static void main(String[] args) {
		List<Advertisement> al=new ArrayList<>();
		System.out.format("%-10s %-15s %-10s\n","AdID","AdTitle","AdContent");
		AdverDao dao=new AdverDao();
		al=dao.getAllAdvertisements();
		for(Advertisement m:al){
			System.out.format("%-10s %-15s %-10s\n",m.getAdId(),m.getAdTitle(),m.getAdContent());
		}

	}

	}
=======
import advertisement.AdException.AdNotFoundException;
import advertisement.AdException.DuplicateAdException;

public class Main {

	public static void main(String[] args) throws AdNotFoundException, DuplicateAdException {
		List<Advertisement> al=new ArrayList<>();
		System.out.format("%-10s %-15s %-10s\n","AdID","AdTitle","AdContent");
		AdverDao dao=new AdverDao();
		//al=dao.getAllAdvertisements();
		//for(Advertisement m:al){
			//System.out.format("%-10s %-15s %-10s\n",m.getAdId(),m.getAdTitle(),m.getAdContent());
		//}
		// Create AdUtility instance
		Scanner sc = new Scanner(System.in);
        AdUtility userUtil = new AdUtility();
        userUtil.displayUserList();
        System.out.println("Add a new Ad:"+userUtil.addAd());
        userUtil.displayUserList();
        System.out.println("Enter AdId to delete");
        String userid = sc.nextLine();
        System.out.println(userUtil.deleteAd(userid));
        userUtil.displayUserList();
        //get details byAd134id
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
        } catch (AdNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        userUtil.displayUserList();
	}
}
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
