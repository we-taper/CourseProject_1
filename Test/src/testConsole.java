import java.io.Console;
public class testConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Console c = System.console();
		String pd = new String(c.readPassword());
		c.printf("pd = %s", pd);
	}

}
