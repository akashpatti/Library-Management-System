import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.io.*;
public class DB_Connection {
	static Connection conn = null;
	
	
	public int Connection1(String query){
			String url = "jdbc:mysql://localhost:3306/library"; 
			String user = "root";
			String password = "1234";
			
			try {
				conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				int affectedrows = stmt.executeUpdate(query);
				
				return affectedrows;
				} 
			 
			catch(SQLException ex) {
				System.out.println("Error in connection: " + ex.getMessage());
				return 0;
			}
	}
	public ResultSet Connection(String query) {
		
		
		String url = "jdbc:mysql://localhost:3306/library"; // direct connect to database in url
	
		String user = "root";
		String password = "1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		        return rs;
			} 

		catch(SQLException ex) {
			System.out.println("Error in connection: " + ex.getMessage());
			return null;
		}
	}
		
}