package controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import model.Employee;
import service.EmployeeService;

@Controller
@RequestMapping(value = "/employees")
public class EmployeeController {

	private static final Logger slf4jLogger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(method = RequestMethod.GET)
	public String displaySearchEmployeePage(Model model) {

		List<Employee> allEmployees = employeeService.getAllEmployees();

		if (!model.containsAttribute("employees")) {
			model.addAttribute("employees", allEmployees);
		}

		return "searchEmployee";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String searchEmployee(@RequestParam("employeeName") String searchTerm, RedirectAttributes redirectAttributes,
			Model model) {
        slf4jLogger.info("Employee search started for " + searchTerm + ".");
        slf4jLogger.trace("Employee search started for" + searchTerm + ".");
        slf4jLogger.warn("Employee search started for " + searchTerm + ".");
        
		List<Employee> searchedEmployees = employeeService.getEmployeeByName(searchTerm);

		model.addAttribute("employees", searchedEmployees);
		redirectAttributes.addFlashAttribute("employees", searchedEmployees);

		slf4jLogger.info("Employee search finished.");
		
		return "redirect:/employees";
	}

	@RequestMapping(value = "new", method = RequestMethod.GET)
	public String displayAddNewEmployeePage(Model model) {

		Employee e = new Employee();
		e.setEmploymentDate(new Date());
		model.addAttribute("employee", e);
		model.addAttribute("action", "add");

		return "addEmployee";
	}

	@RequestMapping(value = "new", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("BindingResult valid error");
			return "addEmployee";
		}

		employee.setActive(true);
		employeeService.createEmployee(employee);

		model.addAttribute("employee", employee);

		return "redirect:/employees";
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String displayEditEmployee(@PathVariable("employeeId") String employeeId, Model model) {
		Employee e = employeeService.getEmployeeById(Long.parseLong(employeeId));

		model.addAttribute("employee", e);
		model.addAttribute("employeeId", employeeId);
		model.addAttribute("action", "edit");

		return "addEmployee";
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.POST)
	public String editEmployee(@RequestParam("employeeId") String oldEmployeeId,
			@Valid @ModelAttribute("employee") Employee newEmployee, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("BindingResult valid error");
			return "addEmployee";
		}

		employeeService.updateEmployee(oldEmployeeId, newEmployee);
		model.addAttribute("employee", newEmployee);

		return "redirect:/employees";
	}

	@RequestMapping(value = "delete/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("employeeId") String employeeId) {
		employeeService.deleteEmployee(employeeId);
		
		return "redirect:/employees";
	}
}
