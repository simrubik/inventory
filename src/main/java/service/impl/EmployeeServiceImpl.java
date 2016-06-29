package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;
import service.EmployeeService;
import storage.EmployeeDAO;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDao;
	
	public void createEmployee(Employee employee) {
		employeeDao.createEmployee(employee);
	}

	public Employee getEmployeeById(Long id) {
		return employeeDao.getEmployeeById(id);
	}

	public List<Employee> getEmployeeByName(String name) {
		return employeeDao.getEmployeeByName(name);
	}

	public List<Employee> getAllEmployees() {
		return employeeDao.getAll();
	}

	@Override
	public void updateEmployee(Employee newEmployee) {
		employeeDao.updateEmployee(newEmployee);
	}

	@Override
	public void markForDeletionEmployee(String employeeId) {
		Long id = Long.parseLong(employeeId);
		
		employeeDao.markForDeletionEmployee(id);
	}

}
