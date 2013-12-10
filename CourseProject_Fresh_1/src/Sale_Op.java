import java.math.BigDecimal;
import java.util.Scanner;

public class Sale_Op
{
	public static Salesman main(Salesman salesman)
	{
		Scanner input = new Scanner(System.in);
		while (true)
		{
			/*System.out.printf("Welcome %s!\nWhat do you want to do?\n",
					salesman.getName());*/
			ioPak.printf("Welcome %s!\nWhat do you want to do?\n",
					salesman.getName());
			ShowChoices();

			while (true)
			{
				int mainChoice = input.nextInt();
				input.nextLine();

				// Choice One Starts!!!!!
				if (mainChoice == 1)
				{
					// Two Functions Ends!
					Calculator();
					break;

				}// Choice One(Calculator) Ends.

				// Then Choice Two(Viewing my account) follows~~
				if (mainChoice == 2)
				{
					ShowAccount(salesman);
					break;
				}// Choice Two(Viewing my account) ends this quick!

				// Then comes Choice Three(Selling goods)!
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
			}// end Big while

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
		/*System.out*/
		ioPak
				.printf("1.\tCalculator\t(Do calculations to see if it's a worthy deal!)"
						+ "\n2.\tSee my account\t(Check your own performance these days!)"
						+ "\n3.\tGo Selling!\t(Make deals and add credits to your profile!)"
						+ "\n4.\tChange my password\t(Change for a more secure password.)"
						+ "\nYour choice:");
	}

	public static void Calculator()
	{
		Scanner input = new Scanner(System.in);
		System.out
				.println("\nYou are now using: Calculator"
						+ "\nCould you tell me the product you want to do the calculations with?\n"
						+ "1.IPAD2\n2.IPAD3\n3.IPHONE4\n4.IPHONE4S\n5.IPHONE5\n6.IPHONE5S"
						+ "\nYour choice:");
		int calProduct;
		// calProductChoice(input.nextInt());
		while (true)
		{
			calProduct = input.nextInt();
			if (calProduct >= 1 && calProduct <= 6)
			{
				break;
			}
			else
			{
				System.out.println("\nProduct with this ID does not exist!\n"
						+ "Please enter the Product ID again:");
			}
		}

		System.out.println("\nGood job!How much will you sell it?"
				+ "\nPlease enter the price:");
		BigDecimal calPrice;
		while (true)// tiny While again
		{
			calPrice = input.nextBigDecimal();
			if (calPrice.compareTo(new BigDecimal("0")) == 1)
			{
				break;
			}
			else
			{
				System.out.println("The price should be above zero!\n"
						+ "Would you enter the price again:");
			}
		}// End tiny While

		System.out.println("Then,how many of it?"
				+ "\nPlease enter an integer:");
		int calNum;
		while (true)// tiny While
		{
			calNum = input.nextInt();
			if (calNum >= 0)
			{
				break;
			}
			else
			{
				System.out
						.println("\nThe amount of the goods is NOT supposed to be below zero!\n"
								+ "Would you please enter it again:");
			}
		}// End tiny While

		System.out
				.println("\nDo you want to calculate the\n1.PRICE\n2.PROFIT\n"
						+ "Your choice:");

		// Choice One(Calculator) has two functions!Here are two!
		while (true)
		{// For Price
			int calChoice = input.nextInt();
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
		/*
		 * 		System.out.println("\nYou are now viewing your account.\n"
				+ "Have you work well these days?Check!");
		System.out.printf("Account ID:\t%d\n" + "Name:\t\t%s\n"
				+ "Sales Amount:\t%.2f\n" + "Sales Profit:\t%.2f\n",
				salesman.getAccountID(), salesman.getName(),
				salesman.getSale(), salesman.getSaleProfit());
		 */
		ioPak.println("\nYou are now viewing your account.\n"
				+ "Have you work well these days?Check!");
		ioPak.printf("Account ID:\t%d\n" + "Name:\t\t%s\n"
				+ "Sales Amount:\t%.2f\n" + "Sales Profit:\t%.2f\n",
				salesman.getAccountID(), salesman.getName(),
				salesman.getSale(), salesman.getSaleProfit());
		return salesman;
	}

	public static Salesman MakeDeal(Salesman salesman)

	{
		Scanner input = new Scanner(System.in);
		System.out.println("\nYou are now ready to sell something!\n"
				+ "Here is our products and their amount left in our store:\n"
				+ "||Name||\t||Amount||\t||Minimal Price||\n");
		System.out
				.printf("1.IPAD2:\t%d%f\n2.IPAD3:%d%f\t\n3.IPHONE4:\t%d%f\n4.IPHONE4S:\t%d%f\n5.IPHONE5:\t%d%f\n6.IPHONE5S:\t%d%f\n",
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
		System.out.println("\nSo, which product do you want to sell?"
				+ "Please enter an integer here:");
		int productChoice;
		while (true)// Likewise,here's a tiny While
		{
			productChoice = input.nextInt();
			if (productChoice >= 1 && productChoice <= 6)
			{
				break;
			}
			else
			{
				System.out.println("\nProduct with this ID does not exist!\n"
						+ "Please enter the Product ID again:");
			}
		}

		System.out.println("\nPlease enter the price here:");
		BigDecimal productPrice;
		while (true)// tiny While again
		{
			productPrice = input.nextBigDecimal();
			if (productPrice.compareTo(new BigDecimal("0")) == 1)
			{
				break;
			}
			else
			{
				System.out.println("\nThe price should be above zero!\n"
						+ "Would you enter the price again:");
			}
		}

		System.out.println("How many of it?\nPlease enter the number here:");
		int productNum;
		while (true)// tiny While
		{
			productNum = input.nextInt();
			if (productNum >= 0)
			{
				break;
			}
			else
			{
				System.out
						.println("\nThe amount of the goods is NOT supposed to be below zero!\n"
								+ "Would you please enter it again:");
			}
		}

		BigDecimal totalPrice = productPrice.multiply(new BigDecimal(""
				+ productNum));
		BigDecimal totalProfit = totalPrice.subtract(Data.getBasePrice(
				productChoice).multiply(new BigDecimal("" + productNum)));
		String judge = "above";
		switch (totalProfit.compareTo(Data.getAlarmPrice()))
		{
		case 1:
			judge = "above";
			break;
		case 0:
			judge = "exactly equal";
			break;
		case -1:
			judge = "below";
			break;
		}
		System.out.printf("The total price is %f"
				+ "\nThe profit is %s the alarm line."
				+ "Do you want to continue?", totalPrice, judge);

		System.out
				.println("Now,please enter these information from the customer:"
						+ "What about the address?\nPlease enter here:");
		String address = input.nextLine();
		System.out.println("Then the telephone number.Please enter it here:");
		String tele = input.nextLine();

		// Now that we get all the information,let's print it out!
		while (true)
		{
			System.out.printf("\nSale confirmation:\n"
					+ "ID of the employee:\t%d\n" + "Product ID:\t%d\n"
					+ "Amount of the product:\t%d\n" + "Total price:\t%f\n"
					+ "Total profit:\t%f\n" + "Address:\t%s\n"
					+ "Telephone number:\t%s\n"
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
						.printf("\nYour total selling amount:\t%.2f\n,"
								+ "The profit you made:\t%.2f\n"
								+ "The degree you have gone below the alarm price:\t%.2f\n"
								+ "The remaining amount of the product:\t%d\n",
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
		Scanner input = new Scanner(System.in);
		System.out.println("\nNow you are setting the password!");
		ioPak.setConPD("account password");
	}
}// end class

