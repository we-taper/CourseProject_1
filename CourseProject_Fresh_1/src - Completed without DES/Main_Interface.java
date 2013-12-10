import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_Interface {
	private final static Scanner input = new Scanner(System.in);
	private static int CurrentUserID = 0;
	private static int ADMIN_ID = -1;
	private static Salesman salesman = new Salesman();
	private static Administrator admin = new Administrator();

	public static void main(String[] args) {
		Data.initiateData();
		int choice = 0;
		// Help user log into their accounts.
		while (true) {
			System.out.printf("Storage management system.\n");
			// if first time, initialize admin account. TODO de-comment flowing.
			/*if (Data.firstTime()) {
				System.out.printf("Please register an administrator account\n"
						+ "Please enter your name:");
				input.nextLine();//TODO
				//admin.name = input.nextLine();
				System.out.printf("Please enter your password:");
				//admin.password = input.nextLine();
				login(ADMIN_ID);
				break;
			} else*/ {// if not first time. let them login or registered account
				System.out.printf("Please enter your choice:\n"
						+ "1: Login with registered account.\n"
						+ "2: Register a new employ account.\n" 
						+ "3: Quit.\n"
						+ "4: Display accounts!\n"// TODO delete this display.
						+ "Your choice:");
				try {
					choice = input.nextInt();
				} catch (InputMismatchException inputMismatchException) {
					System.err.printf("Wrong input, please try again.\n");
				}
				input.nextLine();//Clear the input remaining EOL character.
				if (choice == 1) {
					testPD();
					break;
				} else if (choice == 2) {
					register();
					login(CurrentUserID);
					break;
				} else if (choice == 3) {
					break;
				} else if (choice == 4) {
					Data.displayAccount();// TODO delete this.
				} else {
					System.out.println("Wrong input, please try again.");
				}// end of if
			}//end of if

		}// end of while(true)
		// After login. Write all data to file.
		Data.storeData();
		// And record this run time in open_records.txt
		Data.recordRunTime();
	}// end of main

	public static void testPD() {
		String password;
		while (true) {
			try {
				System.out.printf("Please enter your ID: ");
				CurrentUserID = input.nextInt();
				input.nextLine();// Clear away the subtle errors.
				System.out.printf(
						"Please enter your passowrd for user \"%s\"\nInput: ",
						Data.getSalesman(CurrentUserID).getName());
				password = input.nextLine();
				break;
			} catch (InputMismatchException inputMismmatchExcpetion) {
				System.err.printf
						("Come on, try again and type something good.\n");
				input.nextLine();// Clear input line.
			}
		}
		if (password.equals(Data.getSalesman(CurrentUserID).getPassword())) {
			System.out.printf("Successfully logged in.\n");
			login(CurrentUserID);
		} else {
			System.out.printf("Wrong password or wrong UserID. "
					+ "Please try again. :)\n");
		}// end of if
	}// end of login

	public static void login(int ID) {
		if (ID == ADMIN_ID) {
			admin = Data.getAdmin();
			// process TODO ......
			// Then write admin into Data
			Data.setAdmin(admin);
		} else {
			salesman = Data.getSalesman(CurrentUserID);
			salesman = Sale_Op.main(salesman);
			// process TODO ......
			// Then write salesman into Data
			Data.setSalesman(CurrentUserID, salesman);
		}
	}// end of login

	public static void register() {
		// Retrieve data from user.
		System.out.printf("Please Enter your name:");
		salesman.setName(input.nextLine());
		System.out.printf("Please Enter your password:");
		salesman.setPassword(input.nextLine());
		CurrentUserID = Data.getSalesmanCount()+1;
		salesman.setAccountID(CurrentUserID);
		CurrentUserID = Data.addSalesman(salesman, CurrentUserID );
		// Above add account to salesman, return a 
		//    accountID if add successfully
		//    Data.CREAT_FAILED if add unsuccessfully
		if (CurrentUserID == Data.CREAT_FAILED) {
			System.out.printf("Failed to creat your account\n");
		} else {// Successfully Created
			System.out.printf("Successfully registered."
					+ "Your account ID is %d.\n"
					+ "Please remember you accountID, or else you will not \n"
					+ "be able to login again.\n",CurrentUserID);
			//TODO delete this token.
			Data.displayAccount();
		}

		salesman = null;
	}// end of register

}// end of class Main_Interface
