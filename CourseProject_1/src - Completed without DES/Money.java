import java.math.BigDecimal;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Money implements Serializable
{
	public static final int IPAD2 = 001;
	public static final int IPAD3 = 002;
	public static final int IPHONE4 = 003;
	public static final int IPHONE4S = 004;
	public static final int IPHONE5 = 005;
	public static final int IPHONE5S = 006;
	private static final int SHIFT = -1;// Use +SHIFT to shift numbers in comply
										// with array index.
	private int[] storageAmount = new int[6];
	private BigDecimal[] basePrice = new BigDecimal[6];
	private BigDecimal alarmPrice;
	private BigDecimal currentFunds;
	
	public  void initiateData()
	{
		//1. Initiate storageAmount
		for(int count = IPAD2; count <= IPHONE5S; count++)
		{
			storageAmount[count+SHIFT] = 0;
		}
		//2. Initiate basePrice
		initiateBasePrice();
		//3. Initiate alarmPrice and currentFunds.
		alarmPrice = new BigDecimal("0");
		currentFunds = new BigDecimal("200000.00");
		
	}
	public  void initiateBasePrice()
	{
		basePrice[IPAD2+SHIFT] = new BigDecimal("3000");
		basePrice[IPAD3+SHIFT] = new BigDecimal("3999");
		basePrice[IPHONE4+SHIFT] = new BigDecimal("3000");
		basePrice[IPHONE4S+SHIFT] = new BigDecimal("4005");
		basePrice[IPHONE5+SHIFT] = new BigDecimal("6000");
		basePrice[IPHONE5S+SHIFT] = new BigDecimal("7000");
	}
	public  void setStorageAmount(int goodsID, int amount)
	{
		storageAmount[goodsID+SHIFT] = amount; }
	public  void changeStorageAmount(int goodsID, int amount)
	{
		/*Add the storage amount for product whose name is goodsID. Receive goodsID
		 * and the amount as parameter.
		 */
		storageAmount[goodsID+SHIFT] += amount;
	}
	public  int getStorageAmount(int goodsID)
	{
		/*Get the storage amount for product whose name is goodsID. Receive goodsID
		 * as parameter. Return the storage amount for this product.
		 */
		return storageAmount[goodsID+SHIFT];
	}
	public  BigDecimal getBasePrice(int goodsID)
	{
		/*Get the base price（进价） for product whose name is goodsID. Receive goodsID
		 * as parameter. Return the base price for this product.
		 */
		return basePrice[goodsID+SHIFT];
	}
	public  void setAlarmPrice(BigDecimal price)
	{
		/*Set the 利润额警戒线. 
		 */
		alarmPrice = price;
	}
	public  BigDecimal getAlarmPrice()
	{
		/*Get the 利润额警戒线. 
		 */
		return alarmPrice;
	}
	public  BigDecimal getCurrentFunds()
	{
		// Get current funds as Decimal
		return currentFunds;
	}
	public  void changeCurrentFunds(BigDecimal money)
	{
		// Add or subtract money to current funds.
		currentFunds = currentFunds.add(money);
	}
}
