public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
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
}