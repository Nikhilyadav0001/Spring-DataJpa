package nikhil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import nikhil.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	//=================================select operation=============================//
	@Query("FROM Employee WHERE empSal>=:esal")
	public List<Employee> fetchAllEmployeesWithSalGreater(Double esal);
	
	@Query("FROM Employee")
	public List<Employee> fetchAllEmployees();
	
	@Query("SELECT empName FROM Employee")
	public List<String> fetchNameOfEmployees();
	
	@Query("SELECT empId,empName from Employee")
	public List<Object[]> fetchIdAndNameofEmployee();
	
	@Query("select empId,empDept from Employee where empDept = :dep")
	public List<Object[]> fetchBasedonDept(@Param("dep") String dept);

	//=================================non-select operation=============================//

	@Query("DELETE FROM Employee WHERE empId =:id")
	@Modifying
	@Transactional
	public int deleteEmployeeById(Integer id);
	
	@Query("UPDATE Employee SET empSal = :sal where empId =:id ")
	@Modifying
	@Transactional
	public int updateEmployeeSalById(Integer id,Double sal);


}
