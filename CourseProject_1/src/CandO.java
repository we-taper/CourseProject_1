/**
 * 
 * @author we.taper
 *
 *	C == Command
 *	O == Operands
 */
public class CandO
{
	private String Command = "";
	private String Operands;
	CandO(){
		Command = "";
		Operands = "";
	}
	public String getC(){
		return this.Command;
	}
	public void setC(String c){
		this.Command = c;
	}
	public String[] getO(){
		return Operands.split(" ");
	}
	public String getO(int i){
		// Return the ith operands.
		return this.Operands.split(" ")[i];
	}
	public void addO(String o){
		this.Operands = this.Operands + " " + o;
	}
}
