import java.io.IOException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Pattern;

// I/O package used to simplify programming.
public class ioPak
{
	private static Scanner input = new Scanner(System.in);

	public static String setUserName()
	{
		String name;
		System.out
				.printf("Please set your name(only English characters, numbers, hyphens "
						+ "\nunderlines or spaces are allowed).\n");
		while (true)
		{
			System.out.printf("Your username:");
			name = nextLine();
			if (!name.matches("[a-zA-Z0-9-_ ]*"))
			{
				printf('-', '!',
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

	public static String setConPD(String name_of_account)
	{
		String s1 = "", s2 = "";
		while (true)
		{
			System.out.printf(" Please set your password: ");
			s1 = getConPD();
			System.out.printf(" Please type your password again:");
			s2 = getConPD();
			if (s1.equals(s2))
			{
				ioPak.printf("Successfully set the password for %s!\n", name_of_account);
				break;
			}
			else
			{
				ioPak.printf(true, false, 0,
						" Mismatch input, please try again.\n");
			}
		}
		return s1;
	}

	public static String getConPD()
	{
		String pd = "";
		while (true)
		{
			if (System.console() != null)
			{
				pd = new String(System.console().readPassword());
			}
			else
			{
				pd = nextLine();
			}
			if (pd.length() > 16)
			{
				ioPak.printf(false, false, 0,
						"Sorry, password should be no more than 16 letters.\n");
				System.out.printf("Please try again:");
			}
			else if (pd.length() < 8)
			{
				ioPak.printf(false, false, 0,
						"Sorry, password should be no less than 8 letters.\n");
				System.out.printf("Please try again:");
			}
			else
			{
				break;
			}
		}// end while
		return pd;
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

	public static int getInt(String ask_phrase, int min, String min_tip,
			int max, String max_tip)
	{
		String a;
		int b;
		boolean flag;
		do
		{
			flag = true;
			System.out.printf("%s", ask_phrase);
			a = nextLine();
			for (int i = 0; i < a.length(); i++)
			{
				if (!Character.isDigit(a.charAt(i)))
				{
					flag = false;
				}
			}
			if (!flag)
			{
				ioPak.printf(false, false, 0,
						"Error input, please type an integer.\n");
			}
			else
			{
				b = Integer.parseInt(a);
				if (b > max)
				{
					flag = false;
					System.out.println(max_tip);
					ioPak.printf(false, false, 0,
							"The number should be within %d and %d.\n", min,
							max);
				}
				else if (b < min)
				{
					flag = false;
					ioPak.printf(min_tip + "\n"
							+ "The number should be within %d to %d\n", min,
							max);
				}
			}
			;
		} while (!flag);
		b = Integer.parseInt(a);
		return b;
	}

	public static int getInt(String ask_phrase, int min, int max)
	{
		return getInt(ask_phrase, min, "Sorry, the number is too small.", max,
				"Oh! The number is too big.");
	}
	public static int getInt(String ask_phrase, int min)
	{
		return getInt(ask_phrase, min, "Sorry, the number is too small.", Integer.MAX_VALUE,
				"Oh! The number is too big.");
	}

	public static BigDecimal getBD(String ask_phrase, double min)
	{
		double num;
		String s;
		BigDecimal b;
		do
		{
			System.out.printf("%s", ask_phrase);
			try
			{
				s = nextLine();
				if (s.contains("e") || s.contains("d"))
				{
					ioPak.printf(false, false, 0,
							"Error input, please type an double.\n");
				}
				else
				{
					num = Double.parseDouble(s);
					if (num < min)
					{
						ioPak.printf("Sorry, The number is too small."
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
				ioPak.printf(false, false, 0,
						"Error input, please type an double.\n");
			}
		} while (true);
		b = new BigDecimal(num);
		b = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return b;
	}
	
	public static String next(){
		String str = "";
			try
			{
				str = input.next();
			} catch (NoSuchElementException e)
			{
				ioPak.printf(false, false, 0,
						"Come on, don't be naughty, never try to press Ctrl-Z");
			/*	System.out.printf("Try again:");
				// Use findWithinHorizon to find EOL and clear it.
				try
				{
					System.out.printf(input.findWithinHorizon(
							Pattern.compile("[$]"), 10));
				} catch (NullPointerException ew)
				{
				}*/
			}
		return str;
	}
	public static String nextLine(){
		String str = "";
			try
			{
				str = input.nextLine();
			} catch (NoSuchElementException e)
			{
				ioPak.printf(false, false, 0,
						"Come on, don't be naughty, never try to press Ctrl-Z");
			/*	System.out.printf("Try again:");
				// Use findWithinHorizon to find EOL and clear it.
				try
				{
					System.out.printf(input.findWithinHorizon(
							Pattern.compile("[$]"), 10));
				} catch (NullPointerException ew)
				{
				}*/
			}
		return str;
	}

	public static void printf(String content, Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, 0, "", content, args);
	}

	public static void printf(boolean HEAD, boolean TAIL, int slash_m,
			String content, Object... args)
	{
		printf('-', '*', HEAD, TAIL, slash_m, 3, 3, 0, "", content, args);
	}

	public static void printf(char h_LINE, char v_LINE, String content,
			Object... args)
	{
		ioPak.printf(h_LINE, v_LINE, true, true, 0, 3, 3, 0, "", content, args);
	}

	public static void printf(int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			String content, Object... args)
	{
		printf('-', '*', true, true, slash_m, SPACE_AHEAD, SPACE_LAST, 0, "",
				content, args);
	}

	public static void printTable(int c_length, String SPLIT, String content,
			Object... args)
	{
		printf('-', '*', true, true, 0, 3, 3, c_length, SPLIT, content, args);
	}

	public static void printTable(int c_length, String content, Object... args)
	{
		printTable(c_length, "!!", content, args);
	}

	public static void printf(char h_LINE, char v_LINE, boolean HEAD,
			boolean TAIL, int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			int c_length, String SPLIT, String content, Object... args)
	{
		/*
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
					// Fill temp_s[j] with enough spaces
					spaceToFill = c_length - temp_sa[j].length();
					for (int k = 0; k < spaceToFill; k++)
					{
						temp_sa[j] = temp_sa[j] + " ";
					}// end filling
					temp_s = temp_s + temp_sa[j];
				}// end scan temp_sa
				string[i] = temp_s;
				// Reset the slash_m
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
				// First and only, add the proceeding spaces and *
				for (int i = 0; i < SPACE_AHEAD; i++)
				{
					string[j] = " " + string[j];
				}
				string[j] = v_LINE + string[j];
			}
			else
			{
				// First, add the proceeding spaces and *
				for (int i = 0; i < SPACE_AHEAD; i++)
				{
					string[j] = " " + string[j];
				}
				string[j] = v_LINE + string[j];
				// Second, add the last spaces and *
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
		// Now print
		System.out.printf(content);
	}// end print

	public static void println(String content)
	{
		content = content + "\n";
		printf(content);
	}

}
