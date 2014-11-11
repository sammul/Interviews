public class ReverseLinkR{
    public Node reverse(Node n){
        if(n==null || n.next==null)
            return n;
        Node h = reverse(n.next);
        n.next.next = n;
        n.next=null;
        return h;
    }
}
class Node{
    Node next;
    int val;
    Node(int i){
        this.val = i;
        this.next = null;
    }
}
