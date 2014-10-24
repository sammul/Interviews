import java.util.LinkedHashMap;
import java.util.Map;
public class LRU {
    int size;
    LinkedHashMap<Integer,Integer> map;
    LRU(int s){
        size = s;
        map = new LinkedHashMap<Integer,Integer>(s){
            private static final long serialVersionUID = 1L;
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                   return map.size() > LRU.this.size;
                }
            
        };
    }

    public int get(int key){
        if(map.containsKey(key)){
            int v = map.get(key);
            map.remove(key);
            set(key,v);
            return v;
        }
        else
            return -1;
    }
    public void set(int key, int value){
        if(map.containsKey(key))
            map.remove(key);
        map.put(key, value);
    }
}
