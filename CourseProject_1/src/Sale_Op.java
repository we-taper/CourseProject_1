

import java.math.BigDecimal;

public class Sale_Op
{
	public static Salesman main(Salesman salesman)
	{
		while (true)
		{
			ioPak.printf("Welcome %s!\nWhat do you want to do?\n",
					salesman.getName());
			ShowChoices();

			while (true)
			{
				int mainChoice = ioPak.getInt("Your choice:", 1, 4);

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
		ioPak.printf("1.Calculator\n%20s" + "\n2.See my account\n%20s"
				+ "\n3.Go Selling!\n%20s" + "\n4.Change my password\n%20s",
				"(Do calculations to see if it's a worthy deal!)",
				"(Check your own performance these days!)",
				"(Make deals and add credits to your profile!)",
				"(Change for a more secure password.)\n");
	}

	public static void Calculator()
	{
		ioPak.println("You are now using: Calculator"
				+ "\nCould you tell me the product you want to do the calculations with?\n"
				+ "1.IPAD2\n2.IPAD3\n3.IPHONE4\n4.IPHONE4S\n5.IPHONE5\n6.IPHONE5S");
		int calProduct;

		calProduct = ioPak.getInt("Your choice:", 1, 6);

		ioPak.println("Good job!How much will you sell it?");
		BigDecimal calPrice;
		calPrice = ioPak.getBD("Please enter the price:", 0);

		ioPak.println("Then,how many of it?");
		int calNum;

		calNum = ioPak.getInt("Please enter an integer:", 0,
				Data.getStorageAmount(calProduct));

		ioPak.println("Do you want to calculate the\n1.PRICE\n2.PROFIT\n");

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
				ioPak.printf("The total profit is %.2f\n", profit);
				if (Data.getAlarmPrice(calProduct).compareTo(profit) == -1)
				{
					ioPak.println("The profit is too low!\n"
							+ "Please consider it carefully!");
				}
				break;
			}
			else
			{
				ioPak.println("Enter 1 (for Price) or 2 (for Profit) please:");
			}

		}
	}

	public static Salesman ShowAccount(Salesman salesman)
	{System.out.println("You are now viewing your account.\n"
	+"Have you work well these days?Check!");
		ioPak.printTable(20, "!!","Account ID:!!%d\n"
	+"Name:!!%s\n"+ "Sales Amount:!!%.2f\n"+ 
				"Sales Profit:!!%.2f\n"
				+ "Alarming sales made:!!%.2f",
				salesman.getAccountID(), 
				salesman.getName(),salesman.getSale(), salesman.getSaleProfit(),salesman.getAlarmDegree());
		return salesman;
	}

	public static Salesman MakeDeal(Salesman salesman)

	{
		
		System.out.print(
				"You are now ready to sell something!\n"
						+ "Here is our products and their amount left in our store:\n");
						ioPak.printTable(17,"!!", " Name!!Amount!!Minimal Price!!Recommended Price\n"
						+ "1.IPAD2:!!%d!!%.2f\n2.IPAD3:!!%d!!%.2f\n"
						+ "3.IPHONE4:!!%d!!%.2f\n4.IPHONE4S:!!%d!!%.2f\n"
						+ "5.IPHONE5:!!%d!!%.2f\n6.IPHONE5S:!!%d!!%.2f\n",
				Data.getStorageAmount(Money.IPAD2),
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
		ioPak.println("So, which product do you want to sell?");
		int productChoice = ioPak.getInt("Please enter an integer here:", 1, 6);

		BigDecimal productPrice = ioPak
				.getBD("Please enter the price here:", 0);

		ioPak.println("How many of it?");
		int productNum;
		productNum = ioPak.getInt("Please enter the number here:", 0,
				Data.getStorageAmount(productChoice));

		BigDecimal totalPrice = productPrice.multiply(new BigDecimal(""
				+ productNum));
		
		
		BigDecimal totalProfit = totalPrice.subtract((Data.getBasePrice(
				productChoice)).multiply(new BigDecimal("" + productNum)));
		String judge = "above";
		switch (totalProfit.compareTo(Data.getAlarmPrice(productChoice)))
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
				+ "\nThe profit is %.2f,%s the alarm line.\n", totalPrice,totalProfit, judge);

		ioPak.println("Now,please enter these information from the customer:");
		System.out.println("What about the address?\n"+"Please enter here:");
		String address = ioPak.nextLine();
		System.out.println("Then the telephone number.\nPlease enter it here:");
		String tele = ioPak.nextLine();
		// Now that we get all the information,let's print it out!
		while (true)
		{System.out.print("\nSale confirmation:\n");
			ioPak.printTable(30,"!!",
					"ID of the employee:!!%d\n"
					+ "Product ID:!!%d\n"
					+ "Amount of the product:!!%d\n"
					+ "Total price:!!%.2f\n"
					+ "Total profit:!!%.2f\n" + "Address:!!%s\n"
					+ "Telephone number:!!%s\n"
					+ "Compared to alarming rate:!!%s\n",
					salesman.getAccountID(), productChoice, productNum,
					totalPrice, totalProfit, address, tele, judge);

			ioPak.println("Confirm this order?");
			System.out.println("Please enter yes or no here:");
			String confirm = ioPak.nextLine();
			if (confirm.contains("yes"))
			{
				ioPak.println("Deal accomplished!");
				Data.changeStorageAmount(productChoice, -productNum);
				Data.changeCurrentFunds(totalPrice);
				salesman.changeSaleAmount(totalPrice);
				salesman.changeSaleProfit(totalProfit);
				if (judge.equals("BELOW"))
				{
					salesman.changeAlarmDegree(Data.getAlarmPrice(productChoice).subtract(
							totalProfit));
				}
				ioPak.printTable(40,
						"Total sales amount:%.2f"
				+ "The profit you made:%.2f"
								+"Alarming sales made:%.2f"
				+"Products remained:%d",salesman.getSale()
				,salesman.getSaleProfit()
				,salesman.getAlarmDegree()
				,Data.getStorageAmount(productChoice));
				break;
			}
			if (confirm.contains("no"))
			{
				ioPak.println("No deal accomplished.\n"
						+ "Maybe you are right! Think twice before doing!");
				break;
			}
			else
			{
				ioPak.println("Error.Let's see the order again!");
			}
		}
		return salesman;
	}

	public static void setPasswordInMain()
	{
		ioPak.println("Now you are setting the password!");
		ioPak.setConPD("account password");
	}
}// end class

