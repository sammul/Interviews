import java.util.ArrayList;
import java.util.HashSet;

public class PalindromePairs{
	/*Find all the pair */
	ArrayList<ArrayList<String>> findPair(HashSet<String> set){
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(String s: set){
			for(int i=s.length(); i>=0; i--){
				String p = reverse(s.substring(0,i));
				if(isPalin(s,i,s.length()-1) && !p.equals(s) && set.contains(p)){
					ArrayList<String> nres = new ArrayList<String>();
					nres.add(s);
					nres.add(p);
					res.add(nres);
					break;
				}
			}
		}
		return res;
	}
	public static void main(String[] args){
		PalindromePairs pp = new PalindromePairs();
		String[] sarr = {"aa","bb","ab","abcc","ba"};
		HashSet<String> set = new HashSet<String>();
		for(String s: sarr)
			set.add(s);
		ArrayList<ArrayList<String>> r = pp.findPair(set);
	}
	String reverse(String s){
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--)
			sb.append(s.charAt(i));
		return sb.toString();
	}
	boolean isPalin(String s, int i, int j){
		while(i < j){
			if(s.charAt(i++)!=s.charAt(j--))
				return false;
		}
		return true;
	}
}