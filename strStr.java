public class strStr{
    public static final long MOD = (1<<27)+(1<<20)+(1<<5)+101;
    public static final long BASE = 127;
    public String strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return null;
        if(needle.equals(""))
            return haystack;
        long nee_v=0,hay_v=0,k=1;
        int nl = needle.length(), hl = haystack.length();
        if(hl<nl)
            return null;
        for(int i=0; i<nl; i++){
            nee_v = (nee_v*BASE+(int)needle.charAt(i))%MOD;
            hay_v = (hay_v*BASE+(int)haystack.charAt(i))%MOD;
            k = (k*BASE)%MOD;
        }
        int i=0, j=nl;
        for(; j<=hl; i++,j++){
            if(nee_v==hay_v){
                if(needle.equals(haystack.substring(i,j)))
                    return haystack.substring(i,hl);
            }
            if(j==hl)
                break;
            hay_v = (hay_v*BASE-((long)haystack.charAt(i))*k+(long)haystack.charAt(j)+MOD*BASE)%MOD;
        }
        return null;
    }
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