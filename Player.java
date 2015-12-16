import java.text.NumberFormat;
import java.util.ArrayList;

public class Player
{
	private String name;
	private double cash;
	private ArrayList<Loan> playerLoans;
	private ArrayList<House> currentHouses;
	private int housesBought;
	private int housesSold;

	public Player()
	{
		name = "Player One";
		cash = 100000;
		playerLoans = new ArrayList<>();
		currentHouses = new ArrayList<>();
		housesBought = 0;
		housesSold = 0;
	}
	
	public Player(String name)
	{
		name = name;
		cash = 100000;
		playerLoans = new ArrayList<>();
		currentHouses = new ArrayList<>();
		housesBought = 0;
		housesSold = 0;
	}	

	showLoans()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double loanTotal = 0.0;
		double paymentTotal = 0.0;
		for (int i = 0; i < playerLoans.size(); i++)
		{
			playerLoans[i].showLoan()
			loanTotal += playerLoans[i].getPrinciple();
			paymentTotal += playerLoans[i].getPayment();
		}
		String loanString = currency.format(loanTotal);
		String paymentString = currency.format(paymentTotal);
		System.out.println("Total amount borrowed: " + loanString + ".\n");
		System.out.println("Total weekly payments: " + paymentString + ".\n\n");
	}

	showStatus()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String cashString = currency.format(cash);
		System.out.println(name + " has " + cashString + "\n");
		System.out.println("Loan status:\n");
		showLoans();
		System.out.println("Houses currently owned:\n");
		for (int i = 0; i < currentHouses.size(); i++)
		{
			currentHouses[i].showStatus();
		}
		System.out.println("\n");
	}

	showEndStats()
	{
		System.out.println("You bought " + housesBought + " houses and sold " + housesSold + " of them.\n");
		//would be nice to add value of everything and do an if statement for You're in the green/red... need to add value to House class.
	}
	
	addCash(amount)
	{
		cash += amount;
	}
	
	subtractCash(amount)
	{
		cash -= amount;
	}
	
	double getCash()
	{
		return cash;
	}
	
	makeWeeklyLoanPayments(Scanner sc)
	{
		for (int i = 0; i < playerLoans.size(); i++)
		{
			double payment = playerLoans[i].getPayment();
			//subtract payment from cash
			cash -= payment;
			//make payment on loan
			double refund = playerLoans[i].makePayment(sc, payment);
			//issue refund
			cash += refund;
			//delete loan if paid off
			if (playerLoans[i].getPrinciple() = 0)
			{
				playerLoans.remove(i);
				i--;
			}
		}
	}
}
