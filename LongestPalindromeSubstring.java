public class LongestPalindromeSubstring {
    public String longestPalindromeSimple(String s) {
        if(s==null || s.length()==0)
            return s;
        int l = s.length();
        String res= "";
        int max = 0;
        for(int i=1; i<=2*l-1; i++){
            int count=1;
            while(i-count>=0 && i+count<=2*l && getChar(s,i-count)==getChar(s,i+count)){
                count++;
            }
            count--;
            if(2*count+1 > max){
                max = 2*count+1;
                res = s.substring((i-count)/2,(i+count)/2);
            }
        }
        return res;
    }
    public char getChar(String s, int index){
        return index%2!=0 ? s.charAt(index/2) : '#';
    }

    /*
    * O(n) solution: Machester Algorithm
    * http://www.felix021.com/blog/read.php?2040
    * http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
    */
    public String longestPalindrome(String s) {
        if(s==null || s.length()==0)
            return s;
        String T = preProcess(s);
        int n = T.length();
        int[] p = new int[n];
        int C=0, R=0;
        for(int i=1; i<n-1; i++){
            int m = 2*C-i;
            p[i]= R>i ? Math.min(R-i,p[m]) : 0;
            while(T.charAt(i+p[i]+1)==T.charAt(i-1-p[i]))
                p[i]++;
            if(i+p[i]>R){
                R=i+p[i];
                C=i;
            }
        }
        int max = 0;
        for(int i=0; i<n-1; i++){
            if(p[i]>max){
                max = p[i];
                C=i;
            }
        }
        return s.substring((C-max-1)/2,(C+max-1)/2);
    }
    public String preProcess(String s){
        StringBuilder sb = new StringBuilder();
        sb.append('^');
        for(int i=0; i<s.length(); i++){
            sb.append("#"+s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }
}