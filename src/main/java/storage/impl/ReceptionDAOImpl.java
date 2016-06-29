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

	public List<Reception> getEmployeeAssetReceptions(Long employeeAssetId) {
		return em.createQuery("SELECT r FROM Reception r WHERE r.employeeAsset.id = :id", Reception.class)
				.setParameter("id", employeeAssetId).getResultList();
	}

}
