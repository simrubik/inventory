package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Asset;
import service.AssetService;

@Controller
@RequestMapping("/assets")
public class AssetController {

	@Autowired
	private AssetService assetService;

	@RequestMapping(method = RequestMethod.GET)
	public String displayAsset(Model model) {
		model.addAttribute("asset", new Asset());

		return "addAsset";
	}

	@RequestMapping(method = RequestMethod.POST)
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
}
