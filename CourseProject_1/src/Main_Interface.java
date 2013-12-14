import java.util.InputMismatchException;
import java.util.Scanner;
// TODO:
/*
 * 1. Support to temporarily store last time data.
 * 2. Pass Money as an object to avoid duplicate methods.// Cann't do it.
 * 3. Support block certain employee from login in.
 * 4. Add asc2 pictures to each sub methods.
 * 5. Add password tip.
 * 6. Deal with C-Z error.
 */
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
			initiateAccessCode();
			initiateAdmin();
			ioPak.printf("Program has been initiated, now let's get it working!!\n");
		}
		judgeAccessCode();
		Data.initiateData(accessCode);
		ioPak.cls();
		mainMenu();
		// After login. Write all data to file.
		Data.storeData(accessCode);
		// Since last time we use access code, clear it afterwards.
		accessCode = "";
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
			if (choice == 1)
			{
				adminLogin();
				ioPak.cls();
				ioPak.printf("Welcome back!!\n");
			}
			else if (choice == 2)
			{
				if (Data.getSalesmanCount() == 0)
				{
					System.out
							.printf("No account exists yet, please register one.\n");
				}
				else
				{

					testSMPD();
					ioPak.cls();
					ioPak.printf("Welcome back!!\n");
				}
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

	public static void testSMPD() {
		String pd;


		while (true)//Get User ID
			{
			try {
				System.out.printf("Please enter your ID: ");
				CurrentUserID = input.nextInt();
				input.nextLine();// Clear away the subtle errors.
				System.out.printf(
						"Please enter your passowrd for user \"%s\"\nInput: ",
						Data.getSalesman(CurrentUserID).getName());
				pd = ioPak.getConPD();
				for (int i = 2; i > 0; i--)
				{
					if (pd.equals(Data.getSalesman(CurrentUserID).getPassword()))
					{
						login(CurrentUserID);
						break;
					}
					else
					{

						ioPak.printf(false, false, 0,
								"Sorry, wrong Password! Please check.\n"
										+ "(You still have " + i
										+ " chances to input!)\n");
						System.out.printf("Password: ");
						pd = ioPak.getConPD();
					}
					ioPak.printf("Sorry, program will now exit.");
				}// end for
				break;
			} catch (InputMismatchException inputMismmatchExcpetion) {
				System.out
						.printf("Come on, try again and type something right.\n");
				input.nextLine();// Clear input line.
			} catch (IndexOutOfBoundsException e)
			{
				System.out.printf("No such account exists, please try again.\n");
			}// try-catch
		}// end while

	}// end of login
	public static void login(int ID) {
		if (ID == ADMIN_ID) {
			admin = Admin_op.main(Data.getAdmin());
			// Then write admin into Data
			Data.setAdmin(admin);
		} else {
			salesman = Sale_Op.main(Data.getSalesman(CurrentUserID));
			// Then write salesman into Data
			Data.setSalesman(CurrentUserID, salesman);
		}
	}// end of login

	public static void adminLogin() {
		testAdminPD();
	}

	public static void testAdminPD(){
		admin = Data.getAdmin();
		ioPak.println("Please Input Password For Administrator!");
		System.out.printf("Password: ");
		String pd = ioPak.getConPD();
		for (int i = 2; i > 0; i--)
		{
			if (pd.equals(admin.getPassword())){
				login(ADMIN_ID);
				break;
			}
			else
			{
			ioPak.printf(false, false, 0,
					"Sorry, wrong Password! Please check.\n"
							+ "(You still have " + i
							+ " chances to input!)\n");
			System.out.printf("Password: ");
			pd = ioPak.getConPD();
			}
			ioPak.printf("Sorry, program will now exit.");
		}
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

	public static void initiateAccessCode() {
		ioPak.printf("It's your first time running this program, please "
				+ "set your Access Code.\n");
		accessCode = ioPak.setConPD("original access code");
		Data.setAccessCode(accessCode);
	}

	public static void initiateAdmin() {
		admin = Data.getAdmin();
		ioPak.printf(false, false, 0,"And, please set your password for Administrator.\n");
		admin.setPassword(ioPak.setConPD("password"));
		
	}
}// end of class Main_Interface
