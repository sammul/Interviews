 import java.util.Queue;
 import java.util.LinkedList;
 
 public class BST{
	int findLargestUTargetR(Node root, int target){
		if(root==null)
			return Integer.MIN_VALUE;
		if(root.val >= target)
			return findLargestUTargetR(root.left, target);
		else{
			return Math.max(root.val, findLargestUTargetR(root.right, target));
		}
	}
	int findLargestUTargetNonR(Node root, int target){
		int maxV=Integer.MIN_VALUE;
		Node c = root;
		while(c!=null){
			if(c.val >= target)
				c = c.left;
			else{
				maxV = c.val,maxV;
				c = c.right;
			}
		}
	}
	int findCloest(Node root, int target){
		Node c = root;
		int closest = Integer.MAX_VALUE;
		while(c!=null){
			if(Math.abs(c.val-target) < Math.abs(closest-target))
				closest = c.val;
			c = c.val > target ? c.left : c.right;
		}
		return closest;
	}
	
	public boolean isComplete(Node root){
		if(root==null)
			return true;
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		boolean noLeaf = false;
		while(!q.isEmpty()){
			Node t = q.poll();
			if(t.left!=null){
				if(noLeaf)
					return false;
				q.offer(t.left);
			}
			else
				noLeaf = true;
			if(t.right!=null){
				if(noLeaf)
					return false;
				q.offer(t.right);
			}
			else
				noLeaf = true;
		}
		return true;
	}
	
	/*Find the k-th largest element in BST*/
	public void findKthLargest(Node root, int[] k){
		if(root==null || k[0]<=0)
			return null;
		findKthLargest(root.right, k[0]);
		k[0]--;
		if(k[0]==0){
			System.out.println(root.val);
			return;
		}
		findKthLargest(root.left, k[0]);
	}
 }
 
 class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
 }