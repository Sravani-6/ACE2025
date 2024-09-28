package Message;

import java.sql.*;

public class DbConnection {
	public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/social";
        String user = "root";
        String password = "mysql123";
        return DriverManager.getConnection(url,user,password);
	}
}
