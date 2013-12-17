import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;

// I/O package used to simplify programming.
public class ioPak
{
	private static Scanner input = new Scanner(System.in);
	public static int LEFT_ARROW = 0;
	public static int RIGHT_ARROW = 1;

	public static String setUserName(int SPACE_BEFORE)
	{
		String name;
		System.out
				.printf(shift(SPACE_BEFORE, "Please set your name(only English characters, numbers, hyphens "
						+ "\nunderlines or spaces are allowed).\n"));
		while (true)
		{
			System.out.printf(shift(SPACE_BEFORE, "Your username:"));
			name = nextLine();
			if (!name.matches("[a-zA-Z0-9-_ ]*"))
			{
				printf(SPACE_BEFORE, '-', '!',
						"Your name shoule only contains English characters,\n"
								+ "numbers, hyphens or underlines.");
			}
			else
			{
				break;
			}
		}
		return name;
	}
	public static String setUserName(){
		return setUserName(0);
	}

	public static String setConPD(int SPACE_BEFORE, String name_of_account)
	{
		String s1 = "", s2 = "";
		while (true)
		{
			System.out.printf(shift(SPACE_BEFORE, " Please set your password: "));
			s1 = getConPD();
			System.out.printf(shift(SPACE_BEFORE," Please type your password again:"));
			s2 = getConPD();
			if (s1.equals(s2))
			{
				ioPak.printf(SPACE_BEFORE, "Successfully set the password for %s!\n", name_of_account);
				break;
			}
			else
			{
				ioPak.printf(false, false, 0,
						SPACE_BEFORE, " Mismatch input, please try again.\n");
			}
		}
		return s1;
	}
	public static String setConPD(String name_of_account)
	{
		return setConPD(0,name_of_account);
	}

	public static String getConPD(int SPACE_BEFORE)
	{
		String pd = "";
		while (true)
		{
			try{
				// First, read password
				if (System.console() != null)
				{
					pd = new String(System.console().readPassword());
					/*
					 *  Here throw NullPointerException, which will be caught later
					 *  Throw NullPointerException if user press Ctrl-Z or else like.
					 */
				}
				else
				{
					pd = nextLine();
				}
				// Then judge password
				if (pd.length() > 16)
				{
					ioPak.printf(false, false, 0, SPACE_BEFORE,
							"Sorry, password should be no more than 16 letters.\n");
					System.out.printf(shift(SPACE_BEFORE,"Please try again:"));
				}
				else if (pd.length() < 8)
				{
					ioPak.printf(false, false, 0, SPACE_BEFORE,
							"Sorry, password should be no less than 8 letters.\n");
					System.out.printf(shift(SPACE_BEFORE,"Please try again:"));
				}
				else
				{
					break;
				}
			} catch (NullPointerException e)
			{
				cls(1);
				ioPak.printf(false, false, 0, SPACE_BEFORE,
						"Come on, don't be naughty, never try to press Ctrl-Z or whatever else.\n");
				/*
				 * If program reaches here, it must be inside a ioPak Console, then
				 * System could automatically clear the Ctrl-Z character.
				 */
				System.out.printf(shift(SPACE_BEFORE,"Please try again:"));
			}
		}// end while
		return pd;
	}
	public static String getConPD()
	{
		return getConPD(0);
	}

	public static void cls()
	{
		try
		{
			Runtime.getRuntime().exec("cls");
		} catch (IOException e)
		{
			for (int i = 1; i <= 40; i++)
			{
				System.out.println();
			}
		}
	}

	public static void cls(int lines)
	{
		try
		{
			Runtime.getRuntime().exec("cls");
		} catch (IOException e)
		{
			for (int i = 1; i <= lines; i++)
			{
				System.out.println();
			}
		}
	}

	public static int getInt(int SPACE_BEFORE, String ask_phrase, int min, String min_tip,
			int max, String max_tip)
	{
		String a;
		int b;
		boolean flag;
		do
		{
			flag = true;
			System.out.printf(shift(SPACE_BEFORE,""+ ask_phrase));
			a = nextLine();
			if(a.length() == 0)
			{
				flag = false;
			}
			for (int i = 0; i < a.length(); i++)
			{
				if (!Character.isDigit(a.charAt(i)))
				{
					flag = false;
				}
			}
			if (!flag)
			{
				ioPak.printf(false, false, 0, SPACE_BEFORE,
						"Error input, please type an integer.\n");
			}
			else
			{
				try{
						b = Integer.parseInt(a);
					if (b > max)
					{
						flag = false;
						System.out.println(max_tip);
						ioPak.printf(false, false, 0, SPACE_BEFORE,
								"The number should be within %d and %d.\n", min,
								max);
					}
					else if (b < min)
					{
						flag = false;
						ioPak.printf(SPACE_BEFORE, min_tip + "\n"
								+ "The number should be within %d to %d\n", min,
								max);
					}
				}catch (NumberFormatException e){
					// catch the too long number
					ioPak.printf(false, false, 0, SPACE_BEFORE,
							"The number should be within %d and %d.\n", min,
							max);
					flag =false;
				}
			}
		} while (!flag);
		b = Integer.parseInt(a);
		return b;
	}
	public static int getInt(String ask_phrase, int min, String min_tip,
			int max, String max_tip)
	{
		return getInt(0, ask_phrase, min, min_tip,max, max_tip);
	}

	public static int getInt(int SPACE_BEFORE,String ask_phrase, int min, int max)
	{
		return getInt(SPACE_BEFORE, ask_phrase, min, "Sorry, the number is too small.", max,
				"Oh! The number is too big.");
	}
	public static int getInt(String ask_phrase, int min, int max)
	{
		return getInt(0, ask_phrase, min, "Sorry, the number is too small.", max,
				"Oh! The number is too big.");
	}
	public static int getInt(int SPACE_BEFORE, String ask_phrase, int min)
	{
		return getInt(SPACE_BEFORE, ask_phrase, min, "Sorry, the number is too small.", Integer.MAX_VALUE,
				"Oh! The number is too big.");
	}
	public static int getInt( String ask_phrase, int min)
	{
		return getInt(0, ask_phrase, min, "Sorry, the number is too small.", Integer.MAX_VALUE,
				"Oh! The number is too big.");
	}
	public static BigDecimal getBD(int SPACE_BEFORE,String ask_phrase, double min)
	{
		double num;
		String s;
		BigDecimal b;
		do
		{
			System.out.printf(shift(SPACE_BEFORE,""+ ask_phrase));
			try
			{
				s = nextLine();
				if (s.contains("e") || s.contains("d"))
				{
					ioPak.printf(false, false, 0,SPACE_BEFORE,
							"Error input, please type an double.\n");
				}
				else
				{
					num = Double.parseDouble(s);
					if (num < min)
					{
						ioPak.printf(SPACE_BEFORE,"Sorry, The number is too small."
								+ "The number should be higher than %.2f.\n",
								min);
					}
					else
					{
						break;
					}
				}
			} catch (NumberFormatException e)
			{
				ioPak.printf(false, false, 0,SPACE_BEFORE,
						"Error input, please type an double.\n");
			}
		} while (true);
		b = new BigDecimal(s);
		b = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return b;
	}
	public static BigDecimal getBD(String ask_phrase, double min)
	{
		return getBD(0, ask_phrase, min);
	}
	public static String nextLine(){
		String str = "";
		while(true){
			try
			{
				if(System.console() == null){
					str = input.nextLine();
					break;
				}else{
					str = System.console().readLine();
					if(str == null){
						/*
						 * str == null because console reads a Ctra-Z
						 * If program reaches here, it must be inside a ioPak Console, then
						 * System could automatically clear the Ctrl-Z character.
						 */
						cls(1);
						ioPak.printf(false, false, 0,
								"Come on, don't be naughty, never try to press Ctrl-Z or whatever else\n"
								+ "again.\n");
						System.out.printf("Try again:");
					}else{
						break;
					}
				}// end if System.console()			
			} catch (NoSuchElementException e)
			{
				cls(1);
				ioPak.printf(false, false, 0,
						"Come on, don't be naughty, never try to press Ctrl-Z or whatever else\n"
						+ "again.This forces System to quit.\n");
				if (System.console() != null)
				{
					System.out.printf("Try again:");
				}else{
					String ac = Main_Interface.getAccessCode();
					if (ac.length() != 0)
					{
						Data.storeData(ac);
					}
					System.exit(1);
				}
			}//end catch
		}// end while
		return str;
	}
	public static boolean isDouble(String input){
		try
		{
			Double.parseDouble(input);
			return true;
		} catch (NullPointerException|NumberFormatException  e)
		{
			return false;
		}
	}
	public static void printBlock(int x, int y, int horizon, int vertical,
			char star, char space_l, char space_r)
	{
		if (vertical < 1 || horizon < 1 || x<1 || y<1 || x>horizon || y>vertical)
		{
			return;
		}
		for (int i = 1; i <= vertical; i++)
		{
			for (int j = 1; j <= horizon; j++)
			{
				if (j == x && i == y)
				{
					System.out.print(star);
				}
				else
				{
					if(j<x){
						System.out.print(space_l);
					}else{
						System.out.print(space_r);
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void printArrow(int length, int timeGap, int direction){
		// print ******>
		if( direction == RIGHT_ARROW)
		{
			// print the *******
			for (int i = 1; i < length; i++)
			{
				printBlock(i, 1, length, 1, '.', ' ', ' ');
				try
				{
					Thread.sleep(timeGap);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			// print the >
			printBlock(length, 1, length, 1, '+', ' ', ' ');
			try
			{
				Thread.sleep(timeGap);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		else if(direction == LEFT_ARROW)
		{
			// print the *******
			for (int i = length; i > 1; i--)
			{
				printBlock(i, 1, length, 1, '.', ' ', ' ');
				try
				{
					Thread.sleep(timeGap);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			// print the >
			printBlock(length, 1, 1, 1, '+', ' ', ' ');
			try
			{
				Thread.sleep(timeGap);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void printf(String content, Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, 0, "", 0, content, args);
	}
	public static void printf(int SPACE_BEFORE, String content, Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, 0, "", SPACE_BEFORE, content, args);
	}

	public static void printf(boolean HEAD, boolean TAIL, int slash_m,
			String content, Object... args)
	{
		printf('-', '*', HEAD, TAIL, slash_m, 3, 3, 0, "", 0, content, args);
	}
	public static void printf(boolean HEAD, boolean TAIL, int slash_m,
			int SPACE_BEFORE, String content, Object... args)
	{
		printf('-', '*', HEAD, TAIL, slash_m, 3, 3, 0, "", SPACE_BEFORE, content, args);
	}

	public static void printf(char h_LINE, char v_LINE, String content,
			Object... args)
	{
		ioPak.printf(h_LINE, v_LINE, true, true, 0, 3, 3, 0, "", 0, content, args);
	}
	public static void printf(char h_LINE, char v_LINE,int SPACE_BEFORE, String content,
			Object... args)
	{
		ioPak.printf(h_LINE, v_LINE, true, true, 0, 3, 3, 0, "", SPACE_BEFORE, content, args);
	}

	public static void printf(int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			String content, Object... args)
	{
		printf('-', '*', true, true, slash_m, SPACE_AHEAD, SPACE_LAST, 0, "", 0,
				content, args);
	}
	public static void printf(int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			int SPACE_BEFORE, String content, Object... args)
	{
		printf('-', '*', true, true, slash_m, SPACE_AHEAD, SPACE_LAST, 0, "", SPACE_BEFORE,
				content, args);
	}

	public static void printTable(int c_length, String SPLIT, String content,
			Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, c_length, SPLIT, 0, content, args);
	}
	public static void printTable(int c_length, String SPLIT, int SPACE_BEFORE, String content,
			Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, c_length, SPLIT, SPACE_BEFORE, content, args);
	}

	public static void printTable(int c_length, String content, Object... args)
	{
		printTable(c_length, "!!", content, args);
	}
	public static void printTable(int c_length, int SPACE_BEFORE, String content, Object... args)
	{
		printTable(c_length, "!!", SPACE_BEFORE, content, args);
	}

	public static void printf(char h_LINE, char v_LINE, boolean HEAD,
			boolean TAIL, int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			int c_length, String SPLIT, int SPACE_BEFORE, String content,
			Object... args)
	{
		/**
		 * Parameters: 
		 * h_LINE: Character used to draw horizontal lines. 
		 * v_LINE: Character used to draw vertical lines. 
		 * HEAD: True if print the header. 
		 * TAIL: True if print the bottom line. 
		 * slash_m: The width of lines. Zero(0) to indicate using the default value,
		 *  	which is the max length of strings added with SPACE_AHEAD and SPACE_LAST.
		 * SPACE_AHEAD: First few spaces to insert. 
		 * SPACE_LAST: The number of spaces inserted last.
		 * c_length : In purpose of dealing with \t, we propose a new method:"|" 
		 * 		c_length is the length of column. Zero if we do not need to deal 
		 * 		with the troublesome \t. 
		 * SPLIT: The character or string used to identity splitting strings. 
		 * 		Be careful that SPLIT must not be a regular expression.
		 * SPACE_BEFORE: The spaces before the whole block, used to shift the 
		 * 				block right.
		 */
		// Turn the contents into entirely and only pure strings.
		content = String.format(content, args);
		// Find the maximum string
		int max_length = 0, temp = 0;
		String string[] = content.split("\n");

		max_length = string[0].length();

		// Find the max_lenth of all the strings.
		for (int i = 1; i < string.length; i++)
		{
			max_length = Math.max(string[i].length(), max_length);
		}
		// Set the slash_m
		if (slash_m == 0)
		{
			slash_m = max_length + SPACE_AHEAD + SPACE_LAST + 2;// 2 = two "*"
		}
		// Check if slash_m is large enough.
		if (slash_m >= max_length)
		{
			;// That's OK.
		}
		else
		{
			// Use the default slash_m
			slash_m = max_length + SPACE_AHEAD + SPACE_LAST + 2;// 2 = two "*"
		}

		// Deal with \t
		if (c_length != 0)
		{
			SPACE_AHEAD = 1;
			SPACE_LAST = 1;
			// Cut up all strings into column pieces
			String temp_sa[], temp_s;
			int spaceToFill;
			for (int i = 0; i < string.length; i++)
			{// Scan strings
				temp_sa = string[i].split(SPLIT);
				temp_s = "";
				for (int j = 0; j < temp_sa.length; j++)
				{// Scan temp_sa
					// Check if c_length is legal
					if (c_length < temp_sa[j].length())
					{
						System.err.println("Wrong c_length: too small.");
						return;
					}
					;
					// Fill temp_s[j] with enough spaces appending
					spaceToFill = c_length - temp_sa[j].length();
					for (int k = 0; k < spaceToFill; k++)
					{
						temp_sa[j] = temp_sa[j] + " ";
					}// end filling
					// concatenate all the strings.
					temp_s = temp_s + temp_sa[j];
				}// end scan temp_sa
				string[i] = temp_s;
				// Reset the slash_m in case the concatenated string is too long.
				slash_m = Math.max(slash_m, string[i].length() + 2
						+ SPACE_AHEAD + SPACE_LAST);// 2 = two "*"
			}// end scan string
		}

		// Fill the strings up the length, one by one
		content = ""; // clear content
		for (int j = 0; j < string.length; j++)
		{
			if (string[j].contains("\t")) // \t is difficult to deal with.
			{
				// First and only, add the proceeding spaces and v_LINE
				for (int i = 0; i < SPACE_AHEAD; i++)
				{
					string[j] = " " + string[j];
				}
				string[j] = v_LINE + string[j];
			}
			else
			{
				// First, add the proceeding spaces and v_LINE
				for (int i = 0; i < SPACE_AHEAD; i++)
				{
					string[j] = " " + string[j];
				}
				string[j] = v_LINE + string[j];
				// Second, add the last spaces and v_LINE
				temp = string[j].length();
				for (int i = 0; i < (slash_m - temp - 1); i++)
				{
					string[j] = string[j] + " ";
				}
				string[j] = string[j] + v_LINE;
			}
			// concatenate strings
			content = content + string[j] + "\n";
		}
		// Add header and bottom to content
		if (HEAD)
		{
			content = ".\n" + content;
			for (int i = 0; i < slash_m - 2; i++)
			{
				content = h_LINE + content;
			}
			content = "." + content;
		}
		if (TAIL)
		{
			content = content + "*";
			for (int i = 0; i < slash_m - 2; i++)
			{
				content = content + h_LINE;
			}
			content = content + "*\n";
		}
		// Now shift output right with spaces
		content = shift(SPACE_BEFORE, content );
		content = content + "\n";// add the missing \n deleted by shift
		// Now print
		System.out.printf(content);
	}// end print

	public static void println(String content)
	{
		content = content + "\n";
		printf(content);
	}
	public static String shift(int SPACE_BEFORE, String input)
	{
		// Split
		String[] s = input.split("\n");
		input = "";//clear input
		// one by one shift right
		for (int j=0; j<s.length; j++)
		{
			for (int i = 0; i < SPACE_BEFORE; i++)
			{
				s[j] = " " + s[j];
			}
			if(j < s.length-1){
				input = input + s[j] + "\n";
			}else{
				input = input + s[j];// Don't add \n to the last line.
			}
		}// end for
		return input;
	}

}
