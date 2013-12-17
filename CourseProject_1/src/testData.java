import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
public class testData {

	public static void main(String[] args) throws IOException {
	    Runtime run = Runtime.getRuntime();  
	    Process p = run.exec("C:\\WINDOWS\\system32\\ioPak.exe");  
	    BufferedReader br = new BufferedReader(new InputStreamReader(  
	            p.getInputStream()));  
	    String str = null;  
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(  
	            p.getOutputStream()));  
	    Scanner sc = new Scanner(System.in);  
	    String cmd = null;
	    while (true) {  
	    	if(cmd!=null){
	    		cmd = sc.nextLine(); 
	    		System.out.println(cmd); 
	    	}else{
	    		cmd = "";
	    	}
	        while ((str = br.readLine()) != null) {  
	            System.out.println("--" + str);  
	        }  
	        System.out.println(cmd);  
	        if (cmd.equalsIgnoreCase("q") || cmd.equalsIgnoreCase("exit")) {  
	            break;  
	        }  
	        bw.write(cmd);  
	        bw.flush();  
	    }  
	    p.destroy();  
	    bw.close();  
	    br.close();  
	    sc.close();
	}
}
