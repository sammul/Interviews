/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class PopulateNextII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        while(p!=null){
            TreeLinkNode k = p;
            while(k!=null){
                if(k.left!=null){
                    if(k.right!=null)
                        k.left.next = k.right;
                    else
                        k.left.next = getNext(k.next);
                }
                if(k.right!=null)
                    k.right.next = getNext(k.next);
                k=k.next;
            }
            p = getNext(p);
        }
    }
    public TreeLinkNode getNext(TreeLinkNode p){
        if(p==null)
            return null;
        if(p.left!=null)
            return p.left;
        if(p.right!=null)
            return p.right;
        return getNext(p.next);
    }
}
