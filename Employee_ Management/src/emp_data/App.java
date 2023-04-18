package emp_data;

import java.util.ArrayList;
import java.util.Scanner;
  
public class App {
	
	public static void main(String[] args) throws Exception {
		
		while(true){
		System.out.println("Employee Management");
		System.out.println("1- Create new data \n2- Read all the data \n3- Update the data \n4- Delete the existing data \n5- Fitler data by salary");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		if(choice <1 || choice >=6) break;
		
		switch (choice) {
		
		case 1: System.out.println("id, name, email, salary");
		int id = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		String email = sc.nextLine();
		int salary = sc.nextInt();
		Employee emp = new Employee(id, name, email, salary);
		EmployeeDAO.createEmployee(emp);
			break;

		case 2: ArrayList<Employee> list = EmployeeDAO.readAllEmployee();
		for (Employee employee : list) {
			System.out.println(employee);
		}
			break;
			
			
		case 3:System.out.println("id and name");
		 id = sc.nextInt();
		 sc.nextLine();
		 name = sc.nextLine();
		 
		 EmployeeDAO.udateEmployee(id, name);
		break;
			
			
		case 4: 
			System.out.println("id");
			id = sc.nextInt();
			EmployeeDAO.deleteEmployee(id);
			break;
			
		case 5: 
			System.out.println("how do you want to filtre salary \nchoose \n1- For greater than,  2- For less than, and 3- For equal to");
			int num = sc.nextInt();
			ArrayList<Employee> list1 = new ArrayList<>();
			
			if(num == 1){
				System.out.println("salary");
				salary = sc.nextInt();
				list1 = EmployeeDAO.readEmployeeByGreaterSalary(salary);
			}
			
			if(num == 2){
				System.out.println("salary");
				salary = sc.nextInt();
				list1 = EmployeeDAO.readEmployeeBylessSalary(salary);
			}
			
			if(num == 3){
				System.out.println("salary");
				salary = sc.nextInt();
				list1 = EmployeeDAO.readEmployeeByEqualSalary(salary);
			}
			
			
			for (Employee employee : list1) {
				System.out.println(employee);
			}
			break;
		
		}
	}

	}
}
