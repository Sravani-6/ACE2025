package socialMedia.Grouppackage;
public class Group {
    private int groupId;             // Primary Key
    private String groupName;        // Name of the group
    private int groupMemberCount;    // Number of members in the group
    private String visibility;       // Visibility: public, private, etc.
    
    // Constructor to create a new Group (without groupId)
    public Group(String groupName, int groupMemberCount, String visibility) {
        this.groupName = groupName;
        this.groupMemberCount = groupMemberCount;
        this.visibility = visibility;
    }

    // Constructor to fetch existing Group (with groupId)
    public Group(int groupId, String groupName, int groupMemberCount, String visibility) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupMemberCount = groupMemberCount;
        this.visibility = visibility;
    }

    // Getters and Setters
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGroupMemberCount() {
        return groupMemberCount;
    }

    public void setGroupMemberCount(int groupMemberCount) {
        this.groupMemberCount = groupMemberCount;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Group [groupId=" + groupId + ", groupName=" + groupName + ", groupMemberCount=" + groupMemberCount
                + ", visibility=" + visibility + "]";
    }
}
