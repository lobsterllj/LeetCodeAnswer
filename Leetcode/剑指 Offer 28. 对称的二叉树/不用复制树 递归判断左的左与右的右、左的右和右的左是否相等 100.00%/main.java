import java.util.*;

public class main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        a1.left = a2;
        a1.right = a3;
        System.out.println(main.isSymmetric(a1));
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        if (L == null || R == null)
            return false;
        return (L.val == R.val) && recur(L.left, R.right) && recur(L.right, R.left);
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recur(root.left, root.right);
    }


}

