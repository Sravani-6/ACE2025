package socialMedia.Grouppackage;
import config.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GroupDAO {
	    private Connection conn;

	    // Constructor to initialize the database connection
	    public  GroupDAO(Connection conn) {
	        this.conn = conn;
	    }

	    // Add a new group
	    public boolean addGroup(Group group) throws SQLException, GroupException.InvalidVisibilityException {
	        // Check for valid visibility
	        if (!group.getVisibility().equals("public") && !group.getVisibility().equals("private")) {
	            throw new GroupException.InvalidVisibilityException("Invalid visibility option: " + group.getVisibility());
	        }

	        String query = "INSERT INTO group_s (groupName, groupMemberCount, visibility) VALUES (?, ?, ?)";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, group.getGroupName());
	            pstmt.setInt(2, group.getGroupMemberCount());
	            pstmt.setString(3, group.getVisibility());

	            int affectedRows = pstmt.executeUpdate();
	            return affectedRows > 0;
	        }
	    }

	    // Retrieve a group by its ID
	    public Group getGroupById(int groupId) throws SQLException, GroupException.GroupNotFoundException {
	        String query = "SELECT * FROM group_s WHERE group_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, groupId);

	            ResultSet rs = pstmt.executeQuery();
	            if (rs.next()) {
	                return new Group(
	                    rs.getInt("group_id"),
	                    rs.getString("groupName"),
	                    rs.getInt("groupMemberCount"),
	                    rs.getString("visibility")
	                );
	            } else {
	                throw new GroupException.GroupNotFoundException("Group with ID " + groupId + " not found.");
	            }
	        }
	    }

	    // Update a group
	    public boolean updateGroup(Group group) throws SQLException, GroupException.GroupNotFoundException, GroupException.InvalidVisibilityException {
	        // Check for valid visibility
	        if (!group.getVisibility().equals("public") && !group.getVisibility().equals("private")) {
	            throw new GroupException.InvalidVisibilityException("Invalid visibility option: " + group.getVisibility());
	        }

	        String query = "UPDATE group_s SET groupName = ?, groupMemberCount = ?, visibility = ? WHERE group_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setString(1, group.getGroupName());
	            pstmt.setInt(2, group.getGroupMemberCount());
	            pstmt.setString(3, group.getVisibility());
	            pstmt.setInt(4, group.getGroupId());

	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new GroupException.GroupNotFoundException("Group with ID " + group.getGroupId() + " not found.");
	            }
	            return true;
	        }
	    }

	    // Delete a group by its ID
	    public boolean deleteGroup(int groupId) throws SQLException, GroupException.GroupNotFoundException {
	        String query = "DELETE FROM group_s WHERE group_id = ?";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.setInt(1, groupId);
	            int affectedRows = pstmt.executeUpdate();
	            if (affectedRows == 0) {
	                throw new GroupException.GroupNotFoundException("Group with ID " + groupId + " not found.");
	            }
	            return true;
	        }
	    }

	    // Retrieve all groups
	    public List<Group> getAllGroups() throws SQLException {
	        List<Group> groupList = new ArrayList<>();
	        String query = "SELECT * FROM group_s";
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            ResultSet rs = pstmt.executeQuery();
	            while (rs.next()) {
	                Group group = new Group(
	                    rs.getInt("group_id"),
	                    rs.getString("groupName"),
	                    rs.getInt("groupMemberCount"),
	                    rs.getString("visibility")
	                );
	                groupList.add(group);
	            }
	        }
	        return groupList;
	    }
	

}
