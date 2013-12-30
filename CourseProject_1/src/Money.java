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
	private BigDecimal[] 
			basePrice= new BigDecimal[6], 
			sugPrice = new BigDecimal[6]; 
	private BigDecimal alarmPrice;
	private BigDecimal currentFunds;
	private String anocMen = "Work Harder and achieve Greater!";// Store announcement for all Salesmen

	public void initiateData()
	{
		// 1. Initiate basePrice
		initiateBasePrice();
		// 2. If first time, initiate alarmPrice and currentFunds,min&sug price.
		// and storageAmount
		if (Data.firstTime())
		{
			alarmPrice = new BigDecimal("0");
			currentFunds = new BigDecimal("200000.00");
			for (int i = IPAD2; i <= IPHONE5S; i++)
			{
				//minPrice[i+SHIFT] = basePrice[i+SHIFT];
				sugPrice[i+SHIFT] = basePrice[i+SHIFT];
			}
			for (int count = IPAD2; count <= IPHONE5S; count++)
			{
				storageAmount[count + SHIFT] = 20;
			}
		}
		// initiate the scale of all BigDecimal numbers.
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
	/*public void initiateMinPrice()
	{
		minPrice[IPAD2 + SHIFT] = basePrice[IPAD2 + SHIFT].multiply(alarmPrice)new BigDecimal("3000");
		minPrice[IPAD3 + SHIFT] = new BigDecimal("3999");
		minPrice[IPHONE4 + SHIFT] = new BigDecimal("3000");
		minPrice[IPHONE4S + SHIFT] = new BigDecimal("4005");
		minPrice[IPHONE5 + SHIFT] = new BigDecimal("6000");
		minPrice[IPHONE5S + SHIFT] = new BigDecimal("7000");
	}*/
	public void iniAllScale(){
		for(int i = 0; i < 6; i++){
			basePrice[i] = basePrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
			//minPrice[i] = minPrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
			sugPrice[i] = sugPrice[i].setScale(2, BigDecimal.ROUND_HALF_EVEN);
		}
		alarmPrice = alarmPrice.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		currentFunds = currentFunds.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setStorageAmount(int goodsID, int amount)
	{
		storageAmount[goodsID + SHIFT] = amount;
	}

	public void changeStorageAmount(int goodsID, int amount, BigDecimal price)
	{
		/*
		 * Change the storage amount for product whose name is goodsID. Receive
		 * goodsID and the amount as parameter.
		 * If amount > 0
		 * 		moneyCost > 0
		 * 		amount++
		 * 		CurrentFunds--
		 * If amount < 0
		 * 		moneyCost < 0
		 * 		amount--
		 * 		CurrentFunds++
		 */
		BigDecimal moneyCost;
		if(amount < 0){
			// reduce storage amount
			storageAmount[goodsID+SHIFT] = storageAmount[goodsID+SHIFT] + amount;
			// meanwhile add money to current funds.
			currentFunds = currentFunds.add(price.multiply(new BigDecimal(0-amount)));
		}else{ // amount > 0
			// add storage amount
			moneyCost = price.multiply(new BigDecimal(amount));
			if( stillMoneyLeft(moneyCost)){
				storageAmount[goodsID + SHIFT] += amount;
				changeCurrentFunds(getCurrentFunds().subtract(moneyCost).negate());
				/* Calculate the average purchase(base) price
				 * ( (baseprice*storage) + (price*amount) ) / (amout+storage)
				 */
				moneyCost =( ( getBasePrice(goodsID).multiply(new BigDecimal(getStorageAmount(goodsID))) )
						.add(price.multiply(new BigDecimal(amount))) )
						.divide(new BigDecimal(getStorageAmount(goodsID)+amount), BigDecimal.ROUND_HALF_UP);
				setBasePrice(goodsID, moneyCost);
			}else{
				ioPak.printf(false, false, 0, "Sorry, not enough money left");
			}
			
			
		}

		
	}

	public int getStorageAmount(int goodsID)
	{
		/*
		 * Get the storage amount for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the storage amount for this product.
		 */
		return storageAmount[goodsID + SHIFT];
	}
	private boolean stillMoneyLeft(BigDecimal m)
	{
		BigDecimal x = getCurrentFunds().subtract(m); 
		if( x.compareTo(new BigDecimal("0")) == -1){
			return false;
		}else{
			return true;
		}
	}

	public BigDecimal getBasePrice(int goodsID)
	{
		/*
		 * Get the base price（进价） for product whose name is goodsID. Receive
		 * goodsID as parameter. Return the base price for this product.
		 */
		return basePrice[goodsID + SHIFT];
	}


	public BigDecimal getSugPrice(int goodsID)
	{
		return sugPrice[goodsID + SHIFT];
	}

	public void setSugPrice(int goodsID, BigDecimal price)
	{
		if (price.compareTo(getAlarmPrice(goodsID)) == -1)
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
		 * Set the 利润额警戒线.
		 */
		if (price.compareTo(new BigDecimal("0")) == -1)
		{
			// The alarm price should not be less than zero.
			System.out.printf("Error setting alarm price, the"
					+ " percentage should be greater than zero.\n");
		}
		alarmPrice = price;
	}

	public BigDecimal getAlarmPrice(int goodsID)
	{
		/*
		 * Get the 利润额警戒线.
		 */
		BigDecimal add = getAlarmPercent().add(new BigDecimal("1"));
		BigDecimal times = add.multiply(getBasePrice(goodsID));
		return times;
	}
	public BigDecimal getAlarmPercent()
	{
		return alarmPrice;
	}

	public void setBasePrice(int goodsID, BigDecimal price)
	{
		if(price.compareTo(new BigDecimal("0")) == -1){
			ioPak.printf(false, false, 0, "Oh no, base price can't below zero!!");
		}else{
			basePrice[goodsID+SHIFT] = price;
		}
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
	public void setAnoce(String s)
	{
		anocMen = s;
	}
	public String getAnoce()
	{
		return anocMen;
	}
}
