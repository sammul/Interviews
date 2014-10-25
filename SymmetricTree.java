/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return symmetric(root.left,root.right);
    }
    public boolean symmetric(TreeNode t1, TreeNode t2){
        if(t1==null&&t2==null)
            return true;
        if(t1==null||t2==null)
            return false;
        if(t1.val!=t2.val)
            return false;
        return symmetric(t1.left,t2.right)&&symmetric(t1.right,t2.left);
    }
}