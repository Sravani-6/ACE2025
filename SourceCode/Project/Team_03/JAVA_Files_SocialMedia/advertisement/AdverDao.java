package advertisement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import advertisement.AdException.DuplicateAdException;

public class AdverDao {
	public List<Advertisement>getAllAdvertisements(){
		List<Advertisement> mes=new ArrayList<>();
	try {
		Connection con=DbConnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from advertisement");
			while(rs.next()) {
			String adId=rs.getString("AdId");
			String adTitle=rs.getString("adTitle");
			String adContent=rs.getString("adContent");
			Advertisement msg=new Advertisement(adId,adTitle,adContent);
			mes.add(msg);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return mes;
}
	public boolean addAd(Advertisement u) throws AdException.DuplicateAdException{
		try {
			Connection con = DbConnection.getConnection();
			String query = "Insert into Advertisement(adId,adTitle,adContent) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,u.getAdId());
			ps.setString(2,u.getAdTitle());
			ps.setString(3,u.getAdContent());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Invalid");
			return false;
		}
	}
	private boolean AdExists(String adId) {
		String query = "SELECT COUNT(*) FROM Advertisement WHERE AdId = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, adId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;  // Return true if the user exists
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;  // Return false if the user does not exist
	}
	//delete  ad
	public boolean deleteAd(String u) throws AdException.AdNotFoundException {
		try {
			Connection con = DbConnection.getConnection();
			String query = "delete from Advertisement where adId = ?";
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
    public Advertisement getUserById(String AdId)throws AdException.AdNotFoundException {
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("select * from advertisement where AdId = ?")) {
            
            pstmt.setString(1, AdId);
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
                return new Advertisement(rs.getString("AdId"), rs.getString("AdTitle"), rs.getString("AdContent"));
            } else {
                throw new AdException.AdNotFoundException("Ad with ID " + AdId + " not found.");
            }
            }
         catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	
}
    public boolean updateUser(Advertisement user) throws AdException.AdNotFoundException{
    	// Check if the user exists before updating
        if (!AdExists(user.getAdId())) {
            throw new AdException.AdNotFoundException("Ad with ID " + user.getAdId() + " not found.");
        }
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("Update Advertisement SET AdTitle = ?, AdContent= ? WHERE AdId = ?;")) {
            
        	pstmt.setString(3, user.getAdId());
            pstmt.setString(1, user.getAdTitle());
            pstmt.setString(2, user.getAdContent());
         // Print values for debugging
            System.out.println("Updating ad with ID: " + user.getAdId());
            System.out.println("New AdTitle: " + user.getAdTitle());
            System.out.println("New AdContent: " + user.getAdContent());
            
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);  // Debugging output
            return rowsAffected > 0;  // Return true if the update was successful
        } catch (SQLException e) {
        	 System.out.println("SQL Exception occurred: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}