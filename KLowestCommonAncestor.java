//(Binary tree) K nodes’ lowest common ancestor
public class KLowestCommonAncestor{
	public Node LCA(Node root, Node a, Node b){
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
	public Node kLCA(Node root, ArrayList<Node> l){
		
	}
}

class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
}