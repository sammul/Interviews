
public class MyHashMap {
	private static final int SIZE = 16;
	private Entry table[];
	class Entry{
		private final int key;
		private int value;
		private Entry next;
		Entry(int k, int v){
			this.key = k;
			this.value = v;
			this.next = null;
		}
	}
	MyHashMap(){
		table = new Entry[SIZE];
	}
	public Integer get(int k){
		int hash = k%SIZE;
		Entry e = table[hash];
		while(e!=null){
			if(e.key == k)
				return e.value;
			e = e.next;
		}
		return null;
	}
	public void put(int k, int v){
		int hash = k%SIZE;
		Entry e = table[hash];
		Entry pre = null;
		while(e!=null){
			if(e.key==k){
				e.value = v;
				return;
			}
			else{
				pre = e;
				e = e.next;
			}
		}
		if(pre!=null)
			pre.next = new Entry(k,v);
		else
			table[hash] = new Entry(k,v);
	}
	
	public static void main(String[] args){
		XHashMap map = new XHashMap();
		map.put(1, 2);
		map.put(2, 3);
		map.put(17, 4);
		map.put(33, 5);
		System.out.println(map.get(1));
		System.out.println(map.get(17));
		System.out.println(map.get(3));
		System.out.println(map.get(33));
	}
}
