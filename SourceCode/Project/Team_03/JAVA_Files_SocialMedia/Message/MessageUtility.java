package Message;
import java.util.*;
public class MessageUtility {
		private List<Message> userList = new ArrayList<Message>();
		public void displayUserList() {
			MessageDAO ud = new MessageDAO();
			userList = ud.getAllMessages();
			for(Message it:userList) {
				System.out.format("%-5s %-10s %-10s %-25s\n",it.getMessageId(),it.getSenderId(),it.getRecieverId(),it.getContent());
			}
		}
		// Add a new user
	    public boolean addMessage() {
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Enter the MessageID");
	    	String mesid = sc.nextLine();
	    	System.out.println("Enter the SenderId");
	    	String senid = sc.nextLine();
	    	System.out.println("Enter the RecieverId");
	    	String recid = sc.nextLine();
	    	System.out.println("Enter the content");
	    	String content = sc.nextLine();
	    	Message nu = new Message(mesid,senid,recid,content);
	    	userList.add(nu);
	    	MessageDAO uda = new MessageDAO();
	    	return uda.addUser(nu);
	    }
	    //delete a user
	    public boolean deleteMessage(String u) {
	    	Scanner sc = new Scanner(System.in);
	    	   // Find user in the local list and remove
	        Message mesToDelete = null;
	        for (Message user : userList) {
	            if (user.getMessageId().equals(u)) {
	                mesToDelete = user;
	                break;
	            }
	        }

	        if (mesToDelete != null) {
	            userList.remove(mesToDelete);  // Remove from local list
	            MessageDAO ud = new MessageDAO();  // Remove from the database
	            return ud.deleteUser(u);  // Call the DAO to delete from the database
	        } else {
	            System.out.println("User with ID " + u + " not found.");
	            return false;
	        }
	    }
	    	
	        public void getMessageById() throws MessageException {
		        System.out.println("Enter Message ID to fetch:");
		        Scanner sc = new Scanner(System.in);
		        String mesId = sc.nextLine();
		        MessageDAO userDAO = new MessageDAO();
		        Message msg = userDAO.getMessageById(mesId);
		        
		        if (msg != null) {
		            System.out.println("Ad found: " + msg.getSenderId() + " | " +msg.getSenderId()+" | "+ msg.getContent());
		        } else {
		            System.out.println("Ad not found.");
		        }
		    }
		    // Update a user
		    public boolean updateMessage() throws MessageException {
		    	try {
		        System.out.println("Enter Message ID to update:");
		        Scanner sc = new Scanner(System.in);
		        String MesId = sc.nextLine();
		        MessageDAO MD = new MessageDAO();
		        // Check if the user exists first
		        Message existingUser = MD.getMessageById(MesId);
		        if (existingUser == null) {
		            System.out.println("Message not found.");
		            return false;
		        }
		     
		        System.out.println("Enter new SenderID:");
		        String send = sc.nextLine();
		        System.out.println("Enter new RecieverID:");
		        String recieve = sc.nextLine();
		        System.out.println("Enter new Content:");
		        String content = sc.nextLine();
		        
		      
		   Message updatedMes = new Message(MesId, send, recieve,content);
		        return MD.updateUser(updatedMes);
		    	}
		     catch ( MessageException e) {
		        System.out.println("Error: " + e.getMessage());
		        return false;
		    }
		        
		    }
		    
	    }

