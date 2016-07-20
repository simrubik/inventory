package storage;

import java.util.List;

import model.Asset;

public interface AssetDAO {

	void createAsset(Asset asset);
	
	void updateAsset(Asset asset);
	
	void markForDeletionAsset(Long assetId);
	
	List<Asset> getAllAvailableAssets(Long employeeId);
	
	List<Asset> getAllAssets();

	Asset getAssetById(Long id);

	Asset getAssetBySerie(String serie);

	List<Asset> getAssetByName(String name);
}
