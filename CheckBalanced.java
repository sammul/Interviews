public class CheckBalanced{
	public boolean isBalanced(Node root){
		return getHeight(root)>=0;
	}
	public int getHeight(Node root){
		if(root==null)
			return 0;
		int lh = getHeight(root.left), rh = getHeight(root.right);
		if(lh>=0 && rh>=0 && Math.abs(lh-rh)<=1)
			return Math.max(lh,rh)+1;
		else
			return -1;
	}
}

class Node{
	Node left,right;
	int val;
	Node(int i){
		this.val=i;
	}
}