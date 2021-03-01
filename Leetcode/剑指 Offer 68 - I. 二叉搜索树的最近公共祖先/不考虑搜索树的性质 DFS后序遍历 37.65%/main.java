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

    }

    TreeNode ps;
    TreeNode qs;
    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ps = p;
        qs = q;
        res = null;
        dfs(root);
        return res;
    }

    public TreeNode dfs(TreeNode root) {
        if (root == null)
            return null;

        TreeNode rootL = dfs(root.left);
        TreeNode rootR = dfs(root.right);

        if ((rootL == ps && rootR == qs) || (rootL == qs && rootR == ps) || ((root == ps && (rootL == qs || rootR == qs)) || (root == qs && (rootL == ps || rootR == ps))))
            res = root;

        if (rootL == ps || rootL == qs)
            return rootL;
        if (rootR == ps || rootR == qs)
            return rootR;
        return root;
    }
}

