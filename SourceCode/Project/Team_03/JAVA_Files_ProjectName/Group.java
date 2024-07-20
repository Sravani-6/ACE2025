package SocialMedia;

public class Group {
	private Int groupId;
	private String groupName;
	private Int gpMemberCount;
	
public Group(Int groupId,String groupName,Int gpMemberCount) {
	this.groupId = groupId;
	this.groupName = groupName;
	this.gpMemberCount = gpMemberCount;
}
public Int getGroupId() {
	return groupId;
}
public String getGroupName() {
	return groupName;
}
public Int getGpMemberCount() {
	return gpMemberCount;
}
public void setGroupId(Int groupId) {
	this.groupId = groupId;
}
public void setGroupName(String groupName) {
	this.groupName = groupName;
}
public void setGpMemberCount(Int gpMemberCount) {
	this.gpMemberCount = gpMemberCount;
}
public void display() {
	System.out.println("Group Details");
	System.out.println("Group Id: "+groupId);
	System.out.println("Group Name: "+groupName);
	System.out.println("Group Member Count: "+gpMemberCount);
}
}
