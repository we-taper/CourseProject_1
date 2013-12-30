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
		ioPak.printNextLevel(CS.LEVEL1,CS.LEVEL2, CS.LEVEL_G);
		while (true)
		{
			printWhatICanDO(CS.LEVEL2);
			ioPak.printf(CS.LEVEL2,
					"ADMINISTRATOR MAIN MENU\n"
					+ "Press 1 for Account Management.\n"
					+ "Press 2 for My Products.\n" 
					+ "Press 3 for My Money.\n"
					+ "Press 4 for Change Access Code.\n"
					+ "Press 5 for Logout Administrator.");
			int choice = ioPak.getInt(CS.LEVEL2,"Your choice:", 1, 5);
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
			case 4:// Change Access Code
			{
				ChangeAC();
				break;
			}
			case 5:// Logout Administrator.
			{
				ioPak.printBackLevel(CS.LEVEL1, CS.LEVEL2, CS.LEVEL_G);
				return admin;
			}
			}
		}

	}// end mainMenu

	private static void printWhatICanDO(int SHIFT_BEFORE)
	{
		ioPak.printf(SHIFT_BEFORE,
				"As An Administrator, You Can:\n"
				+ "1. Account Management:\n" 
				+ "  (a). Change My Password;\n"
				+ "  (b). Display all Existing Acounts.\n"
				+ "  (c). Enable Saleman's Account.\n"
				+ "  (d). Disable Saleman's Accounts.\n"
				+ "  (e). Reset Salesman's password.\n"
				+ "  (f). Set Announcement for Salesmen.\n"
				+ "2. My Products:\n" 
				+ "  (a). Check Inventory;\n"
				+ "  (b). Update Inventory Information: Stockpiling;\n"
				+ "3. My Money:\n" 
				+ "  (a). Suggested Price Query;\n"
				+ "  (b). Purchase Price Query;\n"
				+ "  (c). Warning Percentage Query;\n"
				+ "  (d). The Current Funds Query.\n"
				+ "4. Change Access Code."
				+"");
		ioPak.typeATC(SHIFT_BEFORE);
	}

	private static Administrator acManage(Administrator admin)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		theWhile: while (true)
		{
			ioPak.printf(CS.LEVEL3,
					"Account Management MENU\n"
					+ "    Press 1 to see What I Can Do.\n"
					+ "    Press 2 to Change Password.\n"
					+ "    Press 3 to Display all Existing Acounts.\n"
					+ "    Press 4 to Enable Saleman's Account.\n"
					+ "    Press 5 to Disable Saleman's Accounts.\n"
					+ "    Press 6 to Reset Salesman's password.\n"
					+ "    Press 7 to Set Announcement for Salesmen.\n"
					+ "    Press 8 for Exit Account Management.");
			int choice = ioPak.getInt(CS.LEVEL3,"Your choice:", 1, 8);
			switch (choice)
			{
			case 1:
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				printWhatICanDO(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 1
			case 2:
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
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
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 2
			case 3:
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				Data.displayAccount(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 4:// enable account
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				if(Data.getSalesmanCount() == 0){
					ioPak.printf(CS.LEVEL4,"Sorry, no accounts exits!");
					ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
					ioPak.typeATC(CS.LEVEL4);
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
							"This account \"%s\" (ID:%d) is already enabled, there's no need\n"
							+ "to enable it again",
							sa.getName(), sa.getAccountID());
				}
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 4
			case 5:// disable account
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				if(Data.getSalesmanCount() == 0){
					ioPak.printf(CS.LEVEL4,"Sorry, no accounts exits!");
					ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
					ioPak.typeATC(CS.LEVEL4);
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
							"This account \"%s\" (ID:%d) is already disabled, there's no need\n"
							+ "to disable it again",
							sa.getName(), sa.getAccountID());
				}
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 5
			case 6:// Reset password
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
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
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 7:// set announcement
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				ioPak.printf(false, false, 0, CS.LEVEL4, "Current announcement:");
				Data.printAnoce(CS.LEVEL4);
				ioPak.printf(CS.LEVEL4,"Please type your new message.\n"
						+ "Use \"\\\" for line feed.");
				System.out.printf(ioPak.shift(CS.LEVEL4, "Message:"));
				String ance = ioPak.nextLine(CS.LEVEL4);
				ance = ance.replace('\\', '\n');
				Data.setAnoce(ance);
				ioPak.printf(false, false, 0, CS.LEVEL4, "New announcement:");
				Data.printAnoce(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 8:// Exit Account Management.(GET)
			{
				ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
				break theWhile;
			}// end 3
			}// end switch
		}// end while
		return admin;
	}

	private static Administrator myProduct(Administrator admin)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		theWhile: while (true)
		{
			ioPak.printf(CS.LEVEL3,
					"My Products MENU\n"
					+"Press 1 for Check Inventory.\n"
					+"Press 2 for Update Inventory Information: Stockpiling.\n"
					+"Press 3 for Exit My Products.");
			int choice = ioPak.getInt(CS.LEVEL3,"Your Choice:", 1, 3);
			switch (choice)
			{
			case 1:// Check Inventory.(GET)
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				Data.printInventory(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 2:// Update Inventory
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				ioPak.printf(CS.LEVEL4,
						"Update Inventory Information:Stockpiling\n"
						+ "Choose the Product:\n" 
						+ "Press 1 for iPad 2;\n"
						+ "Press 2 for iPad 3;\n" 
						+ "Press 3 for iPhone 4;\n"
						+ "Press 4 for iPhone 4S;\n" 
						+ "Press 5 for iPhone 5;\n"
						+ "Press 6 for iPhone 5S;\n"
						+ "Press 7 for Exit Stockpiling.");
				int SpProductChoice = ioPak.getInt(CS.LEVEL4,"Your Choice:", 1, 7);
				switch (SpProductChoice)
				{
				case 1:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPad 2 is: %d.",
							Data.getStorageAmount(Money.IPAD2));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPad 2.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPAD2, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 2:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPad 3 is: %d.",
							Data.getStorageAmount(Money.IPAD3));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPad 3.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPAD3, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 3:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPhone 4 is: %d.",
							Data.getStorageAmount(Money.IPHONE4));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPhone 4.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPHONE4, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 4:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPhone 4S is: %d.",
							Data.getStorageAmount(Money.IPHONE4S));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPhone 4S.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPHONE4S, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 5:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPhone 5 is: %d.",
							Data.getStorageAmount(Money.IPHONE5));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPhone 5.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPHONE5, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 6:
				{
					ioPak.printf(CS.LEVEL4,
							"Present in-stock amount of iPhone 5S is: %d.",
							Data.getStorageAmount(Money.IPHONE5));
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the amount added to stock");
					int temp = ioPak.getInt(CS.LEVEL4,"Amount:", 0);
					ioPak.printf(false, false, 0,CS.LEVEL4,
							"Please type the purchase price of iPhone 5S.");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4, "Price:", 0);
					Data.changeStorageAmount(Money.IPHONE5S, temp,bd);
					ioPak.printf(CS.LEVEL4,"Successfully changed!");
					Data.printInventory(CS.LEVEL4);
					ioPak.typeATC(CS.LEVEL4);
					break;
				}
				case 7:// Exit Stockpiling.(GET)
				{
					;
				}
				}// end inner switch
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 2
			case 3:// Exit My Products.(GET)
			{
				ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
				break theWhile;
			}// end 3
			}// switch
		}// end while
		return admin;
	}

	private static Administrator myMoney(Administrator admin)
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		theWhile: while (true)
		{
			ioPak.printf(CS.LEVEL3,"My Money MENU\n"
					+ "Press 1 for Suggested Price Query.\n"
					+ "Press 2 for Purchase Price Query.\n"
					+ "Press 3 for Warning Percentage Query\n"
					+ "Press 4 to  Set the Warning Percentage.\n"
					+ "Press 5 for The Current Funds Query.\n"
					+ "Press 6 for Exit My Money.");
			int choice = ioPak.getInt(CS.LEVEL3,"Your Choice:", 1, 6);
			switch (choice)
			{
			case 1://Suggested Price Query
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				Data.printSugPrice(CS.LEVEL4);
				ioPak.printf(CS.LEVEL4,"Do you want to change Suggested Price\n"
						+ "(1 For Yes or 2 For No)?");
				int choice_cf = ioPak.getInt(CS.LEVEL4,"Your choice:", 1, 2);
				if(choice_cf == 1){
					ioPak.printf(CS.LEVEL4,
							"Which product you want to change?\n"
							+ "1. iPad2;\n"
							+ "2. iPad3;\n"
							+ "3. iPhone 4;\n"
							+ "4. iPhone 4S;\n"
							+ "5. iPkone 5;\n"
							+ "6. iPhone 5S.");
					int choice_product = ioPak.getInt(CS.LEVEL4, "Product ID:", 1, 6);
					ioPak.printf(CS.LEVEL4, "Enter the price you want to set.");
					Data.setSugPrice(choice_product, ioPak.getBD(CS.LEVEL4,"Price:"
							, Data.getMinPrice(choice_product).doubleValue()));
					ioPak.printf(CS.LEVEL4,"Set successfully.");
				}
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 2://Purchase Price Query
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				Data.printPurchasePrice(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 3://Warning Percentage Query
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				ioPak.printf(CS.LEVEL4,"Let's see all the alarm price for all products");
				Data.printAlarmPrice(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 3
			case 4://Set the Warning Percentage
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				BigDecimal price = ioPak.getBD(CS.LEVEL4,
						"Please set the Warning Price Percentage(%%):", 0);
				price = price.divide(new BigDecimal("100"));// convert a percentage into double
				Data.setAlarmPrice(price);
				ioPak.printf(CS.LEVEL4,"Let's see all the alarm price for all products");
				Data.printAlarmPrice(CS.LEVEL4);
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}// end 4
			case 5://The Current Funds Query
			{
				ioPak.printNextLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				Data.printCurFunds(CS.LEVEL4);
				ioPak.printf(CS.LEVEL4,"Do you want to change Current Funds\n"
						+ "(1 For Yes or 2 For No)?");
				int choice_cf = ioPak.getInt(CS.LEVEL4,"Your choice:", 1, 2);
				if(choice_cf == 1){
					ioPak.printf(false, false, 0, CS.LEVEL4,
							"How much do you want to add to inventory?\n"
							+ "( add a minus sign if you want to withdraw \n"
							+ "money from current funds, min)");
					BigDecimal bd = ioPak.getBD(CS.LEVEL4,"Amount:",
							Data.getCurrentFunds().negate().doubleValue());
					Data.changeCurrentFunds(bd);
					ioPak.printf(CS.LEVEL4,"Changed successfully.");
					Data.printCurFunds(CS.LEVEL4);
				}
				ioPak.typeATC(CS.LEVEL4);
				ioPak.printBackLevel(CS.LEVEL3, CS.LEVEL4, CS.LEVEL_G);
				break;
			}
			case 6://Exit My Money
			{
				ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
				break theWhile;
			}
			}// end switch
		}// end while
		return admin;
	}// end myMoney
	private static void ChangeAC()
	{
		ioPak.printNextLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
		System.out.printf(CS.level3()+"Please input your orginal Access Code:");
		String acode = ioPak.getConPD(CS.LEVEL3);
		if( acode.equals(Main_Interface.getAccessCode()) )
		{
			acode = ioPak.setConPD(CS.LEVEL3, "Access Code");
			Main_Interface.setAccessCode(acode);
		}else{
			ioPak.printf(CS.LEVEL3,"Mismatched Access Code. \n"
					+ "Sorry, you cannot set the access code");
		}
		ioPak.typeATC(CS.LEVEL3);
		ioPak.printBackLevel(CS.LEVEL2, CS.LEVEL3, CS.LEVEL_G);
	}
}
