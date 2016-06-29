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

	public Asset getAssetById(Long id) {
		return assetDao.getAssetById(id);
	}

	public Asset getAssetBySerie(String serie) {
		return assetDao.getAssetBySerie(serie);
	}

	public List<Asset> getAssetByName(String name) {
		return assetDao.getAssetByName(name);
	}

	public List<Asset> getAllAssets() {
		return assetDao.getAll();
	}

	public Set<String> getAssetDistinctName(){
		Set<String> assetNames = new TreeSet<String>();
		for(Asset a : getAllAssets()){
			assetNames.add(a.getName());
		}
		
		return assetNames;
	}
}
