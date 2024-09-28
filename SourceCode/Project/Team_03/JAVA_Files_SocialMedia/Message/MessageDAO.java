package Message;

import java.sql.*;
import java.util.*;
public class MessageDAO {
	public List<Message>getAllMessages(){
		List<Message> mes=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from message");
			while(rs.next()) {
			int messageId=rs.getInt("messageId");
				int senderId=rs.getInt("senderId");
				int receiverId=rs.getInt("receiverId");
				String content=rs.getString("content");
				Message msg=new Message(messageId,senderId,receiverId,content);
				mes.add(msg);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mes;
}
}
