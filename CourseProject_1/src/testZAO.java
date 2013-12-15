
public class testZAO
{
	public static void Delaytype(long millisecond){
		long startMilli=System.currentTimeMillis();
		long endupMilli=System.currentTimeMillis();
		while (endupMilli<startMilli+millisecond){
			endupMilli=System.currentTimeMillis();
		}
	}
}
