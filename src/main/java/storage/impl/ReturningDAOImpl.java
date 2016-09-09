package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.Returning;
import storage.ReturningDAO;

@Repository("returningDAOImpl")
public class ReturningDAOImpl implements ReturningDAO {

	@PersistenceContext
	private EntityManager em;

	public void createReturning(Returning returning) {
		em.persist(returning);
	}

	public void updateReturning(Returning newReturning) {
		Returning returning = em.find(Returning.class, newReturning.getId());
		
		returning.setNumber(newReturning.getNumber());
		returning.setQuantity(newReturning.getQuantity());
		returning.setReturningDate(newReturning.getReturningDate());
		returning.setType(newReturning.getType());
		
		em.merge(returning);
	}

	public List<Returning> getReturningByEmployeeId(Long employeeId) {
		return em.createNamedQuery("SELECT r FROM Returning r INNER JOIN EmployeeAsset ea ON r.id=ea.returning.id WHERE ea.employee.id =:id", Returning.class).setParameter("id", employeeId).getResultList();
	}

	@Override
	public Returning getReturningByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId) {
		return em.createQuery("SELECT r FROM Returning r INNER JOIN EmployeeAsset ea ON r.id=ea.returning.id WHERE ea.employee.id=:employeeId and ea.id=:employeeAssetId", Returning.class)
				.setParameter("employeeId", employeeId).setParameter("employeeAssetId", employeeAssetId).getSingleResult();
	}

}
