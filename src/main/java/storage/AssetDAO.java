package storage;

import java.util.List;

import model.Asset;

public interface AssetDAO {

	void createAsset(Asset asset);
	
	List<Asset> getAll();

	Asset getAssetById(Long id);

	Asset getAssetBySerie(String serie);

	List<Asset> getAssetByName(String name);
}
