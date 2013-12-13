import java.util.InputMismatchException;
import java.util.Scanner;
// test Hello shaohua
public class Main_Interface {
	private final static Scanner input = new Scanner(System.in);
	private static int CurrentUserID = 0;
	private static int ADMIN_ID = -1;
	private static Salesman salesman = new Salesman();
	private static Administrator admin = new Administrator();
	private static String accessCode = "";

	public static void main(String[] args) {
		// if first time, initialize admin account.
		ioPak.printf(78, 20, 20, "Welcome to Storage Management System\n");
		if (Data.firstTime()) {
			ioPak.printf("It's your first time running this program, please "
					+ "set your Access Code.\n");
			initiateAccessCode();
			initiateAdmin();
		}
		judgeAccessCode();
		Data.initiateData(accessCode);
		// Since last time we use access code, clear it afterwards.
		mainMenu();
		// After login. Write all data to file.
		Data.storeData(accessCode);
	}// end of main

	private static void mainMenu() {
		int choice = 0;
		ioPak.printf("Welcome to Storage Management system.\n");
		ioPak.printf(""
					+ ",------------.                ,.--\"\"-._\n"
					+ "|   Storage   `.           __/         `.\n"
					+ "|  Management   |     _,**\"   \"*-.       `.\n"
					+ "|   System      |   ,'            `.       \\\n"
					+ "`---------------'  ;    _,.---._    \\  ,'\\  \\\n"
					+ "                  :   ,'   ,-.. `.   \\'   \\ :\n"
					+ "                  |  ;_\\  (___)`  `-..__  : |\n"
					+ "                  ;-'`*'\"  `*'    `--._ ` | ;\n"
					+ "                 /,-'/  -.        `---.`  |\"\n"
					+ "                 /_,'`--='.       `-.._,-\" _\n"
					+ "                  (/\\\\,--. \\    ___-.`:   //___\n"
					+ "                     /\\'''\\ '  |   |-`|  ( -__,'\n"
					+ "                    '. `--'    ;   ;  ; ;/_/\n"
					+ "                      `. `.__,/   /_,' /`.~;\n"
					+ "                      _.-._|_/_,'.____/   /\n"
					+ "                 ..--\" /  =/  \\=  \\      /\n"
					+ "                /  ;._.\\_.-`--'-._/ ____/\n"
					+ "                \\ /   /._/|.\\     .\"\n"
					+ "                 `*--'._ \"-.:     :\n"
					+ "                      :/\".A` \\    |\n"
					+ "                      |   |.  `.  :\n"
					+ "                      ;   |.    `. \\\"\n"
					+ "");
		while (true) {
			// Help user log into their accounts.
			ioPak.printf(""
					+ "Please enter your choice:\n"
					+ "1: Administrator login.\n" 
					+ "2: Salesman login.\n"
					+ "3: Register a new salesman account.\n" 
					+ "4: Quit.\n"
					+ "5: Display accounts!\n"// TODO delete this display.
					+ "");
			choice = ioPak.getInt("Your choice:",1,5);
			if (choice == 1) {
				adminLogin();
				ioPak.cls();
				ioPak.printf("Welcome back!!\n");
			} else if (choice == 2) {
				testPD();
				ioPak.cls();
				ioPak.printf("Welcome back!!\n");
			} else if (choice == 3) {
				register();
				login(CurrentUserID);
				ioPak.cls();
				ioPak.printf("Welcome back!!\n");
			} else if (choice == 4) {
				break;
			} else if (choice == 5) {
				Data.displayAccount();// TODO delete this.
			} else {}// end of if
		}// end while(true)
	}

	public static void testPD() {
		int count = 0;
		String password;
		if(Data.getSalesmanCount() == 0){
			System.out.printf("No account exists yet, please register one.\n");
			return;
		}
		while (true)//Get User ID
			{
			try {
				System.out.printf("Please enter your ID: ");
				CurrentUserID = input.nextInt();
				input.nextLine();// Clear away the subtle errors.
				break;
			} catch (InputMismatchException inputMismmatchExcpetion) {
				System.out
						.printf("Come on, try again and type something right.\n");
				input.nextLine();// Clear input line.
			}
		}// end while
		try
		{
			while (true) // get password
			{
				System.out.printf(
						"Please enter your passowrd for user \"%s\"\nInput: ",
						Data.getSalesman(CurrentUserID).getName());
				count++;// Use count so that user can only make no more than three
				// mistakes.(Anti-force-break)
				password = ioPak.getConPD();
				if (password.equals(Data.getSalesman(CurrentUserID)
						.getPassword()))
				{
					ioPak.printf("Successfully logged in.\n");
					login(CurrentUserID);
					break;
				}
				else
				{
					System.out.printf("Wrong password or wrong UserID. ");
					switch (count)
					{
					case 1:
						System.out
								.printf("Please try again(two chances left). :)\n");
						break;
					case 2:
						System.out
								.printf("Please try again(one chance left). :)\n");
						break;
					default:
						ioPak.printf("Sorry, program will now exit.");
						System.exit(0);
					}
				}// end of if
			}// end while
		} catch (IndexOutOfBoundsException e)
		{
			System.out.printf("No such account exists, please try again.\n");
		}// end try-catch

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
			// Then write salesman into Data
			Data.setSalesman(CurrentUserID, salesman);
		}
	}// end of login

	public static void adminLogin() {
		System.out.printf("Please input password for administrator:");
		// TODO complete this.
	}

	public static void register() {
		// Retrieve data from user.
		//System.out.printf("Please Enter your name:");
		salesman.setName(ioPak.setUserName());
		salesman.setPassword(ioPak.setConPD("password"));
		CurrentUserID = Data.getSalesmanCount() + 1;
		salesman.setAccountID(CurrentUserID);
		CurrentUserID = Data.addSalesman(salesman, CurrentUserID);
		// Above add account to salesman, return a
		// accountID if add successfully and return a
		// Data.CREAT_FAILED if add unsuccessfully
		if (CurrentUserID == Data.CREAT_FAILED) {
			ioPak.printf("Failed to creat your account\n");
		} else {// Successfully Created
			ioPak.printf("Successfully registered."
					+ "Your account ID is %d.\n"
					+ "Please remember you accountID, or else you will not \n"
					+ "be able to login again.\n", CurrentUserID);
		}

		salesman = null;
	}// end of register

	public static void judgeAccessCode() {
		byte[] dataUser, dataFile;
		boolean equal = true;
		System.out.printf("Please enter the access code:");
		accessCode = ioPak.getConPD();
		dataUser = encryption.byte2MD5(encryption.Str2SHA256(accessCode));
		dataFile = Data.getHashAccessCode();
		for (int i = 0; i < dataUser.length; i++) {
			if (dataUser[i] != dataFile[i]) {
				equal = false;
				break;
			}
		}
		if (!equal) {
			ioPak.printf("Wrong Access Code. Program will now exit.\n"
					+ "Type any key to exit.");
			System.exit(1);
		}
	}

	public static void initiateAdmin() {

	}// TODO initiate this.

	public static void initiateAccessCode() {
		accessCode = ioPak.setConPD("original access code");
		Data.setAccessCode(accessCode);
	}
}// end of class Main_Interface
