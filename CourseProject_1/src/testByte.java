import java.util.ArrayList;


public class testByte {

	public static ArrayList<Salesman> sa = new ArrayList<Salesman>();
	public static Salesman sale = new Salesman();
	public static Salesman sale2 = new Salesman();
	public static Salesman sale3 = new Salesman();
	public static void main(String[] args)
	{
		sale.setName("1");
		sa.add(sale);
		System.out.println(sa.indexOf(sale));
		sale2.setName("1");
		sa.add(sale2);
		System.out.println(sa.indexOf(sale2));
		
	}
	
}
