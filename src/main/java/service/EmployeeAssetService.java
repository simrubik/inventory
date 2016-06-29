package service;

import java.util.List;

import dto.Inventory;
import model.Employee;
import model.EmployeeAsset;

public interface EmployeeAssetService {

	void createEmployeeAsset(EmployeeAsset employeeAsset);

	List<EmployeeAsset> getEmployeeAssets(Long employeeId);
	
	List<Inventory> getInventoryForEmployee(Long employeeId);

	List<Employee> getAssetEmployees(Integer assetId);
	
	void removeAllEmployeeAssets(Long employeeId);
}
