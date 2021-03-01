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
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(5);
        TreeNode a10 = new TreeNode(1);

        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a4.left = a7;
        a4.right = a8;

        a3.left = a5;
        a3.right = a6;
        a6.left = a9;
        a6.right = a10;

        System.out.println(main.pathSum(a1, 22));

    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> cache = new ArrayList<>();
        search(res, cache, sum, root);
        return res;
    }

    public void search(List<List<Integer>> res, List<Integer> cache, int sum, TreeNode root) {

        if (root == null)
            return;
        System.out.println("root: "+root.val);
        System.out.println("ex:" + cache);
        System.out.println("sum: "+sum);
        sum -= root.val;
        cache.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            List<Integer> temp = new ArrayList<>(cache);
            cache.remove(cache.size() - 1);
            res.add(temp);
            return;
        }

        search(res, cache, sum, root.left);
        search(res, cache, sum, root.right);
        cache.remove(cache.size() - 1);
    }
}

