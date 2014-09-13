//given 2 nodes, get the lowest common ancestor of the 2 nodes. Each node has a field pointing to his parent node.

import java.util.HashSet;

public LowestCommonAncestor{
	public Node LCA(Node A, Node B){
		HashSet<Integer> set = new HashSet<Integer>();
		while(A!=null || B!=null){
			if(A!=null){
				if(set.contains(A))
					return A;
				else
					set.add(A);
				A=A.parent;
			}
			if(B!=null){
				if(set.contains(B))
					return B;
				else
					set.add(B);
				B=B.parent;
			}
		}
		return null;
	}
}

class Node{
	Node parent;
	int val;
	Node(int i){
		this.val=i;
	}
}