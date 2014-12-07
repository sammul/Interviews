/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulateNext {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        while(p!=null){
            TreeLinkNode k = p;
            while(k!=null){
                if(k.left!=null && k.right!=null)
                    k.left.next = k.right;
                if(k.next!=null && k.next.left!=null)
                    k.right.next = k.next.left;
                k = k.next;
            }
            p = p.left;
        }
        return;
    }
}
