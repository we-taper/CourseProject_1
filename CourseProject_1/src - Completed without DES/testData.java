import java.math.BigDecimal;
public class testData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data.initiateData();
		System.out.printf("AP: %s", Data.getAlarmPrice());
		Data.storeData();

	}
}
