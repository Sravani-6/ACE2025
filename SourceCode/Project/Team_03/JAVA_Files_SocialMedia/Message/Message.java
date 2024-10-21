package Message;

public class Message  {
<<<<<<< HEAD
		private int messageId;
		private int senderId;
		private int receiverId;
		private String content;
		
	public Message(int messageId,int senderId,int receiverId,String content) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.content = content;
	}
	public int getMessageId() {
		return messageId;
	}
	public int getSenderId() {
		return senderId;
	}
	public int getRecevierId() {
		return receiverId;
=======
		private String messageId;
		private String senderId;
		private String recieverId;
		private String content;
		
	public Message(String messageId,String senderId,String recieverId,String content) {
		this.messageId = messageId;
		this.senderId = senderId;
		this.recieverId = recieverId;
		this.content = content;
	}
	public String getMessageId() {
		return messageId;
	}
	public String getSenderId() {
		return senderId;
	}
	public String getRecieverId() {
		return recieverId;
>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
}