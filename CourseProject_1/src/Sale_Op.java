import java.math.BigDecimal;
import java.util.Scanner;

public class Sale_Op
{
	public static Salesman main(Salesman salesman)
	{
		ioPak.printNextLevel(CS.LEVEL1,CS.LEVEL2, CS.LEVEL_G);
		while (true)
		{
			/*
			  ioPak.printTable(25,CS.LEVEL2,
			 
					"!!", "Welcome %s!\n" + "NOTICE:\n"// TODO ask world of "!!"
					+ "Star Salesman For Sales:!!Mr./Ms. %s\n"
					+ "Star Salesman For Profit:!!Mr./Ms. %s\n",
					salesman.getName(), Data.getStarNameForSales(),
					Data.getStarNameForProfit());
			ioPak.printTable(25,
				"!!", "Welcome s!\n" + "NOTICE:\n"// TODO ask world of "!!"
				+ "Star Salesman For Sales:!!Mr./Ms. s\n"
				+ "Star Salesman For Profit:!!Mr./Ms. s\n"
				);
			*/
			ioPak.printTable(25,CS.LEVEL2,
					"Welcome %s!\n" + "NOTICE:\n"
					+ "Star Salesman For Sales:!!Mr./Ms. %s\n"
					+ "Star Salesman For Profit:!!Mr./Ms. %s",
					salesman.getName(), Data.getStarNameForSales(),
					Data.getStarNameForProfit());
			
			ShowChoices();

			while (true)
			{
				int mainChoice = ioPak.getInt(CS.LEVEL2,"Your choice:", 1, 5);

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
					ioPak.printBackLevel(CS.LEVEL1,CS.LEVEL2, CS.LEVEL_G);
					return salesman;
				}
			}// end while(true)
			ioPak.printf(CS.LEVEL2,"Would you like to:\n"
					+ "1.Show My Account Menu again or,\n"
					+ "2.Log out!");
			if (ioPak.getInt(CS.LEVEL2,
					"Please enter your choice here:", 1, 2) == 2)
			{
				break;
			}
		}// end Big Big While
		ioPak.printBackLevel(CS.LEVEL1,CS.LEVEL2, CS.LEVEL_G);
		return salesman;
	}// end main

	public static void ShowChoices()
	{
		ioPak.printf(CS.LEVEL2,
				"SALESMAN MAIN MENU:\n" 
				+ "1.Calculator\n%20s"
				+ "\n2.See my account\n%20s" 
				+ "\n3.Go Selling!\n%20s"
				+ "\n4.Change my password\n%20s" 
				+ "\n5.Log out!\n%20s",
				"(Do calculations to see if it's a worthy deal!)",
				"(Check your own performance these days!)",
				"(Make deals and add credits to your profile!)",
				"(Change for a more secure password.)",
				"(Return to the Main Menu.)");
	}

	public static void Calculator()
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		boolean falseToExit = true;
		ioPak.printf(CS.LEVEL3,
				"CALCULATOR"
				+ "\nOn what product you want to do the calculations?\n"
				+ "1.IPAD2\n"
				+ "2.IPAD3\n"
				+ "3.IPHONE4\n"
				+ "4.IPHONE4S\n"
				+ "5.IPHONE5\n"
				+ "6.IPHONE5S\n"
				+ "Press 7 to Quit Calculator");
		int calProduct;

		calProduct = ioPak.getInt(CS.LEVEL3,"Your choice:", 1, 7);

		if (calProduct != 7)
		{
			ioPak.printf(CS.LEVEL3,"Good job!How much will you sell it?");
			BigDecimal calPrice;
			calPrice = ioPak.getBD(CS.LEVEL3,"Please enter the price:", 0);

			ioPak.printf(CS.LEVEL3,"Then,how many of it?");
			int calNum;

			calNum = ioPak.getInt(CS.LEVEL3,"Please enter an integer:", 0,
					Data.getStorageAmount(calProduct));

			ioPak.printf(CS.LEVEL3,
					"Do you want to calculate the\n"
					+ "1.PRICE\n"
					+ "2.PROFIT\n"
					+ "Press 3 to exit.");

			// Choice One(Calculator) has two functions!Here are two!

			while (falseToExit == true)
			{// For Price
				int calChoice = ioPak.getInt(CS.LEVEL3,"Your choice:", 1, 3);
				if (calChoice == 3)
				{
					falseToExit = false;
				}
				if (calChoice == 1)
				{
					System.out.printf(CS.level3()+"The total price is:%.2f\n",
							calPrice.multiply(new BigDecimal("" + calNum)));

					break;
				}
				if (calChoice == 2)
				{// For Profit
					BigDecimal profit = Data.getMinPrice(calProduct).multiply(
							new BigDecimal("" + calNum));
					ioPak.printf(CS.LEVEL3,"The total profit is %.2f", profit);
					if (Data.getAlarmPrice(calProduct).compareTo(profit) == -1)
					{
						ioPak.printf(CS.LEVEL3,
								"The profit is too low!\n"
								+ "Please consider it carefully!");
					}
					break;
				}
			}// End While
		}// End If
		ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
	}

	public static Salesman ShowAccount(Salesman salesman)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		ioPak.printf(CS.LEVEL3,
				"You are now viewing your account.\n"
				+ "Have you work well these days?Check!");
		ioPak.printTable(20,CS.LEVEL3,
				/*"!!",*/
				"Account ID:!!%d\n" + "Name:!!%s\n"//TODO ask world
				+ "Sales Amount:!!%.2f\n" + "Sales Profit:!!%.2f\n"
				+ "Alarming sales made:!!%.2f", salesman.getAccountID(),
				salesman.getName(), salesman.getSale(),
				salesman.getSaleProfit(), salesman.getAlarmDegree());
		ioPak.enterATC(CS.LEVEL3);
		ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		return salesman;
	}

	public static Salesman MakeDeal(Salesman salesman)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		@SuppressWarnings({ "unused", "resource" })
		Scanner input = new Scanner(System.in);
		ioPak.printf(CS.LEVEL3,
				"MAKING DEALS!\n"
				+ "Here is our products and their amount left in our store:\n");
		ioPak.printTable(17,CS.LEVEL3,/* "!!",*/
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
		ioPak.printf(CS.LEVEL3,"So, which product do you want to sell?");
		int productChoice = ioPak.getInt(CS.LEVEL3,
				"(Press 0 to exit)Please enter an integer here:", 0, 6);
		if (productChoice != 0)
		{
			BigDecimal productPrice = ioPak.getBD(CS.LEVEL3,
					"(Press 0 to exit)Please enter the price here:", 0);
			if (productPrice.compareTo(new BigDecimal("0")) != 0)
			{

				ioPak.printf(CS.LEVEL3, "How many of it?");
				int productNum;
				productNum = ioPak.getInt(CS.LEVEL3,
						"(Press 0 to exit)Please enter the number here:", 0,
						Data.getStorageAmount(productChoice));
				if (productNum != 0)
				{
					BigDecimal totalPrice = productPrice
							.multiply(new BigDecimal("" + productNum));

					BigDecimal totalProfit = totalPrice.subtract((Data
							.getMinPrice(productChoice))
							.multiply(new BigDecimal("" + productNum)));
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
					ioPak.printf(CS.LEVEL3, "The total price is %.2f"
							+ "\nThe profit is %.2f,%s the alarm line.",
							totalPrice, totalProfit, judge);

					ioPak.printf(CS.LEVEL3,
							"Would you like to enter information of the customer?\n"
									+ "Press 1 for yes or 2 for no.");
					int ifEnterInfo = ioPak.getInt(CS.LEVEL3, "Your choice:",
							1, 2);
					if (ifEnterInfo == 1)
					{
						System.out.printf(CS.level3()
								+ "What about the address?\n"
								+ CS.level3()+"Please enter here:");
						String address = ioPak.nextLine(CS.LEVEL3);
						System.out
								.printf(CS.level3()
										+ "Then the telephone number.\n"
										+CS.level3()+"Please enter it here:");
						String tele = ioPak.nextLine(CS.LEVEL3);// TODO It should be an integer.
						// Now that we get all the information,let's print it
						// out!
						while (true)
						{
							ioPak.printf(CS.LEVEL3, "\nSale confirmation:\n");
							ioPak.printTable(30, CS.LEVEL3, /*"!!",*/
									"ID of the employee:!!%d\n"
											+ "Product ID:!!%d\n"
											+ "Amount of the product:!!%d\n"
											+ "Total price:!!%.2f\n"
											+ "Total profit:!!%.2f\n"
											+ "Address:!!%s\n"
											+ "Telephone number:!!%s\n"
											+ "Compared to alarming rate:!!%s",
									salesman.getAccountID(), productChoice,
									productNum, totalPrice, totalProfit,
									address, tele, judge);

							ioPak.printf(CS.LEVEL3, "Confirm this order?");
							System.out.printf(CS.level3()
									+ "Please enter yes or no here:");
							String confirm = ioPak.nextLine(CS.LEVEL3);
							if (confirm.contains("yes"))
							{
								ioPak.printf(CS.LEVEL3,"Deal accomplished!");
								Data.changeStorageAmount(productChoice,
										-productNum);
								Data.changeCurrentFunds(totalPrice);
								salesman.changeSaleAmount(totalPrice);
								salesman.changeSaleProfit(totalProfit);
								if (judge.equals("BELOW"))
								{
									salesman.changeAlarmDegree((Data
											.getAlarmPrice(productChoice)
											.subtract(productPrice))
											.multiply(new BigDecimal(""
													+ productNum)));
								}
								ioPak.printTable(
										23,
										CS.LEVEL3,
										/*"!!",*/
										"Total sales amount:!!%.2f\n"
												+ "The profit you made:!!%.2f\n"
												+ "Alarming sales made:!!%.2f\n"
												+ "Products remained:!!%d",
										salesman.getSale(),
										salesman.getSaleProfit(),
										salesman.getAlarmDegree(),
										Data.getStorageAmount(productChoice));
								break;
							}
							if (confirm.contains("no"))
							{
								ioPak.printf(
										CS.LEVEL3,
										"No deal accomplished.\n"
												+ "Maybe you are right! Think twice before doing!");
								break;
							}
							else
							{
								ioPak.printf(CS.LEVEL3,
										"Error.Let's see the order again!");
							}
						}// end while(true)
					}// end if(EnterInfo == 1)
				}// end if (pruductNum!=0)
			}// end if (productPrice.compareTo(new BigDecimal("0")) != 0)
		}// end if (productChoice != 0)
		ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		return salesman;
	}

	public static void setPasswordInMain(Salesman salesman)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		ioPak.printf(CS.LEVEL3,"SETTING PASSWORD!");
		System.out.printf(CS.level3()
				+"Please type your current password:");
		String CurrentPassword = ioPak.getConPD(CS.LEVEL3);
		while (!CurrentPassword.equals(salesman.getPassword()))
		{
			ioPak.printf(false, false, 0, CS.LEVEL3,"The password you gave is incorrect.");
			System.out.printf(CS.level3()+"Please try again:");
			CurrentPassword = ioPak.getConPD(CS.LEVEL3);
		}
		ioPak.printf(CS.LEVEL3,"Please set new password.");
		String pd = ioPak.setConPD(CS.LEVEL3,salesman.getName());
		salesman.setPassword(pd);
		ioPak.pause(CS.WAIT_G_FOR_SEE);
		ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
	}
}// end class

