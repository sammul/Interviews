public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return false;
        int sl = s.length(), pl=p.length();
        boolean[][] res = new boolean[sl+1][pl+1];
        res[sl][pl] = true;
        for(int k=pl-1; k>=0; k--){ // review this part
            res[sl][k] = (k<pl-1 && p.charAt(k+1)=='*') ? res[sl][k+2] : false;
        }
        for(int i=sl-1; i>=0; i--){
            for(int j=pl-1; j>=0; j--){ // review this part
                if(j<pl-1 && p.charAt(j+1)=='*')
                    res[i][j] = (p.charAt(j)=='.' || s.charAt(i)==p.charAt(j)) ? (res[i][j+2] || res[i+1][j]) : res[i][j+2];
                else
                    res[i][j] = (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') ? res[i+1][j+1] : false;
            }
        }
        return res[0][0];
    }
}