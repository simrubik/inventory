package dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import model.EmployeeAsset;

public class EmployeeInventory {
	
	@Valid
	private List<Inventory> inventoryList;
	
	private List<EmployeeAsset> inventoryList2; 
	
	public EmployeeInventory() {
		inventoryList = new ArrayList<>();
		inventoryList2 = new ArrayList<>();
	}

	public EmployeeInventory(List<?> inventoryList) {
		if(inventoryList instanceof Inventory){
			this.inventoryList = (List<Inventory>) inventoryList;
		} else {
			this.inventoryList2 = (List<EmployeeAsset>) inventoryList;
		}
		
	}
	
	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<EmployeeAsset> getInventoryList2() {
		return inventoryList2;
	}

	public void setInventoryList2(List<EmployeeAsset> inventoryList2) {
		this.inventoryList2 = inventoryList2;
	}
	
}
