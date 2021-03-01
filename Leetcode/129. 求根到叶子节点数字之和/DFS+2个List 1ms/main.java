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

        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;

        System.out.println(main.sumNumbers(a1));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<Integer> vales0 = new ArrayList<>();
        List<Integer> res0 = new ArrayList<>();
        dfs(root, vales0, res0);
        int sum = 0;
        for (int it : res0)
            sum += it;
        return sum;
    }

    public void dfs(TreeNode root, List<Integer> vales, List<Integer> res) {
        if(root==null)
            return;
        vales.add(root.val);
//        System.out.println(root.val);
        if (root.left == null && root.right == null) {
            int cache = 0;
            for (int it : vales)
                cache = cache * 10 + it;
            res.add(cache);
            vales.remove(vales.size() - 1);
//            System.out.println("vales:" + vales);
//            System.out.println("res:" + res);
            return;
        }

        dfs(root.left, vales, res);
        dfs(root.right, vales, res);
        vales.remove(vales.size() - 1);
    }

}
