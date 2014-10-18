import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        if(T==null||T.length()==0)
            return "";
        HashMap<Character,Integer> tofind = new HashMap<Character,Integer>();
        HashMap<Character,Integer> found = new HashMap<Character,Integer>();
        for(char c : T.toCharArray()){
            if(tofind.containsKey(c))
                tofind.put(c,tofind.get(c)+1);
            else
                tofind.put(c,1);
            found.put(c,0);
        }
        int foundcount = 0;
        int start=0, end=0, min=Integer.MAX_VALUE;
        String res = "";
        while(end<S.length()){
            char c = S.charAt(end);
            if(!tofind.containsKey(c)){
                end++;
                continue;
            }
            found.put(c,found.get(c)+1);
            if(found.get(c)<=tofind.get(c))
                foundcount++;
            if(foundcount==T.length()){
                while(start<end){
                    char t = S.charAt(start);
                    if(!tofind.containsKey(t))
                        start++;
                    else if(found.get(t)>tofind.get(t)){
                        found.put(t,found.get(t)-1);
                        start++;
                    }
                    else
                        break;
                }
                if(end-start+1<min){
                    min = end-start+1;
                    res = S.substring(start,end+1);
                }
            }
            end++;
        }
        return res;
    }
}