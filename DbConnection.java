/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examineePackage;


/**
 *
 * @author Shivraj
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection 
{ 
	
    public static void main(String[] args){
        connection();
	   
    }
     
	public static void connection()
	{
		 Connection con = null;
		try {
                    Class.forName("com.mysql.jdbc.Driver");
                              	
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Examinationdb",
		"root", "");
		if (!con.isClosed())
		System.out.println("Successfully connected to MySQL server...");
		} catch(Exception e) {
		System.err.println("Exception: " + e.getMessage());
		} finally {
		try {
		if (con != null)
		con.close();
		} catch(SQLException e) {}
}

	  
        }
}

