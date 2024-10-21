package coment;
import java.util.*;
import coment.CommentException.CommentNotFoundException;
public class Main {
	public static void main(String[] args) throws CommentNotFoundException, ClassNotFoundException {
		List<Comment> al=new ArrayList<>();
		System.out.format("%-5s %-15s %-10s %s\n","commentID","postId","userID","content");
		//CommentDAO dao=new CommentDAO();
		//al=dao.getAllComment();
		//for(Comment it:al) {
			//System.out.format("%-10s %-15s %-10s %s\n",it.getCommentId(),it.getPostId(),it.getUserId(),it.getContent());
		//}
	Scanner sc = new Scanner(System.in);
    CommentUtility commentUtil = new CommentUtility();
    commentUtil.displayCommentList();
    System.out.println("Add a new comment:"+commentUtil.addComment());
    commentUtil.displayCommentList();
    System.out.println("Enter commentId to delete");
    String commentid = sc.nextLine();
    System.out.println("CommentId to delete"+commentUtil.deleteComment(commentid));
    commentUtil.displayCommentList();
    commentUtil.getCommentById();
    //update the user details
    //userUtil.updateUser();
    try {
        boolean success = commentUtil.updateComment();
        if (success) {
            System.out.println("Comment updated successfully.");
        } else {
            System.out.println("Comment update failed.");
        }
    } catch (CommentException.CommentNotFoundException e) {
        System.out.println("Error: " + e.getMessage());
    }
    commentUtil.displayCommentList();
}
}
