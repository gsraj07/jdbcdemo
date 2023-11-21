package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDemo {
	
public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement pstmt;
		ResultSet rs;
		Scanner scan;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","redhat");
			
			// create a preparedstatement Object
			pstmt=con.prepareStatement("SELECT customerNumber,customerName,city,country FROM customers"
					+ " where country=?");
			
			scan=new Scanner(System.in);
			System.out.println("Enter Country name of Customers to be displayed :");
			String country=scan.next();
			
			//assign value for to i/p parameter of ps
			pstmt.setString(1, country);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			
			System.out.println("*****************************************");
			
			scan=new Scanner(System.in);
			System.out.println("Enter Country name of Customers to be displayed :");
			String country1=scan.next();
			
			//reuse ps
			pstmt.setString(1, country1);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
}

}
