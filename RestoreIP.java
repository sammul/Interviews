public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        restore(res,cur,s);
        return res;
    }
    public void restore(ArrayList<String> res, ArrayList<Integer> cur, String s){
        if(cur.size()==4 && s.compareTo("")==0){
            String ns = ""+cur.get(0);
            for(int i=1; i<=3; i++)
                ns += "."+cur.get(i);
            res.add(ns);
            return;
        }
        if(s.compareTo("")==0||cur.size()==4)
            return;
        for(int i=1; i<=s.length(); i++){
            if(s.charAt(0)=='0' && i > 1)
                break;
            int b = Integer.parseInt(s.substring(0,i));
            if(b>=0 && b<=255){
                ArrayList<Integer> ncur = new ArrayList<Integer>(cur);
                ncur.add(b);
                restore(res,ncur,s.substring(i,s.length()));
            }
            else
                break;
        }
    }
}