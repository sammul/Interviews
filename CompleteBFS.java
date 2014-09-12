//Q25,  Determine whether a binary tree is complete.
import java.util.LinkedList;
import java.util.Queue;

public class CompleteBFS{
	public boolean isComplete(Node root){
	    Queue<Node> q = new LinkedList<Node>();
	    if(root==null)
	    	return true;
	    boolean nochild = false;
	    while(!q.isEmpty()){
	    	Node t = q.poll();
	    	if(t.left==null)
	    		nochild=true;
	    	else{
	    		if(nochild)
	    			return false;
	    		else
	    			q.offer(t.left);
	    	}
	    	if(t.right==null)
	    		nochild=true;
	    	else{
	    		if(nochild)
	    			return false;
	    		else
	    			q.offer(t.right);
	    	}
	    }
	    return true;
	}
}

class Node{
	Node left, right;
	int val;
	Node(int i){
		this.val = i;
	}
}