package storage.impl;

import java.util.ArrayList;
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
		return em.createQuery("SELECT a FROM Asset a WHERE lower(a.name) like :name ORDER BY a.name", Asset.class)
				.setParameter("name", '%' + name.toLowerCase() + '%').getResultList();
	}

	// select * from asset where asset_id not in (select ea.asset_id from
	// employee_asset ea)
	//
	// union
	//
	// select * from asset where asset_id in
	// (select ea.asset_id from employee_asset ea inner join returning_object r
	// on ea.returning_id=r.returning_id where r.returning_date is not null)
	//
	// select * from asset a inner join employee_asset ea on
	// a.asset_id=ea.asset_id inner join returning_object r on
	// ea.returning_id=r.returning_id
	// where ea.employee_id = 93 and r.returning_date is null
	public List<Asset> getAllAvailableAssets(Long employeeId) {
		// return em.createQuery("SELECT a FROM Asset a",
		// Asset.class).getResultList();
		// return em.createQuery("SELECT a FROM Asset a WHERE a.id NOT IN
		// (SELECT ea.asset.id FROM EmployeeAsset ea) UNION SELECT a FROM Asset
		// a WHERE a.id IN (SELECT ea.asset.id FROM EmployeeAsset ea INNER JOIN
		// Returning r ON ea.returning.id = r.id WHERE r.returningDate IS NOT
		// NULL)", Asset.class).getResultList();

		List<Asset> newAssets = em
				.createQuery("SELECT a FROM Asset a WHERE a.id NOT IN (SELECT ea.asset.id FROM EmployeeAsset ea)",
						Asset.class)
				.getResultList();
		List<Asset> freeAssets = em.createQuery(
				"SELECT a FROM Asset a WHERE a.id IN (SELECT ea.asset.id FROM EmployeeAsset ea INNER JOIN Returning r ON ea.returning.id = r.id WHERE r.returningDate IS NOT NULL)",
				Asset.class).getResultList();
		List<Asset> ownedAssets = em.createQuery(
				"SELECT a FROM Asset a  INNER JOIN EmployeeAsset ea ON a.id = ea.asset.id INNER JOIN Returning r ON ea.returning.id = r.id WHERE r.returningDate IS NULL AND ea.employee.id = :employeeId",
				Asset.class).setParameter("employeeId", employeeId).getResultList();

		List<Asset> allAvailableAssets = new ArrayList<>();
		allAvailableAssets.addAll(newAssets);
		allAvailableAssets.addAll(freeAssets);
		allAvailableAssets.addAll(ownedAssets);

		return allAvailableAssets;

	}

	@Override
	public List<Asset> getAllAssets() {
		return em.createQuery("SELECT a FROM Asset a ORDER BY a.name", Asset.class).getResultList();
	}

	@Override
	public void updateAsset(Asset newAsset) {
		Asset asset = em.find(Asset.class, newAsset.getId());

		asset.setName(newAsset.getName());
		asset.setSerie(newAsset.getSerie());
		asset.setAvailable(newAsset.getAvailable());
		asset.setActive(newAsset.getActive());

		em.merge(asset);
		
	}

	@Override
	public void markForDeletionAsset(Long assetId) {
		Asset asset = getAssetById(assetId);
		asset.setActive(false);
		
		em.merge(asset);
	}

}
