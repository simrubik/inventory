package dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

public class EmployeeInventory {
	
	@Valid
	private List<Inventory> inventoryList;

	public EmployeeInventory() {
		inventoryList = new ArrayList<>();
	}

	public EmployeeInventory(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}
}
