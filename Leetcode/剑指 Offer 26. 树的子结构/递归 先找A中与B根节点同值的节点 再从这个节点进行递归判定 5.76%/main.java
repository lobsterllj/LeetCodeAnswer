import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(4);
        TreeNode a3 = new TreeNode(5);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(2);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;

        TreeNode b1 = new TreeNode(3);
        TreeNode b2 = new TreeNode(4);
        TreeNode b3 = new TreeNode(5);
        TreeNode b4 = new TreeNode(1);
        TreeNode b5 = new TreeNode(2);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;

        System.out.println(main.isSubStructure(a1, b2));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        boolean flag = false;
        Deque<TreeNode> unvisited = new LinkedList<>();
        unvisited.addLast(A);
        while (!unvisited.isEmpty()) {
            TreeNode cache = unvisited.pollFirst();
            if (cache.val == B.val)
                flag |= sameRoot(cache, B);
            if (cache.left != null)
                unvisited.addLast(cache.left);
            if (cache.right != null)
                unvisited.addLast(cache.right);
        }
        return flag;
    }

    public boolean sameRoot(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A != null && B == null) {
            return true;
        } else if (A == null && B != null) {
            return false;
        } else {
            if (A.val == B.val) {
                return sameRoot(A.left, B.left) && sameRoot(A.right, B.right);
            } else
                return false;
        }
    }
}
