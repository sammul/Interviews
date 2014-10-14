import java.util.HashMap;

public class LRUCache {
    ListNode head;
    ListNode tail;
    int size;
    int curnum;
    HashMap<Integer,ListNode> map;
    
    public LRUCache(int capacity) {
        size = capacity;
        curnum = 0;
        head = new ListNode(0,0);//the head is a dummy node
        tail = head;
        map = new HashMap<Integer,ListNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode res = map.get(key);
            remove(res);
            moveToHead(res);
            return res.value;
        }
        else
            return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            ListNode t = map.get(key);
            t.value = value;
            remove(t);
            moveToHead(t);
        }
        else{
            ListNode n = new ListNode(key,value);
            map.put(key,n);
            if(curnum>=size){
                map.remove(tail.key);
                remove(tail);
            }
            moveToHead(n);
        }
    }
    public void remove(ListNode t){
        ListNode tp = t.pre, tn = t.next;
        tp.next = tn;
        if(tn!=null)
            tn.pre = tp;
        if(t==tail)
            tail = tp;
        curnum--;
    }
    public void moveToHead(ListNode t){
        t.next = head.next;
        if(head.next!=null)
            head.next.pre = t;
        head.next = t;
        t.pre = head;
        curnum++;
        if(curnum==1)
            tail = t;
    }
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(1);
    	/*lru.set(2,1);
    	lru.set(1, 1);
    	lru.get(2);
    	lru.set(4, 1);
    	lru.get(1);
    	lru.get(2);*/
    	lru.set(2,1);
    	lru.get(2);
    	lru.set(3,2);
    	lru.get(2);
    	lru.get(3);
    }
}

class ListNode{
    int key;
    int value;
    ListNode pre;
    ListNode next;
    ListNode(int k, int v){
        key = k;
        value = v;
    }
}