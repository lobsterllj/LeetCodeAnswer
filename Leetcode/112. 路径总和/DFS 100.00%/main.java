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
        TreeNode a1 = new TreeNode(5);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(8);
        TreeNode a4 = new TreeNode(11);
        TreeNode a5 = new TreeNode(13);
        TreeNode a6 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(2);
        TreeNode a9 = new TreeNode(1);

        a1.left = a2;
        a2.left = a4;
        a4.left = a7;
        a4.right = a8;

        a1.right = a3;
        a3.left = a5;
        a3.right = a6;
        a6.right = a9;

        TreeNode a10 = new TreeNode(1);

        System.out.println(main.hasPathSum(a10, 0));

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        sum=sum- root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0)
                return true;
            else
                return false;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


}
