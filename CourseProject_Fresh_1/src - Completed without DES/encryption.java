import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class encryption {

	public static byte[] getSHA256(String inputString){
		byte[] data;
		byte[] digest = new byte [256];
		data = inputString.getBytes();
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			sha256.update(data);
			digest = sha256.digest();
			return digest;
		} catch (NoSuchAlgorithmException e) {
			System.err.printf("NoSuchAlgorithmException\n");
			e.printStackTrace();
		}
		return null;
	}
	public static String fromByte2Str( byte[] data){
		return (new String(data));
	}
	public static void main(String[] args){
		byte[] data = getSHA256("happy");
        byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};
        System.out.println(fromByte2Str(data));
        System.out.println(fromByte2Str(byteArray));

	}
}
