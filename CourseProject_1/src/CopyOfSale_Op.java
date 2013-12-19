
import java.math.BigDecimal;
import java.util.Scanner;

public class CopyOfSale_Op
{
	public static Salesman main(Salesman salesman)
	{
		while (true)
		{
			ioPak.printTable(25, "!!", "Welcome %s!\n" + "NOTICE:\n"
					+ "Star Salesman For Sales:!!Mr./Ms. %s\n"
					+ "Star Salesman For Profit:!!Mr./Ms. %s\n",
					salesman.getName(), Data.getStarNameForSales(),
					Data.getStarNameForProfit());
			ShowChoices();

			while (true)
			{
				int mainChoice = ioPak.getInt("Your choice:", 1, 5);

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
					setPasswordInMain(salesman);
					break;
				}
				if (mainChoice == 5)
				{
					return salesman;
				}
			}
			System.out
					.println("Would you like to:\n1.Return to My Account Menu"
							+ "\n2.Log out!");
			if (ioPak.getInt("Please enter your choice here:", 1, 2) == 2)
			{
				break;
			}
		}// end Big Big While
		return salesman;
	}// end main

	public static void ShowChoices()
	{
		ioPak.printf("SALESMAN MAIN MENU:\n" + "1.Calculator\n%20s"
				+ "\n2.See my account\n%20s" + "\n3.Go Selling!\n%20s"
				+ "\n4.Change my password\n%20s" + "\n5.Log out!\n%20s",
				"(Do calculations to see if it's a worthy deal!)",
				"(Check your own performance these days!)",
				"(Make deals and add credits to your profile!)",
				"(Change for a more secure password.)",
				"(Return to the Main Menu.)");
	}

	public static void Calculator()
	{
		boolean falseToExit = true;
		ioPak.printf("CALCULATOR"
				+ "\nOn what product you want to do the calculations?\n"
				+ "1.IPAD2\n2.IPAD3\n3.IPHONE4\n4.IPHONE4S\n5.IPHONE5\n6.IPHONE5S\nPress 7 to Quit Calculator");
		int calProduct;

		calProduct = ioPak.getInt("Your choice:", 1, 7);

		if (calProduct != 7)
		{
			ioPak.printf("Good job!How much will you sell it?");
			BigDecimal calPrice;
			calPrice = ioPak.getBD("Please enter the price:", 0);

			ioPak.printf("Then,how many of it?");
			int calNum;

			calNum = ioPak.getInt("Please enter an integer:", 0,
					Data.getStorageAmount(calProduct));

			ioPak.printf("Do you want to calculate the\n1.PRICE\n2.PROFIT\nPress 3 to exit.");

			// Choice One(Calculator) has two functions!Here are two!

			while (falseToExit == true)
			{// For Price
				int calChoice = ioPak.getInt("Your choice:", 1, 3);
				if (calChoice == 3)
				{
					falseToExit = false;
				}
				if (calChoice == 1)
				{
					System.out.printf("The total price is:%.2f\n",
							calPrice.multiply(new BigDecimal("" + calNum)));

					break;
				}
				if (calChoice == 2)
				{// For Profit
					BigDecimal profit = Data.getMinPrice(calProduct).multiply(
							new BigDecimal("" + calNum));
					ioPak.printf("The total profit is %.2f", profit);
					if (Data.getAlarmPrice(calProduct).compareTo(profit) == -1)
					{
						ioPak.printf("The profit is too low!\n"
								+ "Please consider it carefully!");
					}
					break;
				}
			}// End While
		}// End If
	}

	public static Salesman ShowAccount(Salesman salesman)
	{
		System.out.println("You are now viewing your account.\n"
				+ "Have you work well these days?Check!");
		ioPak.printTable(20, "!!", "Account ID:!!%d\n" + "Name:!!%s\n"
				+ "Sales Amount:!!%.2f\n" + "Sales Profit:!!%.2f\n"
				+ "Alarming sales made:!!%.2f", salesman.getAccountID(),
				salesman.getName(), salesman.getSale(),
				salesman.getSaleProfit(), salesman.getAlarmDegree());
		return salesman;
	}

	public static Salesman MakeDeal(Salesman salesman)

	{
		Scanner input = new Scanner(System.in);
		System.out.print("MAKING DEALS!\n"
				+ "Here is our products and their amount left in our store:\n");
		ioPak.printTable(17, "!!",
				" Name!!Amount!!Minimal Price!!Suggested Price\n"
						+ "1.IPAD2:!!%d!!%.2f!!%.2f\n"
						+ "2.IPAD3:!!%d!!%.2f!!%.2f\n"
						+ "3.IPHONE4:!!%d!!%.2f!!%.2f\n"
						+ "4.IPHONE4S:!!%d!!%.2f!!%.2f\n"
						+ "5.IPHONE5:!!%d!!%.2f!!%.2f\n"
						+ "6.IPHONE5S:!!%d!!%.2f!!%.2f",
				Data.getStorageAmount(Money.IPAD2),
				Data.getMinPrice(Money.IPAD2), Data.getSugPrice(Money.IPAD2),
				Data.getStorageAmount(Money.IPAD3),
				Data.getMinPrice(Money.IPAD3), Data.getSugPrice(Money.IPAD3),
				Data.getStorageAmount(Money.IPHONE4),
				Data.getMinPrice(Money.IPHONE4),
				Data.getSugPrice(Money.IPHONE4),
				Data.getStorageAmount(Money.IPHONE4S),
				Data.getMinPrice(Money.IPHONE4S),
				Data.getSugPrice(Money.IPHONE4S),
				Data.getStorageAmount(Money.IPHONE5),
				Data.getMinPrice(Money.IPHONE5),
				Data.getSugPrice(Money.IPHONE5),
				Data.getStorageAmount(Money.IPHONE5S),
				Data.getMinPrice(Money.IPHONE5S),
				Data.getSugPrice(Money.IPHONE5S));
		// Print out all the products & their information!
		ioPak.printf("So, which product do you want to sell?\n");
		int productChoice = ioPak.getInt(
				"(Press 0 to exit)Please enter an integer here:", 0, 6);
		if (productChoice != 0)
		{
			BigDecimal productPrice = ioPak.getBD(
					"(Press 0 to exit)Please enter the price here:", 0);
			if (productPrice.compareTo(new BigDecimal("0")) != 0)
			{

				ioPak.printf("How many of it?");
				int productNum;
				productNum = ioPak.getInt("Please enter the number here:", 0,
						Data.getStorageAmount(productChoice));

				BigDecimal totalPrice = productPrice.multiply(new BigDecimal(""
						+ productNum));

				BigDecimal totalProfit = totalPrice.subtract((Data
						.getMinPrice(productChoice)).multiply(new BigDecimal(""
						+ productNum)));
				String judge = "above";
				switch (productPrice.compareTo(Data
						.getAlarmPrice(productChoice)))
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
				ioPak.printf("The total price is %.2f"
						+ "\nThe profit is %.2f,%s the alarm line.",
						totalPrice, totalProfit, judge);

				ioPak.printf("Now,please enter these information from the customer:");
				System.out.println("What about the address?\n"
						+ "Please enter here:");
				String address = ioPak.nextLine();
				System.out
						.println("Then the telephone number.\nPlease enter it here:");
				String tele = ioPak.nextLine();
				// Now that we get all the information,let's print it out!
				while (true)
				{
					System.out.print("\nSale confirmation:\n");
					ioPak.printTable(30, "!!", "ID of the employee:!!%d\n"
							+ "Product ID:!!%d\n"
							+ "Amount of the product:!!%d\n"
							+ "Total price:!!%.2f\n" + "Total profit:!!%.2f\n"
							+ "Address:!!%s\n" + "Telephone number:!!%s\n"
							+ "Compared to alarming rate:!!%s",
							salesman.getAccountID(), productChoice, productNum,
							totalPrice, totalProfit, address, tele, judge);

					ioPak.printf("Confirm this order?");
					System.out.println("Please enter yes or no here:");
					String confirm = ioPak.nextLine();
					if (confirm.contains("yes"))
					{
						ioPak.printf("Deal accomplished!");
						Data.changeStorageAmount(productChoice, -productNum);
						Data.changeCurrentFunds(totalPrice);
						salesman.changeSaleAmount(totalPrice);
						salesman.changeSaleProfit(totalProfit);
						if (judge.equals("BELOW"))
						{
							salesman.changeAlarmDegree((Data
									.getAlarmPrice(productChoice)
									.subtract(productPrice))
									.multiply(new BigDecimal("" + productNum)));
						}
						ioPak.printTable(23, "!!",
								"Total sales amount:!!%.2f\n"
										+ "The profit you made:!!%.2f\n"
										+ "Alarming sales made:!!%.2f\n"
										+ "Products remained:!!%d",
								salesman.getSale(), salesman.getSaleProfit(),
								salesman.getAlarmDegree(),
								Data.getStorageAmount(productChoice));
						break;
					}
					if (confirm.contains("no"))
					{
						ioPak.printf("No deal accomplished.\n"
								+ "Maybe you are right! Think twice before doing!");
						break;
					}
					else
					{
						ioPak.printf("Error.Let's see the order again!");
					}
				}
			}
		}

		return salesman;
	}

	public static void setPasswordInMain(Salesman salesman)
	{
		ioPak.printf("Now you are setting the password!");
		System.out.printf("Please type your current password:");
		String CurrentPassword = ioPak.getConPD();
		while (!CurrentPassword.equals(salesman.getPassword()))
		{
			ioPak.printf(false, false, 0, "The password you gave is incorrect.");
			System.out.printf("Please try again:");
			CurrentPassword = ioPak.getConPD();
		}
		ioPak.printf("Please set new password.");
		String pd = ioPak.setConPD(salesman.getName());
		salesman.setPassword(pd);
	}
}// end class

