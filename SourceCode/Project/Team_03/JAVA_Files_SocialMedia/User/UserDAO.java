package User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class UserDAO{
	public List<User>getAllUsers(){
		List<User> u=new ArrayList<>();
		try {
			Connection con=DbConnection.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from user");
			while(rs.next())
			{
				int userId=rs.getInt("userId");
				String username=rs.getString("username");
				String emailID=rs.getString("emailID");
				String passwd=rs.getString("passwd");
				User us=new User(userId,username,emailID,passwd);
				u.add(us);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}