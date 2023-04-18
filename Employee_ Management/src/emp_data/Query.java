package emp_data;

public class Query {
	
	static String create = "Insert into employee (id, name, email, salary) values ( ?,?,?,? )";
	static String read = "Select * from employee";
	static String update = "Update employee set name = ? where id = ? ";
	static String delete = " delete from employee where id = ?";
	static String readByGreaterSalary = "select * from employee where salary > ?"  ;
    static String readByLessSalary = "select * from employee where salary < ?";
    static String readByEqualSalary = "select * from employee where salary = ?";
}
 