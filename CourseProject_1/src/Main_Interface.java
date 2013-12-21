import java.security.GeneralSecurityException;

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
		ioPak.printf(CS.All_LENGTH, 20, 20, "Welcome to Sale Management System");
		if (Data.firstTime()) {
			initiateAccessCode();
			initiateAdmin();
			ioPak.printWait(CS.LEVEL1, CS.WAIT_FOR_BAR,"Decrypting Data...", "  Done!\n");
			ioPak.printf(CS.LEVEL1,
""+
"		         ,--\"\"\"\",--.__,---[],-------._\n"+         
"       ,\"   __,\'            \\         \\--\"\"\"\"\"\"==;-\n"+
"     ,\" _,-\"  \"/---.___     \\       ___\\   ,-\'\',\"\n"+
"    /,-\'      / ;. ,.--\'-.__\\  _,-\"\" ,| `,\'   /\n"+
"   /``\"\"\"\"-._/,-|:\\       []\\,\' ```-/:;-. `. /\n"+
"             `  ;:::      ||       /:,;  `-.\\\n"+
"                =.,\'__,---||-.____\',.=\n"+
"                =(:\\_     ||__    ):)=\n"+
"               ,\"::::`----||::`--\':::\"._\n"+
"             ,\':::::::::::||::::::::::::\'.\n"+
"    .__     ;:::.-.:::::__||___:::::.-.:::\\     __,\n"+
"       \"\"\"-;:::( O )::::>_|| _<::::( O )::::-\"\"\"\n"+
"   =======;:::::`-`:::::::||\':::::::`-`:::::\\=======\n"+
"    ,--\"\";:::_____________||______________::::\"\"----.          , ,\n"+
"         ; ::`._(    |    |||     |   )_,\'::::\\_,,,,,,,,,,____/,\'_,\n"+
"       ,;    :::`--._|____[]|_____|_.-\'::::::::::::::::::::::::);_\n"+
"      ;/ /      :::::::::,||,:::::::::::::::::::::::::::::::::::/\n"+
"     /; ``\'\'\'\'----------/,\'/,__,,,,,____:::::::::::::::::::::,\"\n"+
"     ;/                :);/|_;| ,--.. . ```-.:::::::::::::_,\"\n"+
"    /;                :::):__,\'//\"\"\\\\. ,--.. \\:::,:::::_,\"\n"+
"   ;/              :::::/ . . . . . . //\"\"\\\\. \\::\":__,\"\n"+
"   ;/          :::::::,\' . . . . . . . . . . .:`::\\\n"+
"   \';      :::::::__,\'. ,--.. . .,--. . . . . .:`::`\n"+
"   \';   __,..--\'\'\'-. . //\"\"\\\\. .//\"\"\\\\ . ,--.. :`:::`\n"+
"   ;    /  \\\\ .//\"\"\\\\ . . . . . . . . . //\"\"\\\\. :`::`\n"+
"   ;   /       . . . . . . . . . . . . . . . . .:`::`\n"+
"   ;   (          . . . . . . . . . . . . . . . ;:::`\n"+
"   ,:  ;,            . . . . . . . . . . . . . ;\':::`\n"+
"   ,:  ;,             . . . . . . . . . . . . .;`:::\n"+
"   ,:   ;,             . . . . . . . . . . . . ;`::;`\n"+
"    ,:  ;             . . . . . . . . . . . . ;\':::;`\n"+
"     :   ;             . . . . . . . . . . . ,\':::;\n"+
"      :   \'.          . . . . . . . .. . . .,\':::;`\n"+
"       :    `.       . . . . . . . . . . . ;::::;`\n"+
"        \'.    `-.   . . . . . . . . . . ,-\'::::;\n"+
"          `:_    ``--..___________..--\'\':::::;\'`\n"+
"             `._::,.:,.:,:_-_-_:,:,.::,.:_;\'`\n"+
"________________`\"\\/\"\\/\\/\'\"\"\"\"`\\/\"\\/\"\"\\/\"____________________________\n"+		
					"");
			ioPak.printf(CS.All_LENGTH,3,3,"Program has been initiated, now let's get it working!!");
		}
		judgeAccessCode();
		try
		{
			Data.initiateData(accessCode);
		} catch (GeneralSecurityException  e)
		{
			ioPak.printf(CS.LEVEL1, 
					"Wrong Access Code! Perhaps you have\n"
					+ "opened a file that has a different access code previous\n"
					+ "(e.g. a backup file).\n"
					+ "Please now type the original access code for that file\n"
					+ "(if you remember it). Make sure it is correct or else the\n"
					+ "system has to quit.");
			try
			{
				System.out.printf(CS.level1()+"Previous access code:");
				String acode = ioPak.getConPD(CS.LEVEL1);
				Data.initiateData(acode);
				// If successfully decrypt file
				accessCode = acode;
				ioPak.printf(CS.LEVEL1, "Now the access code for this file\n"
						+ "was changed to the current one(which you typed before)");
				ioPak.typeATC(CS.LEVEL1);
				Data.setAccessCode(accessCode);
			} catch (GeneralSecurityException  e1)
			{
				ioPak.printf("Wrong access code again!\n"
						+ "System will now exit.");
				System.exit(1);
			}
		}
		ioPak.printWait(CS.LEVEL1, CS.WAIT_FOR_BAR,"Decrypting Data...", "  Done!\n");
		ioPak.cls();// Clear Screen
		mainMenu();
		// After login. Write all data to file.
		Data.storeData(accessCode);
		// Since last time we use access code, clear it afterwards.
		accessCode = "";
	}// end of main

	private static void mainMenu() {
		int choice = 0;
		ioPak.printf(CS.All_LENGTH,20,20,CS.LEVEL1,"Welcome to Sale Management system.");
		ioPak.printf(CS.LEVEL1,
					  ",------------.                ,.--\"\"-._\n"
					+ "|     Sale    `.           __/         `.\n"
					+ "|               |     _,**\"   \"*-.       `.\n"
					+ "|  Management   |   ,'            `.       \\\n"
					+ "|               |  ;    _,.---._    \\  ,'\\  \\\n"
					+ "|    System     | :   ,'   ,-.. `.   \\'   \\ :\n"
					+ "`---------------' |  ;_\\  (___)`  `-..__  : |\n"
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
			ioPak.printf(CS.LEVEL1,
					 "Please enter your choice:\n"
					+ "1: Administrator login.\n" 
					+ "2: Salesman login.\n"
					+ "3: Register a new salesman account.\n" 
					+ "4: About me.\n"
					+ "5: Quit."
					+ "");
			choice = ioPak.getInt(CS.LEVEL1,"Your choice:",1,5);
			if (choice == 1)
			{
				adminLogin();
				ioPak.printf(CS.LEVEL1,"Welcome back!!");
			}
			else if (choice == 2)
			{
				if (Data.getSalesmanCount() == 0)
				{
					ioPak.printf(CS.LEVEL1,"No account exists yet, please register one.");
				}
				else
				{
					testSMPD();
					ioPak.printf(CS.LEVEL1,"Welcome back!!");
				}
			} else if (choice == 3) {
				registerSalesman();
				login(CurrentUserID);
				ioPak.printf(CS.LEVEL1,"Welcome back!!");
			} else if (choice == 4) {
				printAboutUs();
			} else if (choice == 5) {
				ioPak.printWait(CS.LEVEL1, CS.WAIT_FOR_BAR, "Storing Data...","  Done!\n");
				ioPak.printf(CS.LEVEL1,"Auf Wiedersehen~~\nPress anykey to exit.");
				ioPak.printf(
"                        / )\n"+
"        (\\__/)         ( (\n"+
"        )    (          ) )\n"+
"      ={      }=       / /\n"+
"        )     `-------/ /\n"+
"       (               /\n"+
"        \\     B y e !  |\n"+
"       ,\'\\       ,    ,\'\n"+
"       `-\'\\  ,---\\   | \\\n"+
"          _) )    `. \\ /\n"+
"         (__/       ) ) \n"+
"                   (_/\n"+
						"");
				break;
			} else {}// end of if
		}// end while(true)
	}

	private static void testSMPD() {
		String pd;
		while (true)//Get User ID
			{
			try {
				CurrentUserID = ioPak.getInt(CS.LEVEL1,"Please enter your ID: ", 1,
						Data.getSalesmanCount());
				if (Data.getSalesman(CurrentUserID).isDisabled())
				{
					ioPak.printf(CS.LEVEL1,
							"Sorry, the account \"%s\"(ID:%d) was disabled by administrator.\n"
									+ "Please ask your administrator to enable you account.",
							Data.getSalesman(CurrentUserID).getName(),
							CurrentUserID);
					return;
				}
				System.out.printf(CS.level1()+
						"Please enter your passowrd for user \"%s\"\n",
						Data.getSalesman(CurrentUserID).getName());
				System.out.printf(CS.level1()+"Input: ");
				pd = ioPak.getConPD(CS.LEVEL1);
				if (pd.equals(Data.getSalesman(CurrentUserID).getPassword()))
				{
					login(CurrentUserID);
					return;
				}
				for (int i = 2; i > 0; i--)// Count down to eliminate try-chances.
				{

					ioPak.printWarn(CS.LEVEL1,
							"Sorry, wrong Password! Please check.\n"
									+ "(You still have " + i
									+ " chances to input!)");
					System.out.printf(CS.level1()+"Password: ");
					pd = ioPak.getConPD();
					if (pd.equals(Data.getSalesman(CurrentUserID).getPassword()))
					{
						login(CurrentUserID);
						break;
					}
				}// end for
				ioPak.printf(CS.LEVEL1,"Sorry, program will now exit.");
				return;
			} catch (IndexOutOfBoundsException e)
			{
				e.printStackTrace();
				System.out.printf(CS.level1()+"No such account exists, please try again.\n");
			}// try-catch
		}// end while

	}// end of login
	private static void login(int ID) {
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

	private static void adminLogin() {
		testAdminPD();
	}

	private static void testAdminPD(){
		admin = Data.getAdmin();
		ioPak.printf(CS.LEVEL1,"Please Input Password For Administrator!");
		System.out.printf(CS.level1()+"Password: ");
		String pd = ioPak.getConPD();
		if (pd.equals(admin.getPassword())){
			login(ADMIN_ID);
			return;
		}
		for (int i = 2; i > 0; i--)
		{
			ioPak.printWarn(CS.LEVEL1,
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
		ioPak.printf(CS.LEVEL1,"Out of chances. Sorry~~.");
	}

	private static void registerSalesman() {
		// Retrieve data from user.
		ioPak.printNextLevel(CS.LEVEL1, CS.LEVEL2, CS.LEVEL_G);
		salesman.setName(ioPak.setUserName(CS.LEVEL2));
		salesman.setPassword(ioPak.setConPD(CS.LEVEL2,"Salesman "+salesman.getName()));
		CurrentUserID = Data.getSalesmanCount() + 1;
		salesman.setAccountID(CurrentUserID);
		CurrentUserID = Data.addSalesman(salesman, CurrentUserID);
		// Above add account to salesman, return a
		// accountID if add successfully and return a
		// Data.CREAT_FAILED if add unsuccessfully
		if (CurrentUserID == Data.CREAT_FAILED) {
			ioPak.printf(CS.LEVEL2,"Failed to creat your account");
		} else {// Successfully Created
			ioPak.printf(CS.LEVEL2,"Successfully registered."
					+ "Your account ID is %d.\n"
					+ "Please remember you accountID, or else you will not \n"
					+ "be able to login again.", CurrentUserID);
			ioPak.typeATC(CS.LEVEL2);
		}
		ioPak.printBackLevel(CS.LEVEL1, CS.LEVEL2, CS.LEVEL_G);
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
		ioPak.printf(CS.All_LENGTH,3,3,"It's your first time running this program, please "
				+ "set your Access Code.");
		accessCode = ioPak.setConPD("original access code");
		Data.setAccessCode(accessCode);
	}

	private static void initiateAdmin() {
		admin = Data.getAdmin();
		ioPak.printNextDo(CS.LEVEL1,"And then, please set your password for Administrator.");
		admin.setPassword(ioPak.setConPD(CS.LEVEL1,"Administrator"));
		
	}
	private static void printAboutUs()
	{
		ioPak.printf(CS.LEVEL1,
""+
"		         ,--\"\"\"\",--.__,---[],-------._\n"+         
"       ,\"   __,\'            \\         \\--\"\"\"\"\"\"==;-\n"+
"     ,\" _,-\"  \"/---.___     \\       ___\\   ,-\'\',\"\n"+
"    /,-\'      / ;. ,.--\'-.__\\  _,-\"\" ,| `,\'   /\n"+
"   /``\"\"\"\"-._/,-|:\\       []\\,\' ```-/:;-. `. /\n"+
"             `  ;:::      ||       /:,;  `-.\\\n"+
"                =.,\'__,---||-.____\',.=\n"+
"                =(:\\_     ||__    ):)=\n"+
"               ,\"::::`----||::`--\':::\"._\n"+
"             ,\':::::::::::||::::::::::::\'.\n"+
"    .__     ;:::.-.:::::__||___:::::.-.:::\\     __,\n"+
"       \"\"\"-;:::( O )::::>_|| _<::::( O )::::-\"\"\"\n"+
"   =======;:::::`-`:::::::||\':::::::`-`:::::\\=======\n"+
"    ,--\"\";:::_____________||______________::::\"\"----.          , ,\n"+
"         ; ::`._(    |    |||     |   )_,\'::::\\_,,,,,,,,,,____/,\'_,\n"+
"       ,;    :::`--._|____[]|_____|_.-\'::::::::::::::::::::::::);_\n"+
"      ;/ /      :::::::::,||,:::::::::::::::::::::::::::::::::::/\n"+
"     /; ``\'\'\'\'----------/,\'/,__,,,,,____:::::::::::::::::::::,\"\n"+
"     ;/                :);/|_;| ,--.. . ```-.:::::::::::::_,\"\n"+
"    /;                :::):__,\'//\"\"\\\\. ,--.. \\:::,:::::_,\"\n"+
"   ;/              :::::/ . . . . . . //\"\"\\\\. \\::\":__,\"\n"+
"   ;/          :::::::,\' . . . . . . . . . . .:`::\\\n"+
"   \';      :::::::__,\'. ,--.. . .,--. . . . . .:`::`\n"+
"   \';   __,..--\'\'\'-. . //\"\"\\\\. .//\"\"\\\\ . ,--.. :`:::`\n"+
"   ;    /  \\\\ .//\"\"\\\\ . . . . . . . . . //\"\"\\\\. :`::`\n"+
"   ;   /       . . . . . . . . . . . . . . . . .:`::`\n"+
"   ;   (          . . . . . . . . . . . . . . . ;:::`\n"+
"   ,:  ;,         Programmer: . . . .  . . . . ;\':::`\n"+
"   ,:  ;,               we.taper . . .. . . . .;`:::\n"+
"   ,:   ;,              KoEki . . . .  . . . . ;`::;`\n"+
"    ,:  ;               Lily. Zhang. .. . . . ;\':::;`\n"+
"     :   ;        Post Design:. . . .  . . . ,\':::;\n"+
"      :   \'.           Lily, Zhang . . . . .,\':::;`\n"+
"       :    `.       . . . . . . . . . . . ;::::;`\n"+
"        \'.    `-.   . . . . . . . . . . ,-\'::::;\n"+
"          `:_    ``--..___________..--\'\':::::;\'`\n"+
"             `._::,.:,.:,:_-_-_:,:,.::,.:_;\'`\n"+
"________________`\"\\/\"\\/\\/\'\"\"\"\"`\\/\"\\/\"\"\\/\"____________________________\n"+		
				"");
		ioPak.typeATC(CS.LEVEL1);
	}
	
	public static String getAccessCode(){
		/**
		 *  This method should work only of the ioPak!!
		 *  and ChangeAC() in Admin_op as well.
		 */
		return accessCode;
	}
	public static void setAccessCode(String acode){
		/**
		 *  This method should work only of the ioPak!!
		 *  and ChangeAC() in Admin_op as well.
		 */
		accessCode = acode;
	}
}// end of class Main_Interface
