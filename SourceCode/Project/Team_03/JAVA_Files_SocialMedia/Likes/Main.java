package Likes;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		List<Like> al=new ArrayList<>();
		System.out.format("%-5s %-5s %s\n","likeId","postId","userId");
		LikeDAO dao=new LikeDAO();
		al=dao.getAllLikes();
		for(Like it:al) {
			System.out.format("%-5s %-5s %s\n",it.getLikeId(),it.getPostId(),it.getUserId());
		}
	}
}
