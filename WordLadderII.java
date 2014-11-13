public class WordLadderII{
	ArrayList<ArrayList<String>> answer;

	public void findPath(Node node, ArrayList<String> cur, String start){
		if(node.val.equals(start)){
			answer.add(cur);
			return;
		}
		for(Node n: node.prev){
			ArrayList<String> nres = new ArrayList<String>(cur);
			cur.add(0,n.val);
			findPath(n,tmp,start);
		}
	}
	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict){
		HashMap<String, Node> map = new HashMap<String, Node>();
		Queue<Node> queue = new LinkedList<Node>();
		Node node = new Node(0,start);
		Node endNode = null;
		map.put(start,node);
		queue.offer(node);
		while(queue.size()>0 && endNode==null){
			int count = queue.size();
			for(int i=0; i<count; i++){
				node = queue.poll();
				for(int j=0; j<node.val.length(); j++){
					StringBuilder t = new StringBuilder(node.val);
					for(char k='a'; k<='z'; k++){
						t.setCharAt(j,k);
						String nt = t.toString();
						if(dict.contains(nt)){
							Node v = map.get(nt);
							if(v==null){
								Node tmp = new Node(node.no+1,nt);
								tmp.addPrev(node);
								queue.add(tmp);
								map.put(nt,tmp);
								if(nt.equals(end)){
									endNode = tmp;								}
							}
							else{
								if(v.no == node.no+1){
									v.addPrev(node);
								}
							}
						}
					}
				}
			}
		}
		answer = new ArrayList<ArrayList<String>>();
		if(endNode!=null){
			findPath(endNode,new ArrayList<String>(Arrays.asList(end)),start);
		}
		return answer;
	}
}

class Node{
	String val;
	int no;
	ArrayList<Node> prev;
	Node(int n, String v){
		val = v;
		no = n;
		prev = new ArrayList<Node>();
	}
	void addPrev(Node n){
		prev.add(n);
	}
}