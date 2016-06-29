package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.EmployeeAsset;
import storage.InventoryDAO;

@Repository("inventoryDAOImpl")
public class InventoryDAOImpl implements InventoryDAO {

	@PersistenceContext
	private EntityManager em;

	//Inainte de a avea relatia bidirectionala. Trebuia returnat List<Inventory>, deoarece nu puteam returna si List<EmployeeAsset> si List<Reception>
//	public List<Inventory> getInventoryForEmployee(Integer employeeId) {
//		Query query = em
//				.createQuery(
//						"select ea, r1 from EmployeeAsset ea left join Reception r1 on ea.id=r1.employeeAsset.id where ea.employee.id=:id order by ea.id")
//				.setParameter("id", new Long(employeeId));
//
//		List<Inventory> inventoryList = new ArrayList<>();
//		for(int i = 0; i < query.getResultList().size(); i++){
//			EmployeeAsset ea = (EmployeeAsset) ((Object[]) query.getResultList().get(i))[0];
//			Reception r = (Reception) ((Object[]) query.getResultList().get(i))[1];
//			
//			String receptionDate = null;
//			if (r != null && !(r.getReceptionDate() == null) && !"".equals(r.getReceptionDate())) {
//				receptionDate = r.getReceptionDate().toString();
//			}
//
//			String receptionQuantity = null;
//			if (r != null && !(r.getQuantity() == null) && !"".equals(r.getQuantity())) {
//				receptionQuantity = r.getQuantity().toString();
//			}
//
//			Inventory inventory = new Inventory(ea.getAsset().getName(), ea.getAsset().getSerie(), ea.getUseTime(), ea.getPu(), ea.getUm(), receptionDate, r != null ? r.getType() : null, r != null ? r.getNumber() : null, receptionQuantity, null, null, null, null);
//			
//			inventoryList.add(inventory);
//		}
//		return inventoryList;
//	}
	
	@Override
	public List<EmployeeAsset> getInventoryForEmployee(Integer employeeId) {
		return em
				.createQuery(
						"select ea from EmployeeAsset ea where ea.employee.id=:id order by ea.id", EmployeeAsset.class)
				.setParameter("id", new Long(employeeId)).getResultList();
	}

}
