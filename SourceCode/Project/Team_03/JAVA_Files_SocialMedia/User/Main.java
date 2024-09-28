package User;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		List<User> al=new ArrayList<>();
		System.out.format("%-5s %-15s %-10s %-20s\n","userID","username","emailID","passwd");
		UserDAO dao=new UserDAO();
		al=dao.getAllUsers();
		for(User it:al) {
			System.out.format("%-5s %-10s %-10s %-25s\n",it.getUserId(),it.getUsername(),it.getEmailID(),it.getPasswd());
		}
	}
}
