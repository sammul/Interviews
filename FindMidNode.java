public class FindMidNode{
	public Node findMid(Node head){
		Node slow = head, fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
class Node{
	Node next;
	int val;
	Node(int i){
		this.val=i;
	}
}