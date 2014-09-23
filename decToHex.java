public class decToHex{
	public String decToHex(int num){
		String[] pair = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		String res = "";
		while(num>0){
			res = pair[num%16]+res;
			num = num/16;
		}
		return "0x"+res;
	}
}