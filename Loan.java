/*
Loan class for RennoGame

-Interest rate is random (.25% - 8%)
-Number of payments is set to 1560: 30 year loan with 52 weekly payments.
-No set methods are available as player will need to accept/decline the loan offered.

*/

import java.lang.math;
import java.text.NumberFormat;
import java.util.Scanner;

public class Loan
{
	private double principle;
	private double payment;
	private double interest;
	
	public Loan()
	{
		principle = 0;
		payment = 0;
		interest = Math.random() * 7.75 + 0.25;
	}
	
	//creates a Loan with a principle somewhere between 0 and the requested amount.
	//if the principle is higher than the requested amount, a higher interest rate is generated
	//if the principle is lower than the requested amount, a lower interest rate is generated
	public Loan(amount)
	{
		principle = Math.random() * amount;
		if (principle > amount)
		{
			interest = Math.random() * 7.75 + 2.25;
		}
		else
		{
			interest = Math.random() * 4.75 + 0.25;
		}
		//used forumla from http://www.wikihow.com/Calculate-Mortgage-Interest
		payment = principle * ((interest*(pow((1+interest),1560)))/(pow(1+interest),1560)-1);
	}

	showLoan()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String principleString = currency.format(principle);
		String paymentString = currency.format(payment);
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(2);
		percent.setMaximumFractionDigits(4);
		String interestString = percent.format(interest);
		System.out.println("Principle remaining: " + principleString + " at an interest rate of " + interestString + ". Weekly payment is: " + paymentString + ".\n\n");
	}
	
	double getPrinciple()
	{
		return principle;
	}
	
	double getPayment()
	{
		return payment;
	}
	
	//intended to be called from Player class and loan is to be removed if principle is zero
	double makePayment(Scanner sc, double amount)
	{
		if (amount > principle)
		{
			double refund = amount - principle;
			principle = 0;
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			String refundString = currency.format(refund);
			System.out.println("Your payment amount was greater than the remaining loan amount.  A refund of " + refundString + " has been issued.\n"
			return refund;
		}
		else if (amount == principle)
		{
			principle = 0;
			System.out.println("Congratulations! You've paid off a loan!\n");
			return 0.0;
		}
		else
		{
			principle -= amount;
			return 0.0;
		}
	}
	
}
