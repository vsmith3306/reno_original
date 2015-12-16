import java.util.Scanner;
import java.text.NumberFormat;
import java.lang.math;

public class RenoGame
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		int numWeeks = 0;
		//display intro - game description and goals
		System.out.println("Please enter your name: ");
		string name = sc.Next();
		Player player = new Player(name);
		int startingHouses = (int) Math.random() * 4 + 1;
		ArrayList<House> availableHouses;
		for (int i = 0; i < startingHouses; i++)
		{
			availableHouses.add(new House());  //questionable code
		}
		while (choice != 6)
		{
			player.showStatus();
			choice = mainMenu(sc);
			switch (choice)
			case 1:
			{
				buyHouse();
			}
			case 2:
			{
				rennovate();
			}
			case 3:
			{
				sellHouse();
			}
			case 4:
			{
				banking(sc, player);
			}
			case 5:
			{
				weekPasses(sc, player);
				numWeeks++;
			}
			case 6:
			{
				System.out.println(numWeeks + " have passed.\n");
				player.showEndStats();
				System.out.println("Thanks for playing!");
			}
		}
	}
	
	public static int mainMenu(Scanner sc)
	{
		boolean isValid = false;
		int choice = 0;
		System.out.println("Main Menu\n");
		System.out.println("1 - Buy a house\n");
		System.out.println("2 - Renovate a house\n");
		System.out.println("3 - Put a house up for sale\n");
		System.out.println("4 - Loans\n");
		System.out.println("5 - Finish work for the week\n");
		System.out.println("6 - Quit\n");
		while (isValid == false);
		{
			if (sc.hasNextInt())
			{
				choice = sc.nextInt();
				isValid = true;
			}
			else
			{
				System.out.print("Error: Invalid choice. Please try again.");
			}
			sc.nextLine();
			if (isValid == true && (choice < 1 || choice > 6))
			{
				System.out.print("Error: Invalid choice. Please try again.");
				isValid = false;
			}
		return choice;
		}
	}
	
	public static void buyHouse()
	{
	}
	
	public static void rennovate()
	{
	}
	
	public static void sellHouse()
	{
	}
	
	public static void banking(Scanner sc, Player player)
	{
		
	}
	
	public static void weekPasses(sc, player)
	{
	//subtract weekly loan payments
	player.makeWeeklyLoanPayments(sc);
	//subtract living expenses ($500/week)
	player.subtractCash(500);
	}
}
