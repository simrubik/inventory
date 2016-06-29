package service;

import java.util.List;
import java.util.Set;

import model.Asset;

public interface AssetService {

	void createAsset(Asset asset);
	
	List<Asset> getAllAssets();

	Asset getAssetById(Long id);

	Asset getAssetBySerie(String serie);

	List<Asset> getAssetByName(String name);
	
	Set<String> getAssetDistinctName();
}
