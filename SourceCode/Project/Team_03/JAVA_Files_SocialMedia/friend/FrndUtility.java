package friend;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import friend.FrndException.*;

public class FrndUtility {
		private List<Frnd> frndList = new ArrayList<Frnd>();
		public void displayUserList() {
			FrndDAO ud = new FrndDAO();
			frndList = ud.getAllFrnds();
			for(Frnd it:frndList) {
				System.out.format("%-5s %-10s %-10s %-25s\n",it.getFriendId(),it.getUserId1(),it.getUserId2(),it.getStatus());
			}
		}
		// Add a new user
		public boolean addFriend() throws FrndAlreadyExistsException {
			Scanner s = new Scanner(System.in);
	    	System.out.println("Enter the id");
	    	String id = s.nextLine();
	    	System.out.println("Enter the UserId1");
	    	String userId1 = s.nextLine();
	    	System.out.println("Enter the UserId2");
	    	String userId2=s.nextLine();
	    	System.out.println("Enter the Status");
	    	String status=s.nextLine();
	      Frnd nu = new Frnd(id,userId1,userId2,status);
	    	frndList.add(nu);
	    	FrndDAO uda = new FrndDAO();
	    	return uda.addUser(nu);
	    }
		 

	    //delete a user
	    public boolean deleteUser(String u)  {
	    	Scanner sc = new Scanner(System.in);
	    	   // Find user in the local list and remove
	        Frnd userToDelete = null;
	        for (Frnd user : frndList) {
	            if (user.getFriendId().equals(u)) {
	                userToDelete = user;
	                break;
	            }
	        }

	        if (userToDelete != null) {
	            frndList.remove(userToDelete);  // Remove from local list
	            FrndDAO ud = new FrndDAO();  // Remove from the database
	            return ud.deleteUser(u);  // Call the DAO to delete from the database
	        } else {
	            System.out.println("Frnd with ID " + u + " not found.");
	            return false;
	        }
	    }
	    	
	        public void getUserById() throws EntityNotFoundException {
		        System.out.println("Enter Frnd ID to fetch:");
		        Scanner sc = new Scanner(System.in);
		        String frndId = sc.nextLine();
		        FrndDAO userDAO = new FrndDAO();
		        Frnd user = userDAO.getUserById(frndId);
		        
		        if (user != null) {
		            System.out.println("Friend exits"+user.getStatus());
		        } else {
		            System.out.println("Friend not found.");
		        }
		    }
	    
	      
		    // Update a user
		    public boolean updateUser() throws EntityNotFoundException {
		    	try {
		        System.out.println("Enter user ID to update:");
		        Scanner sc = new Scanner(System.in);
		        String friendId = sc.nextLine();
		        FrndDAO userDAO = new FrndDAO();
		        // Check if the user exists first
		        Frnd existingUser = userDAO.getUserById(friendId);
		        if (existingUser == null) {
		            System.out.println("User not found.");
		            return false;
		        }
		        System.out.println("Enter new friendId:");
		        String newfriendId = sc.nextLine();
		        System.out.println("Enter new userId1:");
		        String newuserId1 = sc.nextLine();
		        System.out.println("Enter new userId2:");
		        String newuserId2 = sc.nextLine();
		        System.out.println("Enter new status:");
		        String newstatus = sc.nextLine();
		        
		        // Create updated user object
		        Frnd updatedUser = new Frnd(newfriendId, newuserId1, newuserId2,newstatus);
		        validateUserInput(updatedUser);

		        // Call UserDAO to update the user
		        return userDAO.updateUser(updatedUser);
		    	}
		     catch ( EntityNotFoundException e) {
		        System.out.println("Error: " + e.getMessage());
		        return false;
		    }
		        
		    }
		    // Validate user ID
		    private void validateUserId(String userId) throws FrndAlreadyExistsException {
		        if (userId == null || userId.trim().isEmpty()) {
		            throw new FrndAlreadyExistsException("Friend with Id already Exist");
		        }
		    }

		    // Validate user input
		    private void validateUserInput(Frnd user) throws EntityNotFoundException{
		        if (user.getUserId1() == null || user.getUserId2().isEmpty()) {
		            throw new EntityNotFoundException("User IDs canot be null.");
		        }
		        if (user.getFriendId() == null || user.getStatus().isEmpty()) {
		            throw new EntityNotFoundException("Friend Id cannot be null or empty.");
		        }
		    }
			

		}
