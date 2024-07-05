package HelperClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDetails {
	public static String url = "jdbc:mysql://localhost:3306/ecommerce";
    public static String user = "root";
    public static String password = "Password#123";
    public static String driver = "com.mysql.cj.jdbc.Driver";
    
    public static Connection getConnection() {
    	Connection conn =  null;
    	try {
			Class.forName(DatabaseDetails.driver);
			conn = DriverManager.getConnection(DatabaseDetails.url,DatabaseDetails.user,DatabaseDetails.password);
		}
		catch(Exception e) {
			System.out.println(e);
		}
    	return conn;
    }
}
