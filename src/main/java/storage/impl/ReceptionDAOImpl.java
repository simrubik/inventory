package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.Reception;
import storage.ReceptionDAO;

@Repository("receptionDAOImpl")
public class ReceptionDAOImpl implements ReceptionDAO {

	@PersistenceContext
	private EntityManager em;

	public void createReception(Reception reception) {
		em.persist(reception);
	}

	@Override
	public void updateReception(Reception newReception) {
		Reception reception = em.find(Reception.class, newReception.getId());

		reception.setNumber(newReception.getNumber());
		reception.setReceptionDate(newReception.getReceptionDate());
		reception.setQuantity(newReception.getQuantity());
		reception.setType(newReception.getType());

		em.merge(reception);
	}

	@Override
	public Reception getReceptionById(Long receptionId) {
		return em.createNamedQuery("SELECT r FROM Reception r WHERE r.id = :id", Reception.class)
				.setParameter("id", receptionId).getSingleResult();
	}

	@Override
	public List<Reception> getReceptionByEmployeeId(Long employeeId) {
		return em.createNamedQuery("SELECT r FROM Reception r INNER JOIN EmployeeAsset ea on r.id=ea.reception.id WHERE ea.employee.id =:id", Reception.class).setParameter("id", employeeId).getResultList();
	}

	@Override
	public Reception getReceptionByEmployeeIdAndAssetId(Long employeeId, Long employeeAssetId) {
		return em.createQuery("SELECT r FROM Reception r INNER JOIN EmployeeAsset ea ON r.id=ea.reception.id WHERE ea.employee.id=:employeeId and ea.id=:employeeAssetId", Reception.class)
				.setParameter("employeeId", employeeId).setParameter("employeeAssetId", employeeAssetId).getSingleResult();
	}

	
}
