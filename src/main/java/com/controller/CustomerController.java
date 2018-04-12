package com.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.CustTable;
import com.service.CustomerService;

@Controller
public class CustomerController {
	private List<CustTable> custTableList;

	@RequestMapping(value = "/customer", method = GET)
	public String show(Model model) {
		System.out.println("In controller");
		CustomerService customerService = new CustomerService();
		custTableList = customerService.listAllCustomers();
		model.addAttribute("customer", new CustTable());
		model.addAttribute("customerList", custTableList);
		// jspのファイル名
		return "customer";
	}

	@RequestMapping(value = "/customer_css", method = RequestMethod.GET)
	public String showAllCustomers(Model model) {
		System.out.println("Customer controller");
		CustomerService customerService = new CustomerService();
		custTableList = customerService.listAllCustomers();
		model.addAttribute("customer", new CustTable());
		model.addAttribute("customerList", custTableList);
		return "list";
	}

	// show add customer form
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		CustTable custTable = new CustTable();

		// set default value
		custTable.setCustAccount("DefaultAccount");
		custTable.setCustName("Dummy name");
		custTable.setCreditLimit((float) 100.00);

		model.addAttribute("customerForm", custTable);
		model.addAttribute("parameter", "new");
		model.addAttribute("readonly", "false");
		model.addAttribute("readonly_other", "false");
		return "customerform";
	}

	// show update form
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") String custAccount, Model model) {

		System.out.println("Show update form controller");
		CustomerService customerService = new CustomerService();
		custTableList = customerService.getCustomerById(custAccount);
		CustTable custTable = custTableList.get(0);
		model.addAttribute("customerForm", custTable);
		model.addAttribute("parameter", "update");
		model.addAttribute("readonly", "true");
		model.addAttribute("readonly_other", "false");
		return "customerform";
	}

	// save or update customer
	@RequestMapping(value = "/customerForm", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("customerForm") @Validated CustTable custTable, BindingResult result,
			Model model, final RedirectAttributes redirectAttributes) {

		System.out.println("Save or updte controller");
		if (result.hasErrors()) {
			return "customerform";
		} else {
			CustomerService customerService = new CustomerService();
			customerService.saveOrUpdateCustomer(custTable);
			redirectAttributes.addFlashAttribute("msg", "Customer saved successfully");
			/*
			 * if(user.isNew()){ redirectAttributes.addFlashAttribute("msg",
			 * "User added successfully!"); }else{
			 * redirectAttributes.addFlashAttribute("msg", "User updated successfully!"); }
			 */

			// POST/REDIRECT/GET
			return "redirect:/customer_css";

			// POST/FORWARD/GET
			// return "user/list";

		}
	}

	// delete customer
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") String custAccount, final RedirectAttributes redirectAttributes) {

		System.out.println("Delete customer controller");
		CustomerService customerService = new CustomerService();
		CustTable custTable = new CustTable();
		custTable.setCustAccount(custAccount);
		customerService.deleteCustomer(custTable);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Customer is deleted!");

		return "redirect:/customer_css";

	}

	// show view customer form
	@RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
	public String showAddUserForm1(@PathVariable("id") String custAccount, Model model) {
		
		CustomerService customerService = new CustomerService();
		custTableList = customerService.getCustomerById(custAccount);
		CustTable custTable = custTableList.get(0);

		model.addAttribute("customerForm", custTable);
		model.addAttribute("parameter", "view");
		model.addAttribute("readonly", "true");
		model.addAttribute("readonly_other", "true");
		return "customerform";

	}
	
	// Back to main page
	@RequestMapping(value = "/view", method = RequestMethod.POST)
	public String backToMainPage() {

		System.out.println("Back to main controller");
		return "redirect:/customer_css";

	}
}
