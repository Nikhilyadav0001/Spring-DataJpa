package nikhil.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IEmployeeRepository;
import nikhil.entity.Employee;

@Component
public class EmployeeRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {

		repo.saveAll(Arrays.asList(new Employee(101, "AA", 200.0, "DEV"),
				new Employee(102, "BA", 500.0, "DEV"),
				new Employee(103, "AC", 200.0, "QA"),
				new Employee(104, "DD", 400.0, "QA"),
				new Employee(105, "EF", 600.0, "DEV")));
		
		repo.fetchAllEmployeesWithSalGreater(300.0).forEach(System.out::println);

		repo.fetchNameOfEmployees().forEach(System.out::println);

		
		List<Object[]> objects =repo.fetchIdAndNameofEmployee();
		for (Object[] obj : objects) {
			for (Object row : obj) {
				System.out.print(row+"\t");	
			}
			System.out.println();
		}
		List<Object[]> objects1 =repo.fetchBasedonDept("DEV");
		for (Object[] obj : objects1) {
			for (Object row : obj) {
				System.out.print(row+"\t");	
			}
			System.out.println();
		}
		
		System.out.println("Before deletion");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		System.out.println("no of employees deleted is "+repo.deleteEmployeeById(101));
		
		System.out.println("After deletion");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		System.out.println("Before update");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		System.out.println("no of employees deleted is "+repo.updateEmployeeSalById(102,3500.0));
		
		System.out.println("After update");
		repo.fetchAllEmployees().forEach(System.out::println);
		
		
		
		
		
		
		}
}
