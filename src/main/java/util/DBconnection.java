package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	
	private static final String url="jdbc:mysql://localhost:3306/id";
	private static final String username="root";
	private static final String password="";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			System.out.println(e.getMessage() + " : From Database Connection class ");
			return null;
		}
	}  

}
 