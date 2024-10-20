package advertisement;

import java.util.*;

import advertisement.AdException.AdNotFoundException;
import advertisement.AdException.DuplicateAdException;


public class AdUtility {
		private List<Advertisement> adlist = new ArrayList<Advertisement>();
		public void displayUserList() {
			AdverDao ud = new AdverDao();
			adlist = ud.getAllAdvertisements();
			for(Advertisement it:adlist) {
				System.out.format("%-5s %-10s %-10s\n",it.getAdId(),it.getAdTitle(),it.getAdContent());
			}
		}
		// Add a new user
	    public boolean addAd() throws DuplicateAdException {
	    	Scanner s = new Scanner(System.in);
	    	System.out.println("Enter the id");
	    	String id = s.nextLine();
	    	System.out.println("Enter the title");
	    	String title = s.nextLine();
	    	System.out.println("Enter the content");
	    	String content=s.nextLine();
	        Advertisement nu = new Advertisement(id,title,content);
	    	adlist.add(nu);
	    	AdverDao uda = new AdverDao();
	    	return uda.addAd(nu);
	    	
	    }
	    //delete a user
	    public boolean deleteAd(String u) throws AdNotFoundException {
	    	Scanner sc = new Scanner(System.in);
	    	   // Find user in the local list and remove
	        Advertisement adToDelete = null;
	        for (Advertisement a : adlist) {
	            if (a.getAdId().equals(u)) {
	                adToDelete = a;
	                break;
	            }
	        }

	        if (adToDelete != null) {
	            adlist.remove(adToDelete);  // Remove from local list
	            AdverDao ud = new AdverDao();  // Remove from the database
	            return ud.deleteAd(u);  // Call the DAO to delete from the database
	        } else {
	            System.out.println("Ad with ID " + u + " not found.");
	            return false;
	        }
	     }
	  //Get a user by ID
	    public void getUserById() throws AdNotFoundException {
	        System.out.println("Enter Ad ID to fetch:");
	        Scanner sc = new Scanner(System.in);
	        String AdId = sc.nextLine();
	        AdverDao userDAO = new AdverDao();
	        Advertisement user = userDAO.getUserById(AdId);
	        
	        if (user != null) {
	            System.out.println("Ad found: " + user.getAdTitle() + " | " + user.getAdContent());
	        } else {
	            System.out.println("Ad not found.");
	        }
	    }
	    // Update a user
	    public boolean updateUser() throws AdNotFoundException {
	    	try {
	        System.out.println("Enter Ad ID to update:");
	        Scanner sc = new Scanner(System.in);
	        String adId = sc.nextLine();
	        AdverDao userDAO = new AdverDao();
	        // Check if the user exists first
	        Advertisement existingUser = userDAO.getUserById(adId);
	        if (existingUser == null) {
	            System.out.println("Ad not found.");
	            return false;
	        }
	     
	        System.out.println("Enter new AdTitle:");
	        String newAdTitle = sc.nextLine();
	        System.out.println("Enter new Content:");
	        String newAdContent = sc.nextLine();
	        
	        // Create updated user object
	        Advertisement updatedUser = new Advertisement(adId, newAdTitle, newAdContent);
	        validateUserInput(updatedUser);

	        // Call UserDAO to update the user
	        return userDAO.updateUser(updatedUser);
	    	}
	     catch (AdException.AdNotFoundException | AdException.InvalidUserInputException e) {
	        System.out.println("Error: " + e.getMessage());
	        return false;
	    }
	        
	    }
	    // Validate user ID
	    private void validateUserId(String userId) throws AdException.InvalidAdIdException {
	        if (userId == null || userId.trim().isEmpty()) {
	            throw new AdException.InvalidAdIdException("Ad ID cannot be null or empty.");
	        }
	    }

	    // Validate user input
	    private void validateUserInput(Advertisement user) throws AdException.InvalidUserInputException {
	        if (user.getAdTitle() == null || user.getAdTitle().trim().isEmpty()) {
	            throw new AdException.InvalidUserInputException("Ad title cannot be null or empty.");
	        }
	        if (user.getAdContent() == null || user.getAdContent().trim().isEmpty()) {
	            throw new AdException.InvalidUserInputException("Ad Content cannot be null or empty.");
	        }
	    }
	    // Check user login
	    public boolean loginUser(String AdId, String AdTitle) {
	        for (Advertisement user : adlist) {
	            if (user.getAdId().equals(AdId) && user.getAdTitle().equals(AdTitle)) {
	                return true;
	            }
	        }
	        return false;
	    }
	}


