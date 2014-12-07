/***

Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases

***/

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
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int la = getLength(headA);
        int lb = getLength(headB);
        if(la>lb){
            int step = la-lb;
            while(step>0){
                headA = headA.next;
                step--;
            }
        }
        else if(la<lb){
            int step = lb-la;
            while(step>0){
                headB = headB.next;
                step--;
            }
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int getLength(ListNode head){
        int l=0;
        while(head!=null){
            l++;
            head = head.next;
        }
        return l;
    }
}
