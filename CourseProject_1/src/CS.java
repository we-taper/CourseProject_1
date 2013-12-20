
public class CS
{
	// For storing all the constants in system.
	public static final int AR_G = 100; // ArrowGap, for whole system.
	public static final int LEVEL1 = 1;
	public static final int LEVEL2 = LEVEL1 + 10; // Shift right, for level one
	public static final int LEVEL3 = LEVEL2 +10;// Shift right, for level two
	public static final int LEVEL4 = LEVEL3 + 10;// Shift right, for level three
	public static final int WAIT_G = 100;// WatiGap, for whole system.
	public static final int All_LENGTH = 80;// The length of the cmd windows
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
