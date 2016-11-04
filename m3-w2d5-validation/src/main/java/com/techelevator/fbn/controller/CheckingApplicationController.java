package com.techelevator.fbn.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.fbn.model.CheckingAccountApplication;
import com.techelevator.fbn.model.form.PersonalInformationForm;

@Controller
@RequestMapping("/checkingApplication")
@SessionAttributes("customerApplication")
public class CheckingApplicationController {

	@RequestMapping(path={"/","/personalInformationInput"}, method=RequestMethod.GET)
	public String displayPersonalInformationInput() {
		return "checkingApplication/personalInformationInput";
	}
	/*
	@RequestMapping(path="/personalInformationInput", method=RequestMethod.POST)
	public String processPersonalInformationInput(@RequestParam String firstName, 
												 @RequestParam String lastName, 
												 @DateTimeFormat(pattern="MM/dd/yyyy")
												 @RequestParam LocalDate dateOfBirth, 
												 @RequestParam String stateOfBirth, 
												 @RequestParam String emailAddress, 
												 @RequestParam String phoneNumber,
												 RedirectAttributes redirect,
												 ModelMap model,
												 Errors validationErrors) {
		
		String redirectView = null;
		if(validationErrors.hasErrors()) {
			redirect.addFlashAttribute("validationErrors", validationErrors);
			redirectView = "redirect:/checkingApplication/personalInformationInput";
		} else {
			CheckingAccountApplication application = new CheckingAccountApplication();
			application.setFirstName(firstName);
			application.setLastName(lastName);
			application.setDateOfBirth(dateOfBirth);
			application.setStateOfBirth(stateOfBirth);
			application.setEmailAddress(emailAddress);
			application.setPhoneNumber(phoneNumber);
			
			model.addAttribute("customerApplication", application);
			redirectView = "redirect:/checkingApplication/addressInput";
		}
		
		return redirectView;
	}
	*/
	
	@RequestMapping(path="/personalInformationInput", method=RequestMethod.POST)
	public String processPersonalInformationInput(@Valid PersonalInformationForm form,
												 Errors validationErrors,  // This Errors parameter must follow the form data model parameter
												 RedirectAttributes redirect,
												 ModelMap model) {
		
		String redirectView = null;
		if(validationErrors.hasErrors()) {
			redirect.addFlashAttribute("validationErrors", validationErrors);
			redirectView = "redirect:/checkingApplication/personalInformationInput";
		} else {
			CheckingAccountApplication application = new CheckingAccountApplication();
			application.setFirstName(form.getFirstName());
			application.setLastName(form.getLastName());
			application.setDateOfBirth(form.getDateOfBirth());
			application.setStateOfBirth(form.getStateOfBirth());
			application.setEmailAddress(form.getEmailAddress());
			application.setPhoneNumber(form.getPhoneNumber());
			
			model.addAttribute("customerApplication", application);
			redirectView = "redirect:/checkingApplication/addressInput";
		}
		
		return redirectView;
	}
	
	@RequestMapping(path="/addressInput", method=RequestMethod.GET)
	public String displayAddressInput() {
		return "checkingApplication/addressInput";
	}
	
	@RequestMapping(path="/addressInput", method=RequestMethod.POST)
	public String processAddressInput(@RequestParam String streetAddress,
									 @RequestParam String apartmentNumber,
									 @RequestParam String city,
									 @RequestParam String state,
									 @RequestParam String zipCode,
									 ModelMap model) {
		
		CheckingAccountApplication application = (CheckingAccountApplication)model.get("customerApplication");

		application.setAddressStreet(streetAddress);
		application.setAddressApartment(apartmentNumber);
		application.setAddressCity(city);
		application.setAddressState(state);
		application.setAddressZip(zipCode);
		
		return "redirect:/checkingApplication/summary";
	}
	
	@RequestMapping(path="/summary", method=RequestMethod.GET)
	public String displaySummary() {
		return "checkingApplication/summary";
	}
	
	@RequestMapping(path="/completeApplication", method=RequestMethod.POST)
	public String processApplication(ModelMap model) {
		
		CheckingAccountApplication application = (CheckingAccountApplication)model.get("customerApplication");
		
		/* This is where we would do something useful with the application, 
		 * such as save it to a database. */
		
		return "redirect:/checkingApplication/thankYou";
	}
	
	@RequestMapping(path="/thankYou", method=RequestMethod.GET)
	public String displayThankYou() {
		return "checkingApplication/thankYou";
	}
}
