package Message;
import java.util.*;

public class Main {

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
