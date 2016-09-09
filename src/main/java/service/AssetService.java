package service;

import java.util.List;
import java.util.Set;

import model.Asset;

public interface AssetService {

	void createAsset(Asset asset);
	
	void updateAsset(Asset asset);
	
	void markForDeletionAsset(String assetId);
	
	List<Asset> getAllAvailableAssets(String employeeId);
	
	List<Asset> getAllAssets();

	Asset getAssetById(String id);

	Asset getAssetBySerie(String serie);

	List<Asset> getAssetByName(String name);
	
	Set<String> getAssetDistinctName(String employeeId);
	
	List<Asset> getAssetsByEmployeeId(String employeeId);
}
