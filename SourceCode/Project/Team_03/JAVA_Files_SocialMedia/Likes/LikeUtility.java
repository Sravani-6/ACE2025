package Likes;
import java.util.*;

import Likes.Like;
import Likes.LikeDAO;
import Likes.LikeException;
import Likes.LikeException.LikeNotFoundException;
import Likes.LikeException;
public class LikeUtility {
	private List<Like> likeList= new ArrayList<Like>();
	public void displayLikeList() {
		LikeDAO ud = new LikeDAO();
		likeList = ud.getAllLikes();
		for(Like it:likeList) {
			System.out.format("%-5s %-10s %-10s\n",it.getLikeId(),it.getPostId(),it.getUserId());
		}
	}
	// Add a new like
    public boolean addLike() {
    	Scanner sc = new Scanner(System.in);
    	//System.out.println("Enter the likeId");
    	//String likeId = sc.nextLine();
    	System.out.println("Enter the postId");
    	String postId = sc.nextLine();
    	System.out.println("Enter the userId");
    	String userId = sc.nextLine();
		Like nu = new Like("12345",postId,userId);
    	likeList.add(nu);
    	LikeDAO uda = new LikeDAO();
    	return uda.addLikes(nu);
    }
    //delete a like
    public boolean deleteLikes(String u) 
    {
    	Scanner sc = new Scanner(System.in);
    	   // Find user in the local list and remove
        Like likeToDelete = null;
        for (Like like : likeList) {
            if (like.getLikeId().equals(u)) {
                likeToDelete = like;
                break;
            }
        }
        if (likeToDelete != null) {
            likeList.remove(likeToDelete);  // Remove from local list
            LikeDAO ud = new LikeDAO();  // Remove from the database
            return ud.deleteLike(u);  // Call the DAO to delete from the database
        } else{
            System.out.println("Like with ID " + u + " not found.");
            return false;
        }
            } 
      //Get a like by ID
        public void getLikeById() throws LikeNotFoundException {
            System.out.println("Enter like ID to fetch:");
            Scanner sc = new Scanner(System.in);
            String likeId = sc.nextLine();
            LikeDAO likeDAO = new LikeDAO();
            Like like = likeDAO.getLikeById(likeId);
            
            if (like != null) {
                System.out.println("Like found: " + like.getPostId() + " | " + like.getUserId());
            } else {
                System.out.println("Like not found.");
            }
        }
        // Update a like
        public boolean updateLike() throws LikeNotFoundException, ClassNotFoundException {
        	try {
            System.out.println("Enter like ID to update:");
            Scanner sc = new Scanner(System.in);
            String likeId = sc.nextLine();
            LikeDAO likeDAO = new LikeDAO();
            // Check if the like exists first
            Like existingLike = likeDAO.getLikeById(likeId);
            if (existingLike == null) {
                System.out.println("Like not found.");
                return false;
            }
            System.out.println("Enter new postId:");
            String newPostId = sc.nextLine();
            System.out.println("Enter new userId:");
            String newUserId = sc.nextLine();
            // Create updated like object
            Like updatedLike = new Like(likeId, newPostId, newUserId);
            validateLikeId(updatedLike);

            // Call LikeDAO to update the like
            return LikeDAO.updateLike(updatedLike);
        	}
         catch (LikeException.LikeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
            
        }
        // Validation methods
        private void validateLikeId(String likeId) throws Exception {
            if (likeId == null || likeId.trim().isEmpty()) {
                throw new Exception("Like ID cannot be null or empty.");
            }
        }

        private void validateLikeId(Like updatedLike) {
			// TODO Auto-generated method stub
			
		}
		private void validatePostId(String postId) throws Exception {
            if (postId == null || postId.trim().isEmpty()) {
                throw new Exception("Post ID cannot be null or empty.");
            }
        }

        private void validateUserId(String userId) throws Exception {
            if (userId == null || userId.trim().isEmpty()) {
                throw new Exception("User ID cannot be null or empty.");}
            }
            // Method to get a like by its ID
            public Like getLike(String likeId) throws Exception {
                try {
                    validateLikeId(likeId);
                    return LikeDAO.getLikeById(likeId);
                } catch (LikeException.LikeNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                    return null;
                }
        }
}
