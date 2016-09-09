package service.impl;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Asset;
import service.AssetService;
import storage.AssetDAO;

@Service
@Transactional
public class AssetServiceImpl implements AssetService{

	@Autowired
	private AssetDAO assetDao;
	
	public void createAsset(Asset asset) {
		assetDao.createAsset(asset);
	}

	public Asset getAssetById(String id) {
		return assetDao.getAssetById(Long.parseLong(id));
	}

	public Asset getAssetBySerie(String serie) {
		return assetDao.getAssetBySerie(serie);
	}

	public List<Asset> getAssetByName(String name) {
		return assetDao.getAssetByName(name);
	}

	public List<Asset> getAllAvailableAssets(String employeeId) {
		Long id = Long.parseLong(employeeId);
		return assetDao.getAllAvailableAssets(id);
	}

	public Set<String> getAssetDistinctName(String employeeId){
		Set<String> assetNames = new TreeSet<String>();
		for(Asset a : getAllAvailableAssets(employeeId)){
			assetNames.add(a.getName());
		}
		
		return assetNames;
	}

	public List<Asset> getAllAssets() {
		return assetDao.getAllAssets();
	}

	public void updateAsset(Asset asset) {
		assetDao.updateAsset(asset);
	}

	public void markForDeletionAsset(String assetId) {
		Long id = Long.parseLong(assetId);
		
		assetDao.markForDeletionAsset(id);		
	}

	@Override
	public List<Asset> getAssetsByEmployeeId(String employeeId) {
		return assetDao.getAssetsByEmployeeId(Long.parseLong(employeeId));
	}
}
