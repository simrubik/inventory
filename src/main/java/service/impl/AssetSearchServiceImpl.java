package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Asset;
import service.AssetSearchService;
import service.AssetService;

@Service
@Transactional
public class AssetSearchServiceImpl implements AssetSearchService{

	@Autowired
	private AssetService assetService;
	
	public List<Asset> getAssets(String search) {
		if(search == null || search.isEmpty()){
			return assetService.getAllAssets();
		} else {
			return assetService.getAssetByName(search);
		}
	}

}
