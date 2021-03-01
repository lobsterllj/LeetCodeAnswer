import java.util.ArrayList;
import java.util.List;

public class main {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        main main = new main();
        TreeNode a1 = new TreeNode(4);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(0);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        System.out.println(main.sumNumbers(a1));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int res = 0;
        return dfs(root, res);
    }

    public int dfs(TreeNode root, int cache) {
        if (root == null)
            return 0;
//        System.out.println(root.val);
        cache = cache * 10 + root.val;
//        System.out.println("cache:" + cache);
        if (root.left == null && root.right == null) {
            return cache;
        }
        return dfs(root.left, cache) + dfs(root.right, cache);
    }

}
