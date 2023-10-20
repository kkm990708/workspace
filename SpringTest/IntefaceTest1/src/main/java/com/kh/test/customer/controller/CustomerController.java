package com.kh.test.customer.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.test.customer.model.dto.Customer;
import com.kh.test.customer.model.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService service;

	
	@PostMapping("insertCustomer")
	public String insertCustomer(@ModelAttribute Customer customer, Model model
			) {
		
		log.debug(" " + customer);
		System.out.println(customer);
		
		service.insertCustomer(customer);
		
		model.addAttribute("customer",customer);
		
		return "result";
	}
}
