import java.math.BigDecimal;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Administrator implements Serializable
{
	private String password = "0";
	
	public Administrator(String password, BigDecimal saleAmount,BigDecimal saleProfit)
	{
		this.password = password;
	}
	public Administrator()
	{
		password = "0";
	}

	public void setPassword(String password)
	{
		this.password = password;
	}



	public  String getPassword()
	{
		return password;
	}


	public String toString()
	{
		return String.format(
				"User name:%s, ID:%d,\nPassword: %s, Salesamount: %s\n",this.password);
	}
}
