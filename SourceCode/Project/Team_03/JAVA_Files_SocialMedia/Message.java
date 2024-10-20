package sample;
import java.util.*;
import java.sql.*;
public class Message {
	private Int messageId;
	private Int senderId;
	private Int recevierId;
	private String content;
	
public Message(Int messageId,Int senderId,Int recevierId,String content) {
	this.messageId = messageId;
	this.senderId = senderId;
	this.recevierId = recevierId;
	this.content = content;
}
public Int getMessageId() {
	return messageId;
}
public Int getSenderId() {
	return senderId;
}
public Int getRecevierId() {
	return recevierId;
}
public String getContent() {
	return content;
}
public void setMessageId(Int messageId) {
	this.messageId = messageId;
}
public void setSenderId(Int senderId) {
	this.senderId = senderId;
}
public void setRecevierId(Int recevierId) {
	this.recevierId = recevierId;
}
public void setContent(String content) {
	this.content = content;
}
public void display() {
	System.out.println("Message details");
	System.out.println("Message ID: "+messageId);
	System.out.println("Sender Id: "+senderId);
	System.out.println("Recevier Id: "+recevierId);
	System.out.println("Content: "+content);
	
}
public class MessageDAO{
	public List<Message>getAllMessages(){
		List<Message> mes=new ArrayList<>();
		try {
			connection con=Dbconnection.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from item_type");
			while(rs.next()) {
				int messageId=rs.getInt("messageId");
				int senderId=rs.getInt("senderId");
				int recevierId=rs.getInt("recevierId");
				int content=rs.getInt("content");
			}
		}
	}
}
}
