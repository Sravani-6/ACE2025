package Message;

import java.sql.*;
import java.util.*;
<<<<<<< HEAD
=======

import Message.MessageException.*;

>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
public class MessageDAO {
	public List<Message>getAllMessages(){
		List<Message> mes=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from message");
			while(rs.next()) {
<<<<<<< HEAD
			int messageId=rs.getInt("messageId");
				int senderId=rs.getInt("senderId");
				int receiverId=rs.getInt("receiverId");
				String content=rs.getString("content");
				Message msg=new Message(messageId,senderId,receiverId,content);
=======
			String messageId=rs.getString("messageId");
				String senderId=rs.getString("senderId");
				String recieverId=rs.getString("recieverId");
				String content=rs.getString("content");
				Message msg=new Message(messageId,senderId,recieverId,content);
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
				mes.add(msg);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mes;
}
<<<<<<< HEAD
=======
	public boolean addUser(Message u) {
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into message(messageId,senderId,recieverId,content) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getMessageId());
			ps.setString(2,u.getSenderId());
			ps.setString(3,u.getRecieverId());
			ps.setString(4,u.getContent());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	public boolean deleteUser(String u) {
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from message where messageId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u);
			return ps.executeUpdate()>0;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Unable to delete");
			return false;
		}
	}
		// Method to get a user by ID
	    public Message getMessageById(String messageId) {
	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("select * from Message where MessageId = ?")) {
	            
	            pstmt.setString(1, messageId);
	            ResultSet rs = pstmt.executeQuery();
	            
	            //if (rs.next()) {
	              //  return new User(
	                //    rs.getString("userid"),
	                  //  rs.getString("username"),
	                    //rs.getString("email"),
	                    //rs.getString("password")
	                //);
	            if (rs.next()) {
	                // Create and return a User object if found
	                return new Message(rs.getString("MessageId"), rs.getString("SenderId"), rs.getString("RecieverId"), rs.getString("Content"));
	            } else {
	                throw new  MessageNotFoundException("Ad with ID " + messageId + " not found.");
	            }
	            }
	         catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}
	    public boolean updateUser(Message user) throws MessageNotFoundException{
	    	// Check if the user exists before updating
	        if (!MessageExists(user.getMessageId())) {
	            throw new MessageNotFoundException("Ad with ID " + user.getMessageId() + " not found.");
	        }
	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("Update Message SET SenderId= ?,RecieverId= ?,Content= ?  WHERE MessageId = ?;")) {
	            
	        	pstmt.setString(4, user.getMessageId());
	            pstmt.setString(1, user.getSenderId());
	            pstmt.setString(2, user.getRecieverId());
	            pstmt.setString(3, user.getContent());
	         // Print values for debugging
	            System.out.println("Updating message with ID: " + user.getMessageId());
	            System.out.println("New SenderId: " + user.getSenderId());
	            System.out.println("New RecieverId: " + user.getRecieverId());
	            System.out.println("New Content : " + user.getContent());
	            int rowsAffected = pstmt.executeUpdate();
	            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
	            return rowsAffected > 0;  // Return true if the update was successful
	        } catch (SQLException e) {
	        	 System.out.println("SQL Exception occurred: " + e.getMessage());
	            e.printStackTrace();
	            return false;
	        }
	}
		private boolean MessageExists(String messageId) {
			// TODO Auto-generated method stub
			String query = "SELECT COUNT(*) FROM Message WHERE messageId = ?";

	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setString(1, messageId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                return rs.getInt(1) > 0;  // Return true if the user exists
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			return false;
		}
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
}
