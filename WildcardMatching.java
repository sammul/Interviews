public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s==null && p==null)  
            return true;
        if(s==null || p==null)
            return false;
        int i=0, j=0, lastStar=-1, lsmatch=-1;
        while(i<s.length()){
            if(j<p.length() && (p.charAt(j)=='?' || s.charAt(i)==p.charAt(j))){ //judge j<p.length() important!
                i++;j++;
            }
            else if(j<p.length() && p.charAt(j)=='*'){
                lastStar=j++;
                lsmatch = i;
            }
            else{
                if(lastStar!=-1){
                    j=lastStar+1;
                    i=++lsmatch;
                }
                else
                    return false;
            }
        }
        while(j<p.length()){
            if(p.charAt(j)!='*')
                return false;
            j++;
        }
        return true;
    }
}