/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int psum = 0;
        TreeNode p = root, pre =null;
        while(!stack.empty() || p!=null){
            if(p!=null){
                stack.push(p);
                cur.add(p.val);
                psum += p.val;
                p=p.left;
            }
            else{
                TreeNode t = stack.peek();
                if(t.left==null && t.right==null && psum==sum){
                    res.add(new ArrayList<Integer>(cur));
                }
                if(t.right!=null&&t.right!=pre){
                    p = t.right;
                }
                else{
                    stack.pop();
                    cur.remove(cur.size()-1);
                    pre = t;
                    psum -= t.val;
                }
            }
        }
        return res;
    }
	/*
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        Stack<Integer> rem = new Stack<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        pathSumWithResult(root,sum,rem,result);
        return result;
    }
    public void pathSumWithResult(TreeNode root, int sum, Stack<Integer> rem, ArrayList<ArrayList<Integer>> result)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            if(root.val == sum)
            {
                //find a path
                rem.push(root.val);
                ArrayList<Integer> l = new ArrayList<Integer>();
                for(int i: rem)
                {
                    l.add(i);
                }
                result.add(l);
                rem.pop();
            }
            else
            {
                return;
            }
        }
        else
        {
            rem.push(root.val);
            pathSumWithResult(root.left,sum-root.val,rem,result);
            pathSumWithResult(root.right,sum-root.val,rem,result);
            rem.pop();
            System.out.println(rem.size());
            return;
        }
    }*/
    
	/*
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //Use DFS
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root==null)
            return res;
        stack.push(root);
        TreeNode pre = null;
        //sum -= root.val;
        while(!stack.empty()){
            TreeNode cur = stack.peek();
            if(cur.left!=null && cur.left!=pre && !(pre!=null&&cur.right==pre))
            {
                stack.push(cur.left);
                sum-=cur.val;
            }
            else if(cur.right!=null && cur.right!=pre){
                stack.push(cur.right);
                sum-=cur.val;
            }
            else{
                if(cur.left==null&&cur.right==null&&cur.val==sum){
                    ArrayList<Integer> newres = new ArrayList<Integer>();
                    for(TreeNode t : stack){
                        newres.add(t.val);
                    }
                    res.add(newres);
                }
                stack.pop();
                pre = cur;
            }
        }
        return res;
    } */
}