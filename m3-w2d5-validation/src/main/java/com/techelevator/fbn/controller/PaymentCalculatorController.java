package com.techelevator.fbn.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.fbn.model.MortgageLoanEstimate;
import com.techelevator.fbn.model.form.MortgagePaymentCalculatorForm;

@Controller
public class PaymentCalculatorController {

	@RequestMapping("/mortgageCalculatorInput")
	public String showMortgagePaymentCalculatorInputPage() {
		return "mortgageCalculatorInput";
	}
	
	@RequestMapping("/mortgageCalculatorResult")
	public String showMortgagePaymentCalculatorResults(ModelMap model,
													  @Valid MortgagePaymentCalculatorForm form, 
													  Errors validationErrors) {

		String viewName = "mortgageCalculatorResult";
		
		if(validationErrors.hasErrors()) {
			model.put("validationErrors", validationErrors);
			viewName = "mortgageCalculatorInput";
		} else {
			MortgageLoanEstimate estimate = new MortgageLoanEstimate(form.getLoanAmount(), form.getLoanTerm(), form.getRate()/100);
			model.put("estimate", estimate);
		}
		
		return viewName;
	}
}
