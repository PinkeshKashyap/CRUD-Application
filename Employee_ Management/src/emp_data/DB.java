package emp_data;
import java.sql.*;
// mysql 5 ke baad se driver load krne ki jaruarat nhi padti h

public class DB {
	static Connection con = null;
	
	public static Connection connect(){
		
			
//		String url = "jdbc:mysql://localhost:3306:/employee";
//		String dbname = "root";
//		String pass = "pinkesh";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=pinkesh");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 return con;
	}

}
