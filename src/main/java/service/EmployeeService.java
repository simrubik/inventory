package service;

import java.util.List;

import model.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	
	void updateEmployee(String oldEmployeeId, Employee newEmployee);
	
	void deleteEmployee(String employeeId);

	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);

	List<Employee> getEmployeeByName(String name);
}
