public class ReverseWordsInString {
    public String reverseWords(String s) {
        if(s==null||s.length()==0)
            return s;
        StringBuilder sb = new StringBuilder();
        int l=s.length();
        int i=l-1,j=l;
        while(i>=-1){
            if(i==-1||s.charAt(i)==' '){
                if(j-i>1)
                    sb.append(" "+s.substring(i+1,j));
                j=i;
            }
            i--;
        }
        String res = sb.toString();
        return res.equals("") ? res : res.substring(1,res.length());
    }
}