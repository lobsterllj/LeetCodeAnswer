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
        TreeNode a1 = new TreeNode(-1);
        TreeNode a2 = new TreeNode(9);
        TreeNode a3 = new TreeNode(0);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        System.out.println(main.maxPathSum(a1));
    }

    private int globalSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalSum;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        //深度优先，获取左右分支的最大路径和，本结点作为联络点
        //若左右分支返回的值为负数，则对路径和做负贡献，直接舍弃
        int left_sum = Math.max(0, dfs(root.left));
        int right_sum = Math.max(0, dfs(root.right));

        //由于路径最大的一种可能为left->node->right，而不向root的父结点延伸
        int sumofthisroot=root.val+left_sum+right_sum;
        globalSum= Math.max(globalSum,sumofthisroot);

        //node's ancestors->node->node's children
        return root.val+Math.max(left_sum,right_sum);

    }

}
