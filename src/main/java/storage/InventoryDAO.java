package storage;

import java.util.List;

import model.EmployeeAsset;

public interface InventoryDAO {
	
	List<EmployeeAsset> getInventoryForEmployee(Integer employeeId);

}
