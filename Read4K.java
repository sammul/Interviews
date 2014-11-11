public class Read4K{
	String buffer = null;
	int p = 0;
	public String read(int n){
		if(n<0)
			return null;
		else if(n==0)
			return "";
		StringBuilder sb = new StringBuilder();
		while(n>0){
			if(buffer==null || p == buffer.length()){
				buffer = read4k();
				p = 0;
				if(buffer.length()==0)
					break;
			}
			int num = buffer.length()-p;
			if(num >= n){
				sb.append(buffer.substring(p,p+n));
				p = p+n;
				n=0;
			}
			else{
				sb.append(buffer.substring(p));
				p = buffer.length();
				n -= num;
			}
		}
		return sb.toString();
	}
}