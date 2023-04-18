package emp_data;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.StatementWrapper;

public class EmployeeDAO {
	
	
	
	public static void createEmployee(Employee e) throws SQLException {
		
		Connection con = DB.connect();
		
		String query = Query.create;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, e.getId());
		preparedStatement.setString(2, e.getName());
		preparedStatement.setString(3, e.getEmail());
		preparedStatement.setInt(4, e.getSalary());
		
		System.out.println("\n ps= " + preparedStatement + "\n"+ e);
		
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
	public static ArrayList<Employee> readAllEmployee() throws SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection con = DB.connect();
		String query = Query.read;
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		System.out.println(statement);
		
		while(resultSet.next()){
			Employee emp = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
			empList.add(emp);
		}
		statement.close();
		return empList;
	}
	
	
	public static void udateEmployee(int id , String name) throws SQLException{
		
		Connection con = DB.connect();
		String query = Query.update;
		PreparedStatement preparedStatement =  con.prepareStatement(query);
		preparedStatement.setInt(2, id);
		preparedStatement.setString(1, name);
		System.out.println("\n ps= "+ preparedStatement + "\n" + "one row updated");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		
	}
	
	public static void deleteEmployee(int id) throws SQLException {
		
		Connection con = DB.connect();
		
		String query = Query.delete;
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);
		System.out.println("\n ps= "+ preparedStatement);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	}
	
public static ArrayList<Employee> readEmployeeByGreaterSalary(int sal) throws SQLException {
	ArrayList<Employee> empList = new ArrayList<>();
		Connection con = DB.connect();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		String query = Query.readByGreaterSalary;
		App app = new App();
		
		
		preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, sal);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			Employee emp1 = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
			empList.add(emp1);
		} 
		
		resultSet.close();
		preparedStatement.close();
		return empList;
		
	} 

	
public static ArrayList<Employee> readEmployeeBylessSalary(int sal) throws SQLException{
	ArrayList<Employee> empList = new ArrayList<>();
	 Connection con = DB.connect();
	 PreparedStatement preparedStatement;
	 ResultSet resultSet;
	 
	 String query = Query.readByLessSalary;
	 preparedStatement = con.prepareStatement(query);
	 preparedStatement.setInt(1, sal);
	 resultSet = preparedStatement.executeQuery();
	 
	 while(resultSet.next()){
		 Employee emp= new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
		 empList.add(emp);
		 }
	 
	 resultSet.close();
	 preparedStatement.close();
	return empList;
	
}

public static ArrayList<Employee> readEmployeeByEqualSalary(int sal) throws SQLException{
	ArrayList<Employee> empList = new ArrayList<>();
	 Connection con = DB.connect();
	 PreparedStatement preparedStatement;
	 ResultSet resultSet;
	 
	 String query = Query.readByEqualSalary;
	 preparedStatement = con.prepareStatement(query);
	 preparedStatement.setInt(1, sal);
	 resultSet = preparedStatement.executeQuery();
	 
	 while(resultSet.next()){
		 Employee emp= new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4));
		 empList.add(emp);
		 }
	 
	 resultSet.close();
	 preparedStatement.close();
	return empList;
	
}
	
	

		
}

