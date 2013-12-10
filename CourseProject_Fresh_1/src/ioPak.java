import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

// UI package used to simplify programming.
public class ioPak
{
	private static final Scanner input = new Scanner(System.in);

	public static String setConPD(String name_of_password)
	{
		String s1 = "", s2 = "";
		while (true)
		{
			System.out.printf("Please set your %s: ", name_of_password);
			s1 = getConPD();
			System.out.printf("Please type your %s again:", name_of_password);
			s2 = getConPD();
			if (s1.equals(s2))
			{
				System.out.printf("Successfully set!!\n");
				break;
			}
			else
			{
				System.out.printf("Mismatch input, please try again.\n");
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
				pd = input.nextLine();
			}
			if (pd.length() > 16)
			{
				System.out
						.printf("Sorry, password should be no more than 16 letters.\n"
								+ "Please try again:");
			}
			else if (pd.length() < 8)
			{
				System.out
						.printf("Sorry, password should be no less than 8 letters.\n"
								+ "Please try again:");
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
			a = input.nextLine();
			for (int i = 0; i < a.length(); i++)
			{
				if (!Character.isDigit(a.charAt(i)))
				{
					flag = false;
				}
			}
			if (!flag)
			{
				System.out.printf("Error input, please type an integer.\n");
			}
			else
			{
				b = Integer.parseInt(a);
				if (b > max)
				{
					flag = false;
					System.out.println(max_tip);
					System.out.printf(
							"The number should be within %d and %d.\n", min,
							max);
				}
				else if (b < min)
				{
					flag = false;
					System.out.println(min_tip);
					System.out.printf("The number should be within %d to %d\n",
							min, max);
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
				s = input.nextLine();
				num = Double.parseDouble(s);
				if (num < min)
				{
					System.out.println("Oh! The number is too big.");
					System.out.printf(
							"The number should be higher than %.2f.\n", min);
				}
				else
				{
					break;
				}
			} catch (NumberFormatException e)
			{
				System.out.printf("Error input, please type an double.\n");
			}

		} while (true);
		b = new BigDecimal(num);
		b = b.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		return b;
	}

	public static void printf(String content, Object... args)
	{
		printf('-', '*', false, false, 0, 3, 3, content, args);
	}
	public static void printf(boolean NO_HEAD, boolean NO_TAIL, int slash_m, String content, Object...args ){
		printf('-','*', NO_HEAD, NO_TAIL, slash_m, 3, 3, content, args);
	}
	public static void printf(int slash_m, String content, Object...args ){
		printf('-','*', false, false, slash_m, 3, 3, content, args);
	}

	public static void printf(char h_LINE, char v_LINE, boolean NO_HEAD,
			boolean NO_TAIL, int slash_m, int SPACE_AHEAD, int SPACE_LAST,
			String content, Object... args)
	{
		/* Parameters:
		 * h_LINE: Character used to draw horizontal lines.
		 * v_LINE: Character used to draw vertical lines.
		 * NO_HEAD: True if do not print the header.
		 * NO_TAIL: True if do not print the bottom line.
		 * slash_m: The width of lines. Zero(0) to indicate using the default 
		 * 			value, which is the max length of strings added with 
		 * 			SPACE_AHEAD and SPACE_LAST.// TODO
		 * SPACE_AHEAD: First few spaces to insert.
		 * SPACE_LAST: The number of spaces inserted last.
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
		if (slash_m == 0)
		{
			slash_m = max_length + SPACE_AHEAD + SPACE_LAST + 2;// 2 = two "*"
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
		if (!NO_HEAD)
		{
			content = ".\n" + content;
			for (int i = 0; i < slash_m - 2; i++)
			{
				content = h_LINE + content;
			}
			content = "." + content;
		}
		if (!NO_TAIL)
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
