package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Employee;
import model.EmployeeAsset;
import storage.EmployeeAssetDAO;

@Repository("employeeAssetDAOImpl")
public class EmployeeAssetDAOImpl implements EmployeeAssetDAO {

	@PersistenceContext
	private EntityManager em;

	public void createEmployeeAsset(EmployeeAsset employeeAsset) {
		em.persist(employeeAsset);
	}

	public List<EmployeeAsset> getEmployeeAssets(Long employeeId) {
		return em.createQuery("SELECT e FROM EmployeeAsset e WHERE e.employee.id=:id", EmployeeAsset.class)
				.setParameter("id", employeeId).getResultList();
	}

	// sterge toate inregistrarile odata, dar nu merge cu CascadeType.All, de
	// aceea trebuie stersi si copiii individual
	public void removeAllEmployeeAssets(Long employeeId) {
		em.createQuery(
				"DELETE FROM Reception r WHERE r.id IN (SELECT a.reception.id FROM EmployeeAsset a WHERE a.employee.id=:employeeId )")
				.setParameter("employeeId", employeeId).executeUpdate();
		em.createQuery(
				"DELETE FROM Returning r WHERE r.id IN (SELECT a.returning.id FROM EmployeeAsset a WHERE a.employee.id=:employeeId )")
				.setParameter("employeeId", employeeId).executeUpdate();

		em.createQuery("DELETE FROM EmployeeAsset a WHERE a.employee.id=:employeeId")
				.setParameter("employeeId", employeeId).executeUpdate();
	}

	public void removeAllEmployeeAssets(Long employeeId, List<EmployeeAsset> employeeAssets) {
		for (EmployeeAsset ea : employeeAssets) {
			em.remove(ea); // parintele sterge implicit si copiii sai, merge cu
							// CascadeType.All, nefiind nevoie nici macar de:
							// "orphanRemoval=true", doar ca sterge
							// inregistrarile pe rand
		}

	}

	public void updateEmployeeAsset(EmployeeAsset newEmployeeAsset) {
		EmployeeAsset employeeAsset = em.find(EmployeeAsset.class, newEmployeeAsset.getId());

		employeeAsset.setPu(newEmployeeAsset.getPu());
		employeeAsset.setUm(newEmployeeAsset.getUm());
		employeeAsset.setUseTime(newEmployeeAsset.getUseTime());

		em.merge(employeeAsset);

	}

	public List<Employee> getAssetEmployees(Long assetId) {
		// TODO Auto-generated method stub
		return null;
	}

	public EmployeeAsset getEmployeeAssetByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId) {
		Query query = em.createQuery("SELECT ea FROM EmployeeAsset ea WHERE ea.employee.id=:employeeId and ea.id=:employeeAssetId", EmployeeAsset.class)
					.setParameter("employeeId", employeeId).setParameter("employeeAssetId", employeeAssetId);
		EmployeeAsset ea = (EmployeeAsset) query.getSingleResult();
		return ea;
	}

}
