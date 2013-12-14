import java.util.Scanner;
public class Admin_op
{
	public static Administrator main (Administrator admin){
		
		
		return admin;
	}
/*	public static void main(String[] args)
	{
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		//Initial Warning Line of Profit(decimal number).(VARIABLE)
		float ProfitWL_D=(float) 0.2;
		//Initial Amount of Products.(VARIABLE)
		int iPad2_Amount=20;
		int iPad3_Amount=20;
		int iPhone4_Amount=20;
		int iPhone4S_Amount=20;
		int iPhone5_Amount=20;
		int iPhone5S_Amount=20;
		//Initial Purchase Price of Products.(VARIABLE)
		float iPad2_Price_In=3000;
		float iPad3_Price_In=3999;
		float iPhone4_Price_In=3000;
		float iPhone4S_Price_In=4005;
		float iPhone5_Price_In=6000;
		float iPhone5S_Price_In=6000;
		//Suggested Selling Price of Products.(VARIABLE)
		float iPad2_Price=(float) ((1+ProfitWL_D)*iPad2_Price_In);
		float iPad3_Price=(float) ((1+ProfitWL_D)*iPad3_Price_In);
		float iPhone4_Price=(float) ((1+ProfitWL_D)*iPhone4_Price_In);
		float iPhone4S_Price=(float) ((1+ProfitWL_D)*iPhone4S_Price_In);
		float iPhone5_Price=(float) ((1+ProfitWL_D)*iPhone5_Price_In);
		float iPhone5S_Price=(float) ((1+ProfitWL_D)*iPhone5S_Price_In);
		//Actual Selling Price of Products.(VARIABLE)
		float iPad2=iPad2_Price;
		float iPad3=iPad3_Price;
		float iPhone4=iPhone4_Price;
		float iPhone4S=iPhone4S_Price;
		float iPhone5=iPhone5_Price;
		float iPhone5S=iPhone5S_Price;
		//The Amount of Money.(VARIABLE)
		float MoneyAmount=200000;
		//(VARIABLE)
		int Add;//Administrator Stockpiling.
		int AccountID;//Salesman Account ID.
		//Initial AdministratorPassword.(VARIABLE)
		String AdministratorPassword="12345";
		//Initial SalesmanPassword.(VARIABLE)
		String Salesman01Password="12345";
		String Salesman02Password="12345";
		String Salesman03Password="12345";
		String Salesman04Password="12345";
		String Salesman05Password="12345";
		//Initial Salesman Sales.(VARIABLE)
		float SM01Sales=0;
		float SM02Sales=0;
		float SM03Sales=0;
		float SM04Sales=0;
 		float SM05Sales=0;
		//Initial Salesman Profit.(VARIABLE)
		float SM01Profit=0;
		float SM02Profit=0;
		float SM03Profit=0;
		float SM04Profit=0;
		float SM05Profit=0;
		int i;
		int I;
		String a = null;
		String A=null;
		boolean MainYESorNO=true;
		while (MainYESorNO==true){ //TODO login
			System.out.println("Welcome to the SMS, the SALES MANAGEMENT SYSTEM.");
			System.out.println("Press 1 for Login as Administrator.");
			System.out.println("Press 2 for Login as Salesman.");
			System.out.println("Press 3 for STOP this Programme.");
			int MainChoice=input.nextInt();
			switch (MainChoice) {
			case 1:
				//Enter Administrator Account.(GET) TODO admin
				i=4;
				System.out.println("Please Input Password For Administrator!");
				for(i=4;i>0;i--){
					System.out.printf("you have "+ i +" chances to input!");
					a=input.next();
					if(a.intern()==AdministratorPassword.intern())break;
				}
				if(a.intern()==AdministratorPassword.intern()){
					boolean AdministratorMainYESorNO=true;
					while(AdministratorMainYESorNO==true){
						System.out.println("As An Administrator, You Can Do:");
						System.out.println("1. My Account:\n"
								         + "  (1). Change Password;\n"
								         + "2. My Products:\n"
								         + "  (1). Check Inventory;\n"
							           	 + "  (2). Update Inventory Information: Stockpiling;\n"
								         + "3. My Money:\n"
								         + "  (1). Selling Price Query;\n"
								         + "  (2). Purchase Price Query;\n"
								         + "  (3). Set the Warning Line of Profit;\n"
								         + "  (4). The Amount of Money Query.");
						System.out.println("ADMINISTRATOR MAIN MENU");
						System.out.println("Press 1 for My Account.");
						System.out.println("Press 2 for My Products.");
						System.out.println("Press 3 for My Money.");
						System.out.println("Press 4 for Logout Administrator.");
						int AdministratorMainChoice=input.nextInt();
						switch(AdministratorMainChoice){
						case 1://Account Management.(GET)
							boolean AccountYESorNO=true;
							while (AccountYESorNO==true){
								System.out.println("My Account MENU");
								System.out.println("Press 1 for The Administrator Permissions.");
								System.out.println("Press 2 for Change Password.");
								System.out.println("Press 3 for Exit Account Management.");
								int AccountChoice=input.nextInt();
								switch(AccountChoice){
								case 1://The Administrator Permissions.(GET)
									System.out.println("As An Administrator, You Can Do:");
									System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Products:\n"
											         + "  (1). Check Inventory;\n"
										           	 + "  (2). Update Inventory Information: Stockpiling;\n"
											         + "3. My Money:\n"
											         + "  (1). Selling Price Query;\n"
											         + "  (2). Purchase Price Query;\n"
											         + "  (3). Set the Warning Line of Profit;\n"
											         + "  (4). The Amount of Money Query.");
								break;
								case 2://Change Password.(GET)
									System.out.printf("Current Password:");
									String CurrentPassword=input.next();
									while(CurrentPassword.intern()!=AdministratorPassword.intern()){
										System.out.println("The password you gave is incorrect.");
										System.out.printf("Please try again:");
										CurrentPassword=input.next();
									}
									System.out.printf("New Password:");
									String newpassword=input.next();
									while(newpassword.intern()==AdministratorPassword.intern()){
										System.out.println("New Password should be different to Current Password.");
										System.out.printf("Please choose another Password:");
										newpassword=input.next();
									}
									String reinput="39iuqfion";
									while (reinput.intern()!=newpassword.intern()) {
									System.out.printf("Confirm new Password");
									reinput=input.next();
									if(reinput.intern()==newpassword.intern()){
										AdministratorPassword=newpassword;
										System.out.println("You have reset your password to be:"+AdministratorPassword);
									}
									else System.out.println("Wrong Input!");
									}
								break;
								case 3://Exit Account Management.(GET)
									AccountYESorNO=false;
									System.out.println("Exit Account Management.");
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						break;
						case 2://My Products.
							boolean ProductsYESorNO=true;
							while(ProductsYESorNO==true){
								System.out.println("My Products MENU");
								System.out.println("Press 1 for Check Inquiry.");
								System.out.println("Press 2 for Update Inventory Information: Stockpiling.");
								System.out.println("Press 3 for Exit Products Management.");
								int ProductsChoice=input.nextInt();
								switch(ProductsChoice){
								case 1://Check Inventory.(GET)
									boolean CheckInventoryYESorNO=true;
									while (CheckInventoryYESorNO==true){
										System.out.println("Check Inventory");
										System.out.println("Choose the Product:");
										System.out.println("Press 1 for iPad2;");
										System.out.println("Press 2 for iPad3;");
										System.out.println("Press 3 for iPhone4;");
										System.out.println("Press 4 for iPhone4S;");
										System.out.println("Press 5 for iPhone5;");
										System.out.println("Press 6 for iPhone5S;");
										System.out.println("Press 7 for Exit Check Inventory.");
										int SpProductsChoice=input.nextInt();
										switch(SpProductsChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left.");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left.");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left.");
											break;
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left.");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left.");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left.");
											break;
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
										break;
										case 7://Exit Check Inventory.(GET)
											CheckInventoryYESorNO=false;
											System.out.println("Exit Products Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://Update Inventory Information:Stockpiling.(GET)
									boolean SpYESorNO=true;
									while (SpYESorNO==true){
										System.out.println("Update Inventory Information:Stockpiling");
										System.out.println("Choose the Product:");
										System.out.println("Press 1 for iPad 2;");
										System.out.println("Press 2 for iPad 3;");
										System.out.println("Press 3 for iPhone 4;");
										System.out.println("Press 4 for iPhone 4S;");
										System.out.println("Press 5 for iPhone 5;");
										System.out.println("Press 6 for iPhone 5S;");
										System.out.println("Press 7 for Exit Stockpiling.");
										int SpProductChoice=input.nextInt();
										switch(SpProductChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left.");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left.");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left.");
											break;
											}
											System.out.printf("Adding How Many iPad2 to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPad2:");
											iPad2_Price_In=input.nextFloat();
											while (iPad2_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPad2_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPad2_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPad2_Price_In;
												iPad2_Amount=iPad2_Amount+Add;
												iPad2_Price=(float) ((1+ProfitWL_D)*iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left.");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left.");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left.");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left.");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left.");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left.");
											break;
											}
											System.out.printf("Adding How Many iPad3 to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPad3:");
											iPad3_Price_In=input.nextFloat();
											while (iPad3_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPad3_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPad3_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPad3_Price_In;
												iPad3_Amount=iPad3_Amount+Add;
												iPad3_Price=(float) ((1+ProfitWL_D)*iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left.");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left.");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left.");
												break;
												}										}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("Adding How Many iPhone4 to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPhone4:");
											iPhone4_Price_In=input.nextFloat();
											while (iPhone4_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPhone4_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPhone4_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPhone4_Price_In;
												iPhone4_Amount=iPhone4_Amount+Add;
												iPhone4_Price=(float) ((1+ProfitWL_D)*iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("Adding How Many iPhone4S to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPhone4S:");
											iPhone4S_Price_In=input.nextFloat();
											while (iPhone4S_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPhone4S_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPhone4S_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPhone4S_Price_In;
												iPhone4S_Amount=iPhone4S_Amount+Add;
												iPhone4S_Price=(float) ((1+ProfitWL_D)*iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("Adding How Many iPhone5 to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPhone5:");
											iPhone5_Price_In=input.nextFloat();
											while (iPhone5_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPhone5_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPhone5_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPhone5_Price_In;
												iPhone5_Amount=iPhone5_Amount+Add;
												iPhone5_Price=(float) ((1+ProfitWL_D)*iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
											break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("Adding How Many iPhone5S to Storhouse?");
											Add=input.nextInt();
											while (Add<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												Add=input.nextInt();
											}
											System.out.printf("The Purchase Price for each iPhone5S:");
											iPhone5S_Price_In=input.nextFloat();
											while (iPhone5S_Price_In<=0){
												System.out.println("You should input a positive number.");
												System.out.printf("Input Again:");
												iPhone5S_Price_In=input.nextInt();
											}
											if (MoneyAmount-Add*iPhone5S_Price_In<0){
												System.out.println("You don't have enough money.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												MoneyAmount=MoneyAmount-Add*iPhone5S_Price_In;
												iPhone5S_Amount=iPhone5S_Amount+Add;
												iPhone5S_Price=(float) ((1+ProfitWL_D)*iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7://Exit Stockpiling.(GET)
											SpYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://Exit Products Management.(GET)
									ProductsYESorNO=false;
									System.out.println("Exit My Products.");
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						break;
						case 3://My Money.(GET)
							boolean MoneyYESorNO=true;
							while(MoneyYESorNO==true){
								System.out.println("My Money MENU");
								System.out.println("Press 1 for Selling Price Query.");
								System.out.println("Press 2 for Purchase Price Query.");
								System.out.println("Press 3 for Set the Warning Line of Profit.");
								System.out.println("Press 4 for The Amount of Money Query.");
								System.out.println("Press 5 for Exit My Money.");
								int MoneyChoice=input.nextInt();
								switch (MoneyChoice){
								case 1://Selling Price Query.(GET)
									System.out.println("The current Selling Prices of Priducts are as follow:");
									System.out.println("iPad2:--------------------"+iPad2+" CNY.");
									System.out.println("iPad3:--------------------"+iPad3+" CNY.");
									System.out.println("iPhone4:------------------"+iPhone4+" CNY.");
									System.out.println("iPhone4S:-----------------"+iPhone4S+" CNY.");
									System.out.println("iPhone5:------------------"+iPhone5+" CNY.");
									System.out.println("iPhone5S:-----------------"+iPhone5S+" CNY.");
								break;
								case 2://Purchase Price Query.(GET)
									System.out.println("The current Purchase Prices of Priducts are as follow:");
									System.out.println("iPad2:--------------------"+iPad2_Price_In+" CNY.");
									System.out.println("iPad3:--------------------"+iPad3_Price_In+" CNY.");
									System.out.println("iPhone4:------------------"+iPhone4_Price_In+" CNY.");
									System.out.println("iPhone4S:-----------------"+iPhone4S_Price_In+" CNY.");
									System.out.println("iPhone5:------------------"+iPhone5_Price_In+" CNY.");
									System.out.println("iPhone5S:-----------------"+iPhone5S_Price_In+" CNY.");
								break;
								case 3://Set the Warning Line of Profit.(GET)
									System.out.println("The current Warning Line of Profit is "+ProfitWL_D*100+"%");
									System.out.printf("You want to Reset your Warning Line of Profit to be (unit: 1%): ");
									float ProfitWL_PC=input.nextFloat();
									while(ProfitWL_PC<0){
										System.out.println("You should input 0 or a positive number.");
										System.out.printf("Input Again (unit: 1%):");
										ProfitWL_PC=input.nextFloat();
									}
									ProfitWL_D=(float) (ProfitWL_PC/100);
									System.out.println("The current Warning Line of Profit is "+ProfitWL_PC+"%");
								break;
								case 4://The Amount of Money Query.(GET)
									System.out.printf("The current Amount of Money is %.2f Yuan.",MoneyAmount);
									System.out.println("\n");
								break;
								case 5://Exit My Money.(GET)
									MoneyYESorNO=false;
									System.out.println("Exit My Money.");
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						break;
						case 4://Logout Administrator. (GET)
							AdministratorMainYESorNO=false;
							System.out.println("LOGOUT!");
						break;
						default:
							System.out.println("Illegal Input");
						break;
						}	
					}
				}
				else{
					System.out.println("You Input Wrong Password!EXIT!");
				}
			break;
			case 2:
				//Enter Administrator Account
				boolean SalesmanYESorNO=true;
				while (SalesmanYESorNO==true){
					System.out.printf("You Login As a Salesman.");
					System.out.printf("Please Input Your ID or Press 6 to Exit:");
					AccountID=input.nextInt();
					switch(AccountID){
					case 1:
						I=4;
						System.out.println("Please Input Password For Salesman01!");
						for(I=4;I>0;I--){
							System.out.printf("you have "+ I +" chances to input!");
							A=input.next();
							if(A.intern()==Salesman01Password.intern())break;
						}
						if(A.intern()==Salesman01Password.intern()){
							boolean Salesman01MainYESorNO=true;
							while(Salesman01MainYESorNO==true){
								System.out.println("As Salesman01, You Can Do:");
								System.out.println("1. My Account:\n"
										         + "  (1). Change Password;\n"
										         + "2. My Achievement:\n"
										         + "  (1). My Total Sales;\n"
									           	 + "  (2). My Total Profit;\n"
										         + "3. My Sale.\n");
								System.out.println("SALESMAN MAIN MENU");
								System.out.println("Press 1 for My Account.");
								System.out.println("Press 2 for My Achievement.");
								System.out.println("Press 3 for My Sale.");
								System.out.println("Press 4 for Logout Salesman01.");
								int SalesmanMainChoice=input.nextInt();
								switch(SalesmanMainChoice){
								case 1://My Account.(GET)
									boolean AccountYESorNO=true;
									while (AccountYESorNO==true){
										System.out.println("My Account MENU");
										System.out.println("Press 1 for The Salesman01 Permissions.");
										System.out.println("Press 2 for Change Password.");
										System.out.println("Press 3 for Exit Account Management.");
										int AccountChoice=input.nextInt();
										switch(AccountChoice){
										case 1://The Salesman Permissions.(GET)
											System.out.println("As Salesman01, You Can Do:");
											System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Achievement:\n"
											         + "  (1). My Total Sales;\n"
										           	 + "  (2). My Total Profit;\n"
											         + "3. My Sale.\n");
										break;
										case 2://Change Password.(GET)
											System.out.printf("Current Password:");
											String CurrentPassword=input.next();
											while(CurrentPassword.intern()!=Salesman01Password.intern()){
												System.out.println("The password you gave is incorrect.");
												System.out.printf("Please try again:");
												CurrentPassword=input.next();
											}
											System.out.printf("New Password:");
											String newpassword=input.next();
											while(newpassword.intern()==Salesman01Password.intern()){
												System.out.println("New Password should be different to Current Password.");
												System.out.printf("Please choose another Password:");
												newpassword=input.next();
											}
											String reinput="39iuqfion";
											while (reinput.intern()!=newpassword.intern()) {
											System.out.printf("Confirm new Password");
											reinput=input.next();
											if(reinput.intern()==newpassword.intern()){
												Salesman01Password=newpassword;
												System.out.println("You have reset your password to be:"+Salesman01Password);
											}
											else System.out.println("Wrong Input!");
											}
										break;
										case 3://Exit Account Management.(GET)
											AccountYESorNO=false;
											System.out.println("Exit Account Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://My Achievement.(GET)
									boolean AchievementYESorNO=true;
									while (AchievementYESorNO==true){
										System.out.println("My Achievement MENU");
										System.out.println("Press 1 for My Total Sales.");
										System.out.println("Press 2 for My Total Profit.");
										System.out.println("Press 3 for Exit My Achievement.");
										int AchievementChoice=input.nextInt();
										switch(AchievementChoice){
										case 1:
											System.out.println("My Total Sales is "+SM01Sales+" CNY.");
										break;
										case 2:
											System.out.println("My Total Profit is "+SM01Profit+" CNY.");
										break;
										case 3:
											AchievementYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://My Sale.(GET)
									boolean SaleYESorNO=true;
									while (SaleYESorNO==true){
										System.out.println("My Sale MENU");
										System.out.println("Press 1 for Sell iPad2.");
										System.out.println("Press 2 for Sell iPad3.");
										System.out.println("Press 3 for Sell iPhone4.");
										System.out.println("Press 4 for Sell iPhone4S.");
										System.out.println("Press 5 for Sell iPhone5.");
										System.out.println("Press 6 for Sell iPhone5S.");
										System.out.println("Press 7 for Exit My Sale.");
										int SaleChoice=input.nextInt();
										switch(SaleChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left");
											break;
											}
											System.out.printf("How many iPad2 do you sell:");
											int SM01iPad2=input.nextInt();
											while (SM01iPad2<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPad2=input.nextInt();
											}
											if (iPad2_Amount-SM01iPad2<0){
												System.out.println("We don't have enough iPad2.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad2:");
												iPad2=input.nextFloat();
												while (iPad2-iPad2_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad2=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPad2*iPad2;
												iPad2_Amount=iPad2_Amount-SM01iPad2;
												SM01Sales=SM01Sales+SM01iPad2*iPad2;
												SM01Profit=SM01Profit+SM01iPad2*(iPad2-iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left");
											break;
											}
											System.out.printf("How many iPad3 do you sell:");
											int SM01iPad3=input.nextInt();
											while (SM01iPad3<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPad3=input.nextInt();
											}
											if (iPad3_Amount-SM01iPad3<0){
												System.out.println("We don't have enough iPad3.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad3:");
												iPad3=input.nextFloat();
												while (iPad3-iPad3_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad3=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPad3*iPad3;
												iPad3_Amount=iPad3_Amount-SM01iPad3;
												SM01Sales=SM01Sales+SM01iPad3*iPad3;
												SM01Profit=SM01Profit+SM01iPad3*(iPad3-iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left");
												break;
												}
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("How many iPhone4 do you sell:");
											int SM01iPhone4=input.nextInt();
											while (SM01iPhone4<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPhone4=input.nextInt();
											}
											if (iPad2_Amount-SM01iPhone4<0){
												System.out.println("We don't have enough iPhone4.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4:");
												iPhone4=input.nextFloat();
												while (iPhone4-iPhone4_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPhone4*iPhone4;
												iPhone4_Amount=iPhone4_Amount-SM01iPhone4;
												SM01Sales=SM01Sales+SM01iPhone4*iPhone4;
												SM01Profit=SM01Profit+SM01iPhone4*(iPhone4-iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("How many iPhone4S do you sell:");
											int SM01iPhone4S=input.nextInt();
											while (SM01iPhone4S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPhone4S=input.nextInt();
											}
											if (iPhone4S_Amount-SM01iPhone4S<0){
												System.out.println("We don't have enough iPhone4S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4S:");
												iPhone4S=input.nextFloat();
												while (iPhone4S-iPhone4S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPhone4S*iPhone4S;
												iPhone4S_Amount=iPhone4S_Amount-SM01iPhone4S;
												SM01Sales=SM01Sales+SM01iPhone4S*iPhone4S;
												SM01Profit=SM01Profit+SM01iPhone4S*(iPhone4S-iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("How many iPhone5 do you sell:");
											int SM01iPhone5=input.nextInt();
											while (SM01iPhone5<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPhone5=input.nextInt();
											}
											if (iPhone5_Amount-SM01iPhone5<0){
												System.out.println("We don't have enough iPhone5.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5:");
												iPhone5=input.nextFloat();
												while (iPhone5-iPhone5_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPhone5*iPhone5;
												iPhone5_Amount=iPhone5_Amount-SM01iPhone5;
												SM01Sales=SM01Sales+SM01iPhone5*iPhone5;
												SM01Profit=SM01Profit+SM01iPhone5*(iPhone5-iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("How many iPhone5S do you sell:");
											int SM01iPhone5S=input.nextInt();
											while (SM01iPhone5S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM01iPhone5S=input.nextInt();
											}
											if (iPad2_Amount-SM01iPhone5S<0){
												System.out.println("We don't have enough iPhone5S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5S:");
												iPhone5S=input.nextFloat();
												while (iPhone5S-iPhone5S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM01iPhone5S*iPhone5S;
												iPhone5S_Amount=iPhone5S_Amount-SM01iPhone5S;
												SM01Sales=SM01Sales+SM01iPhone5S*iPhone5S;
												SM01Profit=SM01Profit+SM01iPhone5S*(iPhone5S-iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7:
											SaleYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 4:
									Salesman01MainYESorNO=false;
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						}
						else{
							System.out.println("You Input Wrong Password!EXIT!");
						}
					break;
					case 2:
						I=4;
						System.out.println("Please Input Password For Salesman02!");
						for(I=4;I>0;I--){
							System.out.printf("you have "+ I +" chances to input!");
							A=input.next();
							if(A.intern()==Salesman02Password.intern())break;
						}
						if(A.intern()==Salesman02Password.intern()){
							boolean Salesman02MainYESorNO=true;
							while(Salesman02MainYESorNO==true){
								System.out.println("As Salesman02, You Can Do:");
								System.out.println("1. My Account:\n"
										         + "  (1). Change Password;\n"
										         + "2. My Achievement:\n"
										         + "  (1). My Total Sales;\n"
									           	 + "  (2). My Total Profit;\n"
										         + "3. My Sale.\n");
								System.out.println("SALESMAN MAIN MENU");
								System.out.println("Press 1 for My Account.");
								System.out.println("Press 2 for My Achievement.");
								System.out.println("Press 3 for My Sale.");
								System.out.println("Press 4 for Logout Salesman02.");
								int SalesmanMainChoice=input.nextInt();
								switch(SalesmanMainChoice){
								case 1://My Account.(GET)
									boolean AccountYESorNO=true;
									while (AccountYESorNO==true){
										System.out.println("My Account MENU");
										System.out.println("Press 1 for The Salesman02 Permissions.");
										System.out.println("Press 2 for Change Password.");
										System.out.println("Press 3 for Exit Account Management.");
										int AccountChoice=input.nextInt();
										switch(AccountChoice){
										case 1://The Salesman Permissions.(GET)
											System.out.println("As Salesman02, You Can Do:");
											System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Achievement:\n"
											         + "  (1). My Total Sales;\n"
										           	 + "  (2). My Total Profit;\n"
											         + "3. My Sale.\n");
										break;
										case 2://Change Password.(GET)
											System.out.printf("Current Password:");
											String CurrentPassword=input.next();
											while(CurrentPassword.intern()!=Salesman02Password.intern()){
												System.out.println("The password you gave is incorrect.");
												System.out.printf("Please try again:");
												CurrentPassword=input.next();
											}
											System.out.printf("New Password:");
											String newpassword=input.next();
											while(newpassword.intern()==Salesman02Password.intern()){
												System.out.println("New Password should be different to Current Password.");
												System.out.printf("Please choose another Password:");
												newpassword=input.next();
											}
											String reinput="39iuqfion";
											while (reinput.intern()!=newpassword.intern()) {
											System.out.printf("Confirm new Password");
											reinput=input.next();
											if(reinput.intern()==newpassword.intern()){
												Salesman02Password=newpassword;
												System.out.println("You have reset your password to be:"+Salesman02Password);
											}
											else System.out.println("Wrong Input!");
											}
										break;
										case 3://Exit Account Management.(GET)
											AccountYESorNO=false;
											System.out.println("Exit Account Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://My Achievement.(GET)
									boolean AchievementYESorNO=true;
									while (AchievementYESorNO==true){
										System.out.println("My Achievement MENU");
										System.out.println("Press 1 for My Total Sales.");
										System.out.println("Press 2 for My Total Profit.");
										System.out.println("Press 3 for Exit My Achievement.");
										int AchievementChoice=input.nextInt();
										switch(AchievementChoice){
										case 1:
											System.out.println("My Total Sales is "+SM02Sales+" CNY.");
										break;
										case 2:
											System.out.println("My Total Profit is "+SM02Profit+" CNY.");
										break;
										case 3:
											AchievementYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://My Sale.(GET)
									boolean SaleYESorNO=true;
									while (SaleYESorNO==true){
										System.out.println("My Sale MENU");
										System.out.println("Press 1 for Sell iPad2.");
										System.out.println("Press 2 for Sell iPad3.");
										System.out.println("Press 3 for Sell iPhone4.");
										System.out.println("Press 4 for Sell iPhone4S.");
										System.out.println("Press 5 for Sell iPhone5.");
										System.out.println("Press 6 for Sell iPhone5S.");
										System.out.println("Press 7 for Exit My Sale.");
										int SaleChoice=input.nextInt();
										switch(SaleChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left");
											break;
											}
											System.out.printf("How many iPad2 do you sell:");
											int SM02iPad2=input.nextInt();
											while (SM02iPad2<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPad2=input.nextInt();
											}
											if (iPad2_Amount-SM02iPad2<0){
												System.out.println("We don't have enough iPad2.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad2:");
												iPad2=input.nextFloat();
												while (iPad2-iPad2_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad2=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPad2*iPad2;
												iPad2_Amount=iPad2_Amount-SM02iPad2;
												SM02Sales=SM02Sales+SM02iPad2*iPad2;
												SM02Profit=SM02Profit+SM02iPad2*(iPad2-iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left");
											break;
											}
											System.out.printf("How many iPad3 do you sell:");
											int SM02iPad3=input.nextInt();
											while (SM02iPad3<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPad3=input.nextInt();
											}
											if (iPad3_Amount-SM02iPad3<0){
												System.out.println("We don't have enough iPad3.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad3:");
												iPad3=input.nextFloat();
												while (iPad3-iPad3_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad3=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPad3*iPad3;
												iPad3_Amount=iPad3_Amount-SM02iPad3;
												SM02Sales=SM02Sales+SM02iPad3*iPad3;
												SM02Profit=SM02Profit+SM02iPad3*(iPad3-iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left");
												break;
												}
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("How many iPhone4 do you sell:");
											int SM02iPhone4=input.nextInt();
											while (SM02iPhone4<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPhone4=input.nextInt();
											}
											if (iPad2_Amount-SM02iPhone4<0){
												System.out.println("We don't have enough iPhone4.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4:");
												iPhone4=input.nextFloat();
												while (iPhone4-iPhone4_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPhone4*iPhone4;
												iPhone4_Amount=iPhone4_Amount-SM02iPhone4;
												SM02Sales=SM02Sales+SM02iPhone4*iPhone4;
												SM02Profit=SM02Profit+SM02iPhone4*(iPhone4-iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("How many iPhone4S do you sell:");
											int SM02iPhone4S=input.nextInt();
											while (SM02iPhone4S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPhone4S=input.nextInt();
											}
											if (iPhone4S_Amount-SM02iPhone4S<0){
												System.out.println("We don't have enough iPhone4S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4S:");
												iPhone4S=input.nextFloat();
												while (iPhone4S-iPhone4S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPhone4S*iPhone4S;
												iPhone4S_Amount=iPhone4S_Amount-SM02iPhone4S;
												SM02Sales=SM02Sales+SM02iPhone4S*iPhone4S;
												SM02Profit=SM02Profit+SM02iPhone4S*(iPhone4S-iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("How many iPhone5 do you sell:");
											int SM02iPhone5=input.nextInt();
											while (SM02iPhone5<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPhone5=input.nextInt();
											}
											if (iPhone5_Amount-SM02iPhone5<0){
												System.out.println("We don't have enough iPhone5.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5:");
												iPhone5=input.nextFloat();
												while (iPhone5-iPhone5_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPhone5*iPhone5;
												iPhone5_Amount=iPhone5_Amount-SM02iPhone5;
												SM02Sales=SM02Sales+SM02iPhone5*iPhone5;
												SM02Profit=SM02Profit+SM02iPhone5*(iPhone5-iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("How many iPhone5S do you sell:");
											int SM02iPhone5S=input.nextInt();
											while (SM02iPhone5S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM02iPhone5S=input.nextInt();
											}
											if (iPad2_Amount-SM02iPhone5S<0){
												System.out.println("We don't have enough iPhone5S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5S:");
												iPhone5S=input.nextFloat();
												while (iPhone5S-iPhone5S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM02iPhone5S*iPhone5S;
												iPhone5S_Amount=iPhone5S_Amount-SM02iPhone5S;
												SM02Sales=SM02Sales+SM02iPhone5S*iPhone5S;
												SM02Profit=SM02Profit+SM02iPhone5S*(iPhone5S-iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7:
											SaleYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 4:
									Salesman02MainYESorNO=false;
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						}
						else{
							System.out.println("You Input Wrong Password!EXIT!");
						}
					break;
					case 3:
						I=4;
						System.out.println("Please Input Password For Salesman03!");
						for(I=4;I>0;I--){
							System.out.printf("you have "+ I +" chances to input!");
							A=input.next();
							if(A.intern()==Salesman03Password.intern())break;
						}
						if(A.intern()==Salesman03Password.intern()){
							boolean Salesman03MainYESorNO=true;
							while(Salesman03MainYESorNO==true){
								System.out.println("As Salesman03, You Can Do:");
								System.out.println("1. My Account:\n"
										         + "  (1). Change Password;\n"
										         + "2. My Achievement:\n"
										         + "  (1). My Total Sales;\n"
									           	 + "  (2). My Total Profit;\n"
										         + "3. My Sale.\n");
								System.out.println("SALESMAN MAIN MENU");
								System.out.println("Press 1 for My Account.");
								System.out.println("Press 2 for My Achievement.");
								System.out.println("Press 3 for My Sale.");
								System.out.println("Press 4 for Logout Salesman03.");
								int SalesmanMainChoice=input.nextInt();
								switch(SalesmanMainChoice){
								case 1://My Account.(GET)
									boolean AccountYESorNO=true;
									while (AccountYESorNO==true){
										System.out.println("My Account MENU");
										System.out.println("Press 1 for The Salesman03 Permissions.");
										System.out.println("Press 2 for Change Password.");
										System.out.println("Press 3 for Exit Account Management.");
										int AccountChoice=input.nextInt();
										switch(AccountChoice){
										case 1://The Salesman Permissions.(GET)
											System.out.println("As Salesman03, You Can Do:");
											System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Achievement:\n"
											         + "  (1). My Total Sales;\n"
										           	 + "  (2). My Total Profit;\n"
											         + "3. My Sale.\n");
										break;
										case 2://Change Password.(GET)
											System.out.printf("Current Password:");
											String CurrentPassword=input.next();
											while(CurrentPassword.intern()!=Salesman03Password.intern()){
												System.out.println("The password you gave is incorrect.");
												System.out.printf("Please try again:");
												CurrentPassword=input.next();
											}
											System.out.printf("New Password:");
											String newpassword=input.next();
											while(newpassword.intern()==Salesman03Password.intern()){
												System.out.println("New Password should be different to Current Password.");
												System.out.printf("Please choose another Password:");
												newpassword=input.next();
											}
											String reinput="39iuqfion";
											while (reinput.intern()!=newpassword.intern()) {
											System.out.printf("Confirm new Password");
											reinput=input.next();
											if(reinput.intern()==newpassword.intern()){
												Salesman03Password=newpassword;
												System.out.println("You have reset your password to be:"+Salesman03Password);
											}
											else System.out.println("Wrong Input!");
											}
										break;
										case 3://Exit Account Management.(GET)
											AccountYESorNO=false;
											System.out.println("Exit Account Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://My Achievement.(GET)
									boolean AchievementYESorNO=true;
									while (AchievementYESorNO==true){
										System.out.println("My Achievement MENU");
										System.out.println("Press 1 for My Total Sales.");
										System.out.println("Press 2 for My Total Profit.");
										System.out.println("Press 3 for Exit My Achievement.");
										int AchievementChoice=input.nextInt();
										switch(AchievementChoice){
										case 1:
											System.out.println("My Total Sales is "+SM03Sales+" CNY.");
										break;
										case 2:
											System.out.println("My Total Profit is "+SM03Profit+" CNY.");
										break;
										case 3:
											AchievementYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://My Sale.(GET)
									boolean SaleYESorNO=true;
									while (SaleYESorNO==true){
										System.out.println("My Sale MENU");
										System.out.println("Press 1 for Sell iPad2.");
										System.out.println("Press 2 for Sell iPad3.");
										System.out.println("Press 3 for Sell iPhone4.");
										System.out.println("Press 4 for Sell iPhone4S.");
										System.out.println("Press 5 for Sell iPhone5.");
										System.out.println("Press 6 for Sell iPhone5S.");
										System.out.println("Press 7 for Exit My Sale.");
										int SaleChoice=input.nextInt();
										switch(SaleChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left");
											break;
											}
											System.out.printf("How many iPad2 do you sell:");
											int SM03iPad2=input.nextInt();
											while (SM03iPad2<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPad2=input.nextInt();
											}
											if (iPad2_Amount-SM03iPad2<0){
												System.out.println("We don't have enough iPad2.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad2:");
												iPad2=input.nextFloat();
												while (iPad2-iPad2_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad2=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPad2*iPad2;
												iPad2_Amount=iPad2_Amount-SM03iPad2;
												SM03Sales=SM03Sales+SM03iPad2*iPad2;
												SM03Profit=SM03Profit+SM03iPad2*(iPad2-iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left");
											break;
											}
											System.out.printf("How many iPad3 do you sell:");
											int SM03iPad3=input.nextInt();
											while (SM03iPad3<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPad3=input.nextInt();
											}
											if (iPad3_Amount-SM03iPad3<0){
												System.out.println("We don't have enough iPad3.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad3:");
												iPad3=input.nextFloat();
												while (iPad3-iPad3_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad3=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPad3*iPad3;
												iPad3_Amount=iPad3_Amount-SM03iPad3;
												SM03Sales=SM03Sales+SM03iPad3*iPad3;
												SM03Profit=SM03Profit+SM03iPad3*(iPad3-iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left");
												break;
												}
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("How many iPhone4 do you sell:");
											int SM03iPhone4=input.nextInt();
											while (SM03iPhone4<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPhone4=input.nextInt();
											}
											if (iPad2_Amount-SM03iPhone4<0){
												System.out.println("We don't have enough iPhone4.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4:");
												iPhone4=input.nextFloat();
												while (iPhone4-iPhone4_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPhone4*iPhone4;
												iPhone4_Amount=iPhone4_Amount-SM03iPhone4;
												SM03Sales=SM03Sales+SM03iPhone4*iPhone4;
												SM03Profit=SM03Profit+SM03iPhone4*(iPhone4-iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("How many iPhone4S do you sell:");
											int SM03iPhone4S=input.nextInt();
											while (SM03iPhone4S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPhone4S=input.nextInt();
											}
											if (iPhone4S_Amount-SM03iPhone4S<0){
												System.out.println("We don't have enough iPhone4S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4S:");
												iPhone4S=input.nextFloat();
												while (iPhone4S-iPhone4S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPhone4S*iPhone4S;
												iPhone4S_Amount=iPhone4S_Amount-SM03iPhone4S;
												SM03Sales=SM03Sales+SM03iPhone4S*iPhone4S;
												SM03Profit=SM03Profit+SM03iPhone4S*(iPhone4S-iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("How many iPhone5 do you sell:");
											int SM03iPhone5=input.nextInt();
											while (SM03iPhone5<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPhone5=input.nextInt();
											}
											if (iPhone5_Amount-SM03iPhone5<0){
												System.out.println("We don't have enough iPhone5.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5:");
												iPhone5=input.nextFloat();
												while (iPhone5-iPhone5_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPhone5*iPhone5;
												iPhone5_Amount=iPhone5_Amount-SM03iPhone5;
												SM03Sales=SM03Sales+SM03iPhone5*iPhone5;
												SM03Profit=SM03Profit+SM03iPhone5*(iPhone5-iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("How many iPhone5S do you sell:");
											int SM03iPhone5S=input.nextInt();
											while (SM03iPhone5S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM03iPhone5S=input.nextInt();
											}
											if (iPad2_Amount-SM03iPhone5S<0){
												System.out.println("We don't have enough iPhone5S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5S:");
												iPhone5S=input.nextFloat();
												while (iPhone5S-iPhone5S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM03iPhone5S*iPhone5S;
												iPhone5S_Amount=iPhone5S_Amount-SM03iPhone5S;
												SM03Sales=SM03Sales+SM03iPhone5S*iPhone5S;
												SM03Profit=SM03Profit+SM03iPhone5S*(iPhone5S-iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7:
											SaleYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 4:
									Salesman03MainYESorNO=false;
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						}
						else{
							System.out.println("You Input Wrong Password!EXIT!");
						}
					break;
					case 4:
						I=4;
						System.out.println("Please Input Password For Salesman04!");
						for(I=4;I>0;I--){
							System.out.printf("you have "+ I +" chances to input!");
							A=input.next();
							if(A.intern()==Salesman04Password.intern())break;
						}
						if(A.intern()==Salesman04Password.intern()){
							boolean Salesman04MainYESorNO=true;
							while(Salesman04MainYESorNO==true){
								System.out.println("As Salesman04, You Can Do:");
								System.out.println("1. My Account:\n"
										         + "  (1). Change Password;\n"
										         + "2. My Achievement:\n"
										         + "  (1). My Total Sales;\n"
									           	 + "  (2). My Total Profit;\n"
										         + "3. My Sale.\n");
								System.out.println("SALESMAN MAIN MENU");
								System.out.println("Press 1 for My Account.");
								System.out.println("Press 2 for My Achievement.");
								System.out.println("Press 3 for My Sale.");
								System.out.println("Press 4 for Logout Salesman04.");
								int SalesmanMainChoice=input.nextInt();
								switch(SalesmanMainChoice){
								case 1://My Account.(GET)
									boolean AccountYESorNO=true;
									while (AccountYESorNO==true){
										System.out.println("My Account MENU");
										System.out.println("Press 1 for The Salesman04 Permissions.");
										System.out.println("Press 2 for Change Password.");
										System.out.println("Press 3 for Exit Account Management.");
										int AccountChoice=input.nextInt();
										switch(AccountChoice){
										case 1://The Salesman Permissions.(GET)
											System.out.println("As Salesman04, You Can Do:");
											System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Achievement:\n"
											         + "  (1). My Total Sales;\n"
										           	 + "  (2). My Total Profit;\n"
											         + "3. My Sale.\n");
										break;
										case 2://Change Password.(GET)
											System.out.printf("Current Password:");
											String CurrentPassword=input.next();
											while(CurrentPassword.intern()!=Salesman04Password.intern()){
												System.out.println("The password you gave is incorrect.");
												System.out.printf("Please try again:");
												CurrentPassword=input.next();
											}
											System.out.printf("New Password:");
											String newpassword=input.next();
											while(newpassword.intern()==Salesman04Password.intern()){
												System.out.println("New Password should be different to Current Password.");
												System.out.printf("Please choose another Password:");
												newpassword=input.next();
											}
											String reinput="39iuqfion";
											while (reinput.intern()!=newpassword.intern()) {
											System.out.printf("Confirm new Password");
											reinput=input.next();
											if(reinput.intern()==newpassword.intern()){
												Salesman04Password=newpassword;
												System.out.println("You have reset your password to be:"+Salesman04Password);
											}
											else System.out.println("Wrong Input!");
											}
										break;
										case 3://Exit Account Management.(GET)
											AccountYESorNO=false;
											System.out.println("Exit Account Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://My Achievement.(GET)
									boolean AchievementYESorNO=true;
									while (AchievementYESorNO==true){
										System.out.println("My Achievement MENU");
										System.out.println("Press 1 for My Total Sales.");
										System.out.println("Press 2 for My Total Profit.");
										System.out.println("Press 3 for Exit My Achievement.");
										int AchievementChoice=input.nextInt();
										switch(AchievementChoice){
										case 1:
											System.out.println("My Total Sales is "+SM04Sales+" CNY.");
										break;
										case 2:
											System.out.println("My Total Profit is "+SM04Profit+" CNY.");
										break;
										case 3:
											AchievementYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://My Sale.(GET)
									boolean SaleYESorNO=true;
									while (SaleYESorNO==true){
										System.out.println("My Sale MENU");
										System.out.println("Press 1 for Sell iPad2.");
										System.out.println("Press 2 for Sell iPad3.");
										System.out.println("Press 3 for Sell iPhone4.");
										System.out.println("Press 4 for Sell iPhone4S.");
										System.out.println("Press 5 for Sell iPhone5.");
										System.out.println("Press 6 for Sell iPhone5S.");
										System.out.println("Press 7 for Exit My Sale.");
										int SaleChoice=input.nextInt();
										switch(SaleChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left");
											break;
											}
											System.out.printf("How many iPad2 do you sell:");
											int SM04iPad2=input.nextInt();
											while (SM04iPad2<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPad2=input.nextInt();
											}
											if (iPad2_Amount-SM04iPad2<0){
												System.out.println("We don't have enough iPad2.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad2:");
												iPad2=input.nextFloat();
												while (iPad2-iPad2_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad2=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPad2*iPad2;
												iPad2_Amount=iPad2_Amount-SM04iPad2;
												SM04Sales=SM04Sales+SM04iPad2*iPad2;
												SM04Profit=SM04Profit+SM04iPad2*(iPad2-iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left");
											break;
											}
											System.out.printf("How many iPad3 do you sell:");
											int SM04iPad3=input.nextInt();
											while (SM04iPad3<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPad3=input.nextInt();
											}
											if (iPad3_Amount-SM04iPad3<0){
												System.out.println("We don't have enough iPad3.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad3:");
												iPad3=input.nextFloat();
												while (iPad3-iPad3_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad3=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPad3*iPad3;
												iPad3_Amount=iPad3_Amount-SM04iPad3;
												SM04Sales=SM04Sales+SM04iPad3*iPad3;
												SM04Profit=SM04Profit+SM04iPad3*(iPad3-iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left");
												break;
												}
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("How many iPhone4 do you sell:");
											int SM04iPhone4=input.nextInt();
											while (SM04iPhone4<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPhone4=input.nextInt();
											}
											if (iPad2_Amount-SM04iPhone4<0){
												System.out.println("We don't have enough iPhone4.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4:");
												iPhone4=input.nextFloat();
												while (iPhone4-iPhone4_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPhone4*iPhone4;
												iPhone4_Amount=iPhone4_Amount-SM04iPhone4;
												SM04Sales=SM04Sales+SM04iPhone4*iPhone4;
												SM04Profit=SM04Profit+SM04iPhone4*(iPhone4-iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("How many iPhone4S do you sell:");
											int SM04iPhone4S=input.nextInt();
											while (SM04iPhone4S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPhone4S=input.nextInt();
											}
											if (iPhone4S_Amount-SM04iPhone4S<0){
												System.out.println("We don't have enough iPhone4S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4S:");
												iPhone4S=input.nextFloat();
												while (iPhone4S-iPhone4S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPhone4S*iPhone4S;
												iPhone4S_Amount=iPhone4S_Amount-SM04iPhone4S;
												SM04Sales=SM04Sales+SM04iPhone4S*iPhone4S;
												SM04Profit=SM04Profit+SM04iPhone4S*(iPhone4S-iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("How many iPhone5 do you sell:");
											int SM04iPhone5=input.nextInt();
											while (SM04iPhone5<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPhone5=input.nextInt();
											}
											if (iPhone5_Amount-SM04iPhone5<0){
												System.out.println("We don't have enough iPhone5.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5:");
												iPhone5=input.nextFloat();
												while (iPhone5-iPhone5_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPhone5*iPhone5;
												iPhone5_Amount=iPhone5_Amount-SM04iPhone5;
												SM04Sales=SM04Sales+SM04iPhone5*iPhone5;
												SM04Profit=SM04Profit+SM04iPhone5*(iPhone5-iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("How many iPhone5S do you sell:");
											int SM04iPhone5S=input.nextInt();
											while (SM04iPhone5S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM04iPhone5S=input.nextInt();
											}
											if (iPad2_Amount-SM04iPhone5S<0){
												System.out.println("We don't have enough iPhone5S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5S:");
												iPhone5S=input.nextFloat();
												while (iPhone5S-iPhone5S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM04iPhone5S*iPhone5S;
												iPhone5S_Amount=iPhone5S_Amount-SM04iPhone5S;
												SM04Sales=SM04Sales+SM04iPhone5S*iPhone5S;
												SM04Profit=SM04Profit+SM04iPhone5S*(iPhone5S-iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7:
											SaleYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 4:
									Salesman04MainYESorNO=false;
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						}
						else{
							System.out.println("You Input Wrong Password!EXIT!");
						}

					break;
					case 5:
						I=4;
						System.out.println("Please Input Password For Salesman05!");
						for(I=4;I>0;I--){
							System.out.printf("you have "+ I +" chances to input!");
							A=input.next();
							if(A.intern()==Salesman05Password.intern())break;
						}
						if(A.intern()==Salesman05Password.intern()){
							boolean Salesman05MainYESorNO=true;
							while(Salesman05MainYESorNO==true){
								System.out.println("As Salesman05, You Can Do:");
								System.out.println("1. My Account:\n"
										         + "  (1). Change Password;\n"
										         + "2. My Achievement:\n"
										         + "  (1). My Total Sales;\n"
									           	 + "  (2). My Total Profit;\n"
										         + "3. My Sale.\n");
								System.out.println("SALESMAN MAIN MENU");
								System.out.println("Press 1 for My Account.");
								System.out.println("Press 2 for My Achievement.");
								System.out.println("Press 3 for My Sale.");
								System.out.println("Press 4 for Logout Salesman05.");
								int SalesmanMainChoice=input.nextInt();
								switch(SalesmanMainChoice){
								case 1://My Account.(GET)
									boolean AccountYESorNO=true;
									while (AccountYESorNO==true){
										System.out.println("My Account MENU");
										System.out.println("Press 1 for The Salesman05 Permissions.");
										System.out.println("Press 2 for Change Password.");
										System.out.println("Press 3 for Exit Account Management.");
										int AccountChoice=input.nextInt();
										switch(AccountChoice){
										case 1://The Salesman Permissions.(GET)
											System.out.println("As Salesman05, You Can Do:");
											System.out.println("1. My Account:\n"
											         + "  (1). Change Password;\n"
											         + "2. My Achievement:\n"
											         + "  (1). My Total Sales;\n"
										           	 + "  (2). My Total Profit;\n"
											         + "3. My Sale.\n");
										break;
										case 2://Change Password.(GET)
											System.out.printf("Current Password:");
											String CurrentPassword=input.next();
											while(CurrentPassword.intern()!=Salesman05Password.intern()){
												System.out.println("The password you gave is incorrect.");
												System.out.printf("Please try again:");
												CurrentPassword=input.next();
											}
											System.out.printf("New Password:");
											String newpassword=input.next();
											while(newpassword.intern()==Salesman05Password.intern()){
												System.out.println("New Password should be different to Current Password.");
												System.out.printf("Please choose another Password:");
												newpassword=input.next();
											}
											String reinput="39iuqfion";
											while (reinput.intern()!=newpassword.intern()) {
											System.out.printf("Confirm new Password");
											reinput=input.next();
											if(reinput.intern()==newpassword.intern()){
												Salesman05Password=newpassword;
												System.out.println("You have reset your password to be:"+Salesman05Password);
											}
											else System.out.println("Wrong Input!");
											}
										break;
										case 3://Exit Account Management.(GET)
											AccountYESorNO=false;
											System.out.println("Exit Account Management.");
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 2://My Achievement.(GET)
									boolean AchievementYESorNO=true;
									while (AchievementYESorNO==true){
										System.out.println("My Achievement MENU");
										System.out.println("Press 1 for My Total Sales.");
										System.out.println("Press 2 for My Total Profit.");
										System.out.println("Press 3 for Exit My Achievement.");
										int AchievementChoice=input.nextInt();
										switch(AchievementChoice){
										case 1:
											System.out.println("My Total Sales is "+SM05Sales+" CNY.");
										break;
										case 2:
											System.out.println("My Total Profit is "+SM05Profit+" CNY.");
										break;
										case 3:
											AchievementYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 3://My Sale.(GET)
									boolean SaleYESorNO=true;
									while (SaleYESorNO==true){
										System.out.println("My Sale MENU");
										System.out.println("Press 1 for Sell iPad2.");
										System.out.println("Press 2 for Sell iPad3.");
										System.out.println("Press 3 for Sell iPhone4.");
										System.out.println("Press 4 for Sell iPhone4S.");
										System.out.println("Press 5 for Sell iPhone5.");
										System.out.println("Press 6 for Sell iPhone5S.");
										System.out.println("Press 7 for Exit My Sale.");
										int SaleChoice=input.nextInt();
										switch(SaleChoice){
										case 1://iPad2.(GET)
											switch(iPad2_Amount){
											case 0:
												System.out.println("There is no iPad2 left");
											break;
											case 1:
												System.out.println("There is still "+iPad2_Amount+" iPad2 left");
											break;
											default:
												System.out.println("There are still "+iPad2_Amount+" iPad2 left");
											break;
											}
											System.out.printf("How many iPad2 do you sell:");
											int SM05iPad2=input.nextInt();
											while (SM05iPad2<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPad2=input.nextInt();
											}
											if (iPad2_Amount-SM05iPad2<0){
												System.out.println("We don't have enough iPad2.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad2:");
												iPad2=input.nextFloat();
												while (iPad2-iPad2_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad2=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPad2*iPad2;
												iPad2_Amount=iPad2_Amount-SM05iPad2;
												SM05Sales=SM05Sales+SM05iPad2*iPad2;
												SM05Profit=SM05Profit+SM05iPad2*(iPad2-iPad2_Price_In);
												switch(iPad2_Amount){
												case 0:
													System.out.println("There is no iPad2 left");
												break;
												case 1:
													System.out.println("There is still "+iPad2_Amount+" iPad2 left");
												break;
												default:
													System.out.println("There are still "+iPad2_Amount+" iPad2 left");
												break;
												}
											}
										break;
										case 2://iPad3.(GET)
											switch(iPad3_Amount){
											case 0:
												System.out.println("There is no iPad3 left");
											break;
											case 1:
												System.out.println("There is still "+iPad3_Amount+" iPad3 left");
											break;
											default:
												System.out.println("There are still "+iPad3_Amount+" iPad3 left");
											break;
											}
											System.out.printf("How many iPad3 do you sell:");
											int SM05iPad3=input.nextInt();
											while (SM05iPad3<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPad3=input.nextInt();
											}
											if (iPad3_Amount-SM05iPad3<0){
												System.out.println("We don't have enough iPad3.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPad3:");
												iPad3=input.nextFloat();
												while (iPad3-iPad3_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPad3=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPad3*iPad3;
												iPad3_Amount=iPad3_Amount-SM05iPad3;
												SM05Sales=SM05Sales+SM05iPad3*iPad3;
												SM05Profit=SM05Profit+SM05iPad3*(iPad3-iPad3_Price_In);
												switch(iPad3_Amount){
												case 0:
													System.out.println("There is no iPad3 left");
												break;
												case 1:
													System.out.println("There is still "+iPad3_Amount+" iPad3 left");
												break;
												default:
													System.out.println("There are still "+iPad3_Amount+" iPad3 left");
												break;
												}
											}
										break;
										case 3://iPhone4.(GET)
											switch(iPhone4_Amount){
											case 0:
												System.out.println("There is no iPhone4 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
											break;
											default:
												System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
											break;
											}
											System.out.printf("How many iPhone4 do you sell:");
											int SM05iPhone4=input.nextInt();
											while (SM05iPhone4<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPhone4=input.nextInt();
											}
											if (iPad2_Amount-SM05iPhone4<0){
												System.out.println("We don't have enough iPhone4.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4:");
												iPhone4=input.nextFloat();
												while (iPhone4-iPhone4_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPhone4*iPhone4;
												iPhone4_Amount=iPhone4_Amount-SM05iPhone4;
												SM05Sales=SM05Sales+SM05iPhone4*iPhone4;
												SM05Profit=SM05Profit+SM05iPhone4*(iPhone4-iPhone4_Price_In);
												switch(iPhone4_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4_Amount+" iPhone4 left");
												break;
												default:
													System.out.println("There are still "+iPhone4_Amount+" iPhone4 left");
												break;
												}
											}
										break;
										case 4://iPhone4S.(GET)
											switch(iPhone4S_Amount){
											case 0:
												System.out.println("There is no iPhone4S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
											break;
											default:
												System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
											break;
											}
											System.out.printf("How many iPhone4S do you sell:");
											int SM05iPhone4S=input.nextInt();
											while (SM05iPhone4S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPhone4S=input.nextInt();
											}
											if (iPhone4S_Amount-SM05iPhone4S<0){
												System.out.println("We don't have enough iPhone4S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone4S:");
												iPhone4S=input.nextFloat();
												while (iPhone4S-iPhone4S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone4S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPhone4S*iPhone4S;
												iPhone4S_Amount=iPhone4S_Amount-SM05iPhone4S;
												SM05Sales=SM05Sales+SM05iPhone4S*iPhone4S;
												SM05Profit=SM05Profit+SM05iPhone4S*(iPhone4S-iPhone4S_Price_In);
												switch(iPhone4S_Amount){
												case 0:
													System.out.println("There is no iPhone4 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone4S_Amount+" iPhone4S left");
												break;
												default:
													System.out.println("There are still "+iPhone4S_Amount+" iPhone4S left");
												break;
												}
											}
										break;
										case 5://iPhone5.(GET)
											switch(iPhone5_Amount){
											case 0:
												System.out.println("There is no iPhone5 left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
											break;
											default:
												System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
											break;
											}
											System.out.printf("How many iPhone5 do you sell:");
											int SM05iPhone5=input.nextInt();
											while (SM05iPhone5<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPhone5=input.nextInt();
											}
											if (iPhone5_Amount-SM05iPhone5<0){
												System.out.println("We don't have enough iPhone5.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5:");
												iPhone5=input.nextFloat();
												while (iPhone5-iPhone5_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPhone5*iPhone5;
												iPhone5_Amount=iPhone5_Amount-SM05iPhone5;
												SM05Sales=SM05Sales+SM05iPhone5*iPhone5;
												SM05Profit=SM05Profit+SM05iPhone5*(iPhone5-iPhone5_Price_In);
												switch(iPhone5_Amount){
												case 0:
													System.out.println("There is no iPhone5 left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5_Amount+" iPhone5 left");
												break;
												default:
													System.out.println("There are still "+iPhone5_Amount+" iPhone5 left");
												break;
												}
											}
										break;
										case 6://iPhone5S.(GET)
											switch(iPhone5S_Amount){
											case 0:
												System.out.println("There is no iPhone5S left");
											break;
											case 1:
												System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
											break;
											default:
												System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
											break;
											}
											System.out.printf("How many iPhone5S do you sell:");
											int SM05iPhone5S=input.nextInt();
											while (SM05iPhone5S<0){
												System.out.println("You should input 0 or a positive integer.");
												System.out.printf("Input Again:");
												SM05iPhone5S=input.nextInt();
											}
											if (iPad2_Amount-SM05iPhone5S<0){
												System.out.println("We don't have enough iPhone5S.");
												System.out.println("The system have quit this operation automatically.");
											}
											else{
												System.out.printf("The Selling Price for each iPhone5S:");
												iPhone5S=input.nextFloat();
												while (iPhone5S-iPhone5S_Price<=0){
													System.out.println("Lower Profit than Warning Line.");
													System.out.printf("Input Again:");
													iPhone5S=input.nextFloat();
												}
												MoneyAmount=MoneyAmount+SM05iPhone5S*iPhone5S;
												iPhone5S_Amount=iPhone5S_Amount-SM05iPhone5S;
												SM05Sales=SM05Sales+SM05iPhone5S*iPhone5S;
												SM05Profit=SM05Profit+SM05iPhone5S*(iPhone5S-iPhone5S_Price_In);
												switch(iPhone5S_Amount){
												case 0:
													System.out.println("There is no iPhone5S left");
												break;
												case 1:
													System.out.println("There is still "+iPhone5S_Amount+" iPhone5S left");
												break;
												default:
													System.out.println("There are still "+iPhone5S_Amount+" iPhone5S left");
												break;
												}
											}
										break;
										case 7:
											SaleYESorNO=false;
										break;
										default:
											System.out.println("Illegal Input");
										break;
										}
									}
								break;
								case 4:
									Salesman05MainYESorNO=false;
								break;
								default:
									System.out.println("Illegal Input");
								break;
								}
							}
						}
						else{
							System.out.println("You Input Wrong Password!EXIT!");
						}
					break;
					case 6:
						SalesmanYESorNO=false;
					break;
					default:
						System.out.println("Illegal Input");
					break;
					}
				}
			break;
			case 3://STOP this Programme.(GET)
				MainYESorNO=false;
				System.out.println("You have STOPPED this Programme.");
			break;
			default:
				
			break;
			}

		}
	}*/


}
