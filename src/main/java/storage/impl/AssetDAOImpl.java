package storage.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import model.Asset;
import storage.AssetDAO;

@Repository("assetDAOImpl")
public class AssetDAOImpl implements AssetDAO {

	@PersistenceContext
	private EntityManager em;

	public void createAsset(Asset asset) {
		em.persist(asset);
	}

	public Asset getAssetById(Long id) {
		return em.createQuery("SELECT a FROM Asset a WHERE a.id = :id", Asset.class).setParameter("id", id)
				.getSingleResult();
	}

	public Asset getAssetBySerie(String serie) {
		return em.createQuery("SELECT a FROM Asset a WHERE lower(a.serie) like :serie", Asset.class)
				.setParameter("name", '%' + serie.toLowerCase() + '%').getSingleResult();
	}

	public List<Asset> getAssetByName(String name) {
		return em.createQuery("SELECT a FROM Asset a WHERE lower(a.name) like :name", Asset.class)
				.setParameter("name", '%' + name.toLowerCase() + '%').getResultList();
	}

	public List<Asset> getAll() {
		return em.createQuery("SELECT a FROM Asset a", Asset.class).getResultList();
	}

}
