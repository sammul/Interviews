//find the closest value with the target in the tree
public class FindClosest{
	public int findClosest(Node root, int target){
		int res = Integer.MAX_VALUE;
		Node c = root;
		while(c!=null){
			if(Math.abs(res-target) > Math.abs(c.val-target))
				res = c.val;
			c = c.val > target ? c.left : c.right;
		}
		return res;
	}
}

class Node{
	Node left,right;
	int val;
	Node(int i){
		this.val=i;
	}
}