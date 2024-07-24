package com.hallbookingmanagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hallbookingmanagement.beans.Customer;
import com.hallbookingmanagement.util.DAOFactory;

@Controller
public class sampleController {
	
	@RequestMapping("add")
	public ModelAndView add() {
		try {
		List<Customer> list=  DAOFactory.getCustomerDao().getAllCustomer();
		ModelAndView model = new ModelAndView();
		System.out.println("List :"+list);
		model.setViewName("dummy");
		return model;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
