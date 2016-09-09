package storage;

import java.util.List;

import model.Employee;
import model.EmployeeAsset;

public interface EmployeeAssetDAO {

	void createEmployeeAsset(EmployeeAsset employeeAsset);

	List<EmployeeAsset> getEmployeeAssets(Long employeeId);
	
	void removeAllEmployeeAssets(Long employeeId);
	
	void removeAllEmployeeAssets(Long employeeId, List<EmployeeAsset> employeeAssets);
	
	void updateEmployeeAsset(EmployeeAsset employeeAsset);

	List<Employee> getAssetEmployees(Long assetId);

	EmployeeAsset getEmployeeAssetByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId);
}
