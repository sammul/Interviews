public class swapPair{
	//recursion method
	public Node swap(Node head){
		if(head==null || head.next==null)
			return head;
		Node nn = swap(head.next.next);
		Node n = head.next;
		n.next = head;
		head.next = nn;
		return n;
	}

	//non-recursion
	public Node swapn(Node head){
		if(head==null || head.next==null)
			return head;
		Node pre=null, newhead=head.next, p=head, np=head.next;
		while(np!=null){
			if(pre!=null)
				pre.next=np;
			}
			Node nnp = np.next;
			np.next = p;
			pre = p;
			p = nnp;
			np = nnp==null ? null : nnp.next;
		}
		return newhead;
	}
}

class Node{
	Node next;
	int val;
	Node(int i){
		this.val = i;
	}
}