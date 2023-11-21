package jdbcdemo;

import java.sql.*;

// Employee class implement CRUD operations
public class Employee {
	
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet res;
	
	public Connection getConnection()
	{
	
		return con;
	}
	
	public void insertEmployee(String name, String city, String contact) 
	{
		System.out.println("**************** Insert new Employees*****************");
		
	}
	
	public void getEmployee() 
	{
	 System.out.println("**************** Display Employees*****************");
	}
	
	public void updateEmployee(int id,String city) 
	{
		System.out.println("**************** Update Employees*****************");
	}
	
	public void deleteEmployee(int cid) 
	{
		System.out.println("**************** Delete Employees*****************");
	}

}
