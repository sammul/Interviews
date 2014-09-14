//Search in a BST for range [L,U]
import java.util.ArrayList;

public class searchBSTRange{
	public ArrayList<Integer> searchRange(Node root, int L, int U){
		ArrayList<Integer> res = new ArrayList<Integer>();
		search(root,L,U,res);
		return res;
	}
	public void search(Node root, int L, int U, ArrayList<Integer> res){
		if(root==null)
			return;
		if(root.val <= U && root.val >= L){
			res.add(root.val);
			search(root.left);
			search(root.right);
		}
		else if(root.val < L){
			search(root.right);
		}
		else{
			search(root.left);
		}
		return;
	}
}

class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
}