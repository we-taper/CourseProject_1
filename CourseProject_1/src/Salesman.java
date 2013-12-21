import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Salesman implements Serializable {
	private int accountID = 1;
	private String password = "0";
	private BigDecimal saleAmount = new BigDecimal("0");
	private BigDecimal saleProfit = new BigDecimal("0");
	private String name = "Tom";
	private BigDecimal alarmDegree = new BigDecimal("0");
	private boolean disabled = false;
	// constructors~~!

	public Salesman(int accountID, String name, String password,
			BigDecimal saleAmount, BigDecimal saleProfit, BigDecimal alarmDegree) {
		this.accountID = accountID;
		this.password = password;
		this.name = name;
		this.saleProfit = saleProfit;
		this.saleAmount = saleAmount;
		this.alarmDegree = alarmDegree;
	}

	public Salesman() {
		accountID = 0;
		password = "0";
		name = "Tom";
		saleAmount = new BigDecimal("0");
		saleAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
		disabled = false;
	}

	// a lot of sets!!!
	public void setAlarmDegree(BigDecimal alarmDegree) {
		this.alarmDegree = alarmDegree;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSale(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSaleProfit(BigDecimal saleProfit) {
		this.saleProfit = saleProfit;
	}

	public void setDisable()
	{
		disabled = true;
	}
	public void setEnable()
	{
		disabled = false;
	}

	// end sets!!
	// a lot of gets!!
	public BigDecimal getAlarmDegree() {
		return alarmDegree;
	}

	public int getAccountID() {
		return accountID;
	}

	public String getPassword() {
		return password;
	}

	public BigDecimal getSale() {
		return saleAmount;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getSaleProfit() {
		return saleProfit;
	}
	public boolean isDisabled(){
		return disabled;
	}
	// Wow,gets end!!

	// We CHANGE things after our salesmen really make a deal!
	public void changeSaleAmount(BigDecimal changeA) {
		saleAmount = saleAmount.add(changeA);
	}

	public void changeSaleProfit(BigDecimal changeP) {
		saleProfit = saleProfit.add(changeP);
	}

	public void changeAlarmDegree(BigDecimal changeD) {
		alarmDegree = alarmDegree.add(changeD);
	}
	// CHANGEs End! Then it's a real deal.
	@Override
	public String toString()
	{
		return String.format("User name:%s, ID:%d, Salesamount: %s\n"
				+ "The account is %s",
				this.name,this.accountID,this.saleAmount,
				isDisabled() ? "disabled.":"accessiable.");
	}
}
