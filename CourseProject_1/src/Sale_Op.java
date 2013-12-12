//LOOK AT ME!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//We have an empty warehouse, with the (alarm line) +(minimal price)+( recommended price) not set.
//So there're still sth i can't test.


import java.math.BigDecimal;
import java.util.Scanner;

public class Sale_Op
{
	public static Salesman main(Salesman salesman)
	{
		while (true)
		{
			System.out.printf("\nWelcome %s!\nWhat do you want to do?\n",
					salesman.getName());
			ShowChoices();

			while (true)
			{
				int mainChoice =ioPak.getInt("Your choice:", 1, 4);
				
				if (mainChoice == 1)
				{
					Calculator();
					break;

				}
				if (mainChoice == 2)
				{
					ShowAccount(salesman);
					break;
				}
				if (mainChoice == 3)
				{
					MakeDeal(salesman);
					break;
				}
				if (mainChoice == 4)
				{
					setPasswordInMain();
					break;
				}
				else
				{
					System.out
							.println("Curiosity kill a cat!\nPlease enter 1,2,3 here:");
				}
			}
			System.out
					.println("\nWould you like to:\n1.Return to My Account Menu"
							+ "\n2.Exit the programme");
			if (ioPak.getInt("Please enter your choice here:", 1, 2) == 2)
			{
				break;
			}
		}// end Big Big While
		return salesman;
	}// end main

	public static void ShowChoices()
	{
		System.out
				.printf("1.\tCalculator\t(Do calculations to see if it's a worthy deal!)"
						+ "\n2.\tSee my account\t(Check your own performance these days!)"
						+ "\n3.\tGo Selling!\t(Make deals and add credits to your profile!)"
						+ "\n4.\tChange my password\t(Change for a more secure password.)\n");
	}

	public static void Calculator()
	{
		System.out
				.println("\nYou are now using: Calculator"
						+ "\nCould you tell me the product you want to do the calculations with?\n"
						+ "1.IPAD2\n2.IPAD3\n3.IPHONE4\n4.IPHONE4S\n5.IPHONE5\n6.IPHONE5S");
		int calProduct;
		
			calProduct = ioPak.getInt("Your choice:",1,6);

		System.out.println("\nGood job!How much will you sell it?");
		BigDecimal calPrice;
			calPrice =ioPak.getBD("Please enter the price:", 0);

		System.out.println("Then,how many of it?");
		int calNum;
		
			calNum = ioPak.getInt("Please enter an integer:", 0,Data.getStorageAmount(calProduct));

		System.out
				.println("\nDo you want to calculate the\n1.PRICE\n2.PROFIT\n");

		// Choice One(Calculator) has two functions!Here are two!
		while (true)
		{// For Price
			int calChoice = ioPak.getInt("Your choice:", 1, 2);
			if (calChoice == 1)
			{
				System.out.printf("The total price is:%.2f\n",
						calPrice.multiply(new BigDecimal("" + calNum)));

				break;
			}
			if (calChoice == 2)
			{// For Profit
				BigDecimal profit = Data.getBasePrice(calProduct).multiply(
						new BigDecimal("" + calNum));
				System.out.printf("\nThe total profit is %.2f\n", profit);
				if (Data.getAlarmPrice().compareTo(profit) == -1)
				{
					System.out.println("\nThe profit is too low!\n"
							+ "Please consider it carefully!");
				}
				break;
			}
			else
			{
				System.out
						.println("\nEnter 1 (for Price) or 2 (for Profit) please:");
			}

		}
	}

	public static Salesman ShowAccount(Salesman salesman)
	{
		System.out.println("\nYou are now viewing your account.\n"
				+ "Have you work well these days?Check!");
		System.out.printf("Account ID:\t%d\n" + "Name:\t\t%s\n"
				+ "Sales Amount:\t%.2f\n" + "Sales Profit:\t%.2f\n",
				salesman.getAccountID(), salesman.getName(),
				salesman.getSale(), salesman.getSaleProfit());
		return salesman;
	}

	public static Salesman MakeDeal(Salesman salesman)

	{
		Scanner input=new Scanner(System.in);
		System.out.println("\nYou are now ready to sell something!\n"
				+ "Here is our products and their amount left in our store:\n"
				+ "||Name||\t||Amount||\t||Minimal Price||\t||Recommended Price||\n");
		System.out
				.printf("1.IPAD2:\t%d\t%.2f\n2.IPAD3:\t%d\t%.2f\t\n3.IPHONE4:\t%d\t%.2f\n4.IPHONE4S:\t%d\t%.2f\n5.IPHONE5:\t%d\t%.2f\n6.IPHONE5S:\t%d\t%.2f\n",
						+Data.getStorageAmount(Money.IPAD2),
						Data.getBasePrice(Money.IPAD2),
						Data.getStorageAmount(Money.IPAD3),
						Data.getBasePrice(Money.IPAD3),
						Data.getStorageAmount(Money.IPHONE4),
						Data.getBasePrice(Money.IPHONE4),
						Data.getStorageAmount(Money.IPHONE4S),
						Data.getBasePrice(Money.IPHONE4S),
						Data.getStorageAmount(Money.IPHONE5),
						Data.getBasePrice(Money.IPHONE5),
						Data.getStorageAmount(Money.IPHONE5S),
						Data.getBasePrice(Money.IPHONE5S));
		// Print out all the products & their information!
		System.out.println("\nSo, which product do you want to sell?");
		int productChoice = ioPak.getInt("Please enter an integer here:", 1, 6);
		
		BigDecimal productPrice = ioPak.getBD("Please enter the price here:", 0);

		System.out.println("How many of it?");
		int productNum;
			productNum = ioPak.getInt("Please enter the number here:", 0, Data.getStorageAmount(productChoice));

		BigDecimal totalPrice = productPrice.multiply(new BigDecimal(""
				+ productNum));
		BigDecimal totalProfit = totalPrice.subtract(Data.getBasePrice(
				productChoice).multiply(new BigDecimal("" + productNum)));
		String judge = "above";
		switch (totalProfit.compareTo(Data.getAlarmPrice()))
		{
		case 1:
			judge = "ABOVE";
			break;
		case 0:
			judge = "EXACTLY EQUAL";
			break;
		case -1:
			judge = "BELOW";
			break;
		}
		System.out.printf("The total price is %.2f"
				+ "\nThe profit is %s the alarm line.\n", totalPrice, judge);

		System.out
				.println("\nNow,please enter these information from the customer:\n"
						+ "What about the address?\nPlease enter here:");
		String address = input.nextLine();
		System.out.println("Then the telephone number.\nPlease enter it here:");
		String tele = input.nextLine();
		// Now that we get all the information,let's print it out!
		while (true)
		{
			System.out.printf("\nSale confirmation:\n"
					+ "ID of the employee:\t\t\t%d\n" + "Product ID:\t\t\t\t%d\n"
					+ "Amount of the product:\t\t\t%d\n" + "Total price:\t\t\t\t%.2f\n"
					+ "Total profit:\t\t\t\t%.2f\n" + "Address:\t\t\t\t%s\n"
					+ "Telephone number:\t\t\t%s\n"
					+ "In comparison to the alarming rate:\t%s\n",
					salesman.getAccountID(), productChoice, productNum,
					totalPrice, totalProfit, address, tele, judge);
			// This's where that lacks a
			// method!!!!!!!!!!!!!!!!!!!!(Product ID!!!)Perhaps???

			System.out
					.println("Confirm this order?\nPlease enter yes or no here:");
			String confirm = input.nextLine();
			if (confirm.contains("yes"))
			{
				System.out.println("Deal accomplished!");
				Data.changeStorageAmount(productChoice, -productNum);
				Data.changeCurrentFunds(totalPrice);
				salesman.changeSaleAmount(totalPrice);
				salesman.changeSaleProfit(totalProfit);
				if (judge == "below")
				{
					salesman.changeAlarmDegree(Data.getAlarmPrice().subtract(
							totalProfit));
				}
				System.out
						.printf("\nYour total selling amount:\t\t%.2f\n"
								+ "The profit you made:\t\t\t%.2f\n"
								+ "The degree you have gone below the alarm price:\t%.2f\n"
								+ "The remaining amount of the product:\t\t%d\n",
								salesman.getSale(), salesman.getSaleProfit(),
								salesman.getAlarmDegree(),
								Data.getStorageAmount(productChoice));

				break;
			}
			if (confirm.contains("no"))
			{
				System.out.println("\nNo deal accomplished.\n"
						+ "Maybe you are right! Think twice before doing!");
				break;
			}
			else
			{
				System.out.println("Error.Let's see the order again!");
			}
		}
		return salesman;
	}

	public static void setPasswordInMain()
	{
		System.out.println("\nNow you are setting the password!");
		ioPak.setConPD("account password");
	}
}// end class

