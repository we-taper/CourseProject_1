import java.math.BigDecimal;
import java.util.Scanner;
//Problems:
//1. When counting the profit,oh,
//	I can't get the BasePrice!!
//	Try this sentence: System.out.println(Data.getBasePrice(2));
//2. Also, i can't get the storage amount,either. 
//	Not yet initialized?
//3. Things not yet tested:
	//can the alarmPrice be got? 
	//something wrong with this part of code(also Choice 3)? i can't test it.
//4. Is the expression "product ID" weird?
/*	There's no method to get the name(String) from its ID(int)!
//5. The methods in class Salesman: changeXXX
* 		produce errors!These just reject to be used!
* 		To check,please view Choice 3, after he has confirm a deal.
*/
public class Sale_Op {

	public static Salesman main(Salesman salesman) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.printf("Welcome %s!\nWhat do you want to do?\n",
					salesman.getName());
			System.out
					.printf("1.\tCalculator\n2.\tSee my account\n3.\tGo Selling!\nYour choice:");

			while (true) {

				int mainChoice = input.nextInt();
				input.nextLine();

				// Choice One Starts!!!!!
				if (mainChoice == 1) {
					System.out
							.println("You are now using: Calculator"
									+ "\nCould you tell me the product you want to do the calculations with?\n"
									+ "1.IPAD2\n2.IPAD3\n3.IPHONE4\n4.IPHONE4S\n5.IPHONE5\n6.IPHONE5S"
									+ "\nYour choice:");
					int calProduct;
					while (true)//for every choice, i invite a tiny While to get rid of unexpected input.
					{
					calProduct = input.nextInt();
					if(calProduct>=1&&calProduct<=6)
					{
						break;
					}
					else
					{
						System.out.println("Product with this ID does not exist!\n"
								+ "Please enter the Product ID again:");
					}
					}//This tiny While ends here.
					
					System.out.println("Good job!How much will you sell it?"
							+ "\nPlease enter the price:");
					BigDecimal calPrice;
					while (true)//tiny While again
					{
					calPrice = input.nextBigDecimal();
					if(calPrice.compareTo(new BigDecimal("0"))==1)
					{
						break;
					}
					else
					{
						System.out.println("The price should be above zero!\n"
								+ "Would you enter the price again:");
					}
					}//End tiny While
					
					System.out.println("Then,how many of it?"
							+ "\nPlease enter an integer:");
					int calNum;
					while(true)//tiny While
					{
						calNum = input.nextInt();
					if(calNum>=0)
					{
						break;
					}
					else
					{
						System.out.println("The amount of the goods is NOT supposed to be below zero!\n"
								+ "Would you please enter it again:");
					}
					}//End tiny While
					
					System.out
							.println("Do you want to calculate the\n1.PRICE\n2.PROFIT\n"
									+ "Your choice:");

					// Choice One(Calculator) has two functions!Here are two!
					while (true) {//For Price
						int calChoice = input.nextInt();
						if (calChoice == 1) {
							System.out.printf(
									"The total price is:%.2f\n",
									calPrice.multiply(new BigDecimal(""
											+ calNum)));
						
							break;
						}
						if (calChoice == 2) {//For Profit
							BigDecimal profit = Data.getBasePrice(calProduct)
									.multiply(new BigDecimal("" + calNum));
							System.out.printf("The total profit is %.2f\n",
									profit);
							if (Data.getAlarmPrice().compareTo(profit) == -1) {
								System.out.println("The profit is too low!\n"
										+ "Please consider it carefully!");
							}
							break;
						} 
						else {
							System.out
									.println("Enter 1 (for Price) or 2 (for Profit) please:");
						}
						
					

					}// Two Functions Ends!

					break;

				}// Choice One(Calculator) Ends.

				// Then Choice Two(Viewing my account) follows~~
				if (mainChoice == 2) {
					System.out.println("You are now viewing your account.\n"
							+ "Have you work well these days?Check!");
					System.out.printf("Account ID:\t%d\n" + "Name:\t\t%s\n"
							+ "Sales Amount:\t%.2f\n" + "Sales Profit:\t%.2f\n",
							salesman.getAccountID(), salesman.getName(),
							salesman.getSale(), salesman.getSaleProfit());
					break;
				}// Choice Two(Viewing my account) ends this quick!

				// Then comes Choice Three(Selling goods)!
				if (mainChoice == 3) {
					System.out
							.println("You are now ready to sell something!\n"
									+ "Here is our products and their amount left in our store:\n"
									+ "||Name||\t||Amount||\t||Minimal Price||\n");
					System.out
							.printf("1.IPAD2:\t%d%f\n2.IPAD3:%d%f\t\n3.IPHONE4:\t%d%f\n4.IPHONE4S:\t%d%f\n5.IPHONE5:\t%d%f\n6.IPHONE5S:\t%d%f\n",
									+Data.getStorageAmount(1),
									Data.getBasePrice(1),
									Data.getStorageAmount(2),
									Data.getBasePrice(2),
									Data.getStorageAmount(3),
									Data.getBasePrice(3),
									Data.getStorageAmount(4),
									Data.getBasePrice(4),
									Data.getStorageAmount(5),
									Data.getBasePrice(5),
									Data.getStorageAmount(6),
									Data.getBasePrice(6));
					// Print out all the products & their information!
					System.out.println("So, which product do you want to sell?"
							+ "Please enter an integer here:");
					int productChoice;
					while (true)//Likewise,here's a tiny While
					{
						productChoice = input.nextInt();
					if(productChoice>=1&&productChoice<=6)
					{
						break;
					}
					else
					{
						System.out.println("Product with this ID does not exist!\n"
								+ "Please enter the Product ID again:");
					}
					}
					
					System.out.println("Please enter the price here:");
					BigDecimal productPrice;
					while (true)//tiny While again
					{
						productPrice = input.nextBigDecimal();
					if(productPrice.compareTo(new BigDecimal("0"))==1)
					{
						break;
					}
					else
					{
						System.out.println("The price should be above zero!\n"
								+ "Would you enter the price again:");
					}
					}
					
					System.out
							.println("How many of it?\nPlease enter the number here:");
					int productNum;
					while(true)//tiny While
					{
						productNum = input.nextInt();
					if(productNum>=0)
					{
						break;
					}
					else
					{
						System.out.println("The amount of the goods is NOT supposed to be below zero!\n"
								+ "Would you please enter it again:");
					}
					}
					
					BigDecimal totalPrice = productPrice
							.multiply(new BigDecimal("" + productNum));
					BigDecimal totalProfit = totalPrice.subtract(Data
							.getBasePrice(productChoice).multiply(
									new BigDecimal("" + productNum)));
					String judge = "above";
					switch (totalProfit.compareTo(Data.getAlarmPrice())) {
					case 1:
						judge = "above";
						break;
					case 0:
						judge = "exactly equal";
						break;
					case -1:
						judge = "below";
						break;
					}
					System.out.printf("The total price is %f"
							+ "\nThe profit is %s the alarm line."
							+ "Do you want to continue?", totalPrice, judge);

					System.out
							.println("Now,please enter these information from the customer:"
									+ "What about the address?\nPlease enter here:");
					String address = input.nextLine();
					System.out
							.println("Then the telephone number.Please enter it here:");
					String tele = input.nextLine();

					// Now that we get all the information,let's print it out!
					while (true) {
						System.out.printf("Sale confirmation:\n"
								+ "ID of the employee:\t%d\n"
								+ "Product ID:\t%d\n"
								+ "Amount of the product:\t%d\n"
								+ "Total price:\t%f\n" + "Total profit:\t%f\n"
								+ "Address:\t%s\n" + "Telephone number:\t%s\n"
								+ "In comparison to the alarming rate:\t%s\n",
								salesman.getAccountID(), productChoice,
								productNum, totalPrice, totalProfit, address,
								tele, judge);
						// This's where that lacks a
						// method!!!!!!!!!!!!!!!!!!!!(Product ID!!!)Perhaps???

						System.out
								.println("Confirm this order?\nPlease enter yes or no here:");
						String confirm = input.nextLine();
						if (confirm.contains("yes")) 
						{
							System.out.println("Deal accomplished!");
							Data.changeStorageAmount(productChoice, -productNum);
							Data.changeCurrentFunds(totalPrice);
							/*salesman.changeSaleAmount(totalPrice);
							salesman.changeSaleProfit(totalProfit);
							if (judge == "below") 
							{
								salesman.changeAlarmDegree(Data.getAlarmPrice().subtract(totalProfit));
							}  Why is this wrong! I just can't understand!!!*/
							System.out
									.printf("Your total selling amount:\t%.2f\n,"
											+ "The profit you made:\t%.2f\n"
											+ "The degree you have gone below the alarm price:\t%.2f\n"
											+ "The remaining amount of the product:\t%d\n",
											salesman.getSale(),
											salesman.getSaleProfit(),
											salesman.getAlarmDegree(),
											Data.getStorageAmount(productChoice));

							break;
						}
						if (confirm.contains("no")) {
							System.out.println("No deal accomplished.\n"
									+ "Maybe you are right! Think twice before doing!");
							break;
						} else {
							System.out
									.println("Error.Let's see the order again!");
						}
					}

					break;
				} else {
					System.out.println("Please enter 1,2,3.Curiosity kill a cat!");
				}
			}// end Big while
			
			System.out.println("Do you want to return to the main menu?\n"
					+ "Please enter yes or no here:");
			String exit = input.nextLine();
			if (exit.contains("no")) {
				break;
			}
			else{
				System.out.println("nonohere");
			}
			String s = input.next();
		}// end Big Big While
		return salesman;

	}// end main
}// end class