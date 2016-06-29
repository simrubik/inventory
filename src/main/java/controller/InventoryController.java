package controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dto.EmployeeInventory;
import model.Asset;
import model.Employee;
import service.AssetSearchService;
import service.AssetService;
import service.EmployeeSearchService;
import serviceAggregation.InventoryService;

@Controller("inventoryController")
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private EmployeeSearchService employeeSearchService;
	@Autowired
	private AssetService assetService;
	@Autowired
	private AssetSearchService assetSearchService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String displayInventoryForm(Model model) {
		model.addAttribute("employees", employeeSearchService.getEmployees(""));
		model.addAttribute("empl", new Employee());

//		model.addAttribute("assets", assetService.getAssetDistinctName());
//		model.addAttribute("assetSerie", assetSearchService.getAssets(""));
//		
//		model.addAttribute("inventoryList", new EmployeeInventory());
		return "showEmployees";
	}

	// @RequestMapping(method = RequestMethod.POST)
	// public String sendEmployeeId(@ModelAttribute("empl") Employee employee){
	// System.out.println(employee.getId());
	// return "redirect:/inventory";
	// }

	@RequestMapping(value="/{employeeId}", method=RequestMethod.GET)
	public String goToEmployeeInventory(@PathVariable("employeeId") String id, Model model){
		model.addAttribute("assets", assetService.getAssetDistinctName());
		model.addAttribute("assetSerie", assetSearchService.getAssets(""));
		
		EmployeeInventory ei = new EmployeeInventory();
		
		if(inventoryService.getExistingInventory(Long.parseLong(id)) != null){
			ei.setInventoryList(inventoryService.getExistingInventory(Long.parseLong(id)));
		}
		
		if(!model.containsAttribute("inventoryList")){
			model.addAttribute("inventoryList", ei);
			model.addAttribute("employeeId", id);
		}
				
		return "inventoryFile";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveInventory(@RequestParam("employeeId") String emplId,
			@Valid @ModelAttribute("inventoryList") EmployeeInventory inventoryList, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws ParseException {
		
		if (bindingResult.hasErrors()) {
			System.out.println("BindingResult valid error");
			model.addAttribute("employees", employeeSearchService.getEmployees(""));
			model.addAttribute("assets", assetService.getAssetDistinctName());
			model.addAttribute("assetSerie", assetSearchService.getAssets(""));

			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.inventoryList", bindingResult);
		    redirectAttributes.addFlashAttribute("inventoryList", inventoryList);

		    return "redirect:/inventory/" + emplId;
		}
		
		inventoryService.createInventory(inventoryList, emplId);
				
		model.addAttribute("inventoryList", inventoryList);
		
		return "redirect:/inventory";
	}

	@RequestMapping(value = "assets", method = RequestMethod.POST)
	@ResponseBody
	public List<Asset> getAssetsByName(@RequestParam("name") String name) {
		return assetSearchService.getAssets(name);
	}
	
}
