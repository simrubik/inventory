package service;

import java.util.List;

import model.Employee;

public interface EmployeeSearchService {

	List<Employee> getEmployees(String search);
}
