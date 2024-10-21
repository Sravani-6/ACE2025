package Message;
import java.util.*;

public class Main {

<<<<<<< HEAD
	public static void main(String[] args) {
				List<Message> al=new ArrayList<>();
				System.out.format("%-5s %-10s %-10s %s\n","MessageId","SenderId","ReceiverId","Content");
				MessageDAO dao=new MessageDAO();
				al=dao.getAllMessages();
				for(Message m:al){
					System.out.format("%-10s %-10s %-10s %s\n",m.getMessageId(),m.getSenderId(),m.getRecevierId(),m.getContent());
				}
			}
		}
=======
	public static void main(String[] args) throws MessageException {
				List<Message> al=new ArrayList<>();
				System.out.format("%-5s %-10s %-10s %s\n","MessageId","SenderId","RecieverId","Content");
				MessageDAO dao=new MessageDAO();
				al=dao.getAllMessages();
				for(Message m:al){
					System.out.format("%-10s %-10s %-10s %s\n",m.getMessageId(),m.getSenderId(),m.getRecieverId(),m.getContent());
				}
				Scanner sc = new Scanner(System.in);
		        MessageUtility Util = new MessageUtility();
		        System.out.println("Add a new user:"+Util.addMessage());
		        Util.displayUserList();
		        System.out.println("Enter Id to delete");
		        String userid = sc.nextLine();
		        System.out.println("Id to delete"+Util.deleteMessage(userid));
		        Util.displayUserList();
		        Util.getMessageById();
		        try {
		            boolean success = Util.updateMessage();
		            if (success) {
		                System.out.println("Message updated successfully.");
		            } else {
		                System.out.println("Message update failed.");
		            }
		        } catch (MessageException e) {
		            System.out.println("Error: " + e.getMessage());
		        }
		        Util.displayUserList();
			}
			}

>>>>>>> 65a822c6ec19055c2c9c5c63383b00503d887e7a
