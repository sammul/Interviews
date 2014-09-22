import java.util.ArrayList;

public class KLowestCommonAncestor{
	public static void main(String[] args){
		Node[] ns = new Node[15];
		for(int i=0; i<15; i++)
			ns[i] = new Node(i);
		for(int i=0; i<6; i++){
			ns[i].left = ns[2*i+1];
			ns[i].right = ns[2*i+2];
		}
		ArrayList<Node> l = new ArrayList<Node>();
		l.add(ns[8]);
		l.add(ns[3]);
		l.add(ns[4]);
		l.add(ns[7]);
		Node p = kLCA(ns[0],l);
		int k = 0;
	}
	public static Node LCA(Node root, Node a, Node b){
		if(root==null)
			return null;
		if(root==a || root==b)
			return root;
		Node left = LCA(root.left,a,b);
		Node right = LCA(root.right,a,b);
		if(left!=null && right!=null)
			return root;
		else
			return left==null? right : left;
	}
	public static Node kLCA(Node root, ArrayList<Node> l){
		int size = l.size();
		if(size==1)
			return l.get(0);
		else if(size==2)
			return LCA(root,l.get(0),l.get(1));
		else{
			int mid = size/2;
			ArrayList<Node> lh = new ArrayList<Node>(l.subList(0,mid));
			ArrayList<Node> rh = new ArrayList<Node>(l.subList(mid,size));
			Node l1 = kLCA(root,lh);
			Node l2 = kLCA(root,rh);
			return LCA(root,l1,l2);
		}
	}
}

class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
}