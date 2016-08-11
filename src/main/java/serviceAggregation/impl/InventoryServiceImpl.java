package serviceAggregation.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.EmployeeInventory;
import dto.Inventory;
import model.Asset;
import model.Employee;
import model.EmployeeAsset;
import model.Reception;
import model.Returning;
import service.AssetService;
import service.EmployeeAssetService;
import service.EmployeeService;
import serviceAggregation.InventoryService;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private EmployeeAssetService employeeAssetService;
//	@Autowired
//	private ReceptionService receptionService;

	public InventoryServiceImpl(){
		
	}
	public Asset getCurrentAsset(String assetId) {
		return assetService.getAssetById(Long.parseLong(assetId));
	}

	public Employee getCurrentEmployee(String emplId) {
		return employeeService.getEmployeeById(Long.parseLong(emplId));
	}

	public void createInventory(EmployeeInventory inventoryList, String emplId) throws ParseException {
		Employee currentEmployee = getCurrentEmployee(emplId);
		
		//Before creating a EmployeeAsset, delete all from EmployeeAsset and his child related tables
		deleteFromEmployeeAssets(Long.parseLong(emplId));
		
		for (Inventory i : inventoryList.getInventoryList()) {

			Asset currentAsset = getCurrentAsset(i.getAssetSerie());

			if (emplId != null || !"".equals(emplId)) {
				
				Reception reception = getReceptionFromInventory(i);						
				Returning returning = getReturningFromInventory(i);
				
//				receptionService.createReception(getReceptionFromInventory(i)); //nu e neaparat nevoie deoarece se creaza pe baza create-ului obiectului parinte
				
				if(reception.getReceptionDate() != null && returning.getReturningDate() == null){
					currentAsset.setAvailable(false);
				}
				
				EmployeeAsset employeeAsset = new EmployeeAsset(currentEmployee, currentAsset, i.getUseTime(),
						i.getPu(), i.getUm(), reception, returning);
				employeeAssetService.createEmployeeAsset(employeeAsset);
				
				//Dupa crearea unui inventory=EmployeeAsset, trebuie facut update la asset-ul respectiv, ca sa nu mai fie 'available' pentru un alt employee
				assetService.updateAsset(currentAsset);
			}
		}

	}

	
	@Override
	public List<Inventory> getExistingInventory(Long employeeId) {
		return employeeAssetService.getInventoryForEmployee(employeeId);
	}

	private Reception getReceptionFromInventory(Inventory i) throws ParseException{
		Date receptionDate = null;
		if (i.getReceptionDate() != null && !"".equals(i.getReceptionDate())) {
			if(i.getReceptionDate().matches("\\d{2}\\/\\d{2}\\/\\d{4}")){
				receptionDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(i.getReceptionDate());
			}
			if(i.getReceptionDate().matches("\\d{4}-\\d{2}-\\d{2}.+")){
				receptionDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(i.getReceptionDate());
			}
		}

		Integer receptionQuantity = null;
		if (i.getReceptionQuantity() != null && !"".equals(i.getReceptionQuantity())) {
			receptionQuantity = Integer.parseInt(i.getReceptionQuantity());
		}

		return new Reception(receptionDate, i.getReceptionType(), i.getReceptionNumber(), receptionQuantity);
	}
	
	private Returning getReturningFromInventory(Inventory i) throws ParseException{
		Date returningDate = null;
		if (i.getReturningDate() != null && !"".equals(i.getReturningDate())) {
			if(i.getReturningDate().matches("\\d{2}\\/\\d{2}\\/\\d{4}")){
				returningDate = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH).parse(i.getReturningDate());
			}
			if(i.getReturningDate().matches("\\d{4}-\\d{2}-\\d{2}.+")){
				returningDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH).parse(i.getReturningDate());
			}			
		}

		Integer returningQuantity = null;
		if (i.getReturningQuantity() != null && !"".equals(i.getReturningQuantity())) {
			returningQuantity = Integer.parseInt(i.getReturningQuantity());
		}
		
		return new Returning(returningDate, i.getReturningType(), i.getReturningnNumber(), returningQuantity);
	}
	
	private void deleteFromEmployeeAssets(Long employeeId) {
		employeeAssetService.removeAllEmployeeAssets(employeeId);
	}

}
