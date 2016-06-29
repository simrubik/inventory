package service;

import java.util.List;

import model.Asset;

public interface AssetSearchService {

	List<Asset> getAssets(String search);
}
