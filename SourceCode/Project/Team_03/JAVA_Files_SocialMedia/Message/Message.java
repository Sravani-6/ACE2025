package Message;

public class Message  {
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
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return content;
	}
}