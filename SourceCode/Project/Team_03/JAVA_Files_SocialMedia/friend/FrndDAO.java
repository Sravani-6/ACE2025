package friend;

import java.sql.*;
import java.util.*;

public class FrndDAO {
	public List<Frnd>getAllFrnds(){
		List<Frnd> mes=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from friend");
			while(rs.next()) {
			int friendId=rs.getInt("friendId");
			int userId1=rs.getInt("userId1");
			String status=rs.getString("status");
			int userId2=rs.getInt("userId2");
			Frnd msg=new Frnd(friendId,userId1,status,userId2);
			mes.add(msg);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mes;
}
}
