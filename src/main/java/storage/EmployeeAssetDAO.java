package storage;

import java.util.List;

import model.Employee;
import model.EmployeeAsset;

public interface EmployeeAssetDAO {

	void createEmployeeAsset(EmployeeAsset employeeAsset);

	List<EmployeeAsset> getEmployeeAssets(Long employeeId);

	List<Employee> getAssetEmployees(Integer assetId);
	
	void removeAllEmployeeAssets(Long employeeId);
	
	void removeAllEmployeeAssets(Long employeeId, List<EmployeeAsset> employeeAssets);
}
