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
 *    1.Secure (encode) data.
 *    2.Exception handle.
 */

public class Data {
	ArrayList<Integer> password = new ArrayList<Integer>();

	private static ArrayList<Salesman> salesman = new ArrayList<Salesman>();
	private static Administrator admin = new Administrator();
	private static Scanner inputFile;
	private static Formatter outputFile;
	private static Money money = new Money();
	public static final int CREAT_FAILED = -111;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;

	public static boolean firstTime() {
		boolean flag = false;// Temporarily store the return value.
		// Open file.
		try {
			inputFile = new Scanner(new File("open_records.txt"));
		} catch (FileNotFoundException fileNotFoundException) { 
			// If not found the file, create it.
			flag = true;// This must be the first time.
		}// end try open file
		return flag;
	}
	public static void recordRunTime()
	{
		/* 1. If first time, create open_records.txt and write to it.
		 * 2. If not first time, read open_records.txt and increase by 1.
		 */
		int temp = 0; // Temporarily store the open_records value.
		// 1
		if(firstTime()){
			try {// Create file.
				outputFile = new Formatter("open_records.txt");
			} catch (SecurityException securityException) {
				System.err.println("You do not have write access to the file open_records.txt.");
				System.exit(1);
			} 
			catch (FileNotFoundException fileNotFoundException1) {
				System.err.println("Error opening or creating file open_records.txt.");
				System.exit(1);
			}// end try create file
			if(outputFile != null)// close file
				outputFile.close();
			// Then open the file.
			try {
				outputFile = new Formatter("open_records.txt");
			} catch (SecurityException securityException) {
				System.err.println("You do not have write access to the file open_records.txt.");
				System.exit(1);
			} 
			catch (FileNotFoundException fileNotFoundException1) {
				System.err.println("Error opening or creating file open_records.txt.");
				System.exit(1);
			}// end try open file
			// Then write some data to it
			outputFile.format("RunTimeCounter: \n%d", 1);
			if(outputFile != null)
				outputFile.close();
			// file closed.
		}else{ // If not first time.
			try {// open a input stream.
				inputFile = new Scanner(new File("open_records.txt"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}// end of try open in put stream.
			//@SuppressWarnings("unused")
			//String a = inputFile.nextLine();// Clear first words, proceed to
											// next integer.
			inputFile.nextLine();
			temp = inputFile.nextInt();// Read the run time counter.
			if (inputFile != null)
				inputFile.close();
			// Then record it.
			try {// open file.
				outputFile = new Formatter("open_records.txt");
			} catch (SecurityException securityException) {
				System.err
						.println("You do not have write access to the file open_records.txt.");
				System.exit(1);
			} catch (FileNotFoundException fileNotFoundException) {
				System.err
						.println("Error opening or creating file open_records.txt.");
				System.exit(1);
			}// end try open file.
			outputFile.format("RunTimeCounter: \n%d", temp + 1);// write file.
			if (outputFile != null)
				outputFile.close();// close file.
		}
	}
	public static void initiateData() {
		// Initiate and prepare data for reading.
		// 1. Initiate the files.
		if (firstTime()) // If the first time to use, initiate files.
		{
			// Initiate all the data in money, but not the accounts(cause they have
			// nothing to initiate).  TODO In main_interface, initiate the admin.
			Data.money.initiateData();
		} else {
			// If not first time, read data from files.
			readMoney();
			readAccount();
		}
	}
	public static void storeData() {
		writeMoney();
		writeAccount();
	}
	
	private static void readMoney() {
		// Read money management data from file.
		try {
			input = new ObjectInputStream(new FileInputStream("money.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("File money.ser not found.");
		} catch (IOException e) {
			System.err.println("Error opening file money.ser.");
		}
		try {
			money = (Money) input.readObject();
		} catch (EOFException endOfFileException) {
			return; // end of file was reached
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
		} catch (IOException ioException) {
			System.err.println("Error during reading from file money.ser.");
		}
	}
	private static void writeMoney() {
		// Write money management info into file.
		try {
			output = new ObjectOutputStream(new FileOutputStream("money.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("File money.ser not found.");
		} catch (IOException e) {
			System.err.println("Error opening file money.ser.");
		}// open file
		try {
			output.writeObject(money);
		} catch (IOException e) {
			System.err.println("Error opening file money.ser.");
		}// write file
	}
	private static void readAccount() {
		// Read account info from file.
		try {
			input = new ObjectInputStream(new FileInputStream("account.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("File account.ser not found.");
		} catch (IOException e) {
			System.err.println("Error opening file account.ser.");
		}
		try {
			admin = (Administrator) input.readObject();
		} catch (EOFException endOfFileException) {
			return; // end of file was reached
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
		} catch (IOException ioException) {
			System.err.println("Error during reading from file account.ser.");
			ioException.printStackTrace();
		}
		// input the Salesmen from the file
		try {
			while (true) {
				salesman.add((Salesman) input.readObject());
			} // end while
		} // end try
		catch (EOFException endOfFileException) {
			return; // end of file was reached
		} // end catch
		catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Unable to create object.");
			classNotFoundException.printStackTrace();
		} // end catch
		catch (IOException ioException) {
			System.err.println("Error during reading from file account.ser.");
			ioException.printStackTrace();
		} // end catch
	}
	private static void writeAccount() {
		// Write account info into file.
		try {
			output = new ObjectOutputStream(new FileOutputStream("account.ser"));
		} catch (FileNotFoundException e) {
			System.err.println("File account.ser not found.");
		} catch (IOException e) {
			System.err.println("Error account.ser opening file.");
		}// open file
		try {
			output.writeObject(admin);
		} catch (IOException e1) {
			System.err.println("Error opening file account.ser.");
		}// write admin
		for (Salesman salesman_now : salesman) {
			try {
				output.writeObject(salesman_now);
			} catch (IOException e1) {
				System.err.println("Error opening file account.ser.");
			}
		}// write salesman
	}

	public static Administrator getAdmin() {
		return admin;
	}
	public static void setAdmin(Administrator admin_) {
		admin = admin_;
	}
	public static int addSalesman(Salesman a_salesman, int accountID) {
		// Add a salesman object to salesman arraylist and return his accountID.
		salesman.add(a_salesman);
		// Check the sequence of arraylist salesman.
		if ( salesman.indexOf(a_salesman)  == accountID -1) {
			return accountID;
		} else {
			return CREAT_FAILED;
		}
	}
	public static Salesman getSalesman(int accountID) {
		return salesman.get(accountID-1);
	}
	public static void setSalesman(int accountID, Salesman slm) {
		salesman.set(accountID-1, slm);
	}
	public static int getSalesmanCount()
	{
		return salesman.size();
	}

	
	// Read and Write money data.
	public static void setStorageAmount(int goodsID, int amount) {
		money.setStorageAmount(goodsID, amount);
	}
	public static void changeStorageAmount(int goodsID, int amount) {
		/*
		 * Add the storage amount for product whose name is goodsID. Receive
		 * goodsID and the amount as parameter.
		 */
		money.changeStorageAmount(goodsID, amount);
	}
	public static int getStorageAmount(int goodsID) {
		/*
		 * Get the storage amount for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the storage amount for this product.
		 */
		return money.getStorageAmount(goodsID);
	}
	public static BigDecimal getBasePrice(int goodsID) {
		/*
		 * Get the base price（进价） for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the base price for this product.
		 */
		return money.getBasePrice(goodsID);
	}
	public static void setAlarmPrice(BigDecimal price) {
		/*
		 * Set the 利润额警戒线.
		 */
		money.setAlarmPrice(price);
	}
	public static BigDecimal getAlarmPrice() {
		/*
		 * Get the 利润额警戒线.
		 */
		return money.getAlarmPrice();
	}
	public static BigDecimal getCurrentFunds() {
		// Get current funds as Decimal
		return money.getCurrentFunds();
	}
	public static void changeCurrentFunds(BigDecimal m) {
		// Add or subtract money to current funds.
		money.changeCurrentFunds(m);
	}

	public static void displayAccount() { // TODO delete this method after
											// finishing program.
		for(Salesman sla:salesman){// TODO toString to class Salesman
			System.out.printf("%s",sla);
		}
	}
}
