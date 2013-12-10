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
	public static byte[] accessCode;
	// with array index.
	private int[] storageAmount = new int[6];
	private BigDecimal[] 
			basePrice= new BigDecimal[6], 
			minPrice = new BigDecimal[6], 
			sugPrice = new BigDecimal[6]; 
	private BigDecimal alarmPrice;
	private BigDecimal currentFunds;

	public void initiateData()
	{
		// 1. Initiate storageAmount
		for (int count = IPAD2; count <= IPHONE5S; count++)
		{
			storageAmount[count + SHIFT] = 0;
		}
		// 2. Initiate basePrice
		initiateBasePrice();
		// 3. If first time, initiate alarmPrice and currentFunds,min&sug price.
		if (Data.firstTime())
		{
			alarmPrice = new BigDecimal("0");
			currentFunds = new BigDecimal("200000.00");
			for (int i = IPAD2; i <= IPHONE5S; i++)
			{
				minPrice[i+SHIFT] = basePrice[i+SHIFT];
				sugPrice[i+SHIFT] = minPrice[i+SHIFT];
			}
		}
		iniAllScale();

	}

	public void initiateBasePrice()
	{
		basePrice[IPAD2 + SHIFT] = new BigDecimal("3000");
		basePrice[IPAD3 + SHIFT] = new BigDecimal("3999");
		basePrice[IPHONE4 + SHIFT] = new BigDecimal("3000");
		basePrice[IPHONE4S + SHIFT] = new BigDecimal("4005");
		basePrice[IPHONE5 + SHIFT] = new BigDecimal("6000");
		basePrice[IPHONE5S + SHIFT] = new BigDecimal("7000");
	}
	public void iniAllScale(){
		for(int i = 0; i < 6; i++){
			basePrice[i] = basePrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
			minPrice[i] = minPrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
			sugPrice[i] = sugPrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
		}
		alarmPrice = alarmPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		currentFunds = currentFunds.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setStorageAmount(int goodsID, int amount)
	{
		storageAmount[goodsID + SHIFT] = amount;
	}

	public void changeStorageAmount(int goodsID, int amount)
	{
		/*
		 * Add the storage amount for product whose name is goodsID. Receive
		 * goodsID and the amount as parameter.
		 */
		storageAmount[goodsID + SHIFT] += amount;
	}

	public int getStorageAmount(int goodsID)
	{
		/*
		 * Get the storage amount for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the storage amount for this product.
		 */
		return storageAmount[goodsID + SHIFT];
	}

	public BigDecimal getBasePrice(int goodsID)
	{
		/*
		 * Get the base price�����ۣ� for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the base price for this product.
		 */
		return basePrice[goodsID + SHIFT];
	}

	public BigDecimal getMinPrice(int goodsID)
	{
		return minPrice[goodsID + SHIFT];
	}

	public void setMinPrice(int goodsID, BigDecimal price)
	{
		if (price.compareTo(basePrice[goodsID]) == -1)
		{
			System.out.printf("Sorry, the minimum price is too low\n");
		}
		else
		{
			minPrice[goodsID + SHIFT] = price;
		}
	}

	public BigDecimal getSugPrice(int goodsID)
	{
		return sugPrice[goodsID + SHIFT];
	}

	public void setSugPrice(int goodsID, BigDecimal price)
	{
		if (price.compareTo(minPrice[goodsID]) == -1)
		{
			System.out.printf("Sorry, the suggest price is too lower than "
					+ "the minimum price\n");
		}
		else
		{
			sugPrice[goodsID + SHIFT] = price;
		}
	}

	public void setAlarmPrice(BigDecimal price)
	{
		/*
		 * Set the ��������.
		 */
		if (price.compareTo(new BigDecimal("0")) == -1)
		{
			// The alarm price should not be less than zero.
			System.out.printf("Error setting alarm price, the"
					+ " percentage should be greater than zero.\n");
		}
		alarmPrice = price;
	}

	public BigDecimal getAlarmPrice()
	{
		/*
		 * Get the ��������.
		 */
		return alarmPrice;
	}

	public BigDecimal getCurrentFunds()
	{
		// Get current funds as Decimal
		return currentFunds;
	}

	public void changeCurrentFunds(BigDecimal money)
	{
		// Add or subtract money to current funds.
		currentFunds = currentFunds.add(money);
	}
}
