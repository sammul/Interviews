/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
       val = x;
       next = null;
    }
}
public class ReorderList {
    public void reorderList(ListNode head) {
    ListNode slow = head, spre =null, fast = head;
        if(head==null || head.next==null || head.next.next==null)
            return;
        while(fast!=null && fast.next!=null){
            spre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            spre = slow;
            slow = slow.next;
        }
        //slow is the mid - start of the second part list
        spre.next = null;
        ListNode p2 = reverse(slow);
        ListNode p1 = head;
        spre = null;
        while(p2!=null){
            ListNode np1 = p1.next;
            ListNode np2 = p2.next;
            p1.next= p2;
            p2.next = np1;
            p1 = np1;
            p2 = np2;
        }
    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null)
            return head;
        ListNode pre = head;
        ListNode next = head.next;
        while(next!=null){
            ListNode nnext = next.next;
            next.next = pre;
            if(pre==head)
                pre.next = null;
            pre = next;
            next = nnext;
        }
        return pre;
    }
}