package gradientdescent.objects;
//this object represents one digit from the handwritten ones
public class Digit {
	public int id;
	public byte[][] digits;
	
	public Digit(int id, byte[][] digits){
		this.id = id;
		this.digits = digits;
	}
	
	public String toString(){
		String str= "[";
		if (digits!=null && digits.length>0 && digits[0].length>0){
			for (int j=0; j<digits.length; j++){
				for (int i=0; i<digits[0].length; i++){
					str += digits[j][i]+",";
				}
				str +="\n";
			}
			
		}
		str += "],\n";
		return str;
	}
}
