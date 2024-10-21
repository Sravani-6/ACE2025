package friend;

import java.sql.*;
import java.util.*;

<<<<<<< HEAD
=======
import friend.FrndException.*;


>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
public class FrndDAO {
	public List<Frnd>getAllFrnds(){
		List<Frnd> mes=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from friend");
			while(rs.next()) {
<<<<<<< HEAD
			int friendId=rs.getInt("friendId");
			int userId1=rs.getInt("userId1");
			String status=rs.getString("status");
			int userId2=rs.getInt("userId2");
			Frnd msg=new Frnd(friendId,userId1,status,userId2);
=======
			String friendId=rs.getString("friendId");
			String userId1=rs.getString("userId1");
			String userId2=rs.getString("userId2");
			String status=rs.getString("status");
			Frnd msg=new Frnd(friendId,userId1,userId2,status);
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
}
=======
	public boolean addUser(Frnd u) throws FrndAlreadyExistsException {
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into Friend(FriendId,userId1,userId2,status) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getFriendId());
			ps.setString(2,u.getUserId1());
			ps.setString(3,u.getUserId2());
			ps.setString(4,u.getStatus());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	public boolean deleteUser(String u){
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from Friend where FriendId = ?";
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
	public Frnd getUserById(String friendId)  {
		try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("select * from friend where friendId = ?")) {
	            
	            pstmt.setString(1, friendId);
	            ResultSet rs = pstmt.executeQuery();
	            
	       
	            if (rs.next()) {
	                // Create and return a User object if found
	                return new Frnd(rs.getString("friendId"), rs.getString("userId1"), rs.getString("userId2"),rs.getString("status"));
	            } else {
	                throw new EntityNotFoundException("Ad with ID " + friendId + " not found.");
	            }
	            }
	         catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
		
	}
	public boolean updateUser(Frnd user) throws EntityNotFoundException {
		 if (!FrndExists(user.getFriendId())) {
	            throw new EntityNotFoundException("Ad with ID " + user.getFriendId() + " not found.");
	        }
	        try (Connection conn = DbConnection.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement("Update friend SET userId1 = ?, userId2 = ?, status = ? WHERE friendId = ?;")) {
	            
	        	pstmt.setString(4, user.getFriendId());
	            pstmt.setString(1, user.getUserId1());
	            pstmt.setString(2, user.getUserId2());
	            pstmt.setString(3, user.getStatus());
	         // Print values for debugging
	            System.out.println("Updating friend with ID: " + user.getFriendId());
	            System.out.println("New UserId1: " + user.getUserId1());
	            System.out.println("New UserId2: " + user.getUserId2());
	            
	            System.out.println("New Status: " + user.getStatus());
	            int rowsAffected = pstmt.executeUpdate();
	            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
	            return rowsAffected > 0;  // Return true if the update was successful
	        } catch (SQLException e) {
	        	 System.out.println("SQL Exception occurred: " + e.getMessage());
	            e.printStackTrace();
	            return false;
	        }
	    }
	private boolean FrndExists(String friendId) {
		String query = "SELECT COUNT(*) FROM Friend WHERE friendId = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, friendId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;  // Return true if the user exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

		return false;
	}
}
	
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
