package jdbcdemo;

import java.sql.*;

public class MySQLConnectionDemo {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		ResultSet rs;
		
		try {
			// Load & register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Create a connection getConnection() of DM class - 
			// Create a Session between Java & Mysql
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","redhat");
			
			// create statement Object
			stmt=con.createStatement();
			
			//execute a Query & store in Resultset
			rs=stmt.executeQuery("select * from employees");
			
			//Traverse Resultset
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ " "+rs.getString(3)+" "+rs.getString("email")+" "
			+rs.getString(8));
			}
			
			
			
		con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
			
	}

}
