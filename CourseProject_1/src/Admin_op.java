import java.math.BigDecimal;

public class Admin_op
{
	public static Administrator main(Administrator admin)
	{

		admin = mainMenu(admin);
		return admin;
	}

	private static Administrator mainMenu(Administrator admin)
	{
		while (true)
		{
			printWhatICanDO();
			ioPak.printf("ADMINISTRATOR MAIN MENU\n"
					+ "Press 1 for Account Management.\n"
					+ "Press 2 for My Products.\n" 
					+ "Press 3 for My Money.\n"
					+ "Press 4 for Logout Administrator.");
			int choice = ioPak.getInt("Your choice:", 1, 4);
			switch (choice)
			{
			case 1:// Account Management.
			{
				admin = acManage(admin);
				break;
			}
			case 2:// My Products.
			{
				admin = myProduct(admin);
				break;
			}
			case 3:// My Money.
			{
				admin = myMoney(admin);
				break;
			}
			case 4:// Logout Administrator.
			{
				return admin;
			}
			}
		}

	}// end mainMenu

	private static void printWhatICanDO()
	{
		ioPak.printf("As An Administrator, You Can:\n"
				+ "1. My Account:\n" 
				+ "  (a). Change My Password;\n"
				+ "  (b). Display All Existing Accounts;\n"
				+ "  (c). Enable Accounts;\n" 
				+ "  (d). Disable Accounts;\n"
				+ "2. My Products:\n" 
				+ "  (a). Check Inventory;\n"
				+ "  (b). Update Inventory Information: Stockpiling;\n"
				+ "3. My Money:\n" 
				+ "  (a). Selling Price Query;\n"
				+ "  (b). Purchase Price Query;\n"
				+ "  (c). Set the Warning Line of Profit;\n"
				+ "  (d). The Current Funds Query.");
	}

	private static Administrator acManage(Administrator admin)
	{
		theWhile: while (true)
		{
			ioPak.printf("My Account MENU\n"
					+ "    Press 1 to see What I Can Do.\n"
					+ "    Press 2 to Change Password.\n"
					+ "    Press 3 to Display all Existing Acounts.\n"
					+ "    Press 4 to Enable Acounts.\n"
					+ "    Press 5 to Disable Accounts.\n"
					+ "    Press 6 for Exit Account Management.");
			int choice = ioPak.getInt("Your choice:", 1, 6);
			switch (choice)
			{
			case 1:
			{
				printWhatICanDO();
				break;
			}// end 1
			case 2:
			{
				System.out.printf("Type your current password:");
				String CurrentPassword = ioPak.getConPD();
				while (!CurrentPassword.equals(admin.getPassword()))
				{
					ioPak.printf(false, false, 0,
							"The password you gave is incorrect.");
					System.out.printf("Please try again:");
					CurrentPassword = ioPak.getConPD();
				}
				ioPak.printf("Please set new password.");
				String pd = ioPak.setConPD("administrator");
				admin.setPassword(pd);
				break;
			}// end 2
			case 3:
			{
				Data.displayAccount();
				break;
			}
			case 4:
			{
				if(Data.getSalesmanCount() == 0){
					ioPak.printf("Sorry, no accounts exits!");
					break;
				}
				int accID = ioPak.getInt("Please Enter the accountID that you want to enable:", 
						1,"The account does not exits.", 
						Data.getSalesmanCount(),"The account does not exits.");
				Salesman sa = Data.getSalesman(accID);
				if (sa.isDisabled())
				{
					sa.setEnable();
					ioPak.printf(
							"Successfully enable account \"%s\" (ID:%d)",
							sa.getName(), sa.getAccountID());
					Data.setSalesman(accID, sa);
				}
				else
				{
					ioPak.printf(
							"This account \"%s\" (ID:%d) is already enabled, there's no need to enable it again",
							sa.getName(), sa.getAccountID());
				}
				break;
			}// end 4
			case 5:
			{
				if(Data.getSalesmanCount() == 0){
					ioPak.printf("Sorry, no accounts exits!");
					break;
				}
				int accID = ioPak.getInt("Please Enter the accountID that you want to disable:", 
						1,"The account does not exits.", 
						Data.getSalesmanCount(),"The account does not exits.");
				Salesman sa = Data.getSalesman(accID);
				if (!sa.isDisabled())
				{
					sa.setDisable();
					ioPak.printf(
							"Successfully disable account \"%s\" (ID:%d)",
							sa.getName(), sa.getAccountID());
					Data.setSalesman(accID, sa);
				}
				else
				{
					ioPak.printf(
							"This account \"%s\" (ID:%d) is already disabled, there's no need to disable it again",
							sa.getName(), sa.getAccountID());
				}
				break;
			}// end 5
			case 6:// Exit Account Management.(GET)
			{
				break theWhile;
			}// end 3
			}// end switch
		}// end while
		return admin;
	}

	private static Administrator myProduct(Administrator admin)
	{
		theWhile: while (true)
		{
			ioPak.printf("My Products MENU\n"
					+"Press 1 for Check Inventory.\n"
					+"Press 2 for Update Inventory Information: Stockpiling.\n"
					+"Press 3 for Exit My Products.");
			int choice = ioPak.getInt("Your Choice:", 1, 3);
			switch (choice)
			{
			case 1:// Check Inventory.(GET)
			{
				Data.printInventory();
				break;
			}
			case 2:// Update Inventory
			{
				ioPak.printf("Update Inventory Information:Stockpiling\n"
						+ "Choose the Product:\n" 
						+ "Press 1 for iPad 2;\n"
						+ "Press 2 for iPad 3;\n" 
						+ "Press 3 for iPhone 4;\n"
						+ "Press 4 for iPhone 4S;\n" 
						+ "Press 5 for iPhone 5;\n"
						+ "Press 6 for iPhone 5S;\n"
						+ "Press 7 for Exit Stockpiling.");
				int SpProductChoice = ioPak.getInt("Your Choice:", 1, 7);
				switch (SpProductChoice)
				{
				case 1:
				{
					ioPak.printf("Present in-stock amount of iPad 2 is: %d.",
							Data.getStorageAmount(Money.IPAD2));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPAD2, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 2:
				{
					ioPak.printf("Present in-stock amount of iPad 3 is: %d.",
							Data.getStorageAmount(Money.IPAD3));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPAD3, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 3:
				{
					ioPak.printf("Present in-stock amount of iPhone 4 is: %d.",
							Data.getStorageAmount(Money.IPHONE4));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPHONE4, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 4:
				{
					ioPak.printf("Present in-stock amount of iPhone 4S is: %d.",
							Data.getStorageAmount(Money.IPHONE4S));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPHONE4S, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 5:
				{
					ioPak.printf("Present in-stock amount of iPhone 5S is: %d.",
							Data.getStorageAmount(Money.IPHONE5));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPHONE5, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 6:
				{
					ioPak.printf("Present in-stock amount of iPhone 5S is: %d.",
							Data.getStorageAmount(Money.IPHONE5S));
					ioPak.printf(false, false, 0,
							"Please type the amount added to stock");
					int temp = ioPak.getInt("Amount:", 0);
					Data.changeStorageAmount(Money.IPHONE5S, temp);
					ioPak.printf("Successfully changed!");
					Data.printInventory();
					break;
				}
				case 7:// Exit Stockpiling.(GET)
				{
					;
				}
				}// end inner switch
				break;
			}// end 2
			case 3:// Exit My Products.(GET)
			{
				break theWhile;
			}// end 3
			}// switch
		}// end while
		return admin;
	}

	private static Administrator myMoney(Administrator admin)
	{
		theWhile: while (true)
		{
			ioPak.printf("My Money MENU\n"
					+ "Press 1 for Suggesting Price Query.\n"
					+ "Press 2 for Purchase Price Query.\n"
					+ "Press 3 for Warning Percentage Query\n"
					+ "Press 4 to Set the Warning Percentage.\n"
					+ "Press 5 for The Current Funds Query.\n"
					+ "Press 6 for Exit My Money.");
			int choice = ioPak.getInt("Your Choice:", 1, 6);
			switch (choice)
			{
			case 1://Suggesting Price Query
			{
				Data.printSugPrice();
				break;
			}
			case 2://Purchase Price Query
			{
				Data.printPurchasePrice();
				break;
			}
			case 3://Warning Percentage Query
			{
				ioPak.printf(" Let's see all the alarm price for all products");
				Data.printAlarmPrice();
				break;
			}// end 3
			case 4://Set the Warning Percentage
			{
				BigDecimal price = ioPak.getBD(
						"Please set the Warning Price Percentage:", 0);
				price = price.divide(new BigDecimal("100"));// convert a percentage into double
				Data.setAlarmPrice(price);
				ioPak.printf(" Let's see all the alarm price for all products");
				Data.printAlarmPrice();
				break;
			}// end 4
			case 5://The Current Funds Query
			{
				Data.printCurFunds();
				ioPak.printf("Do you want to change out Current Funds(Yes or No)?");
				String s;
				while(true)
				{
					System.out.printf("Your choice:");
					s = ioPak.nextLine();
					if ((s.contains("yes") || s.contains("no"))
							&& !(s.contains("yes") && s.contains("no")))
						// single yes or no but not both yes and no
					{
						break;
					}else{
						ioPak.printf(false, false, 0,
								"Please don't type something that I can't understand. :)");
					}
				}
				if(s.contains("yes")){
					ioPak.printf(false, false, 0, "How much do you want to add to inventory?\n"
							+ "( add a minus sign if you want to withdraw money from current funds, min)");
					BigDecimal bd = ioPak.getBD("Amount:", Data.getCurrentFunds().negate().doubleValue());
					Data.changeCurrentFunds(bd);
					ioPak.printf("Changed successfully.");
				}
				break;

			}
			case 6://Exit My Money
			{
				break theWhile;
			}
			}// end switch
		}// end while
		return admin;
	}// end myMoney

}
