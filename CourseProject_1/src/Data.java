import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.util.Scanner;

/*
 * TODO note:
 */

public class Data
{
	ArrayList<Integer> password = new ArrayList<Integer>();

	private static ArrayList<Salesman> salesman = new ArrayList<Salesman>();
	private static Administrator admin = new Administrator();
	private static Scanner inputFile;
	private static Formatter outputFile;
	private static Money money = new Money();
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	public static final int CREAT_FAILED = -111;
	public static final String ACCOUNT_FILE = "account.ser";
	public static final String MONEY_FILE = "money.ser";
	public static final String ACCESS_CODE_FILE = "ac.data";
	public static final String RECORD_FILE = "open_records.txt";

	public static boolean firstTime()
	{
		boolean flag = false;// Temporarily store the return value.
		// Open file.
		try
		{
			inputFile = new Scanner(new File(RECORD_FILE));
		} catch (FileNotFoundException fileNotFoundException)
		{
			// If not found the file, create it.
			flag = true;// This must be the first time.
		}// end try open file
		return flag;
	}

	private static void recordRunTime()
	{
		/*
		 * 1. If first time, create open_records.txt and write to it. 2. If not
		 * first time, read open_records.txt and increase by 1.
		 */
		int temp = 0; // Temporarily store the open_records value.
		// 1
		if (firstTime())
		{
			// Create the file and write some data to it
			try
			{
				outputFile = new Formatter("open_records.txt");
				outputFile.format("RunTimeCounter: \n%d", 1);
				if (outputFile != null)
					outputFile.close();
				// file closed.
			} catch (SecurityException securityException)
			{
				System.out
						.println("You do not have write access to \n"
								+ "the file open_records.txt.");
				System.exit(1);
			} catch (FileNotFoundException fileNotFoundException1)
			{
				System.out.println("Error opening or creating file "
						+ RECORD_FILE);
				System.exit(1);
			}// end try open file
		}
		else
		{ // If not first time.
			try
			{// open a input stream.
				inputFile = new Scanner(new File("open_records.txt"));
				inputFile.nextLine();// Clear first words, proceed to next
										// integer.
				temp = inputFile.nextInt();// Read the run time counter.
				if (inputFile != null)
					inputFile.close();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}// end of try open in put stream.
				// Then record it.
			try
			{// open file.
				outputFile = new Formatter("open_records.txt");
				outputFile.format("RunTimeCounter: \n%d", temp + 1);// write
																	// file.
				if (outputFile != null)
					outputFile.close();// close file.
			} catch (SecurityException securityException)
			{
				System.out
						.println("You do not have write access \n"
								+ "to the file open_records.txt.");
				System.exit(1);
			} catch (FileNotFoundException fileNotFoundException)
			{
				System.out
						.println("Error opening or creating file open_records.txt.");
				System.exit(1);
			}// end try open file.

		}
	}

	public static void initiateData (String accessCode) 
			throws GeneralSecurityException
	{
		// Initiate and prepare data for reading.
		// 1. Initiate the files.
		if (firstTime()) // If the first time to use, initiate files.
		{
			// Initiate all the data in money, but not the accounts(cause they
			// have
			// nothing to initiate). 
			Data.money.initiateData();
		}
		else
		{
			// If not first time, read data from files.
			encryption.decryptFileDES(ACCOUNT_FILE + encryption.FILE_EXTENSION,
					ACCOUNT_FILE, accessCode);
			encryption.decryptFileDES(MONEY_FILE + encryption.FILE_EXTENSION,
					MONEY_FILE, accessCode);
			readMoney();
			readAccount();
			clearFiles();
		}
	}

	public static void storeData(String accessCode)
	{
		writeMoney();
		writeAccount();
		encryption.encryptFileDES(MONEY_FILE, accessCode);
		encryption.encryptFileDES(ACCOUNT_FILE, accessCode);
		// Record this run time in RECORD_FILE
		recordRunTime();
		clearFiles();
		System.gc();
	}

	private static void readMoney()
	{
		// Read money management data from file.
		try
		{
			input = new ObjectInputStream(new FileInputStream(MONEY_FILE));
		} catch (FileNotFoundException e)
		{
			System.out.printf("File %s not found.\n", MONEY_FILE);
		} catch (IOException e)
		{
			System.out.printf("Error opening file %s.\n", MONEY_FILE);
		}
		try
		{
			money = (Money) input.readObject();
		} catch (EOFException endOfFileException)
		{
			return; // end of file was reached
		} catch (ClassNotFoundException classNotFoundException)
		{
			System.out.println("Unable to create object.");
		} catch (IOException ioException)
		{
			System.out.printf("Error during reading from file %s.\n",
					MONEY_FILE);
		}
		try
		{
			input.close();
		} catch (IOException e)
		{
			System.out.printf("Error closing file %s.\n", MONEY_FILE);
			e.printStackTrace();
		}
	}

	private static void writeMoney()
	{
		// Write money management info into file.
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(MONEY_FILE));
		} catch (FileNotFoundException e)
		{
			System.out.printf("File %s not found.\n", MONEY_FILE);
		} catch (IOException e)
		{
			System.out.printf("Error opening file %s.\n", MONEY_FILE);
		}// open file
		try
		{
			output.writeObject(money);
		} catch (IOException e)
		{
			System.out.printf("Error opening file %s.\n", MONEY_FILE);
		}// write file
		try
		{
			output.close();
		} catch (IOException e)
		{
			System.out.printf("Error closing file %s.\n", MONEY_FILE);
			e.printStackTrace();
		}
	}

	private static void readAccount()
	{
		// Read account info from file.
		try
		{
			input = new ObjectInputStream(new FileInputStream(ACCOUNT_FILE));
		} catch (FileNotFoundException e)
		{
			System.out.printf("File %s not found.\n", ACCOUNT_FILE);
		} catch (IOException e)
		{
			System.out.printf("Error opening file %s.\n", ACCOUNT_FILE);
		}
		try
		{
			admin = (Administrator) input.readObject();
		} catch (EOFException endOfFileException)
		{
			return; // end of file was reached
		} catch (ClassNotFoundException classNotFoundException)
		{
			System.out.println("Unable to create object.");
		} catch (IOException ioException)
		{
			System.out.printf("Error during reading from file %s.\n",
					ACCOUNT_FILE);
			ioException.printStackTrace();
		}
		// input the Salesmen from the file
		try
		{
			while (true)
			{
				salesman.add((Salesman) input.readObject());
			}
		} // end try
		catch (EOFException endOfFileException)
		{
			return; // end of file was reached
		} catch (ClassNotFoundException classNotFoundException)
		{
			System.out.println("Unable to create object.");
			classNotFoundException.printStackTrace();
		} catch (IOException ioException)
		{
			System.out.printf("Error during reading from file %s.\n",
					ACCOUNT_FILE);
			ioException.printStackTrace();
		} // end catch
		try
		{
			input.close();
		} catch (IOException e)
		{
			System.out.printf("Error closing file %s.\n", ACCOUNT_FILE);
			e.printStackTrace();
		}
	}

	private static void writeAccount()
	{
		// Write account info into file.
		// open file
		try
		{
			output = new ObjectOutputStream(new FileOutputStream(ACCOUNT_FILE));
		} catch (FileNotFoundException e)
		{
			System.out.printf("File %s not found.\n", ACCOUNT_FILE);
		} catch (IOException e)
		{
			System.out.printf("Error  opening file.\n", ACCOUNT_FILE);
		}
		// write admin
		try
		{
			output.writeObject(admin);
		} catch (IOException e1)
		{
			System.out.printf("Error opening file %s.\n", ACCOUNT_FILE);
		}
		// write salesman
		for (Salesman salesman_now : salesman)
		{
			try
			{
				output.writeObject(salesman_now);
			} catch (IOException e1)
			{
				System.out.printf("Error opening file %s.\n", ACCOUNT_FILE);
			}
		}
		try
		{
			output.close();
		} catch (IOException e)
		{
			System.out.printf("Error closing file %s.\n", ACCOUNT_FILE);
			e.printStackTrace();
		}
	}

	private static void clearFiles()
	{
		// Clear files to prevent hacking.
		deleteFile(ACCOUNT_FILE);
		deleteFile(MONEY_FILE);

	}

	private static void deleteFile(String filename)
	{
		File file = new File(filename);
		// Close all the streams possibly exist.
		// This step is very important to delete files.
		try
		{
			if (input != null)
			{
				input.close();
			}
			if (output != null)
			{
				output.close();
			}
			if (inputFile != null)
			{
				inputFile.close();
			}
			if (outputFile != null)
			{
				outputFile.close();
			}
		} catch (IOException e1)
		{
			e1.printStackTrace();
		}
		if (file.exists())
		{
			try
			{
				file.delete();
			} catch (SecurityException e)
			{
				e.printStackTrace();
				System.out.printf("Unable to delete file %s. Please "
						+ "do delete it yourself.\n"
						+ "This files is located in :\n%s\n", filename,
						file.getAbsolutePath());
			}
			if (file.exists())
			{
				System.out.printf("Unable to delete file %s. Please "
						+ "do delete it yourself.\n"
						+ "This files is located in :\n%s\n", filename,
						file.getAbsolutePath());
			}
		}
		else
		{
			;// File not exists, do nothing.
		}
	}

	public static Administrator getAdmin()
	{
		return admin;
	}

	public static void setAdmin(Administrator admin_)
	{
		admin = admin_;
	}

	public static int addSalesman(Salesman a_salesman, int accountID)
	{
		// Add a salesman object to salesman arraylist and return his accountID.
		salesman.add(a_salesman);
		// Check the sequence of arraylist salesman.
		/*if (salesman.indexOf(a_salesman) == (accountID - 1))
		{
			return accountID;
		}
		else
		{
			return CREAT_FAILED;
		}*/ // This method is now needless and may cause subtle error.
		return accountID;
	}

	public static Salesman getSalesman(int accountID)
	{
		return salesman.get(accountID - 1);
	}

	public static void setSalesman(int accountID, Salesman slm)
	{
		salesman.set(accountID - 1, slm);
	}

	public static int getSalesmanCount()
	{
		return salesman.size();
	}

	// Read and Write money data.
	public static void setStorageAmount(int goodsID, int amount)
	{
		money.setStorageAmount(goodsID, amount);
	}

	public static void changeStorageAmount(int goodsID, int amount, BigDecimal price)
	{
		/*
		 * Add the storage amount for product whose name is goodsID. Receive
		 * goodsID and the amount as parameter.
		 */
		money.changeStorageAmount(goodsID, amount, price);
	}

	public static int getStorageAmount(int goodsID)
	{
		/*
		 * Get the storage amount for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the storage amount for this product.
		 */
		return money.getStorageAmount(goodsID);
	}

	public static BigDecimal getBasePrice(int goodsID)
	{
		/*
		 * Get the base price. Receive
		 * goodsID as parameter. Return the base price for this product.
		 */
		return money.getBasePrice(goodsID);
	}

	public static void setAlarmPrice(BigDecimal price)
	{
		money.setAlarmPrice(price);
	}

	public static BigDecimal getAlarmPrice(int goodsID)
	{
		return money.getAlarmPrice(goodsID);
	}

	public static BigDecimal getMinPrice(int goodsID)
	{
		// MinPrice == AlarmPrice
		return money.getAlarmPrice(goodsID);
	}

	public static BigDecimal getSugPrice(int goodsID)
	{
		return money.getSugPrice(goodsID);
	}

	public static void setSugPrice(int goodsID, BigDecimal price)
	{
		money.setSugPrice(goodsID, price);
	}

	public static void setBasePrice(int goodsID, BigDecimal price)
	{
		money.setBasePrice(goodsID, price);
	}

	public static BigDecimal getCurrentFunds()
	{
		// Get current funds as Decimal
		return money.getCurrentFunds();
	}

	public static void changeCurrentFunds(BigDecimal m)
	{
		// Add or subtract money to current funds.
		money.changeCurrentFunds(m);
	}
	public static void printInventory(int SHIFT_BEFORE)
	{
		ioPak.printTable(20,SHIFT_BEFORE,
				"Inventory List:\n"
				+ "Name!!Amounts\n"
				+ "iPad2!!%d\n"
				+ "iPad3!!%d\n"
				+ "iPhone 4!!%d\n"
				+ "iPhone 4S!!%d\n"
				+ "iPhone 5!!%d\n"
				+ "iPhone 5S!!%d"
				, Data.getStorageAmount(Money.IPAD2)
				, Data.getStorageAmount(Money.IPAD3)
				, Data.getStorageAmount(Money.IPHONE4)
				, Data.getStorageAmount(Money.IPHONE4S)
				, Data.getStorageAmount(Money.IPHONE5)
				, Data.getStorageAmount(Money.IPHONE5S));
	}
	public static void printSugPrice(int SHIFT_BEFORE)
	{
		ioPak.printf(SHIFT_BEFORE,
				"The current Suggesting Prices of Priducts\n"
				+ "are as follow:");
		ioPak.printTable(15,SHIFT_BEFORE,
				"Name!!Price\n"
				+"iPad 2!!%.2f CNY.\n"
				+"iPad 3!!%.2f CNY.\n"
				+"iPhone 4!!%.2f CNY.\n"
				+"iPhone 4S!!%.2f CNY.\n"
				+"iPhone 5!!%.2f CNY.\n"
				+"iPhone 5S!!%.2f CNY."
				, getSugPrice(Money.IPAD2)
				, getSugPrice(Money.IPAD3)
				, getSugPrice(Money.IPHONE4)
				, getSugPrice(Money.IPHONE4S)
				, getSugPrice(Money.IPHONE5)
				, getSugPrice(Money.IPHONE5S));
	}
	public static void printPurchasePrice(int SHIFT_BEFORE)
	{
		ioPak.printf(SHIFT_BEFORE,
				"The current Purchase Prices of Priducts\n"
				+ "are as follow:");
		ioPak.printTable(15,SHIFT_BEFORE,
				"Name!!Price\n"
				+"iPad 2!!%.2f CNY.\n"
				+"iPad 3!!%.2f CNY.\n"
				+"iPhone 4!!%.2f CNY.\n"
				+"iPhone 4S!!%.2f CNY.\n"
				+"iPhone 5!!%.2f CNY.\n"
				+"iPhone 5S!!%.2f CNY."
				, getBasePrice(Money.IPAD2)
				, getBasePrice(Money.IPAD3)
				, getBasePrice(Money.IPHONE4)
				, getBasePrice(Money.IPHONE4S)
				, getBasePrice(Money.IPHONE5)
				, getBasePrice(Money.IPHONE5S));
	}
	public static void printMinPrice(int SHIFT_BEFORE)
	{
		ioPak.printf(SHIFT_BEFORE,
				"The current Minimum Prices of Priducts\n"
				+ "are as follow:");
		ioPak.printTable(20,SHIFT_BEFORE,
				"Name!!Price\n"
				+"iPad 2!!%.2f CNY.\n"
				+"iPad 3!!%.2f CNY.\n"
				+"iPhone 4!!%.2f CNY.\n"
				+"iPhone 4S!!%.2f CNY.\n"
				+"iPhone 5!!%.2f CNY.\n"
				+"iPhone 5S!!%.2f CNY."
				, getMinPrice(Money.IPAD2)
				, getMinPrice(Money.IPAD3)
				, getMinPrice(Money.IPHONE4)
				, getMinPrice(Money.IPHONE4S)
				, getMinPrice(Money.IPHONE5)
				, getMinPrice(Money.IPHONE5S));
	}
	
	public static void printAlarmPrice(int SHIFT_BEFORE)
	{
		// AlarmPrice == MinPrice
		ioPak.printf(SHIFT_BEFORE,"The current Alarm Prices of\n"
				+ "Priducts are as follow:");
		ioPak.printf(false, false, 0, SHIFT_BEFORE, 
				"Warning Percent: %s.", money.getAlarmPercent());
		ioPak.printTable(20,SHIFT_BEFORE,
				"Name!!Price\n"
				+"iPad 2!!%.2f CNY.\n"
				+"iPad 3!!%.2f CNY.\n"
				+"iPhone 4!!%.2f CNY.\n"
				+"iPhone 4S!!%.2f CNY.\n"
				+"iPhone 5!!%.2f CNY.\n"
				+"iPhone 5S!!%.2f CNY."
				, getMinPrice(Money.IPAD2)
				, getMinPrice(Money.IPAD3)
				, getMinPrice(Money.IPHONE4)
				, getMinPrice(Money.IPHONE4S)
				, getMinPrice(Money.IPHONE5)
				, getMinPrice(Money.IPHONE5S));
	}

	public static void printCurFunds(int SHIFT_BEFORE){
		ioPak.printf(SHIFT_BEFORE,
				"The current funds is %.2f Yuan.",getCurrentFunds());
	}
	public static void printAnoce(int SHIFT_BEFORE)
	{
		String s = money.getAnoce();
		if (s.isEmpty())
		{
			return;
		}
		else
		{
			ioPak.printf(SHIFT_BEFORE, "Announcement:\n\n"+money.getAnoce());
		}
	}
	public static String getAnoce()
	{
		return money.getAnoce();
	}
	public static void setAnoce( String a )
	{
		money.setAnoce(a);
	}
	public static byte[] getHashAccessCode()
	{
		File file = new File(ACCESS_CODE_FILE);
		FileInputStream fis;
		try
		{
			fis = new FileInputStream(file);
			if (file.length() > Integer.MAX_VALUE)
			{
				System.out.printf("file.length()>Integer.MAX_VALUE");
				System.exit(1);
			}
			byte data[] = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			return data;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void setAccessCode(String accessCode)
	{
		byte[] data;
		// Encrypt accessCode (Double encryption).
		data = encryption.byte2MD5(encryption.Str2SHA256(accessCode));
		try
		{
			FileOutputStream fos = new FileOutputStream(ACCESS_CODE_FILE);
			fos.write(data);
			fos.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void displayAccount(int SHIFT_BEFORE )
	{
		if (Data.getSalesmanCount() == 0)
		{
			ioPak.printf(SHIFT_BEFORE,"Sorry, no account exits!");
		}
		else
		{
			for (Salesman sla : salesman)
			{
				ioPak.printf(SHIFT_BEFORE,"%s", sla);
			}
		}
	}
	
	public static String getStarNameForSales()
	{
		BigDecimal maxSale=new BigDecimal("0");
		int maxSaleID=1;
		for(Salesman s:salesman)
		{
			if(s.getSale().compareTo(maxSale)==1)
			{
				maxSale=s.getSale();
				maxSaleID=s.getAccountID();
			}
		}
		return getSalesman(maxSaleID).getName();
	}
	public static String getStarNameForProfit()
	{
		BigDecimal maxProfit=new BigDecimal("0");
		int maxProfitID=1;
		for(Salesman s:salesman)
		{
			if(s.getSale().compareTo(maxProfit)==1)
			{
				maxProfit=s.getSale();
				maxProfitID=s.getAccountID();
			}
		}
		return getSalesman(maxProfitID).getName();
	}
	public static String id2Name(int productID)
	{
		switch (productID)
		{
		case Money.IPAD2:
			return "iPad 2";
		case Money.IPAD3:
			return "iPad 3";
		case Money.IPHONE4:
			return "iPhone 4";
		case Money.IPHONE4S:
			return "iPhone 4S";
		case Money.IPHONE5:
			return "iPhone 5";
		case Money.IPHONE5S:
			return "iPhone 5S";
		default:
			return "No such Product!";
		}
	}
}
