package coment;
import java.util.*;
import coment.Comment;
import coment.CommentException;
import coment.CommentException.CommentNotFoundException;
import coment.CommentException.InvalidCommentIdException;
import coment.CommentException.PostNotFoundException;
import coment.CommentException.UserNotFoundException;
public class CommentUtility {
	private List<Comment> commentList = new ArrayList<Comment>();
	public void displayCommentList() {
		CommentDAO ud = new CommentDAO();
		commentList = ud.getAllComment();
		for(Comment it:commentList) {
			System.out.format("%-5s %-10s %-10s %-25s\n",it.getCommentId(),it.getPostId(),it.getUserId(),it.getContent());
		}
	}
	// Add a new comment
    public boolean addComment() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the postId");
    	String postId = sc.nextLine();
    	System.out.println("Enter the userId");
    	String userId = sc.nextLine();
    	System.out.println("Enter the content");
    	String content = sc.nextLine();
    	Comment nu = new Comment("12345",postId,userId,content);
    	commentList.add(nu);
    	CommentDAO uda = new CommentDAO();
    	return uda.addComments(nu);
    }
    //delete a comment
    public boolean deleteComment(String u) 
    {
    	Scanner sc = new Scanner(System.in);
    	   // Find comment in the local list and remove
        Comment commentToDelete = null;
        for (Comment comment : commentList) {
            if (comment.getCommentId().equals(u)) {
                commentToDelete = comment;
                break;
            }
        }

        if (commentToDelete != null) {
            commentList.remove(commentToDelete);  // Remove from local list
            CommentDAO ud = new CommentDAO();  // Remove from the database
            return ud.deleteComment1(u);  // Call the DAO to delete from the database
        } else {
            System.out.println("Comment with ID " + u + " not found.");
            return false;}
    }	
    //Get a comment by ID
    public void getCommentById() throws CommentNotFoundException {
        System.out.println("Enter comment ID to fetch:");
        Scanner sc = new Scanner(System.in);
        String commentId = sc.nextLine();
        CommentDAO commentDAO = new CommentDAO();
        Comment comment = commentDAO.getCommentById(commentId);
        
        if (comment != null) {
            System.out.println("Comment found: " + comment.getPostId() + " | " + comment.getUserId());
        } else {
            System.out.println("Comment not found.");
        }
    }
    // Update a comment
    public boolean updateComment() throws CommentNotFoundException, ClassNotFoundException {
    	try {
        System.out.println("Enter comment ID to update:");
        Scanner sc = new Scanner(System.in);
        String commentId = sc.nextLine();
        CommentDAO commentDAO = new CommentDAO();
        // Check if the comment exists first
        Comment existingComment = commentDAO.getCommentById(commentId);
        if (existingComment == null) {
            System.out.println("Comment not found.");
            return false;
        }
        System.out.println("Enter new postId:");
        String newPostId = sc.nextLine();
        System.out.println("Enter new userId:");
        String newUserId = sc.nextLine();
        System.out.println("Enter new content:");
        String newContent = sc.nextLine();
    	
    
    	// Create updated comment object
        Comment updatedComment = new Comment(commentId, newUserId, newPostId,newContent);
        validateCommentInput(updatedComment);

        // Call UserDAO to update the comment
        return commentDAO.updateComment(updatedComment);
    	}
     catch (CommentException.CommentNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
    }
        
       

            // Validate comment ID
            private void validateCommentId(String commentId) throws CommentException.CommentNotFoundException {
                if (commentId == null || commentId.trim().isEmpty()) {
                    throw new CommentException.CommentNotFoundException("Comment ID cannot be null or empty.");
                }
            }

            // Validate post ID
            private void validatePostId(String postId) throws CommentException.PostNotFoundException {
                if (postId == null || postId.trim().isEmpty()) {
                    throw new CommentException.PostNotFoundException("Post ID cannot be null or empty.");
                }
            }

            // Validate user ID
            private void validateUserId(String userId) throws CommentException.UserNotFoundException {
                if (userId == null || userId.trim().isEmpty()) {
                    throw new CommentException.UserNotFoundException("User ID cannot be null or empty.");
                }
            }

            // Validate comment input
            private void validateCommentInput(Comment comment) throws CommentException.CommentNotFoundException {
                if (comment.getContent() == null || comment.getContent().trim().isEmpty()) {
                    throw new CommentException.CommentNotFoundException("Content cannot be null or empty.");
                }
            }

            // Method to check if the comment exists for a specific post
            //public boolean commentExists(String commentId, String postId) throws ClassNotFoundException {
             //   return CommentDAO.commentExists(commentId, postId);
            //}

   

            // Method to get a comment by its ID
            public Comment getComment(String commentId) throws CommentNotFoundException {
                try {
                    validateCommentId(commentId);
                    return CommentDAO.getCommentById(commentId);
                } catch (CommentException.CommentNotFoundException e) {
                    System.out.println("Error: " + e.getMessage());
                    return null;
                }
            }
        }
