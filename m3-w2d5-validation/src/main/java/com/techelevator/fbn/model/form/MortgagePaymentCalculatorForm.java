package com.techelevator.fbn.model.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public class MortgagePaymentCalculatorForm {

	@Min(1)
	private int loanAmount;
	@NotNull
	private int loanTerm;
	@Min(0)
	@Max(20)
	private double interestRate;
	
	public int getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getLoanTerm() {
		return loanTerm;
	}
	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}
	public double getRate() {
		return interestRate;
	}
	public void setRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
