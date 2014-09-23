import java.util.HashMap;
public class CopyGraph{
	public Node copy(Node root, HashMap<Node,Node> map){
		if(map.containsKey(root)){
			return map.get(root);
		Node newroot = new Node(root.val);
		for(Node neighbor : root.neighbors){
			newroot.addNeighbor(copy(neighbor, map));
		}
		return newroot;
	}
	public Node copyGraph(Node root){
		HashMap<Node,Node> map = new HashMap<Node,Node>();
		Node nr = copy(root,map);
		return nr;
	}
}

class Node{
	ArrayList<Node> neighbors;
	int val;
	Node(int v){
		this.val = v;
		neighbors = new ArrayList<Node>();
	}
	void addNeighbor(Node v){
		this.neighbors.add(v);
	}
}