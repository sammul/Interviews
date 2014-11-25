/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversalII {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> fres = new ArrayList<ArrayList<Integer>>();
        if(root==null)
            return fres;
        Stack<ArrayList<Integer>> res = new Stack<ArrayList<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            ArrayList<Integer> cres = new ArrayList<Integer>();
            for(int i=0; i<s; i++){
                TreeNode t = q.poll();
                cres.add(t.val);
                if(t.left!=null)
                    q.offer(t.left);
                if(t.right!=null)
                    q.offer(t.right);
            }
            res.push(cres);
        }
        while(!res.empty())
            fres.add(res.pop());
        return fres;
    }
}
