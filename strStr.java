public class strStr{
	public static String strStrRollingHash(String haystack, String needle){
		final int BASE = 27;
		long M = 1<<29+1;
		int hl=haystack.length(), nl=needle.length();
		char[] harr = haystack.toCharArray();
		char[] narr = needle.toCharArray();
		if(hl<nl){
			return null;
		}
		else if(nl==0){
			return haystack;
		}
		long h_hashv = 0, n_hashv = 0;
		long k=1;
		for(int i=0; i<nl; i++){
			h_hashv = (h_hashv*BASE+(harr[i]-'a'))%M;
			n_hashv = (n_hashv*BASE+(narr[i]-'a'))%M;
			k = (k*BASE)%M;
		}
		int i=nl, j=0;
		for(;i<hl; i++,j++){
			if(h_hashv == n_hashv)
				return haystack.substring(j,hl);
			h_hashv = (h_hashv*BASE - k*(harr[j]-'a')+ (harr[i]-'a'))%M;
		}
		return null;
	}
	public static String strStrBasic(String haystack, String needle){
		int hl = haystack.length();
		int nl = needle.length();
		for(int i=0; i<=hl-nl; i++){
			int j=0;
			for(; j<nl; j++){
				if(haystack.charAt(i+j) == needle.charAt(j))
					continue;
				else break;
			}
			if(j==nl)
				return haystack.substring(i,hl);
		}
		return null;
	}
}