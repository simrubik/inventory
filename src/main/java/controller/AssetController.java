package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.Asset;
import service.AssetService;

@Controller
@RequestMapping("/assets")
public class AssetController {

	@Autowired
	private AssetService assetService;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySearchAssetPage(Model model){
		List<Asset> allAssets = assetService.getAllAssets();
		
		if(!model.containsAttribute("assets")){
			model.addAttribute("assets", allAssets);
		}
		
		return "searchAsset";
	}
	
	//Pentru search
	@RequestMapping(method = RequestMethod.POST)
	public String searchAsset(@RequestParam("searchTerm") String searchTerm, RedirectAttributes redirectAttributes, Model model){		
		List<Asset> searchedAssets = assetService.getAssetByName(searchTerm);
		
		model.addAttribute("assets", searchedAssets);
		redirectAttributes.addFlashAttribute("assets", searchedAssets);
		
		return "redirect:/assets";
	}
	
	//Pentru a adauga un nou asset
	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String displayAddNewAsset(Model model) {
		model.addAttribute("asset", new Asset());
		model.addAttribute("action", "add");

		return "addAsset";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addAsset(@Valid @ModelAttribute("asset") Asset asset, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("BindingResult valid error");
			return "addAsset";
		}

		assetService.createAsset(asset);
		
		model.addAttribute("asset", asset);
//		model.addAttribute("asset", new Asset()); //pentru a goli field-urile din formular

		return "redirect:/assets";
	}
	
	//Pentru a modifica un asset
	@RequestMapping(value = "/editAsset/{assetId}", method = RequestMethod.GET)
	public String displayEditAsset(@PathVariable("assetId") String assetId, Model model){	
		Asset a = assetService.getAssetById(assetId);
		model.addAttribute("asset", a);
		model.addAttribute("action", "edit");
		
		return "addAsset";
	}
	
	@RequestMapping(value = "/editAsset/{assetId}", method = RequestMethod.POST)
	public String editAsset(@Valid @ModelAttribute("asset") Asset asset, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "addAsset";
		}
		
		assetService.updateAsset(asset);
		
		return "redirect:/assets";
	}
	
	@RequestMapping(value = "/delete/{assetId}", method = RequestMethod.GET)
	public String deleteAsset(@PathVariable("assetId") String assetId){
		assetService.markForDeletionAsset(assetId);
		
		return "redirect:/assets";
	}
}
