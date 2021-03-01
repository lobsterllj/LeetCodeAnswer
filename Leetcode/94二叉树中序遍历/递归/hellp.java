import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;
import java.util.regex.Pattern;

public class hellp {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void visit(TreeNode aa,List<Integer> res){

        if(aa==null)
        {
            return;
        }
        visit(aa.left,res);
        res.add(aa.val);
        visit(aa.right,res);

    }


    public static void main(String[] args) {
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

        visit(a,result);

        for (int i=0;i<result.size();++i)
        {
            System.out.println(result.get(i));
        }
    }

}
