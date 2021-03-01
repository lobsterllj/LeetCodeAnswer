import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static void nodeIn(TreeNode tn, Stack<TreeNode>  st)
    {
        while(tn!=null)
        {
            st.push(tn);
            tn=tn.left;
        }
    }

    static void visit(TreeNode tn, Stack<TreeNode> st,List<Integer> result)
    {
        nodeIn(tn,st);
        TreeNode x;
        while(!st.empty())
        {
            x = st.pop();
            result.add(x.val);
            if (x.right != null) {
                x = x.right;
                nodeIn(x, st);
            }
        }
    }

    public static void main(String[] args)
        {
            Stack stack=new Stack();
            List<Integer> result=new ArrayList();

            TreeNode a=new TreeNode(1);
            TreeNode b=new TreeNode(2);
            TreeNode c=new TreeNode(3);
            TreeNode d=new TreeNode(4);
            TreeNode e=new TreeNode(5);
            TreeNode f=new TreeNode(6);
            TreeNode g=new TreeNode(7);
            a.left=b;
            a.right=c;
            b.left=d;
            b.right=e;
            c.left=f;
            c.right=g;

            visit(a,stack,result);


            for (int i=0;i<result.size();++i)
            {
                System.out.println(result.get(i));
            }
        }
}
