package serviceAggregation;

import java.text.ParseException;
import java.util.List;

import dto.EmployeeInventory;
import dto.Inventory;
import model.Asset;
import model.Employee;

public interface InventoryService {

	Asset getCurrentAsset(String assetId);

	Employee getCurrentEmployee(String emplId);
	
	void createInventory(EmployeeInventory inventoryList, String emplId) throws ParseException;
	
	void updateExistingInventory(EmployeeInventory inventoryList, String employeeId) throws ParseException;

	List<Inventory> getExistingInventory(Long employeeId);
}
