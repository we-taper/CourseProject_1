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
			printWhatICanDO(CS.LEVEL2);
			ioPak.printf(CS.LEVEL2,
					"ADMINISTRATOR MAIN MENU\n"
					+ "Press 1 for Account Management.\n"
					+ "Press 2 for My Products.\n" 
					+ "Press 3 for My Money.\n"
					+ "Press 4 for Logout Administrator.");
			int choice = ioPak.getInt(CS.LEVEL2,"Your choice:", 1, 4);
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

	private static void printWhatICanDO(int SHIFT_BEFORE)
	{
		ioPak.printf(SHIFT_BEFORE,
				"As An Administrator, You Can:\n"
				+ "1. My Account:\n" 
				+ "  (a). Change My Password;\n"
				+ "  (b). Change Password.\n"
				+ "  (c). Display all Existing Acounts.\n"
				+ "  (d). Enable Saleman's Account.\n"
				+ "  (e). Disable Saleman's Accounts.\n"
				+ "  (f). Reset Salesman's password.\n"
				+ "2. My Products:\n" 
				+ "  (a). Check Inventory;\n"
				+ "  (b). Update Inventory Information: Stockpiling;\n"
				+ "3. My Money:\n" 
				+ "  (a). Suggesting Price Query;\n"
				+ "  (b). Purchase Price Query;\n"
				+ "  (c). Warning Percentage Query;\n"
				+ "  (d). The Current Funds Query."
				+"");
	}

	private static Administrator acManage(Administrator admin)
	{
		theWhile: while (true)
		{
			ioPak.printf(CS.LEVEL3,
					"My Account MENU\n"
					+ "    Press 1 to see What I Can Do.\n"
					+ "    Press 2 to Change Password.\n"
					+ "    Press 3 to Display all Existing Acounts.\n"
					+ "    Press 4 to Enable Saleman's Account.\n"
					+ "    Press 5 to Disable Saleman's Accounts.\n"
					+ "    Press 6 to Reset Salesman's password.\n"
					+ "    Press 7 for Exit Account Management.");
			int choice = ioPak.getInt(CS.LEVEL3,"Your choice:", 1, 7);
			switch (choice)
			{
			case 1:
			{
				printWhatICanDO(CS.LEVEL4);
				break;
			}// end 1
			case 2:
			{
				System.out.printf(CS.level4()+"Type your current password:");
				String CurrentPassword = ioPak.getConPD();
				while (!CurrentPassword.equals(admin.getPassword()))
				{
					ioPak.printWarn(CS.LEVEL4,
							"The password you gave is incorrect.");
					System.out.printf(CS.level4()+"Please try again:");
					CurrentPassword = ioPak.getConPD(CS.LEVEL4);
				}
				ioPak.printf(CS.LEVEL4,"Please set new password.");
				String pd = ioPak.setConPD(CS.LEVEL4,"administrator");
				admin.setPassword(pd);
				break;
			}// end 2
			case 3:
			{
				Data.displayAccount(CS.LEVEL4);
				break;
			}
			case 4:
			{
				if(Data.getSalesmanCount() == 0){
					ioPak.printf(CS.LEVEL4,"Sorry, no accounts exits!");
					break;
				}
				int accID = ioPak.getInt(CS.LEVEL4,
						"Please Enter the accountID that you want to enable:", 
						1,"The account does not exits.", 
						Data.getSalesmanCount(),"The account does not exits.");
				Salesman sa = Data.getSalesman(accID);
				if (sa.isDisabled())
				{
					sa.setEnable();
					ioPak.printf(CS.LEVEL4,
							"Successfully enable account \"%s\" (ID:%d)",
							sa.getName(), sa.getAccountID());
					Data.setSalesman(accID, sa);
				}
				else
				{
					ioPak.printf(CS.LEVEL4,
							"This account \"%s\" (ID:%d) is already enabled, there's no need to enable it again",
							sa.getName(), sa.getAccountID());
				}
				break;
			}// end 4
			case 5:
			{
				if(Data.getSalesmanCount() == 0){
					ioPak.printf(CS.LEVEL4,"Sorry, no accounts exits!");
					break;
				}
				int accID = ioPak.getInt(CS.LEVEL4,
						"Please Enter the accountID that you want to disable:", 
						1,"The account does not exits.", 
						Data.getSalesmanCount(),"The account does not exits.");
				Salesman sa = Data.getSalesman(accID);
				if (!sa.isDisabled())
				{
					sa.setDisable();
					ioPak.printf(CS.LEVEL4,
							"Successfully disable account \"%s\" (ID:%d)",
							sa.getName(), sa.getAccountID());
					Data.setSalesman(accID, sa);
				}
				else
				{
					ioPak.printf(CS.LEVEL4,
							"This account \"%s\" (ID:%d) is already disabled, there's no need to disable it again",
							sa.getName(), sa.getAccountID());
				}
				break;
			}// end 5
			case 6:// Reset password
			{
				if(Data.getSalesmanCount() == 0){
					ioPak.printf(CS.LEVEL4,"No Salesman's account exits yet~~");
				}else{
					ioPak.printf(CS.LEVEL4,"Which Salesman's password you want to disable?");
					int accID = ioPak.getInt(CS.LEVEL4,
							"Salesman ID:", 1,Data.getSalesmanCount());
					Data.getSalesman(accID).setPassword("luckybear");
					ioPak.printf(CS.LEVEL4,
							"Successfully reset the password to \"luckybear\"\n"
							+ "Salesman: %s (ID: %d).", Data.getSalesman(accID).getName(),
							Data.getSalesman(accID).getAccountID());
				}
			}
			case 7:// Exit Account Management.(GET)
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
			ioPak.printf(CS.LEVEL3,"My Money MENU\n"
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
				Data.printSugPrice(CS.LEVEL4);
				break;
			}
			case 2://Purchase Price Query
			{
				Data.printPurchasePrice(CS.LEVEL4);
				break;
			}
			case 3://Warning Percentage Query
			{
				ioPak.printf(CS.LEVEL4,"Let's see all the alarm price for all products");
				Data.printAlarmPrice(CS.LEVEL4);
				break;
			}// end 3
			case 4://Set the Warning Percentage
			{
				BigDecimal price = ioPak.getBD(CS.LEVEL4,
						"Please set the Warning Price Percentage(%):", 0);
				price = price.divide(new BigDecimal("100"));// convert a percentage into double
				Data.setAlarmPrice(price);
				ioPak.printf(CS.LEVEL4,"Let's see all the alarm price for all products");
				Data.printAlarmPrice(CS.LEVEL4);
				break;
			}// end 4
			case 5://The Current Funds Query
			{
				Data.printCurFunds(CS.LEVEL4);
				ioPak.printf(CS.LEVEL4,"Do you want to change out Current Funds(Yes or No)?");
				String s;
				while(true)
				{
					System.out.printf(CS.level4(),"Your choice:");
					s = ioPak.nextLine(CS.LEVEL4);
					if ((s.contains("yes") || s.contains("no"))
							&& !(s.contains("yes") && s.contains("no")))
						// single yes or no but not both yes and no
					{
						break;
					}else{
						ioPak.printf(false, false, 0,CS.LEVEL4,
								"Please don't type something that I can't understand. :)");
					}
				}
				if(s.contains("yes")){
					ioPak.printf(false, false, 0, CS.LEVEL4,
							"How much do you want to add to inventory?\n"
							+ "( add a minus sign if you want to withdraw money from current funds, min)");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4,"Amount:", Data.getCurrentFunds().negate().doubleValue());
					Data.changeCurrentFunds(bd);
					ioPak.printf(CS.LEVEL4,"Changed successfully.");
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
