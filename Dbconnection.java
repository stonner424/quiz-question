package Examinepackage;

import java.sql.connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	public static void main(string[]args) {
		connection();
	}
public static void main(String[]args) {
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jbdc:mysql://localhost:3306/Examination","root", "");
		if(!con.isClosed())
			System.out.println("successfully connected to MYSQL server...");
	}} catch (Exception e) {
		System.err.println("Exception:"+ e.getMessage());
	}} finally {
		try {
			if(con !=null)
				con.close();
		}catch (SQLException SQLException) {}
	}
	
	
	}
}
}
