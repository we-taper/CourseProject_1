import java.math.BigDecimal;
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
						.println("You do not have write access to the file open_records.txt.");
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
						.println("You do not have write access to the file open_records.txt.");
				System.exit(1);
			} catch (FileNotFoundException fileNotFoundException)
			{
				System.out
						.println("Error opening or creating file open_records.txt.");
				System.exit(1);
			}// end try open file.

		}
	}

	public static void initiateData(String accessCode)
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
			encryption.DecryptFile(ACCOUNT_FILE + encryption.FILE_EXTENSION,
					ACCOUNT_FILE, accessCode);
			encryption.DecryptFile(MONEY_FILE + encryption.FILE_EXTENSION,
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
		encryption.encryptFile(MONEY_FILE, accessCode);
		encryption.encryptFile(ACCOUNT_FILE, accessCode);
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
		if (salesman.indexOf(a_salesman) == accountID - 1)
		{
			return accountID;
		}
		else
		{
			return CREAT_FAILED;
		}
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

	public static void changeStorageAmount(int goodsID, int amount)
	{
		/*
		 * Add the storage amount for product whose name is goodsID. Receive
		 * goodsID and the amount as parameter.
		 */
		money.changeStorageAmount(goodsID, amount);
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
		 * Get the base price（进价） for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the base price for this product.
		 */
		return money.getBasePrice(goodsID);
	}

	public static void setAlarmPrice(BigDecimal price)
	{
		/*
		 * Set the 利润额警戒线.
		 */
		money.setAlarmPrice(price);
	}

	public static BigDecimal getAlarmPrice(int goodsID)
	{
		/*
		 * Get the 利润额警戒线.
		 */
		return money.getAlarmPrice(goodsID);
	}

	public BigDecimal getMinPrice(int goodsID)
	{
		return money.getMinPrice(goodsID);
	}

	public void setMinPrice(int goodsID, BigDecimal price)
	{
		money.setMinPrice(goodsID, price);
	}

	public BigDecimal getSugPrice(int goodsID)
	{
		return money.getSugPrice(goodsID);
	}

	public void setSugPrice(int goodsID, BigDecimal price)
	{
		money.setSugPrice(goodsID, price);
	}

	public void setBasePrice(int goodsID, BigDecimal price)
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

	public static void displayAccount()
	{
		for (Salesman sla : salesman)
		{
			ioPak.printf("%s", sla);
		}
	}

}
