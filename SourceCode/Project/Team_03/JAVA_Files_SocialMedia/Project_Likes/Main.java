package Likes;
import java.util.*;

import Likes.LikeException.LikeNotFoundException;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException {
		List<Like> al=new ArrayList<>();
		System.out.format("%-5s %-5s %s\n","likeId","postId","userId");
		//LikeDAO dao=new LikeDAO();
		//al=dao.getAllLikes();
		//for(Like it:al) {
			//System.out.format("%-5s %-5s %s\n",it.getLikeId(),it.getPostId(),it.getUserId());
		//}
		Scanner sc = new Scanner(System.in);
		LikeUtility likeUtil = new LikeUtility();
        likeUtil.displayLikeList();
        System.out.println("Add a new like:"+likeUtil.addLike());
        likeUtil.displayLikeList();
        System.out.println("Enter likeId to delete");
        String likeId = sc.nextLine();
        System.out.println("LikeId to delete"+likeUtil.deleteLikes(likeId));
        likeUtil.displayLikeList();
        likeUtil.getLikeById();
        //update the like details
        //likeUtil.updateLike();
        try {
            boolean success = likeUtil.updateLike();
            if (success) {
                System.out.println("Like updated successfully.");
            } else {
                System.out.println("Like update failed.");
            }
        } catch (LikeException.LikeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        likeUtil.displayLikeList();
	}
}
