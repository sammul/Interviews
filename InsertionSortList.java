/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode p = head, nhead = null;
        while(p!=null){
            ListNode next = p.next;
            p.next = null;
            nhead = insert(nhead,p);
            p = next;
        }
        return nhead;
    }
    public ListNode insert(ListNode head, ListNode t){
        if(head==null)
            return t;
        if(t.val <= head.val){
            t.next = head;
            return t;
        }
        else{
            ListNode p = head;
            while(p!=null && p.next!=null){
                if(p.val < t.val && p.next.val >= t.val){
                    t.next = p.next;
                    p.next= t;
                    break;
                }
                p = p.next;
            }
            if(p.next==null)
                p.next = t;
            return head;
        }
    }
}