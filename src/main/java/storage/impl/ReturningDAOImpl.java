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

	public List<Returning> getEmployeeAssetReturning(Integer employeeAssetId) {
		return em.createQuery("SELECT r FROM Returning r WHERE r.employeeAsset.id = :id", Returning.class)
				.setParameter("id", employeeAssetId).getResultList();
	}

}
