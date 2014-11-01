import java.util.NavigableSet;
import java.util.TreeMap;


public class TreeMapTest {
	public static void main(String[] args){
		TreeMap<String,Integer> tm = new TreeMap<String,Integer>();
        tm.put("bb",5);
        tm.put("aa",2);
        tm.put("cc",5);
        tm.put("aaa", 3);
        NavigableSet<String> k = tm.navigableKeySet();
        for(String a : k)
        	System.out.println(a);
	}
}
