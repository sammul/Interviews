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
	int findClosest(Node root, int target){
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
	
	/*Find the k-th largest in BST*/
	class TreeNode{
		TreeNode left, right;
		int val;
		int rightChildNum;
	}
	public TreeNode findKthLargestInBST(TreeNode root, int k){
		if(root==null)
			return null;
		if(k < root.rightChildNum){
			return findKthLargestInBST(root.right,k);
		}
		k -= root.rightChildNum;
		if(k==0)
			return root;
		return findKthLargestInBST(root.left,k--);
	}

	/*Validate BST method1*/
	public boolean validateBST_m1(Node root){
		return validateBST_m1_Helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public boolean validateBST_m1_Helper(Node root, int min, int max){
		if(root==null)
			return true;
		if(root.val<=min || root.val>=max)
			return false;
		return validateBST_m1_Helper(root.left, min, root.val) && validateBST_m1_Helper(root.right, root.val, max);
	}

	/*Validate BST method2*/
	Node last = null;
	public boolean validateBST_m2(Node root){
		if(root==null)
			return true;
		boolean b1 = validateBST_m2(root.left);
		if(last!=null && last.val >= root.val)
			return false;
		last = root;
		boolean b2 = validateBST_m2(root.right);
		return b1&&b2;
	}

	/*Vertical Level Order Traversal*/
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		vertical(root,0,map);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int l : map.keySet()){
			res.add(l,map.get(l));
		}
		return res;
	}
	public void vertical(TreeNode t, int l, HashMap<Interger,ArrayList<Integer>> map){
		if(t==null)
			return;
		if(!map.containsKey(l)){
			map.put(l,new ArrayList<Integer>());
		}
		map.get(l).add(t.val);
		vertical(t.left,l-1,map);
		vertical(t.right,l+1,map);
	}
 }
 
 class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
 }
