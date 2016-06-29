package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Employee;
import service.EmployeeSearchService;
import service.EmployeeService;

@Service
@Transactional
public class EmployeeSearchServiceImpl implements EmployeeSearchService{

	@Autowired
	private EmployeeService employeeService;
	
	public List<Employee> getEmployees(String search) {
		if(search == null || search.isEmpty()){
			return employeeService.getAllEmployees();
		} else {
			return employeeService.getEmployeeByName(search);
		}
	}

}
