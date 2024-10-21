package socialMedia.Grouppackage;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class GroupUtility {
	    private GroupDAO groupDAO;
	    private Scanner sc;

	    // Constructor to initialize GroupUtility with GroupTypeDAO
	    public GroupUtility(Connection conn) {
	        this.groupDAO = new GroupDAO(conn);
	        this.sc = new Scanner(System.in);
	    }

	    // Create a new group
	    public void createGroup() {
	        try {
	            System.out.println("Enter Group Name:");
	            String groupName = sc.nextLine();

	            System.out.println("Enter Number of Members:");
	            int groupMemberCount = sc.nextInt();
	            sc.nextLine();  // Consume the newline

	            System.out.println("Enter Visibility (public/private):");
	            String visibility = sc.nextLine();

	            Group newGroup = new Group(groupName, groupMemberCount, visibility);
	            if (groupDAO.addGroup(newGroup)) {
	                System.out.println("Group created successfully.");
	            } else {
	                System.out.println("Failed to create group.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (GroupException.InvalidVisibilityException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Display a group by ID
	    public void displayGroupById() {
	        try {
	            System.out.println("Enter Group ID to retrieve:");
	            int groupId = sc.nextInt();
	            sc.nextLine();  // Consume the newline

	            Group group = groupDAO.getGroupById(groupId);
	            System.out.println(group);

	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (GroupException.GroupNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Display all groups
	    public void displayAllGroups() {
	        try {
	            List<Group> groupList = groupDAO.getAllGroups();
	            for (Group group : groupList) {
	                System.out.println(group);
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        }
	    }

	    // Update a group
	    public void updateGroup() {
	        try {
	            System.out.println("Enter Group ID to update:");
	            int groupId = sc.nextInt();
	            sc.nextLine();  // Consume newline

	            Group group = groupDAO.getGroupById(groupId);
	            if (group != null) {
	                System.out.println("Enter new Group Name:");
	                String newGroupName = sc.nextLine();

	                System.out.println("Enter new Number of Members:");
	                int newMemberCount = sc.nextInt();
	                sc.nextLine();  // Consume newline

	                System.out.println("Enter new Visibility (public/private):");
	                String newVisibility = sc.nextLine();

	                group.setGroupName(newGroupName);
	                group.setGroupMemberCount(newMemberCount);
	                group.setVisibility(newVisibility);

	                if (groupDAO.updateGroup(group)) {
	                    System.out.println("Group updated successfully.");
	                } else {
	                    System.out.println("Failed to update group.");
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (GroupException.InvalidVisibilityException | GroupException.GroupNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    // Delete a group
	    public void deleteGroup() {
	        try {
	            System.out.println("Enter Group ID to delete:");
	            int groupId = sc.nextInt();

	            if (groupDAO.deleteGroup(groupId)) {
	                System.out.println("Group deleted successfully.");
	            } else {
	                System.out.println("Failed to delete group.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Database error: " + e.getMessage());
	        } catch (GroupException.GroupNotFoundException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
	

}
