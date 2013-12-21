
public class CS
{
	// For storing all the constants in system.
	public static final int LEVEL_G = 50;
	// Level time Gap, for whole system when printing arrow
	public static final int LEVEL1 = 1;
	public static final int LEVEL2 = LEVEL1 +7; // Shift right, for level one
	public static final int LEVEL3 = LEVEL2 +7;// Shift right, for level two
	public static final int LEVEL4 = LEVEL3 +7;// Shift right, for level three
	public static final int WAIT_FOR_BAR = 30;
	// Wait gap, for progress bar.
	public static final int WAIT_G_FOR_SEE = 500;
	// Wait gap, for customer to see the message, for whole system.
	public static final int WAIT_G_FOR_MENU = 300;
	// Wait gap, for customer to see the Menu, for whole system.
	public static final int All_LENGTH = 78;// The length of the cmd windows
	public static final int NO_SHIFT = 0;  // Do not shift the output right
	
	public static String level1()
	{
		/**
		 * return a String of spaces whose length is LEVEL1;
		 */
		String s = "";
		for(int i=0; i<LEVEL1; i++)
		{
			s = s + " ";
		}
		return s;
	}
	public static String level2()
	{
		/**
		 * return a String of spaces whose length is LEVEL2;
		 */
		String s = "";
		for(int i=0; i<LEVEL2; i++)
		{
			s = s + " ";
		}
		return s;
	}
	public static String level3()
	{
		/**
		 * return a String of spaces whose length is LEVEL3;
		 */
		String s = "";
		for(int i=0; i<LEVEL3; i++)
		{
			s = s + " ";
		}
		return s;
	}
	public static String level4()
	{
		/**
		 * return a String of spaces whose length is LEVEL4;
		 */
		String s = "";
		for(int i=0; i<LEVEL4; i++)
		{
			s = s + " ";
		}
		return s;
	}
}
