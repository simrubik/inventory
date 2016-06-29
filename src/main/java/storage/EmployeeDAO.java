package storage;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {

	void createEmployee(Employee employee);
	
	void updateEmployee(Employee newEmployee);
	
	void markForDeletionEmployee(Long employeeId);
	
	List<Employee> getAll();

	Employee getEmployeeById(Long id);

	List<Employee> getEmployeeByName(String name); //both firstName and secondName
}
