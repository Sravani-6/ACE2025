package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/chinki";
        String user = "root";
        String password = "myroot";
        return DriverManager.getConnection(url,user,password);
	}
}
