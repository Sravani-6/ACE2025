package friend;

import java.util.ArrayList;
import java.util.List;

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

}
