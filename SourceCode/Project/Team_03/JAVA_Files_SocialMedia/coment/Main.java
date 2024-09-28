package coment;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		List<Comment> al=new ArrayList<>();
		System.out.format("%-5s %-15s %-10s %s\n","commentID","postId","userID","content");
		CommentDAO dao=new CommentDAO();
		al=dao.getAllComment();
		for(Comment it:al) {
			System.out.format("%-10s %-15s %-10s %s\n",it.getCommentId(),it.getPostId(),it.getUserId(),it.getContent());
		}
	}
}
