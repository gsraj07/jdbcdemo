package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectDemo1 {

	public static void main(String[] args) {
		Connection con=null;
		Statement stmt;
		ResultSet rs;
		
		try {
			
			con=ConnectionUtil.createConnection();
			
			stmt=con.createStatement();
			
			rs=stmt.executeQuery("SELECT first_name,last_name,email from candidates");
			
			while(rs.next())
			{
				System.out.print(rs.getString(1)+"\t"+rs.getString("last_name")+"\t"+
			rs.getString("email"));
			}
			con.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		

	}

}
