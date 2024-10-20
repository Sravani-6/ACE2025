package socialMedia.User;
import config.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UserDAO{
	public List<User>getAllUsers(){
		List<User> u=new ArrayList<>();
		//method to get all users
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				String userId=rs.getString("userid");
				String username=rs.getString("username");
				String emailID=rs.getString("email");
				String passwd=rs.getString("password");
				User us=new User(userId,username,emailID,passwd);
				u.add(us);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	//method to insert a new user
	public boolean addUser(User u)throws UserException.DuplicateUserException {
		if (userExists(u.getUserId())) {
            throw new UserException.DuplicateUserException("User with ID " + u.getUserId() + " already exists.");
        }
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into user(userid,username,email,password) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getUserId());
			ps.setString(2,u.getUsername());
			ps.setString(3,u.getEmailID());
			ps.setString(4,u.getPasswd());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	//method to delete a user
	public boolean deleteUser(String u)throws UserException.UserNotFoundException {
		// Check if the user exists before deleting
        if (!userExists(u)) {
            throw new UserException.UserNotFoundException("User with ID " + u + " not found.");
        }
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from user where userid = ?";
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
    public User getUserById(String userId)throws UserException.UserNotFoundException {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from user where userid = ?")) {
            
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Create and return a User object if found
                return new User(rs.getString("userId"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
            } else {
                throw new UserException.UserNotFoundException("User with ID " + userId + " not found.");
            }
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
 // Method to update a user
    public boolean updateUser(User user) throws UserException.UserNotFoundException{
    	// Check if the user exists before updating
        if (!userExists(user.getUserId())) {
            throw new UserException.UserNotFoundException("User with ID " + user.getUserId() + " not found.");
        }
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("Update user SET username = ?, password = ?, email = ? WHERE userId = ?;")) {
            
        	pstmt.setString(4, user.getUserId());
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmailID());
            pstmt.setString(3, user.getPasswd());
         // Print values for debugging
            System.out.println("Updating user with ID: " + user.getUserId());
            System.out.println("New Username: " + user.getUsername());
            System.out.println("New Password: " + user.getPasswd());
            System.out.println("New Email: " + user.getEmailID());
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
            return rowsAffected > 0;  // Return true if the update was successful
        } catch (SQLException e) {
        	 System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    private boolean userExists(String userId) {
        String query = "SELECT COUNT(*) FROM user WHERE userId = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;  // Return true if the user exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Return false if the user does not exist
    }

	
}