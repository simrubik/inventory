package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dto.Inventory;
import model.Employee;
import model.EmployeeAsset;
import model.Reception;
import model.Returning;
import service.EmployeeAssetService;
import storage.EmployeeAssetDAO;

@Service
@Transactional
public class EmployeeAssetServiceImpl implements EmployeeAssetService {

	@Autowired
	private EmployeeAssetDAO employeeAssetDAO;

	public void createEmployeeAsset(EmployeeAsset employeeAsset) {
		employeeAssetDAO.createEmployeeAsset(employeeAsset);
	}

	public List<EmployeeAsset> getEmployeeAssets(Long employeeId) {
		return employeeAssetDAO.getEmployeeAssets(employeeId);
	}

	public List<Employee> getAssetEmployees(Long assetId) {
		return employeeAssetDAO.getAssetEmployees(assetId);
	}

	@Override
	public List<Inventory> getInventoryForEmployee(Long employeeId) {
		List<EmployeeAsset> employeeAssets = employeeAssetDAO.getEmployeeAssets(employeeId);
		
		List<Inventory> inventoryList = new ArrayList<>();
		for(EmployeeAsset ea : employeeAssets){
			Reception r = ea.getReception();
			
			String receptionDate = null;
			if (r != null && !(r.getReceptionDate() == null) && !"".equals(r.getReceptionDate())) {
				receptionDate = r.getReceptionDate().toString();
			}

			String receptionQuantity = null;
			if (r != null && !(r.getQuantity() == null) && !"".equals(r.getQuantity())) {
				receptionQuantity = r.getQuantity().toString();
			}

			Returning ret = ea.getReturning();
			
			String returningDate = null;
			if (ret != null && !(ret.getReturningDate() == null) && !"".equals(ret.getReturningDate())) {
				returningDate = ret.getReturningDate().toString();
			}

			String returningQuantity = null;
			if (ret != null && !(ret.getQuantity() == null) && !"".equals(ret.getQuantity())) {
				returningQuantity = ret.getQuantity().toString();
			}
			Inventory inventory = new Inventory(ea.getAsset().getName(), ea.getAsset().getSerie(), ea.getUseTime(), ea.getPu(), ea.getUm(), receptionDate, r != null ? r.getType() : null, r != null ? r.getNumber() : null, receptionQuantity, returningDate, ret != null ? ret.getType() : null, ret != null ? ret.getNumber() : null, returningQuantity, ea.getId().toString());
			
			inventoryList.add(inventory);
		}
		
		return inventoryList;
	}

	@Override
	public void removeAllEmployeeAssets(Long employeeId) {
//		employeeAssetDAO.removeAllEmployeeAssets(employeeId);	
				
		employeeAssetDAO.removeAllEmployeeAssets(employeeId, employeeAssetDAO.getEmployeeAssets(employeeId));
	}

	@Override
	public void updateEmployeeAsset(EmployeeAsset employeeAsset) {
		employeeAssetDAO.updateEmployeeAsset(employeeAsset);
	}

	@Override
	public EmployeeAsset getEmployeeAssetByEmployeeIdAndAssetId(String employeeId, String employeeAssetId) {
		return employeeAssetDAO.getEmployeeAssetByEmployeeIdAndAssetId(Long.parseLong(employeeId), Long.parseLong(employeeAssetId));
	}
}
