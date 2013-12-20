import java.math.BigDecimal;

public class testSale_Op {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bd = new BigDecimal ("100");
		Salesman sa = new Salesman(1, "taper", "tapertaper", bd, bd, bd);
		Sale_Op.main(sa);
		
	}

}
