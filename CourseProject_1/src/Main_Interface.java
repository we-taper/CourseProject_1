
// TODO:
/*
 * 1. Support to temporarily store last time data.
 * 2. Pass Money as an object to avoid duplicate methods.// Cann't do it.
 * 3. Support block certain employee from login in.// DONE
 * 4. Add asc2 pictures to each sub methods.
 * 5. Add password tip.
 * 6. Deal with C-Z error.// DONE
 * 7. Add thank-you info.
 * 8. Add quit option to all things.
 * 9. Enable clear screen for all accounts.
 * 10.Test all data.
 * 11.业绩，数据分析
 * 12.管理员 ranking
 * 13.订单记录
 * 14.销售员 记录老客户
 * 15.Admin knows all the profit // By Zao
 * 16.Change access code
 */
public class Main_Interface {
	private static int CurrentUserID = 0;
	private static int ADMIN_ID = -1;
	private static Salesman salesman = new Salesman();
	private static Administrator admin = new Administrator();
	private static String accessCode = "";

	public static void main(String[] args) {
		// if first time, initialize admin account.
		ioPak.printf(78, 20, 20, "Welcome to Storage Management System");
		if (Data.firstTime()) {
			initiateAccessCode();
			initiateAdmin();
			ioPak.cls();
			ioPak.printf("Program has been initiated, now let's get it working!!");
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
		ioPak.printf("Welcome to Storage Management system.");
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
					+ "                      ;   |.    `. \\\""
					+ "");
		while (true) {
			// Help user log into their accounts.
			ioPak.printf(
					 "Please enter your choice:\n"
					+ "1: Administrator login.\n" 
					+ "2: Salesman login.\n"
					+ "3: Register a new salesman account.\n" 
					+ "4: Quit."
					+ "");
			choice = ioPak.getInt("Your choice:",1,4);
			if (choice == 1)
			{
				adminLogin();
				ioPak.printf("Welcome back!!");
			}
			else if (choice == 2)
			{
				if (Data.getSalesmanCount() == 0)
				{
					ioPak.printf("No account exists yet, please register one.");
				}
				else
				{

					testSMPD();
					ioPak.printf("Welcome back!!");
				}
			} else if (choice == 3) {
				register();
				login(CurrentUserID);
				ioPak.printf("Welcome back!!");
			} else if (choice == 4) {
				ioPak.printf("Auf Wiedersehen~~\nPress anykey to exit.");
				break;
			} else {}// end of if
		}// end while(true)
	}

	private static void testSMPD() {
		String pd;
		while (true)//Get User ID
			{
			try {
				CurrentUserID = ioPak.getInt("Please enter your ID: ", 1,
						Data.getSalesmanCount());
				if (Data.getSalesman(CurrentUserID).isDisabled())
				{
					ioPak.printf(
							"Sorry, the account \"%s\"(ID:%d) was disabled by administrator.\n"
									+ "Please ask your administrator to enable you account.",
							Data.getSalesman(CurrentUserID).getName(),
							CurrentUserID);
					return;
				}
				System.out.printf(
						"Please enter your passowrd for user \"%s\"\nInput: ",
						Data.getSalesman(CurrentUserID).getName());
				pd = ioPak.getConPD();
				if (pd.equals(Data.getSalesman(CurrentUserID).getPassword()))
				{
					login(CurrentUserID);
					return;
				}
				for (int i = 2; i > 0; i--)// Count down to eliminate try-chances.
				{

					ioPak.printf(false, false, 0,
							"Sorry, wrong Password! Please check.\n"
									+ "(You still have " + i
									+ " chances to input!)");
					System.out.printf("Password: ");
					pd = ioPak.getConPD();
					if (pd.equals(Data.getSalesman(CurrentUserID).getPassword()))
					{
						login(CurrentUserID);
						break;
					}
				}// end for
				ioPak.printf("Sorry, program will now exit.");
				return;
			} catch (IndexOutOfBoundsException e)
			{
				System.out.printf("No such account exists, please try again.\n");
			}// try-catch
		}// end while

	}// end of login
	private static void login(int ID) {
		if (ID == ADMIN_ID) {
			admin = Admin_op.main(Data.getAdmin());
			ioPak.cls();// clear screen.
			// Then write admin into Data
			Data.setAdmin(admin);
		} else {
			salesman = Sale_Op.main(Data.getSalesman(CurrentUserID));
			ioPak.cls();// clear screen.
			// Then write salesman into Data
			Data.setSalesman(CurrentUserID, salesman);
		}
	}// end of login

	private static void adminLogin() {
		testAdminPD();
	}

	private static void testAdminPD(){
		admin = Data.getAdmin();
		ioPak.printf("Please Input Password For Administrator!");
		System.out.printf("Password: ");
		String pd = ioPak.getConPD();
		if (pd.equals(admin.getPassword())){
			login(ADMIN_ID);
			return;
		}
		for (int i = 2; i > 0; i--)
		{
			ioPak.printf(false, false, 0,
					"Sorry, wrong Password! Please check.\n"
							+ "(You still have " + i
							+ " chances to input!)");
			System.out.printf("Password: ");
			pd = ioPak.getConPD();
			if (pd.equals(admin.getPassword())){
				login(ADMIN_ID);
				return;
			}
		}
		ioPak.printf("Out of chances. Sorry~~.");
	}

	private static void register() {
		// Retrieve data from user.
		salesman.setName(ioPak.setUserName());
		salesman.setPassword(ioPak.setConPD("Salesman "+salesman.getName()));
		CurrentUserID = Data.getSalesmanCount() + 1;
		salesman.setAccountID(CurrentUserID);
		CurrentUserID = Data.addSalesman(salesman, CurrentUserID);
		// Above add account to salesman, return a
		// accountID if add successfully and return a
		// Data.CREAT_FAILED if add unsuccessfully
		if (CurrentUserID == Data.CREAT_FAILED) {
			ioPak.printf("Failed to creat your account");
		} else {// Successfully Created
			ioPak.printf("Successfully registered."
					+ "Your account ID is %d.\n"
					+ "Please remember you accountID, or else you will not \n"
					+ "be able to login again.", CurrentUserID);
		}

		salesman = null;
	}// end of register

	private static void judgeAccessCode() {
		byte[] dataUser, dataFile;
		boolean equal = true;
		String ac;// Use a temporary String ac so that accessCode remain either valid or empty.
		for (int i = 2; i >= 0; i--)
		{
			System.out.printf("Please enter the access code:");
			ac = ioPak.getConPD();
			dataUser = encryption.byte2MD5(encryption.Str2SHA256(ac));
			dataFile = Data.getHashAccessCode();
			for (int j = 0; j < dataUser.length; j++) {
				if (dataUser[j] != dataFile[j]) {
					equal = false;
					break;
				}
			}
			if (!equal) {
				if(i != 0)
				{
					ioPak.printf("Wrong Access Code. Still %d chance(s) left.", i);
					equal = true;
				}
			}else{
				accessCode = ac;
				return;
			}
		}
		ioPak.printf("Out of chance, sorry~~\nSytem will now exit!");
		System.exit(1);
	}

	private static void initiateAccessCode() {
		ioPak.printf("It's your first time running this program, please "
				+ "set your Access Code.");
		accessCode = ioPak.setConPD("original access code");
		Data.setAccessCode(accessCode);
	}

	private static void initiateAdmin() {
		admin = Data.getAdmin();
		ioPak.printf("And then, please set your password for Administrator.");
		admin.setPassword(ioPak.setConPD("Administrator"));
		
	}
	
	public static String getAccessCode(){
		/**
		 *  This method should work only of the ioPak!!
		 */
		return accessCode;
	}
}// end of class Main_Interface
