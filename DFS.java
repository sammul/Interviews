import java.util.Stack;

public class DFS{
    //pre-order travesal the Binary Tree
    public ArrayList<Integer> preorder_dfs(Node root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Stack<Integer> s = new Stack<Integer>();
        s.push(root);
        while(!s.empty()){
            Node t = s.pop();
            res.add(t.val);
            if(t.right!=null)
                s.push(t.right);
            if(t.left!=null)
                s.push(t.left);
        }
        return res;
    }
    
    //in-order travesal the Binary Tree
    public ArrayList<Integer> inorder_dfs(Node root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Node p = root;
        Stack<Integer> s = new Stack<Integer>();
        while(!s.empty() || p!=null){
            if(p!=null){
                s.push(p);
                p=p.left;
            }
            else{
                Node t = s.pop();
                res.add(t.val);
				p=p.right;
            }
        }
        return res;
    }
    
    //post-order travesal the Binary Tree
    public ArrayList<Integer> postorder_dfs(Node root){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null)
            return res;
        Node p = root, pre = null;
        while(!s.empty() || p!=null){
            if(p!=null){
                s.push(p);
                p=p.left;
            }
            else{
                Node t = s.peek();
                if(t.right!=null && t.right!=pre){
                    p = t.right;
                }
                else{
                    s.pop();
                    pre = t;
                    res.add(t.val);
                }
            }
        }
        return res;
    }

}

class Node{
    Node left, right;
    int val;
    Node(int i){
        this.val=i;
    }
}